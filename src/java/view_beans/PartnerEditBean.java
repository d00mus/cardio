package view_beans;

import ctrl.util.JsfUtil;
import dao.CardioPartnerFacade;
import dao.UaStateFacade;
import dao.UaTownFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mdl.CardioPartner;
import mdl.CardioUser;
import mdl.PartnerAddress;
import mdl.PartnerBankRecv;
import mdl.PartnerEmploye;
import mdl.PartnerEvent;
import mdl.PartnerEventAttrs;
import mdl.UaState;
import mdl.UaTown;
import viewModel.PartnerEmplDataModel;
import viewModel.PartnerEmployeVM;
/*
 import org.primefaces.event.SelectEvent;  
 import org.primefaces.event.UnselectEvent;  
 */

/**
 *
 * @author d00mus
 */
@Named("partnerEditBean")
@SessionScoped
public class PartnerEditBean implements Serializable {

    @EJB
    private CardioPartnerFacade dao;

    @EJB
    private UaStateFacade stateDao;

    @EJB
    private UaTownFacade townDao;

    //=======поддержка фильтра по событиям=========
    //список отфильтрованнных событий
    private List<PartnerEvent> filteredEvents;

    private String fltEventLabel;

    private String fltEventUser;

    private String fltEventSubj;

    private String fltEventType;

    private CardioPartner current;

    private boolean doCreateNew;//признак того, что идёт создание нового пользователя

    //поддерджка выделения строк в списке сотрудников
    private PartnerEmplDataModel emplDataModel;

    //поддержка выделения строк в событиях
    private PartnerEventDataModel eventDataModel;

    //выбранная строка с событием
    private PartnerEvent selectedEventRow = new PartnerEvent();//чтоб не было нулл поинтер..

    private List<UaState> uaStates;
    private List<UaTown> uaTowns;

    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    private int tabBarId = 0;

    @Inject
    LoginBean loginBean;

    //модель данных для работы с сотрудниками
    @Inject
    PartnerEmployeVM employeVM;

    String caption = "Заголовок";

    private PartnerBankRecv newBankRecv = new PartnerBankRecv();

    private PartnerAddress newBranchAddr = new PartnerAddress();
    private PartnerEvent newEvent = new PartnerEvent();

    private PartnerEventAttrs newEventAttrs = new PartnerEventAttrs();

    @PostConstruct
    private void init() {
        uaStates = stateDao.findAll();//найти все области усраины
        uaTowns = townDao.findAll();//найти все города усраины
    }

    /**
     * Очистить фильтр событий
     */
    public void clearFilter() {
        filteredEvents = null;
        clearSelection();
    }

    /**
     * Очистить выделение
     */
    public void clearSelection() {
        eventDataModel = new PartnerEventDataModel(current.getPartnerEventList());
        selectedEventRow = new PartnerEvent();
    }

    /**
     * Очистка всех полей текущего партнёра
     */
    public void clean() {
        current = new CardioPartner();
        doCreateNew = true;
        caption = "Заведение нового предприятия";
        emplDataModel = new PartnerEmplDataModel(current.getPartnerEmployeList());
        clearFilter();
        clearSelection();

    }

    /**
     * Запустить создание нового юзера
     *
     * @return
     */
    public String startCreateNew() {
        clean();
        updateCaption();
        employeVM.setCurrent(null);
        employeVM.setCurrIsNew(true);

        return null;
    }

    /**
     * Начать редактирование существующего(!!!) в базе партнёра
     *
     * @param edited
     * @param retPath
     * @return
     */
    public String startEdit(CardioPartner edited, String retPath) {
        current = edited;//выставить текущего юзера для правки
        clearSelection();

        doCreateNew = false;//отключить режим создания нового юзера

        updateCaption();
        employeVM.setCurrent(null);
        emplDataModel = new PartnerEmplDataModel(current.getPartnerEmployeList());

        return "partner_edit?faces-redirect=true";
    }

