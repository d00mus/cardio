PROMPT ALTER TABLE contacts_data ADD CONSTRAINT pk_contacts_data PRIMARY KEY
ALTER TABLE contacts_data
  ADD CONSTRAINT pk_contacts_data PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

