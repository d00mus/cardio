PROMPT CREATE INDEX ifk_partner_employe_phone
CREATE INDEX ifk_partner_employe_phone
  ON partner_employe_phone (
    employe_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

