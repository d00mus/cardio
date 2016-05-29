PROMPT CREATE TABLE store_item_vendor
CREATE TABLE store_item_vendor (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(128) NULL,
  name VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE store_item_vendor IS 'Производители товаров склад';


