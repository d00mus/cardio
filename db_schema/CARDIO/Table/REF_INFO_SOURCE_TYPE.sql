PROMPT CREATE TABLE ref_info_source_type
CREATE TABLE ref_info_source_type (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(16)  NOT NULL,
  name VARCHAR2(128) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE ref_info_source_type IS 'Типы источника информации для пациентов';

COMMENT ON COLUMN ref_info_source_type.code IS 'Код типа источника';
COMMENT ON COLUMN ref_info_source_type.name IS 'Название типа источника';

