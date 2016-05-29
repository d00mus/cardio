PROMPT CREATE TABLE store_doc_line
CREATE TABLE store_doc_line (
  id          NUMBER(18,0) NOT NULL,
  document_id NUMBER(18,0) NOT NULL,
  item_id     NUMBER(18,0) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE store_doc_line IS 'Табличная часть документов';


