PROMPT CREATE TABLE cardio_user
CREATE TABLE cardio_user (
  id                 NUMBER(10,0)  NOT NULL,
  user_name          VARCHAR2(32)  NOT NULL,
  password           VARCHAR2(32)  NOT NULL,
  short_name         VARCHAR2(255) NULL,
  first_name         VARCHAR2(255) NULL,
  last_name          VARCHAR2(255) NULL,
  middle_name        VARCHAR2(255) NULL,
  birth_date         DATE          NULL,
  adr_state_id       NUMBER(8,0)   NULL,
  adr_town_id        NUMBER(8,0)   NULL,
  address            VARCHAR2(255) NULL,
  work_email         VARCHAR2(255) NULL,
  personal_email     VARCHAR2(255) NULL,
  is_outside_empl    CHAR(1)       DEFAULT 'F' NULL,
  outside_work_place VARCHAR2(255) NULL,
  outside_work_spec  VARCHAR2(255) NULL,
  pass_ser           VARCHAR2(8)   NULL,
  pass_no            VARCHAR2(32)  NULL,
  pass_giveout_date  DATE          NULL,
  pass_giveout       VARCHAR2(255) NULL,
  inn                VARCHAR2(32)  NULL,
  is_driver          CHAR(1)       NULL,
  drv_lic_no         VARCHAR2(32)  NULL,
  notes              VARCHAR2(255) NULL,
  is_have_auto       CHAR(1)       NULL,
  lic_auto_model     VARCHAR2(255) NULL,
  lic_auto_no        VARCHAR2(16)  NULL,
  fam_mbr_name       VARCHAR2(255) NULL,
  fam_mbr_phone_id   NUMBER(8,0)   NULL,
  avatar_file_id     NUMBER(8,0)   NULL,
  theme_name         VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON COLUMN cardio_user.user_name IS 'Логин пользователя системы';
COMMENT ON COLUMN cardio_user.password IS 'пароль, MD5 хеш';
COMMENT ON COLUMN cardio_user.short_name IS 'Краткое имя';
COMMENT ON COLUMN cardio_user.first_name IS 'Имя';
COMMENT ON COLUMN cardio_user.last_name IS 'Фамилия';
COMMENT ON COLUMN cardio_user.middle_name IS 'Отчество';
COMMENT ON COLUMN cardio_user.birth_date IS 'Дата рождения';
COMMENT ON COLUMN cardio_user.adr_state_id IS 'Адрес/Область';
COMMENT ON COLUMN cardio_user.adr_town_id IS 'Адрес/Город';
COMMENT ON COLUMN cardio_user.address IS 'Адрес - улица, дом, кв';
COMMENT ON COLUMN cardio_user.work_email IS 'Рабочий эл. адрес';
COMMENT ON COLUMN cardio_user.personal_email IS 'Личный эл. адрес';
COMMENT ON COLUMN cardio_user.is_outside_empl IS 'Дополнительно работает за пределами компании';
COMMENT ON COLUMN cardio_user.outside_work_place IS 'Место работы за пределами компании(Где)';
COMMENT ON COLUMN cardio_user.outside_work_spec IS 'Место работы за пределами компании(Кем)';
COMMENT ON COLUMN cardio_user.pass_ser IS 'Паспорт/серия';
COMMENT ON COLUMN cardio_user.pass_no IS 'Паспорт/номер';
COMMENT ON COLUMN cardio_user.pass_giveout_date IS 'Паспорт/дата выдачи';
COMMENT ON COLUMN cardio_user.pass_giveout IS 'Паспорт/кем выдан';
COMMENT ON COLUMN cardio_user.inn IS 'ИНН';
COMMENT ON COLUMN cardio_user.is_driver IS 'Наличие прав';
COMMENT ON COLUMN cardio_user.drv_lic_no IS 'Номер прав';
COMMENT ON COLUMN cardio_user.notes IS 'Примечание';
COMMENT ON COLUMN cardio_user.is_have_auto IS 'Есть личное авто';
COMMENT ON COLUMN cardio_user.lic_auto_model IS 'Модель личного авто';
COMMENT ON COLUMN cardio_user.lic_auto_no IS 'Гос номер авто';
COMMENT ON COLUMN cardio_user.fam_mbr_name IS 'Родственник';
COMMENT ON COLUMN cardio_user.fam_mbr_phone_id IS 'Телефон родственника';
COMMENT ON COLUMN cardio_user.avatar_file_id IS 'Ссылка на файл с авой';
COMMENT ON COLUMN cardio_user.theme_name IS 'Название темы оформления';

