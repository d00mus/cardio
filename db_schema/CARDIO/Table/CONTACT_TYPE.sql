PROMPT CREATE TABLE contact_type
CREATE TABLE contact_type (
  id          NUMBER(18,0)   NOT NULL,
  code        VARCHAR2(16)   NOT NULL,
  name        VARCHAR2(64)   NOT NULL,
  description VARCHAR2(128)  NULL,
  regexp      VARCHAR2(2000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE contact_type IS 'Типы контактов';

COMMENT ON COLUMN contact_type.code IS 'Код типа';
COMMENT ON COLUMN contact_type.name IS 'Название';
COMMENT ON COLUMN contact_type.description IS 'Описание';
COMMENT ON COLUMN contact_type.regexp IS 'Регексп для проверки правильности формата';

