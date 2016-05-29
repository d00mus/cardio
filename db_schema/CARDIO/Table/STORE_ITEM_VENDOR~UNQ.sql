PROMPT ALTER TABLE store_item_vendor ADD CONSTRAINT pk_store_item_vendor PRIMARY KEY
ALTER TABLE store_item_vendor
  ADD CONSTRAINT pk_store_item_vendor PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE store_item_vendor ADD CONSTRAINT unq_store_item_vendor UNIQUE
ALTER TABLE store_item_vendor
  ADD CONSTRAINT unq_store_item_vendor UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

