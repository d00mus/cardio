PROMPT ALTER TABLE partner_address ADD CONSTRAINT fk_partner_address FOREIGN KEY
ALTER TABLE partner_address
  ADD CONSTRAINT fk_partner_address FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE partner_address ADD CONSTRAINT fk_partner_address_state FOREIGN KEY
ALTER TABLE partner_address
  ADD CONSTRAINT fk_partner_address_state FOREIGN KEY (
    ua_state_id
  ) REFERENCES ua_state (
    id
  )
/

PROMPT ALTER TABLE partner_address ADD CONSTRAINT fk_partner_address_town FOREIGN KEY
ALTER TABLE partner_address
  ADD CONSTRAINT fk_partner_address_town FOREIGN KEY (
    ua_town_id
  ) REFERENCES ua_town (
    id
  )
/

