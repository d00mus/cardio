PROMPT ALTER TABLE cardio_partner ADD CONSTRAINT fk_cardio_partner_state FOREIGN KEY
ALTER TABLE cardio_partner
  ADD CONSTRAINT fk_cardio_partner_state FOREIGN KEY (
    jur_addr_ua_state_id
  ) REFERENCES ua_state (
    id
  )
/

PROMPT ALTER TABLE cardio_partner ADD CONSTRAINT fk_cardio_partner_town FOREIGN KEY
ALTER TABLE cardio_partner
  ADD CONSTRAINT fk_cardio_partner_town FOREIGN KEY (
    jur_addr_ua_town_id
  ) REFERENCES ua_town (
    id
  )
/

PROMPT ALTER TABLE cardio_partner ADD CONSTRAINT fk_cardio_partner_type FOREIGN KEY
ALTER TABLE cardio_partner
  ADD CONSTRAINT fk_cardio_partner_type FOREIGN KEY (
    type_id
  ) REFERENCES cardio_partner_type (
    id
  )
/

PROMPT ALTER TABLE cardio_partner ADD CONSTRAINT fk_cardio_partner_user FOREIGN KEY
ALTER TABLE cardio_partner
  ADD CONSTRAINT fk_cardio_partner_user FOREIGN KEY (
    manager_id
  ) REFERENCES cardio_user (
    id
  )
/

