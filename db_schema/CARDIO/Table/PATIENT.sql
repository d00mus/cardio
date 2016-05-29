PROMPT CREATE TABLE patient
CREATE TABLE patient (
  id                     NUMBER(18,0)   NOT NULL,
  name                   VARCHAR2(64)   NULL,
  first_name             VARCHAR2(64)   NULL,
  second_name            VARCHAR2(64)   NULL,
  pseudo_name            VARCHAR2(64)   NULL,
  sex                    CHAR(1)        DEFAULT 'M' NOT NULL,
  birth_date             DATE           NOT NULL,
  adr_country            VARCHAR2(64)   DEFAULT 'Украина' NOT NULL,
  adr_city               VARCHAR2(64)   NULL,
  adr_street             VARCHAR2(64)   NULL,
  adr_house              VARCHAR2(8)    NULL,
  adr_flat               VARCHAR2(8)    NULL,
  cur_height             NUMBER(8,2)    NULL,
  cur_weight             NUMBER(8,2)    NULL,
  pass_ser               VARCHAR2(8)    NULL,
  pass_no                VARCHAR2(16)   NULL,
  pass_date              DATE           NULL,
  pass_gived_by          VARCHAR2(255)  NULL,
  contacts_id            NUMBER(18,0)   NULL,
  avatar_id              NUMBER(18,0)   NULL,
  work_town              VARCHAR2(64)   NULL,
  work_place             VARCHAR2(64)   NULL,
  is_foto_ads_allowed    CHAR(1)        DEFAULT 'F' NOT NULL,
  is_tv_ads_allowed      CHAR(1)        DEFAULT 'F' NOT NULL,
  is_other_ads_allowed   CHAR(1)        DEFAULT 'F' NOT NULL,
  vip_rank_id            NUMBER(18,0)   NULL,
  ref_info_doc_id        NUMBER(18,0)   NULL,
  ref_info_patient_id    NUMBER(18,0)   NULL,
  ref_rank_id            NUMBER(18,0)   NULL,
  is_checked             CHAR(1)        DEFAULT 'F' NOT NULL,
  is_active              CHAR(1)        DEFAULT 'T' NOT NULL,
  is_interest            CHAR(1)        DEFAULT 'F' NOT NULL,
  create_date            DATE           DEFAULT sysdate NOT NULL,
  last_psg_date          DATE           NULL,
  adr_district           VARCHAR2(64)   NULL,
  adr_ua_town_id         NUMBER(8,0)    NULL,
  adr_ua_state_id        NUMBER(8,0)    NULL,
  self_story             VARCHAR2(4000) NULL,
  nurse_notes            VARCHAR2(4000) NULL,
  special_notes          VARCHAR2(4000) NULL,
  doc_conlusion          VARCHAR2(4000) NULL,
  ref_info_src_type_id   NUMBER(8,0)    NULL,
  ref_info_src_detail    VARCHAR2(1000) NULL,
  cured_by_doc           VARCHAR2(255)  NULL,
  is_lor_invasion        CHAR(1)        DEFAULT 'F' NOT NULL,
  lor_invasion_details   VARCHAR2(1000) NULL,
  is_allergic            CHAR(1)        DEFAULT 'F' NOT NULL,
  allergic_detail        VARCHAR2(2000) NULL,
  is_gepatit             CHAR(1)        DEFAULT 'F' NOT NULL,
  is_botkin              CHAR(1)        DEFAULT 'F' NOT NULL,
  is_cert_given          CHAR(1)        DEFAULT 'F' NOT NULL,
  next_psg_date          DATE           NULL,
  created_by_user_id     NUMBER(10,0)   NULL,
  partner_name           VARCHAR2(255)  NULL,
  partner_phone_id       NUMBER(18,0)   NULL,
  fam_member_name        VARCHAR2(255)  NULL,
  fam_member_phone_id    NUMBER(18,0)   NULL,
  email_addr_list        VARCHAR2(2000) NULL,
  work_ua_town_id        NUMBER(8,0)    NULL,
  tracked_by_user_id     NUMBER(10,0)   NULL,
  cpap_status            VARCHAR2(64)   NULL,
  is_birth_day_not_valid CHAR(1)        DEFAULT 'T' NULL,
  is_card_prg_passed     CHAR(1)        NULL,
  patalogy_detail        VARCHAR2(2000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient IS 'Пациенты';

COMMENT ON COLUMN patient.name IS 'Фамилия';
COMMENT ON COLUMN patient.first_name IS 'Имя';
COMMENT ON COLUMN patient.second_name IS 'Отчество';
COMMENT ON COLUMN patient.pseudo_name IS 'Псевдоним';
COMMENT ON COLUMN patient.sex IS 'Пол (M,F)';
COMMENT ON COLUMN patient.birth_date IS 'Дата рождения';
COMMENT ON COLUMN patient.adr_country IS 'Адрес - страна';
COMMENT ON COLUMN patient.adr_city IS 'Адрес - город';
COMMENT ON COLUMN patient.adr_street IS 'Адрес - улица';
COMMENT ON COLUMN patient.adr_house IS 'Адрес - дом';
COMMENT ON COLUMN patient.adr_flat IS 'Адрес - квартира';
COMMENT ON COLUMN patient.cur_height IS 'Текущий рост, см';
COMMENT ON COLUMN patient.cur_weight IS 'Текуший вес, кг';
COMMENT ON COLUMN patient.pass_ser IS 'Паспорт: серия';
COMMENT ON COLUMN patient.pass_no IS 'Паспорт: номер';
COMMENT ON COLUMN patient.pass_date IS 'Паспорт: дата выдачи';
COMMENT ON COLUMN patient.pass_gived_by IS 'Паспорт: Кем выдан';
COMMENT ON COLUMN patient.contacts_id IS 'Ссылка на контакты';
COMMENT ON COLUMN patient.avatar_id IS 'Ссылка на фотку - аватар';
COMMENT ON COLUMN patient.work_town IS 'Город, в котором работает';
COMMENT ON COLUMN patient.work_place IS 'Место работы';
COMMENT ON COLUMN patient.is_foto_ads_allowed IS 'Согласие на использование в фото-рекламе';
COMMENT ON COLUMN patient.is_tv_ads_allowed IS 'Согласие на использование в ТВ-рекламе';
COMMENT ON COLUMN patient.is_other_ads_allowed IS 'Согласие на использование в прочей рекламе';
COMMENT ON COLUMN patient.vip_rank_id IS 'Уровень крутости пациента';
COMMENT ON COLUMN patient.ref_info_doc_id IS 'Источник информации: кто из докторов его прислал';
COMMENT ON COLUMN patient.ref_info_patient_id IS 'Источник информации: Кто из пациентов его прислал';
COMMENT ON COLUMN patient.ref_rank_id IS 'Сколько раз этот пациент присылал других, его ссылочный рейтинг';
COMMENT ON COLUMN patient.is_checked IS 'Анкета проверена администратором';
COMMENT ON COLUMN patient.is_active IS 'Признак того, что пациент активен(лечится)';
COMMENT ON COLUMN patient.is_interest IS 'Интересный пациент?';
COMMENT ON COLUMN patient.create_date IS 'Дата создания анкеты';
COMMENT ON COLUMN patient.last_psg_date IS 'Дата последней ПГС';
COMMENT ON COLUMN patient.adr_district IS 'Адрес - Область, название';
COMMENT ON COLUMN patient.adr_ua_town_id IS 'Адрес - ссылка на украинский город';
COMMENT ON COLUMN patient.adr_ua_state_id IS 'Адрес - ссылка на украинскую область';
COMMENT ON COLUMN patient.self_story IS 'Рассказ пациента, жалобы';
COMMENT ON COLUMN patient.nurse_notes IS 'Заметки - для сестры, врача';
COMMENT ON COLUMN patient.special_notes IS 'Особые заметки - инфаркт, сердечная недостаточность, идр';
COMMENT ON COLUMN patient.doc_conlusion IS 'Заключение врача';
COMMENT ON COLUMN patient.ref_info_src_type_id IS 'Источник информации:Ссылка на тип информации, которая привела пациента в клинику';
COMMENT ON COLUMN patient.ref_info_src_detail IS 'Источник информации:Подбробности, относительно типа инфы';
COMMENT ON COLUMN patient.cured_by_doc IS 'Лечащий врач, кардилог, невропатолог, эндокринолог, семейный, итд';
COMMENT ON COLUMN patient.is_lor_invasion IS 'ЛОР-вмешательства: были?';
COMMENT ON COLUMN patient.lor_invasion_details IS 'ЛОР-вмешательства:подробности';
COMMENT ON COLUMN patient.is_allergic IS 'Алергия: есть?';
COMMENT ON COLUMN patient.allergic_detail IS 'Алергия: подробности';
COMMENT ON COLUMN patient.is_gepatit IS 'Гепатит?';
COMMENT ON COLUMN patient.is_botkin IS 'Боткин?';
COMMENT ON COLUMN patient.is_cert_given IS 'Выдан ли сертификат?';
COMMENT ON COLUMN patient.next_psg_date IS 'Дата очередной ПСГ, должна обновлятся по результатам ПСГ и обзвона??';
COMMENT ON COLUMN patient.created_by_user_id IS 'Юзер, который создал анкету';
COMMENT ON COLUMN patient.partner_name IS 'Супруг пациента';
COMMENT ON COLUMN patient.partner_phone_id IS 'Телефон супруга, из множества телефонов данного пациента';
COMMENT ON COLUMN patient.fam_member_name IS 'Член семьи пациента';
COMMENT ON COLUMN patient.fam_member_phone_id IS 'Телефон члена семьи, из множества телефонов данного пациента';
COMMENT ON COLUMN patient.email_addr_list IS 'Список email-адресов пациента, разделённые запятыми';
COMMENT ON COLUMN patient.work_ua_town_id IS 'Ссылка на украинский город, в котором работает пациент';
COMMENT ON COLUMN patient.tracked_by_user_id IS 'Ссылка на пользователя, который ведёт анкету';
COMMENT ON COLUMN patient.cpap_status IS 'CPAP: купил/ не купил/ вернул';
COMMENT ON COLUMN patient.is_birth_day_not_valid IS 'Признак того, что день рождения пациента известен точно';
COMMENT ON COLUMN patient.is_card_prg_passed IS 'Пройдена ли кардио программа?';
COMMENT ON COLUMN patient.patalogy_detail IS 'Сопутствующая патология';

