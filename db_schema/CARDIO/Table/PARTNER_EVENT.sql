PROMPT CREATE TABLE partner_event
CREATE TABLE partner_event (
  id          NUMBER(18,0)   NOT NULL,
  partner_id  NUMBER(18,0)   NOT NULL,
  user_id     NUMBER(10,0)   NOT NULL,
  event_date  DATE           NOT NULL,
  create_date DATE           NOT NULL,
  label       VARCHAR2(2000) NULL,
  type_id     NUMBER(8,0)    NOT NULL,
  subj_id     NUMBER(8,0)    NOT NULL,
  employe_id  NUMBER(18,0)   NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_event IS '�������, ��������';

COMMENT ON COLUMN partner_event.partner_id IS '������, � �������� ��������� ������ �������';
COMMENT ON COLUMN partner_event.user_id IS '����, ������� ������� ������';
COMMENT ON COLUMN partner_event.event_date IS '���� �������';
COMMENT ON COLUMN partner_event.create_date IS '���� �������� �������';
COMMENT ON COLUMN partner_event.label IS '�����, ������� ����';
COMMENT ON COLUMN partner_event.type_id IS '��� �������';
COMMENT ON COLUMN partner_event.subj_id IS '������� �������';
COMMENT ON COLUMN partner_event.employe_id IS '���������, ��������� � ������ ��������';

