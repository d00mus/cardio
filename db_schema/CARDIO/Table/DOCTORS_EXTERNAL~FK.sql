PROMPT ALTER TABLE doctors_external ADD CONSTRAINT fc_doc_ex_type_id FOREIGN KEY
ALTER TABLE doctors_external
  ADD CONSTRAINT fc_doc_ex_type_id FOREIGN KEY (
    doc_type_id
  ) REFERENCES ex_doc_type (
    id
  )
/

PROMPT ALTER TABLE doctors_external ADD CONSTRAINT fk_contacts_id FOREIGN KEY
ALTER TABLE doctors_external
  ADD CONSTRAINT fk_contacts_id FOREIGN KEY (
    contacts_id
  ) REFERENCES contacts (
    id
  )
/

PROMPT ALTER TABLE doctors_external ADD CONSTRAINT fk_doc_ex_ua_state_id FOREIGN KEY
ALTER TABLE doctors_external
  ADD CONSTRAINT fk_doc_ex_ua_state_id FOREIGN KEY (
    ua_state_id
  ) REFERENCES ua_state (
    id
  )
/

PROMPT ALTER TABLE doctors_external ADD CONSTRAINT fk_doc_ex_ua_town_id FOREIGN KEY
ALTER TABLE doctors_external
  ADD CONSTRAINT fk_doc_ex_ua_town_id FOREIGN KEY (
    ua_town_id
  ) REFERENCES ua_town (
    id
  )
/

PROMPT ALTER TABLE doctors_external ADD CONSTRAINT fk_snd_rank FOREIGN KEY
ALTER TABLE doctors_external
  ADD CONSTRAINT fk_snd_rank FOREIGN KEY (
    send_rank_id
  ) REFERENCES send_rank (
    id
  )
/

