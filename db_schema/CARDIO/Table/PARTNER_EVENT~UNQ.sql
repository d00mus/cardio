PROMPT ALTER TABLE partner_event ADD CONSTRAINT pk_partner_event PRIMARY KEY
ALTER TABLE partner_event
  ADD CONSTRAINT pk_partner_event PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

