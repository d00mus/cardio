PROMPT CREATE TABLE mask_type
CREATE TABLE mask_type (
  id   NUMBER(18,0) NOT NULL,
  code VARCHAR2(16) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE mask_type IS '���� �����( �������)';

COMMENT ON COLUMN mask_type.id IS 'ID';
COMMENT ON COLUMN mask_type.code IS '���/������ �����';
COMMENT ON COLUMN mask_type.name IS '�������� �����';

