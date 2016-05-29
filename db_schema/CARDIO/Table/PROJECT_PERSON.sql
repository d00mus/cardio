PROMPT CREATE TABLE project_person
CREATE TABLE project_person (
  id         NUMBER(18,0) NOT NULL,
  project_id NUMBER(18,0) NOT NULL,
  employe_id NUMBER(18,0) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE project_person IS 'Сотрудники по проекту';


