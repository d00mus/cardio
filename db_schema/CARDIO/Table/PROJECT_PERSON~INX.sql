PROMPT CREATE INDEX unq_pk_project_person
CREATE UNIQUE INDEX unq_pk_project_person
  ON project_person (
    project_id,
    employe_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

