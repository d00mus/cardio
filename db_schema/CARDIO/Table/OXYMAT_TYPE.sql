PROMPT CREATE TABLE oxymat_type
CREATE TABLE oxymat_type (
  id   NUMBER(10,0) NOT NULL,
  code VARCHAR2(32) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE oxymat_type IS 'Типы OXYMAT';

COMMENT ON COLUMN oxymat_type.code IS 'Код';
COMMENT ON COLUMN oxymat_type.name IS 'Название';

