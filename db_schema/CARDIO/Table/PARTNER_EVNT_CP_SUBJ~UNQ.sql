PROMPT ALTER TABLE partner_evnt_cp_subj ADD CONSTRAINT pk_partner_evnt_cp_subj PRIMARY KEY
ALTER TABLE partner_evnt_cp_subj
  ADD CONSTRAINT pk_partner_evnt_cp_subj PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE partner_evnt_cp_subj ADD CONSTRAINT unq_partner_evnt UNIQUE
ALTER TABLE partner_evnt_cp_subj
  ADD CONSTRAINT unq_partner_evnt UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

