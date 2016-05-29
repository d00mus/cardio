PROMPT CREATE INDEX ifk_task_equipment
CREATE INDEX ifk_task_equipment
  ON task_equipment (
    task_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

