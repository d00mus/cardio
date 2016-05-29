PROMPT CREATE TABLE task_store_item
CREATE TABLE task_store_item (
  task_id NUMBER(18,0) NOT NULL,
  item_id NUMBER(18,0) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE task_store_item IS 'Оборудование по задачам';


