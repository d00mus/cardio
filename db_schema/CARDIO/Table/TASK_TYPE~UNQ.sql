PROMPT ALTER TABLE task_type ADD CONSTRAINT pk_task_type PRIMARY KEY
ALTER TABLE task_type
  ADD CONSTRAINT pk_task_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE task_type ADD CONSTRAINT unq_task_type UNIQUE
ALTER TABLE task_type
  ADD CONSTRAINT unq_task_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

