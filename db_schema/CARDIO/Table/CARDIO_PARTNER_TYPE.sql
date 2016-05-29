PROMPT CREATE TABLE cardio_partner_type
CREATE TABLE cardio_partner_type (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_partner_type IS 'Тип конторы-партнёра';


