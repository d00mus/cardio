PROMPT CREATE TABLE doctor_type
CREATE TABLE doctor_type (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctor_type IS 'Типы(специальности) докторов';

COMMENT ON COLUMN doctor_type.code IS 'Код специальности';
COMMENT ON COLUMN doctor_type.name IS 'Название';

