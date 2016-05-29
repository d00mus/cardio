PROMPT ALTER TABLE partner_employe_phone ADD CONSTRAINT fk_partner_employe_phone FOREIGN KEY
ALTER TABLE partner_employe_phone
  ADD CONSTRAINT fk_partner_employe_phone FOREIGN KEY (
    employe_id
  ) REFERENCES partner_employe (
    id
  ) ON DELETE CASCADE
/

