PROMPT CREATE TABLE project_event_attrs
CREATE TABLE project_event_attrs (
  event_id       NUMBER(18,0)   NOT NULL,
  text_field     VARCHAR2(4000) NULL,
  item_no        VARCHAR2(32)   NULL,
  company_id     NUMBER(8,0)    NULL,
  date_field     DATE           NULL,
  user_id        NUMBER(10,0)   NULL,
  is_proxy_exist VARCHAR2(5)    DEFAULT 'false' NULL,
  conference_id  NUMBER(18,0)   NULL,
  cp_subject_id  NUMBER(8,0)    NULL,
  pay_status     NUMBER(8,0)    NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE project_event_attrs IS '��������� ��������� �������';

COMMENT ON COLUMN project_event_attrs.event_id IS '������ �� �������';
COMMENT ON COLUMN project_event_attrs.text_field IS '��������� ����';
COMMENT ON COLUMN project_event_attrs.item_no IS '���� � �������';
COMMENT ON COLUMN project_event_attrs.company_id IS '������ �� ����� ������';
COMMENT ON COLUMN project_event_attrs.date_field IS '���� � �����';
COMMENT ON COLUMN project_event_attrs.user_id IS '������ �� �����';
COMMENT ON COLUMN project_event_attrs.is_proxy_exist IS '������������ ����? (��/���)';
COMMENT ON COLUMN project_event_attrs.conference_id IS '������ �� �����������';
COMMENT ON COLUMN project_event_attrs.cp_subject_id IS '�������� ��';
COMMENT ON COLUMN project_event_attrs.pay_status IS '������ �������(������� ��� ���)';

