PROMPT CREATE INDEX unq_pk_store_doc_line
CREATE UNIQUE INDEX unq_pk_store_doc_line
  ON store_doc_line (
    document_id,
    item_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

