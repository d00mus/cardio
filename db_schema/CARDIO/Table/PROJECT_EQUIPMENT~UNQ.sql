PROMPT ALTER TABLE project_equipment ADD CONSTRAINT pk_project_equipment PRIMARY KEY
ALTER TABLE project_equipment
  ADD CONSTRAINT pk_project_equipment PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

