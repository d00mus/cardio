PROMPT CREATE TABLE document_type
CREATE TABLE document_type (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(64)  NOT NULL,
  name VARCHAR2(128) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE document_type IS 'Типы документов';


