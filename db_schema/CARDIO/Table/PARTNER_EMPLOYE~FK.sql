PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_doc_assoc FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_doc_assoc FOREIGN KEY (
    doctor_assoc_id
  ) REFERENCES doctor_assoc (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_doc_div FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_doc_div FOREIGN KEY (
    doctor_division_id
  ) REFERENCES doctor_division (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_doc_pos FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_doc_pos FOREIGN KEY (
    doctor_position_id
  ) REFERENCES doctor_position (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_doc_pri FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_doc_pri FOREIGN KEY (
    doctor_priority_id
  ) REFERENCES doctor_priority (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_doc_rank FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_doc_rank FOREIGN KEY (
    doctor_rank_id
  ) REFERENCES doctor_rank (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_doc_type FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_doc_type FOREIGN KEY (
    doctor_type_id
  ) REFERENCES doctor_type (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_man1 FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_man1 FOREIGN KEY (
    manager_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_man2 FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_man2 FOREIGN KEY (
    manager2_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_posi FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_posi FOREIGN KEY (
    position_id
  ) REFERENCES position (
    id
  )
/

PROMPT ALTER TABLE partner_employe ADD CONSTRAINT fk_partner_employe_state FOREIGN KEY
ALTER TABLE partner_employe
  ADD CONSTRAINT fk_partner_employe_state FOREIGN KEY (
    ua_state_id
  ) REFERENCES ua_state (
    id
  )
/

