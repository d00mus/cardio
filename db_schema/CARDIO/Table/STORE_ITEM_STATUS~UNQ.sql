PROMPT ALTER TABLE store_item_status ADD CONSTRAINT pk_store_item_status PRIMARY KEY
ALTER TABLE store_item_status
  ADD CONSTRAINT pk_store_item_status PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE store_item_status ADD CONSTRAINT unq_pk_store_item_status UNIQUE
ALTER TABLE store_item_status
  ADD CONSTRAINT unq_pk_store_item_status UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

