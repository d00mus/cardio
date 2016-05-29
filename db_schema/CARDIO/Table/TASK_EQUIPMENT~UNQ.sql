PROMPT ALTER TABLE task_equipment ADD CONSTRAINT pk_task_equipment PRIMARY KEY
ALTER TABLE task_equipment
  ADD CONSTRAINT pk_task_equipment PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

