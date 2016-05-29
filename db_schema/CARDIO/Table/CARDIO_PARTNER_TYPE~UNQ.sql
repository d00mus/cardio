PROMPT ALTER TABLE cardio_partner_type ADD CONSTRAINT pk_cardio_partner_type PRIMARY KEY
ALTER TABLE cardio_partner_type
  ADD CONSTRAINT pk_cardio_partner_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE cardio_partner_type ADD CONSTRAINT unq_cardio_partner_type UNIQUE
ALTER TABLE cardio_partner_type
  ADD CONSTRAINT unq_cardio_partner_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

