PROMPT CREATE TABLE task
CREATE TABLE task (
  id                  NUMBER(18,0)   NOT NULL,
  user_id             NUMBER(10,0)   NOT NULL,
  partner_id          NUMBER(18,0)   NOT NULL,
  type_id             NUMBER(8,0)    NOT NULL,
  plan_date           DATE           NULL,
  status_id           NUMBER(8,0)    NOT NULL,
  fact_date           DATE           NULL,
  ua_town_id          NUMBER(8,0)    NULL,
  person_id           NUMBER(18,0)   NULL,
  notes               VARCHAR2(4000) NULL,
  engineer_id         NUMBER(10,0)   NULL,
  cont_pers_aux       VARCHAR2(256)  NULL,
  cont_pers_phone_id  NUMBER(18,0)   NULL,
  cont_pers_phone_aux VARCHAR2(32)   NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE task IS '������ ���������';

COMMENT ON COLUMN task.user_id IS '��������';
COMMENT ON COLUMN task.partner_id IS '������';
COMMENT ON COLUMN task.type_id IS '��� ������';
COMMENT ON COLUMN task.plan_date IS '���� �� �����';
COMMENT ON COLUMN task.status_id IS '������� ������';
COMMENT ON COLUMN task.fact_date IS '����������� ����';
COMMENT ON COLUMN task.ua_town_id IS '�����';
COMMENT ON COLUMN task.person_id IS '����� ���� � ����������..���� ���';
COMMENT ON COLUMN task.notes IS '����������';
COMMENT ON COLUMN task.engineer_id IS '�������';
COMMENT ON COLUMN task.cont_pers_aux IS '��� ����� ���������� �������';
COMMENT ON COLUMN task.cont_pers_phone_id IS '������� ��������';
COMMENT ON COLUMN task.cont_pers_phone_aux IS '����� ������� ���������� �������';