    ;
    
    
    /**
     * Метод для автокомплита областей
     * @param query
     * @return 
     */
    public List<UaState> stateAutoComplete(String query) {

        List<UaState> stateSuggestion = new ArrayList<UaState>();
        int i = 0;
        for (UaState t : uaStates) {
            if (t.getRusName().toLowerCase().indexOf(query.toLowerCase()) >= 0) {
                stateSuggestion.add(t);
                i++;
            }
            if (i > 30) {
                break;
            }
        }
        return stateSuggestion;
    }

    /**
     * Метод для автокомплита городов
     *
     * @param query
     * @return
     */
    public List<UaTown> townAutoComplete(String query) {
        List<UaTown> townSuggestion = new ArrayList<UaTown>();
        int i = 0;
        for (UaTown t : uaTowns) {
            if (t.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >= 0) {
                townSuggestion.add(t);
                i++;
            }
            if (i > 50) {
                break;
            }
        }
        return townSuggestion;
    }

//----------------------------------------------------------------------------    
    /**
     * Версия автокомплита городов с фильтрацией по областям
     *
     * @param query
     * @return
     */
    public List<UaTown> townAutoCompleteEdit(String query) {

        boolean useFilterByState = false;//использовать ограничение по области?
        Integer curStateId = null;
        if (current.getJurAddrUaState() != null && current.getJurAddrUaState().getId() != null) {
            useFilterByState = true;
            curStateId = current.getJurAddrUaState().getId();
        }
        List<UaTown> townSuggestion = new ArrayList<UaTown>();
        int i = 0;
        for (UaTown t : uaTowns) {
            //проверить фильтрацию по области
            if (useFilterByState && (t.getState().getId() != curStateId)) {
                //если фильтрация по областям есть, то скипаем города из других областей
                continue;//пропускаем города в другой области
            }
            //если совпало имя
            if (t.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >= 0) {
                townSuggestion.add(t);
                i++;
            }
            if (i > 50) {
                break;
            }
        }
        return townSuggestion;
    }

//----------------------------------------------------------------------------    
    /**
     * Перечитать данные по текущему партнёру из базы
     */
    public void refresh() {
        if (!doCreateNew) {
            current = dao.refresh(current.getId());
            clearFilter();

        }
    }

    /**
     * Выполнить проверки перед сохранением
     *
     * @return
     */
    private boolean preSaveCheck() {
        boolean result = true;

        //коллекция сообщений об ошибках валидации
        HashSet<FacesMessage> messages = new HashSet<FacesMessage>();

        String name = current.getName();
        String inn = current.getInn();
        UaState state = current.getJurAddrUaState();
        UaTown town = current.getJurAddrUaTown();

        //проверить имя на пустоту
        if (name == null || name.trim().isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Название - обязательно", "Ошибка");
            FacesContext.getCurrentInstance().addMessage(JsfUtil.EvalEL(":#{bnd.name.clientId}", String.class), msg);
            messages.add(msg);
            result = false;
        }

        //проверить инн на пустоту
        if (inn == null || inn.trim().isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ИНН - обязателен", "Ошибка");
            FacesContext.getCurrentInstance().addMessage(JsfUtil.EvalEL(":#{bnd.inn.clientId}", String.class), msg);
            messages.add(msg);
            result = false;
        }

        //проверить инн на уникальность
        if (result) { //если ещё не отфутболили
            TypedQuery<CardioPartner> innQ = em.createQuery("select c from CardioPartner c where c.inn=:inn", CardioPartner.class);
            innQ.setParameter("inn", inn);//выставить искомое значение inn
            //попробуем найти все записи с таким INN
            List<CardioPartner> rl = innQ.getResultList();
            if (rl == null || rl.size() != 0) { //если есть какой-то резалт, тогда надо разбиратся..
                CardioPartner r = rl.get(0);//получить первую запись
                if (doCreateNew) {//если режим создания нового - однозначно ошибка
                    result = false;
                } else {//если не создение нового - возможны варианты
                    if (!r.getId().equals(current.getId())) {//если айдишки текущего и найденного не равны - ошибка
                        result = false;
                    }
                }
            }
            if (!result) {//если ошибка уникальности
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Такой ИНН - уже есть!", "Ошибка");
                FacesContext.getCurrentInstance().addMessage(JsfUtil.EvalEL(":#{bnd.inn.clientId}", String.class), msg);
                messages.add(msg);
            }
        }

        //проверить область на пустоту
        if (state == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Область - обязательна", "Ошибка");
            FacesContext.getCurrentInstance().addMessage(JsfUtil.EvalEL(":#{bnd.jurAddrUaState.clientId}", String.class), msg);
            messages.add(msg);
            result = false;
        }

        //проверить город на пустоту
        if (town == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Город - обязателен", "Ошибка");
            FacesContext.getCurrentInstance().addMessage(JsfUtil.EvalEL(":#{bnd.jurAddrUaTown.clientId}", String.class), msg);
            messages.add(msg);
            result = false;
        }

        /*
         Эта херня работает не так!
         надо для каждого проперти делать валидатор и в нём бросать эксепшны!!
         if(!result){
         throw new ValidatorException(messages);
         }
         */
        return result;
    }

