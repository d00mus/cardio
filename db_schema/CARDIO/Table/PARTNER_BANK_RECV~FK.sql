PROMPT ALTER TABLE partner_bank_recv ADD CONSTRAINT fk_partner_bank_recv FOREIGN KEY
ALTER TABLE partner_bank_recv
  ADD CONSTRAINT fk_partner_bank_recv FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  ) ON DELETE CASCADE
/

