PROMPT CREATE INDEX unq_pk_task_store
CREATE UNIQUE INDEX unq_pk_task_store
  ON task_store_item (
    task_id,
    item_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

