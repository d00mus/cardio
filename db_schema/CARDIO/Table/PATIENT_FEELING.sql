PROMPT CREATE TABLE patient_feeling
CREATE TABLE patient_feeling (
  id   NUMBER(8,0)  NOT NULL,
  code VARCHAR2(8)  NOT NULL,
  name VARCHAR2(16) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient_feeling IS 'Самочувствие пациента';


