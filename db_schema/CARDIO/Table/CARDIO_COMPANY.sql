PROMPT CREATE TABLE cardio_company
CREATE TABLE cardio_company (
  id         NUMBER(8,0)   NOT NULL,
  name       VARCHAR2(255) NULL,
  short_name VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_company IS 'Компании Кардио';

COMMENT ON COLUMN cardio_company.name IS 'Название компании';
COMMENT ON COLUMN cardio_company.short_name IS 'Краткое название';

