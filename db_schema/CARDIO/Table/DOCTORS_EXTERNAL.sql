PROMPT CREATE TABLE doctors_external
CREATE TABLE doctors_external (
  id           NUMBER(18,0)  NOT NULL,
  fio          VARCHAR2(128) NOT NULL,
  contacts_id  NUMBER(18,0)  NULL,
  birth_date   DATE          NOT NULL,
  send_rank_id NUMBER(18,0)  NULL,
  doc_type_id  NUMBER(18,0)  NULL,
  ua_town_id   NUMBER(8,0)   NULL,
  ua_state_id  NUMBER(8,0)   NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctors_external IS '������� �������, ��� �������';

COMMENT ON COLUMN doctors_external.fio IS '��� �������';
COMMENT ON COLUMN doctors_external.contacts_id IS '�������� �������';
COMMENT ON COLUMN doctors_external.birth_date IS '���� ��������';
COMMENT ON COLUMN doctors_external.send_rank_id IS '��������� ����(������� ������ �� �������)';
COMMENT ON COLUMN doctors_external.doc_type_id IS '��� �������(�������������)';
COMMENT ON COLUMN doctors_external.ua_town_id IS '���������� �����';
COMMENT ON COLUMN doctors_external.ua_state_id IS '���������� �������';

