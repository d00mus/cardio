PROMPT ALTER TABLE partner_employe_phone ADD CONSTRAINT pk_partner_employe_phone PRIMARY KEY
ALTER TABLE partner_employe_phone
  ADD CONSTRAINT pk_partner_employe_phone PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE partner_employe_phone ADD CONSTRAINT unq_partner_employe_phone UNIQUE
ALTER TABLE partner_employe_phone
  ADD CONSTRAINT unq_partner_employe_phone UNIQUE (
    employe_id,
    phone
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

