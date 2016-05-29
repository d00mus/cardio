PROMPT CREATE TABLE user_education
CREATE TABLE user_education (
  id        NUMBER(8,0)   NOT NULL,
  user_id   NUMBER(8,0)   NOT NULL,
  univer    VARCHAR2(255) NULL,
  spec      VARCHAR2(255) NULL,
  diplom_no VARCHAR2(255) NULL,
  end_date  DATE          NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE user_education IS '����������� �����������';

COMMENT ON COLUMN user_education.user_id IS '���������';
COMMENT ON COLUMN user_education.univer IS '���������';
COMMENT ON COLUMN user_education.spec IS '�������������';
COMMENT ON COLUMN user_education.diplom_no IS '����� �������';
COMMENT ON COLUMN user_education.end_date IS '���� ���������';

