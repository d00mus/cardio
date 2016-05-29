PROMPT ALTER TABLE store_doc_line ADD CONSTRAINT pk_store_doc_line PRIMARY KEY
ALTER TABLE store_doc_line
  ADD CONSTRAINT pk_store_doc_line PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

