PROMPT ALTER TABLE project_event ADD CONSTRAINT pk_project_event PRIMARY KEY
ALTER TABLE project_event
  ADD CONSTRAINT pk_project_event PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

