PROMPT CREATE TABLE project_event
CREATE TABLE project_event (
  id          NUMBER(18,0)   NOT NULL,
  project_id  NUMBER(18,0)   NOT NULL,
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

COMMENT ON TABLE project_event IS '������� �� �������';

COMMENT ON COLUMN project_event.project_id IS '������, � �������� ��������� ������ �������';
COMMENT ON COLUMN project_event.user_id IS '����, ������� ������� ������';
COMMENT ON COLUMN project_event.event_date IS '���� �������';
COMMENT ON COLUMN project_event.create_date IS '���� �������� �������';
COMMENT ON COLUMN project_event.label IS '�����, ������� ����';
COMMENT ON COLUMN project_event.type_id IS '��� �������';
COMMENT ON COLUMN project_event.subj_id IS '������� �������';
COMMENT ON COLUMN project_event.employe_id IS '���������, ��������� � ������ ��������';

