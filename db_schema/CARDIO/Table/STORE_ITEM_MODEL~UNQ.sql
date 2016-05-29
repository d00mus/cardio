PROMPT ALTER TABLE store_item_model ADD CONSTRAINT pk_store_item_model PRIMARY KEY
ALTER TABLE store_item_model
  ADD CONSTRAINT pk_store_item_model PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE store_item_model ADD CONSTRAINT unq_store_item_model UNIQUE
ALTER TABLE store_item_model
  ADD CONSTRAINT unq_store_item_model UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

