PROMPT ALTER TABLE partner_event_subj ADD CONSTRAINT pk_partner_event_subj PRIMARY KEY
ALTER TABLE partner_event_subj
  ADD CONSTRAINT pk_partner_event_subj PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE partner_event_subj ADD CONSTRAINT unq_partner_event_subj UNIQUE
ALTER TABLE partner_event_subj
  ADD CONSTRAINT unq_partner_event_subj UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

