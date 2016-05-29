PROMPT ALTER TABLE contacts_data ADD CONSTRAINT fk_contacts_data_con FOREIGN KEY
ALTER TABLE contacts_data
  ADD CONSTRAINT fk_contacts_data_con FOREIGN KEY (
    contacts_id
  ) REFERENCES contacts (
    id
  )
/

PROMPT ALTER TABLE contacts_data ADD CONSTRAINT fk_fk_contacts_data_type FOREIGN KEY
ALTER TABLE contacts_data
  ADD CONSTRAINT fk_fk_contacts_data_type FOREIGN KEY (
    type_id
  ) REFERENCES contact_type (
    id
  )
/

