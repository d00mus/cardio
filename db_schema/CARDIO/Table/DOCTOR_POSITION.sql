PROMPT CREATE TABLE doctor_position
CREATE TABLE doctor_position (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctor_position IS 'Должности докторов';

COMMENT ON COLUMN doctor_position.code IS 'Код';
COMMENT ON COLUMN doctor_position.name IS 'Название';

