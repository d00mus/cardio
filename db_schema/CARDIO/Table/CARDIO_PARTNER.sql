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

COMMENT ON TABLE cardio_partner IS '����������(�������)';

COMMENT ON COLUMN cardio_partner.name IS '��������';
COMMENT ON COLUMN cardio_partner.phone IS '�������(�)';
COMMENT ON COLUMN cardio_partner.jur_addr_ua_state_id IS '�� ����� - �������';
COMMENT ON COLUMN cardio_partner.jur_addr_ua_town_id IS '�� ����� - �����';
COMMENT ON COLUMN cardio_partner.jur_addr_street IS '�� ����� - �����';
COMMENT ON COLUMN cardio_partner.jur_addr_house IS '�� ����� - ��� � ������';
COMMENT ON COLUMN cardio_partner.inn IS '���';
COMMENT ON COLUMN cardio_partner.www IS '����';
COMMENT ON COLUMN cardio_partner.email IS 'email';
COMMENT ON COLUMN cardio_partner.manager_id IS '��� ��������';
COMMENT ON COLUMN cardio_partner.type_id IS '��� �������';
COMMENT ON COLUMN cardio_partner.phone1 IS '��� �������(�)';

