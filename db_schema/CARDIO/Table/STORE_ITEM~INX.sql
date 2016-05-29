PROMPT CREATE INDEX idx_store_item_sn
CREATE INDEX idx_store_item_sn
  ON store_item (
    serial
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_item_model
CREATE INDEX ifk_store_item_model
  ON store_item (
    model_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_item_partner
CREATE INDEX ifk_store_item_partner
  ON store_item (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_item_status
CREATE INDEX ifk_store_item_status
  ON store_item (
    status_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_item_store
CREATE INDEX ifk_store_item_store
  ON store_item (
    store_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

