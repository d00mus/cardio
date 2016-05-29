PROMPT CREATE TABLE partner_employe
CREATE TABLE partner_employe (
  id                 NUMBER(18,0)   NOT NULL,
  partner_id         NUMBER(18,0)   NOT NULL,
  first_name         VARCHAR2(255)  NOT NULL,
  last_name          VARCHAR2(255)  NOT NULL,
  middle_name        VARCHAR2(255)  NULL,
  sex                CHAR(1)        DEFAULT 'M' NOT NULL,
  birth_date         DATE           NULL,
  ua_state_id        NUMBER(8,0)    NULL,
  manager_id         NUMBER(8,0)    NULL,
  manager2_id        NUMBER(8,0)    NULL,
  is_doc             VARCHAR2(5)    DEFAULT 'true' NOT NULL,
  position_id        NUMBER(8,0)    NULL,
  doctor_type_id     NUMBER(8,0)    NULL,
  doctor_rank_id     NUMBER(8,0)    NULL,
  doctor_division_id NUMBER(8,0)    NULL,
  doctor_position_id NUMBER(8,0)    NULL,
  doctor_assoc_id    NUMBER(8,0)    NULL,
  doctor_priority_id NUMBER(8,0)    NULL,
  ref_count          NUMBER(8,0)    NULL,
  email1             VARCHAR2(1024) NULL,
  email2             VARCHAR2(1024) NULL,
  www                VARCHAR2(1024) NULL,
  notes              VARCHAR2(4000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_employe IS '���������� ��������(������)';

COMMENT ON COLUMN partner_employe.partner_id IS '������';
COMMENT ON COLUMN partner_employe.first_name IS '���';
COMMENT ON COLUMN partner_employe.last_name IS '�������';
COMMENT ON COLUMN partner_employe.middle_name IS '��������';
COMMENT ON COLUMN partner_employe.sex IS '���';
COMMENT ON COLUMN partner_employe.birth_date IS '���� ��������';
COMMENT ON COLUMN partner_employe.ua_state_id IS '�����-�������';
COMMENT ON COLUMN partner_employe.manager_id IS '�������� ����';
COMMENT ON COLUMN partner_employe.manager2_id IS '�������� ���';
COMMENT ON COLUMN partner_employe.is_doc IS '��� ������?';
COMMENT ON COLUMN partner_employe.position_id IS '��������� �� �������';
COMMENT ON COLUMN partner_employe.doctor_type_id IS '������������� �������';
COMMENT ON COLUMN partner_employe.doctor_rank_id IS '���� �������';
COMMENT ON COLUMN partner_employe.doctor_division_id IS '����������� ��������� ';
COMMENT ON COLUMN partner_employe.doctor_position_id IS '��������� �������';
COMMENT ON COLUMN partner_employe.doctor_assoc_id IS '���������� �������';
COMMENT ON COLUMN partner_employe.doctor_priority_id IS '���������';
COMMENT ON COLUMN partner_employe.ref_count IS '���-�� ������ �� ����';
COMMENT ON COLUMN partner_employe.email1 IS '�����1';
COMMENT ON COLUMN partner_employe.email2 IS '�����2';
COMMENT ON COLUMN partner_employe.www IS '����';
COMMENT ON COLUMN partner_employe.notes IS '����������';

