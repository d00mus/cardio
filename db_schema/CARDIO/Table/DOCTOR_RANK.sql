PROMPT CREATE TABLE doctor_rank
CREATE TABLE doctor_rank (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctor_rank IS 'Ранг доктора';


