PROMPT ALTER TABLE project_status ADD CONSTRAINT pk_project_status PRIMARY KEY
ALTER TABLE project_status
  ADD CONSTRAINT pk_project_status PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE project_status ADD CONSTRAINT unq_project_status UNIQUE
ALTER TABLE project_status
  ADD CONSTRAINT unq_project_status UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

