PROMPT CREATE TABLE cardio_project
CREATE TABLE cardio_project (
  id              NUMBER(18,0)  NOT NULL,
  partner_id      NUMBER(18,0)  NULL,
  status_id       NUMBER(8,0)   NULL,
  user_id         NUMBER(10,0)  NULL,
  name            VARCHAR2(255) NULL,
  notes           VARCHAR2(255) NULL,
  contact_pers_id NUMBER(18,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_project IS '������� ���������';

COMMENT ON COLUMN cardio_project.partner_id IS '����������';
COMMENT ON COLUMN cardio_project.status_id IS '������';
COMMENT ON COLUMN cardio_project.user_id IS '������� ����';
COMMENT ON COLUMN cardio_project.name IS '��������';
COMMENT ON COLUMN cardio_project.notes IS '����������';
COMMENT ON COLUMN cardio_project.contact_pers_id IS '���������� �������, ��������� ����������';

