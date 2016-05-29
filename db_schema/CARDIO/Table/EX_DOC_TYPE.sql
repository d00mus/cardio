PROMPT CREATE TABLE ex_doc_type
CREATE TABLE ex_doc_type (
  id   NUMBER(18,0) NOT NULL,
  code VARCHAR2(16) NOT NULL,
  name VARCHAR2(64) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE ex_doc_type IS 'Типы внешних докторов';

COMMENT ON COLUMN ex_doc_type.code IS 'Код типа доктора';
COMMENT ON COLUMN ex_doc_type.name IS 'Название';

