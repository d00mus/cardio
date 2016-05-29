PROMPT CREATE TABLE cardio_store
CREATE TABLE cardio_store (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(128) NULL,
  name VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_store IS 'Склады';


