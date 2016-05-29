PROMPT ALTER TABLE task_status ADD CONSTRAINT pk_task_status PRIMARY KEY
ALTER TABLE task_status
  ADD CONSTRAINT pk_task_status PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE task_status ADD CONSTRAINT unq_task_status UNIQUE
ALTER TABLE task_status
  ADD CONSTRAINT unq_task_status UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

