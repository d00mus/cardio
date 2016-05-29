PROMPT CREATE INDEX ifk_partner_bank_recv
CREATE INDEX ifk_partner_bank_recv
  ON partner_bank_recv (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

