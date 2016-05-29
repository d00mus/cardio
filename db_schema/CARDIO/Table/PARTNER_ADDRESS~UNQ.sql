PROMPT ALTER TABLE partner_address ADD CONSTRAINT pk_partner_address PRIMARY KEY
ALTER TABLE partner_address
  ADD CONSTRAINT pk_partner_address PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

