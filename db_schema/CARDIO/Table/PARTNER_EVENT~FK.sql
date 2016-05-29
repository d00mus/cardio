PROMPT ALTER TABLE partner_event ADD CONSTRAINT fk_partner_event_employe FOREIGN KEY
ALTER TABLE partner_event
  ADD CONSTRAINT fk_partner_event_employe FOREIGN KEY (
    employe_id
  ) REFERENCES partner_employe (
    id
  )
/

PROMPT ALTER TABLE partner_event ADD CONSTRAINT fk_partner_event_part FOREIGN KEY
ALTER TABLE partner_event
  ADD CONSTRAINT fk_partner_event_part FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  )
/

PROMPT ALTER TABLE partner_event ADD CONSTRAINT fk_partner_event_subj FOREIGN KEY
ALTER TABLE partner_event
  ADD CONSTRAINT fk_partner_event_subj FOREIGN KEY (
    subj_id
  ) REFERENCES partner_event_subj (
    id
  )
/

PROMPT ALTER TABLE partner_event ADD CONSTRAINT fk_partner_event_type FOREIGN KEY
ALTER TABLE partner_event
  ADD CONSTRAINT fk_partner_event_type FOREIGN KEY (
    type_id
  ) REFERENCES partner_event_type (
    id
  )
/

PROMPT ALTER TABLE partner_event ADD CONSTRAINT fk_partner_event_user FOREIGN KEY
ALTER TABLE partner_event
  ADD CONSTRAINT fk_partner_event_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

