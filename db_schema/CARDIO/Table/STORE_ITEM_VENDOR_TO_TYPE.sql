PROMPT CREATE TABLE store_item_vendor_to_type
CREATE TABLE store_item_vendor_to_type (
  store_item_vendor_id NUMBER(8,0) NOT NULL,
  store_item_type_id   NUMBER(8,0) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON COLUMN store_item_vendor_to_type.store_item_vendor_id IS 'Вендор';
COMMENT ON COLUMN store_item_vendor_to_type.store_item_type_id IS 'Тип оборудования';

