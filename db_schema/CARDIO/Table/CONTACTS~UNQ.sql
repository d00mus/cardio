PROMPT ALTER TABLE contacts ADD CONSTRAINT pk_contacts PRIMARY KEY
ALTER TABLE contacts
  ADD CONSTRAINT pk_contacts PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

