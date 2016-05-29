PROMPT CREATE TABLE user_occupation
CREATE TABLE user_occupation (
  id         NUMBER(8,0)   NOT NULL,
  user_id    NUMBER(8,0)   NOT NULL,
  company_id NUMBER(8,0)   NOT NULL,
  start_date DATE          NULL,
  end_date   DATE          NULL,
  position   VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE user_occupation IS '��������� ������������� � ���������';

COMMENT ON COLUMN user_occupation.user_id IS '����';
COMMENT ON COLUMN user_occupation.company_id IS '������ �� ��������';
COMMENT ON COLUMN user_occupation.start_date IS '���� ������ ������';
COMMENT ON COLUMN user_occupation.end_date IS '���� ��������� ������';
COMMENT ON COLUMN user_occupation.position IS '���������';

