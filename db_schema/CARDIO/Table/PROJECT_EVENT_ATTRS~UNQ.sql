PROMPT ALTER TABLE project_event_attrs ADD CONSTRAINT pk_project_event_attrs PRIMARY KEY
ALTER TABLE project_event_attrs
  ADD CONSTRAINT pk_project_event_attrs PRIMARY KEY (
    event_id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

