PROMPT ALTER TABLE contact_type ADD CONSTRAINT pk_contact_type PRIMARY KEY
ALTER TABLE contact_type
  ADD CONSTRAINT pk_contact_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE contact_type ADD CONSTRAINT unq_contact_type UNIQUE
ALTER TABLE contact_type
  ADD CONSTRAINT unq_contact_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

