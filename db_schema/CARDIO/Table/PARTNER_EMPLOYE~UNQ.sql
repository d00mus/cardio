PROMPT ALTER TABLE partner_employe ADD CONSTRAINT pk_partner_employe PRIMARY KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT pk_partner_employe PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

