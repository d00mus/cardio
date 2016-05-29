PROMPT CREATE TABLE task_type
CREATE TABLE task_type (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(64)  NOT NULL,
  name VARCHAR2(128) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE task_type IS 'Типы задач';


