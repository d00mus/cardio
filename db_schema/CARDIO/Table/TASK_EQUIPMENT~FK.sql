PROMPT ALTER TABLE task_equipment ADD CONSTRAINT fk_task_equipment FOREIGN KEY
ALTER TABLE task_equipment
  ADD CONSTRAINT fk_task_equipment FOREIGN KEY (
    task_id
  ) REFERENCES task (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE task_equipment ADD CONSTRAINT fk_task_equipment_model FOREIGN KEY
ALTER TABLE task_equipment
  ADD CONSTRAINT fk_task_equipment_model FOREIGN KEY (
    model_id
  ) REFERENCES store_item_model (
    id
  )
/

