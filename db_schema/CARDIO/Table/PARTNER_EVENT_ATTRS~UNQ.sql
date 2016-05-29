PROMPT ALTER TABLE partner_event_attrs ADD CONSTRAINT pk_partner_event_attrs PRIMARY KEY
ALTER TABLE partner_event_attrs
  ADD CONSTRAINT pk_partner_event_attrs PRIMARY KEY (
    event_id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

