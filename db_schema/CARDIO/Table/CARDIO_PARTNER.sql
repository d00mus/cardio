PROMPT CREATE TABLE cardio_partner
CREATE TABLE cardio_partner (
  id                   NUMBER(18,0)   NOT NULL,
  name                 VARCHAR2(255)  NOT NULL,
  phone                VARCHAR2(128)  NULL,
  jur_addr_ua_state_id NUMBER(8,0)    NOT NULL,
  jur_addr_ua_town_id  NUMBER(8,0)    NOT NULL,
  jur_addr_street      VARCHAR2(255)  NULL,
  jur_addr_house       VARCHAR2(100)  NULL,
  inn                  VARCHAR2(16)   NOT NULL,
  www                  VARCHAR2(1024) NULL,
  email                VARCHAR2(1024) NULL,
  manager_id           NUMBER(10,0)   NULL,
  type_id              NUMBER(8,0)    DEFAULT 1 NOT NULL,
  phone1               VARCHAR2(128)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_partner IS 'Учреждения(партнёры)';

COMMENT ON COLUMN cardio_partner.name IS 'Название';
COMMENT ON COLUMN cardio_partner.phone IS 'Телефон(ы)';
COMMENT ON COLUMN cardio_partner.jur_addr_ua_state_id IS 'Юр адрес - область';
COMMENT ON COLUMN cardio_partner.jur_addr_ua_town_id IS 'Юр адрес - город';
COMMENT ON COLUMN cardio_partner.jur_addr_street IS 'Юр адрес - улица';
COMMENT ON COLUMN cardio_partner.jur_addr_house IS 'Юр адрес - дом и прочее';
COMMENT ON COLUMN cardio_partner.inn IS 'ИНН';
COMMENT ON COLUMN cardio_partner.www IS 'Сайт';
COMMENT ON COLUMN cardio_partner.email IS 'email';
COMMENT ON COLUMN cardio_partner.manager_id IS 'Кто менеджер';
COMMENT ON COLUMN cardio_partner.type_id IS 'Тип конторы';
COMMENT ON COLUMN cardio_partner.phone1 IS 'Ещё телефон(ы)';

