PROMPT ALTER TABLE partner_bank_recv ADD CONSTRAINT pk_partner_bank_recv PRIMARY KEY
ALTER TABLE partner_bank_recv
  ADD CONSTRAINT pk_partner_bank_recv PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

