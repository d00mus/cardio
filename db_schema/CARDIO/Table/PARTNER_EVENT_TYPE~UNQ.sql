PROMPT ALTER TABLE partner_event_type ADD CONSTRAINT pk_partner_event_type PRIMARY KEY
ALTER TABLE partner_event_type
  ADD CONSTRAINT pk_partner_event_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE partner_event_type ADD CONSTRAINT unq_partner_event_type UNIQUE
ALTER TABLE partner_event_type
  ADD CONSTRAINT unq_partner_event_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

