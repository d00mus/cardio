PROMPT ALTER TABLE project_person ADD CONSTRAINT pk_project_person PRIMARY KEY
ALTER TABLE project_person
  ADD CONSTRAINT pk_project_person PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

