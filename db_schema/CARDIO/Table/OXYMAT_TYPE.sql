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

COMMENT ON TABLE oxymat_type IS '���� OXYMAT';

COMMENT ON COLUMN oxymat_type.code IS '���';
COMMENT ON COLUMN oxymat_type.name IS '��������';

