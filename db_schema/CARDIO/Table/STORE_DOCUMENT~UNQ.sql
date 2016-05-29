PROMPT ALTER TABLE store_document ADD CONSTRAINT pk_store_document PRIMARY KEY
ALTER TABLE store_document
  ADD CONSTRAINT pk_store_document PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

