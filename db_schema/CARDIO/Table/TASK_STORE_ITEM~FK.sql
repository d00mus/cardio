PROMPT ALTER TABLE task_store_item ADD CONSTRAINT fk_task_store_item_item FOREIGN KEY
ALTER TABLE task_store_item
  ADD CONSTRAINT fk_task_store_item_item FOREIGN KEY (
    item_id
  ) REFERENCES store_item (
    id
  )
/

PROMPT ALTER TABLE task_store_item ADD CONSTRAINT fk_task_store_item_task FOREIGN KEY
ALTER TABLE task_store_item
  ADD CONSTRAINT fk_task_store_item_task FOREIGN KEY (
    task_id
  ) REFERENCES task (
    id
  ) ON DELETE CASCADE
/

