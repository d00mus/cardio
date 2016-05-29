PROMPT ALTER TABLE task ADD CONSTRAINT pk_task PRIMARY KEY
ALTER TABLE task
  ADD CONSTRAINT pk_task PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

