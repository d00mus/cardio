PROMPT CREATE TABLE partner_employe_phone
CREATE TABLE partner_employe_phone (
  id         NUMBER(18,0)  NOT NULL,
  employe_id NUMBER(18,0)  NOT NULL,
  phone      VARCHAR2(32)  NOT NULL,
  notes      VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_employe_phone IS 'Телефоны сотрудников партнёров(докторов)';


