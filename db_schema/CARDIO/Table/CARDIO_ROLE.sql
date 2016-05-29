PROMPT CREATE TABLE cardio_role
CREATE TABLE cardio_role (
  id          NUMBER(10,0) NOT NULL,
  role_name   VARCHAR2(32) NOT NULL,
  description VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_role IS '���������� �����';

COMMENT ON COLUMN cardio_role.role_name IS '��������� ��� ����';
COMMENT ON COLUMN cardio_role.description IS '�������� ����';

