PROMPT CREATE INDEX ifk_project_equipment
CREATE INDEX ifk_project_equipment
  ON project_equipment (
    project_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

