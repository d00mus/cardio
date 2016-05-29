PROMPT CREATE INDEX ifk_store_item_model_type_id
CREATE INDEX ifk_store_item_model_type_id
  ON store_item_model (
    type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_item_model_vendor_id
CREATE INDEX ifk_store_item_model_vendor_id
  ON store_item_model (
    vendor_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

