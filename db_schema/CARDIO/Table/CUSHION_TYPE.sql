PROMPT CREATE TABLE cushion_type
CREATE TABLE cushion_type (
  id   NUMBER(18,0) NOT NULL,
  code VARCHAR2(16) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cushion_type IS 'Виды подушек';

COMMENT ON COLUMN cushion_type.id IS 'ID';
COMMENT ON COLUMN cushion_type.code IS 'Код подушки';
COMMENT ON COLUMN cushion_type.name IS 'Название(вид) подушки';

