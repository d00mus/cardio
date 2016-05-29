PROMPT CREATE TABLE cpap_type
CREATE TABLE cpap_type (
  id   NUMBER(18,0)  NOT NULL,
  code VARCHAR2(64)  NULL,
  name VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cpap_type IS 'Виды CPAP';

COMMENT ON COLUMN cpap_type.id IS 'ID';
COMMENT ON COLUMN cpap_type.code IS 'Код';
COMMENT ON COLUMN cpap_type.name IS 'Название';

