PROMPT CREATE TABLE doctor_division
CREATE TABLE doctor_division (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctor_division IS 'Медицинские отделения';

COMMENT ON COLUMN doctor_division.code IS 'Код';
COMMENT ON COLUMN doctor_division.name IS 'Название';

