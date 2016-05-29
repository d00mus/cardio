PROMPT ALTER TABLE project_equipment ADD CONSTRAINT fk_project_equipment FOREIGN KEY
ALTER TABLE project_equipment
  ADD CONSTRAINT fk_project_equipment FOREIGN KEY (
    project_id
  ) REFERENCES cardio_project (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE project_equipment ADD CONSTRAINT fk_project_equipment_model FOREIGN KEY
ALTER TABLE project_equipment
  ADD CONSTRAINT fk_project_equipment_model FOREIGN KEY (
    model_id
  ) REFERENCES store_item_model (
    id
  )
/

