PROMPT ALTER TABLE store_item ADD CONSTRAINT pk_store_item PRIMARY KEY
ALTER TABLE store_item
  ADD CONSTRAINT pk_store_item PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

