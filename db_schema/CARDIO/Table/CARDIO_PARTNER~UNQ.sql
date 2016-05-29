PROMPT ALTER TABLE cardio_partner ADD CONSTRAINT pk_cardio_partner PRIMARY KEY
ALTER TABLE cardio_partner
  ADD CONSTRAINT pk_cardio_partner PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE cardio_partner ADD CONSTRAINT unq_cardio_partner UNIQUE
ALTER TABLE cardio_partner
  ADD CONSTRAINT unq_cardio_partner UNIQUE (
    inn
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

