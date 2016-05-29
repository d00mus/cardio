PROMPT CREATE TABLE doctor_assoc
CREATE TABLE doctor_assoc (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctor_assoc IS 'Ассоциации врачей';


