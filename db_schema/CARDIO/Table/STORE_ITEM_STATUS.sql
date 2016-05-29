PROMPT CREATE TABLE store_item_status
CREATE TABLE store_item_status (
  id   NUMBER(8,0)  NOT NULL,
  code VARCHAR2(30) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE store_item_status IS 'Статусы склада';