    /**
     * Сохранить модификации в базе
     */
    public void save() throws ValidatorException {

        //выполнить проверки перед сохранением
        if (!preSaveCheck()) {
            return;
        }

        String details = null;

        try {
            if (doCreateNew) {//Если режим создания нового предприятия
                dao.create(current);
                details = "Предприятие создано";
            } else {
                dao.edit(current);
                details = "Сохранено в базе";
                refresh();
            }

            //отменить режим правки
            doCreateNew = false;

        } catch (Throwable t) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, t.getMessage(), "Ошибка работы с базой");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }

        current = dao.refresh(current.getId());

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, details, details);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        updateCaption();

        clearFilter();

    }

//--------------------------------------------------------------------------
    /**
     * Обработка добавления сотрудника
     */
    public void onAddNewEmploye() {
        employeVM.endCreateNew();
        //перестроить список
        emplDataModel = new PartnerEmplDataModel(current.getPartnerEmployeList());
    }

    public void onDelEmploye(PartnerEmploye forDel) {
        employeVM.delEmploye(forDel);
        //перестроить список
        emplDataModel = new PartnerEmplDataModel(current.getPartnerEmployeList());
    }
//---------------------------------------------------------------------------

    /**
     * Добавить платёжный реквизит
     */
    public void addBankRecv() {
        newBankRecv.setPartner(current);
        current.getPartnerBankRecvList().add(newBankRecv);
        newBankRecv = new PartnerBankRecv();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Реквизит добавлен", "Добавлено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Удалить реквизит из списка
     *
     * @param forDel
     */
    public void delBankRecv(PartnerBankRecv forDel) {

        current.getPartnerBankRecvList().remove(forDel);
        newBankRecv = forDel;
        forDel.setPartner(null);
        //сообщить      
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Реквизит удалён", "Удалено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//---------------------------------------------------------------------------
    /**
     * Добавить адрес филиала
     */
    public void addBranchAddress() {
        newBranchAddr.setPartner(current);
        current.getPartnerAddressList().add(newBranchAddr);
        newBranchAddr = new PartnerAddress();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Адрес добавлен", "Добавлено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Удалить адрес филиала
     *
     * @param forDel
     */
    public void delBranchAddress(PartnerAddress forDel) {

        current.getPartnerAddressList().remove(forDel);
        newBranchAddr = forDel;
        forDel.setPartner(null);
        //сообщить      
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Адрес удалён", "Удалено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//---------------------------------------------------------------------------
    public void editSelectedEvent() {
        selectedEventRow.setCreateDate(new Date());
        selectedEventRow.setUser(loginBean.getCurrentUser());

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Правки внесены, надо сохранить", "Поправлено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Добавить событие
     */
    public void addEvent() {
        newEvent.setPartner(current);
        newEvent.setAttrs(newEventAttrs);
        newEventAttrs.setEvent(newEvent);
        newEvent.setCreateDate(new Date());
        current.getPartnerEventList().add(newEvent);
        newEvent.setUser(loginBean.getCurrentUser());//юзер-создатель

        newEvent = new PartnerEvent();
        newEventAttrs = new PartnerEventAttrs();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Событие добавлено", "Добавлено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Удалить событие
     *
     * @param forDel
     */
    public void delEvent(PartnerEvent forDel) {

        current.getPartnerEventList().remove(forDel);
        newEvent = forDel;
        if (forDel.getAttrs() != null) {
            newEventAttrs = forDel.getAttrs();
        }

        forDel.setPartner(null);
        //сообщить      
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Событие удалёно", "Удалено");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//--------------------------------------------------------------------------
    //==================== геттеры и сеттеры ==============
    public PartnerEvent getNewEvent() {
        return newEvent;
    }

    public PartnerEmplDataModel getEmplDataModel() {
        return emplDataModel;
    }

    public void setEmplDataModel(PartnerEmplDataModel emplDataModel) {
        this.emplDataModel = emplDataModel;
    }

    public void setNewEvent(PartnerEvent newEvent) {
        this.newEvent = newEvent;
    }

    public PartnerEventDataModel getEventDataModel() {
        return eventDataModel;
    }

    public void setEventDataModel(PartnerEventDataModel eventDataModel) {
        this.eventDataModel = eventDataModel;
    }

    public PartnerEvent getSelectedEventRow() {
        return selectedEventRow;
    }

    public void setSelectedEventRow(PartnerEvent selectedEventRow) {
        this.selectedEventRow = selectedEventRow;
    }

    public PartnerEventAttrs getNewEventAttrs() {
        return newEventAttrs;
    }

    public void setNewEventAttrs(PartnerEventAttrs newEventAttrs) {
        this.newEventAttrs = newEventAttrs;
    }

    public CardioPartner getCurrent() {
        return current;
    }

    /**
     * Выставить текущего партнёра для правки
     *
     * @param current
     */
    public void setCurrent(CardioPartner current) {
        this.current = current;
        employeVM.setCurrent(null);
        emplDataModel = new PartnerEmplDataModel(current.getPartnerEmployeList());
    }

    public boolean isDoCreateNew() {
        return doCreateNew;
    }

    public void setDoCreateNew(boolean doCreateNew) {
        this.doCreateNew = doCreateNew;
        updateCaption();
        employeVM.setCurrent(null);
        emplDataModel = new PartnerEmplDataModel(current.getPartnerEmployeList());
    }

    public List<UaState> getUaStates() {
        return uaStates;
    }

    public void setUaStates(List<UaState> uaStates) {
        this.uaStates = uaStates;
    }

    public List<UaTown> getUaTowns() {
        return uaTowns;
    }

    public void setUaTowns(List<UaTown> uaTowns) {
        this.uaTowns = uaTowns;
    }

    public PartnerBankRecv getNewBankRecv() {
        return newBankRecv;
    }

    public void setNewBankRecv(PartnerBankRecv newBankRecv) {
        this.newBankRecv = newBankRecv;
    }

    public PartnerAddress getNewBranchAddr() {
        return newBranchAddr;
    }

    public void setNewBranchAddr(PartnerAddress newBranchAddr) {
        this.newBranchAddr = newBranchAddr;
    }

    public int getTabBarId() {
        return tabBarId;
    }

    public void setTabBarId(int tabBarId) {
        this.tabBarId = tabBarId;
    }

    public List<PartnerEvent> getFilteredEvents() {
        return filteredEvents;
    }

    public void setFilteredEvents(List<PartnerEvent> filteredEvents) {
        this.filteredEvents = filteredEvents;
    }

    public String getFltEventLabel() {
        return fltEventLabel;
    }

    public void setFltEventLabel(String fltEventLabel) {
        this.fltEventLabel = fltEventLabel;
    }

    public String getFltEventUser() {
        return fltEventUser;
    }

    public void setFltEventUser(String fltEventUser) {
        this.fltEventUser = fltEventUser;
    }

    public String getFltEventSubj() {
        return fltEventSubj;
    }

    public void setFltEventSubj(String fltEventSubj) {
        this.fltEventSubj = fltEventSubj;
    }

    public String getFltEventType() {
        return fltEventType;
    }

    public void setFltEventType(String fltEventType) {
        this.fltEventType = fltEventType;
    }

    public String getCaption() {
        return caption;
    }

    /**
     * Обновить заголовок согласно текущему режиму работы
     */
    protected void updateCaption() {
        if (doCreateNew) {
            caption = "Заведение нового предприятия";
        } else {
            caption = "Правка предприятия \"" + current.getName() + "\"";
        }
    }

}
