PROMPT ALTER TABLE store_item_type ADD CONSTRAINT pk_store_item_type PRIMARY KEY
ALTER TABLE store_item_type
  ADD CONSTRAINT pk_store_item_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE store_item_type ADD CONSTRAINT unq_store_item_ UNIQUE
ALTER TABLE store_item_type
  ADD CONSTRAINT unq_store_item_ UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

