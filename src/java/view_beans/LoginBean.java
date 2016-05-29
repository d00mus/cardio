package view_beans;

import dao.CardioUserFacade;
import dao.PfThemeFacade;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mdl.CardioRole;
import mdl.CardioUser;
import mdl.PfTheme;

/**
 * Бин, хранящий инфо о юзере, который вошёл
 *
 * @author d00mus
 */
@SessionScoped
@Named("loginBean")
public class LoginBean implements Serializable {

    private HttpSession sess;
    private Principal pricipal;
    private CardioUser currentUser;

    private CardioRole roleForAdd;

    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    private boolean _isAdmin = false;
    private boolean _isSysAdmin = false;
    private boolean _isNurse = false;
    private boolean _isManager = false;
    private boolean _isBuch = false;
    private boolean _isChief = false;
    private boolean _isEngeener = false;
    private boolean isRolesSet = false;

    @EJB
    private CardioUserFacade userDao;
    
    @EJB
    private PfThemeFacade themeDao;
    

    private void clearRoles() {
        _isAdmin = false;//флаг наличия у юзера роли Админа
        _isSysAdmin = false;//флаг наличия у юзера роли СисАдмина
        _isNurse = false;//флаг наличия у юзера роли Медсестры
        _isManager = false;//флаг наличия у юзера роли Менеджера
        _isBuch = false;//флаг наличия у юзера роли буха
        _isEngeener = false;//флаг наличия у юзера роли инженера
        _isChief = false;//флаг наличия у юзера роли главбуха(босса)
        isRolesSet = false;//признак того, что роли выставленны
    }

    public HttpSession getSession() {
        if (sess == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            pricipal = request.getUserPrincipal();
            sess = request.getSession(true);
        }
        return sess;
    }

    /**
     * Выйти из системы, сбросить данные текущего юзера
     *
     * @return адрес страницы с выходом
     */
    public String logout() {
        this.getSession().invalidate();
       //getSession();

        currentUser = null;
        pricipal = null;
        sess = null;
        clearRoles();
        /*       
         FacesContext context = FacesContext.getCurrentInstance();  
         HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
         */
        System.out.println("logged out!");
        return "/index?faces-redirect=true";
    }

    public Principal getPrincipal() {
        getSession();
        return pricipal;
    }

    public String getUserName() {
        getSession();
        if (pricipal != null) {
            getCurrentUser();//прочитать параметры текущего юзера из базы
            return pricipal.getName();
        }
        return null;
    }

    /**
     * Загрузить роли текущего залогиненного юзера
     */
    private void loadRoles() {
        _isAdmin = findRoleByName("ADMIN");
        _isNurse = findRoleByName("NURSE");
        _isSysAdmin = findRoleByName("SYSADMIN");
        _isManager = findRoleByName("MANAGER");
        _isBuch = findRoleByName("BUCH");
        _isEngeener = findRoleByName("ENGENEER");
        _isChief = findRoleByName("CHIEF");
        isRolesSet = true;
    }

    /**
     * Получить текущего юзера, если не установлен - читает его из принципала
     * Загружает роли юзера
     */
    public CardioUser getCurrentUser() {
        if (currentUser == null && pricipal != null) {
            TypedQuery<CardioUser> usrQ = em.createQuery("select c from CardioUser c where c.userName = :p_user_name", CardioUser.class);
            usrQ.setParameter("p_user_name", pricipal.getName());
            currentUser = usrQ.getSingleResult();
            loadRoles();//загрузить роли текущего юзера 
        }
        return currentUser;
    }

    //вынести этот код в админку!
    public CardioRole getRoleForAdd() {
        return roleForAdd;
    }

    public void setRoleForAdd(CardioRole roleForAdd) {
        this.roleForAdd = roleForAdd;
    }

    public void addRole() {
        currentUser.getRoleList().add(roleForAdd);
        userDao.edit(currentUser);
    }

    public void delRole(CardioRole roleForDel) {
        currentUser.getRoleList().remove(roleForDel);
        userDao.edit(currentUser);
    }
    //---------вынос в админку----------

    /**
     * Найти у текущего юзера роль по имени
     *
     * @param roleName
     * @return
     */
    private boolean findRoleByName(String roleName) {
        boolean result = false;
        if (roleName == null || currentUser == null) {
            return false;
        }

        for (CardioRole rol : currentUser.getRoleList()) {
            if (roleName.equals(rol.getRoleName())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Проверить наличие у текущего юзера прав админа
     *
     * @return
     */
    public boolean isAdmin() {
        return isRolesSet && (_isAdmin || _isSysAdmin);
    }

    /**
     * Проверить наличие у текущего юзера прав медсестры
     *
     * @return
     */
    public boolean isNurse() {
        return isRolesSet && (_isAdmin || _isSysAdmin || _isNurse);
    }

    /**
     * Проверить наличие у текущего юзера прав менеджера
     *
     * @return
     */
    public boolean isManager() {
        return isRolesSet && (_isAdmin || _isSysAdmin || _isManager);
    }

    /**
     * Проверить у юзера наличие роли инженера
     *
     * @return
     */
    public boolean isEngeneer() {
        return isRolesSet && (_isAdmin || _isSysAdmin || _isEngeener);
    }

    /**
     * Проверить у юзера наличие роли буха
     *
     * @return
     */
    public boolean isBuch() {
        return isRolesSet && (_isAdmin || _isSysAdmin || _isBuch);
    }

    /**
     * Проверить наличие у текущего юзера прав сисадмина
     *
     * @return
     */
    public boolean isSysAdmin() {
        return isRolesSet && (_isSysAdmin);
    }
    
    public boolean isChief() {
        return isRolesSet && (_isAdmin || _isSysAdmin || _isChief);
    }

    public String getThemeName() {
        if (currentUser == null || currentUser.getTheme() == null || currentUser.getTheme().getThemeName() == null) {
            return "hot-sneaks";
        } else {
            return currentUser.getTheme().getThemeName();
        }
    }
    
    public void setThemeName(String themeName) {
        List<PfTheme> allThemes = themeDao.findAll();
        for(PfTheme theme:allThemes){
            if(themeName.equals(theme.getThemeName())){
              currentUser.setTheme(theme);
              userDao.edit(currentUser);
            }
        }
    }
}
