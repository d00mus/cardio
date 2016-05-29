PROMPT ALTER TABLE cardio_project ADD CONSTRAINT fk_cardio_project FOREIGN KEY
ALTER TABLE cardio_project
  ADD CONSTRAINT fk_cardio_project FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  )
/

PROMPT ALTER TABLE cardio_project ADD CONSTRAINT fk_cardio_project_status FOREIGN KEY
ALTER TABLE cardio_project
  ADD CONSTRAINT fk_cardio_project_status FOREIGN KEY (
    status_id
  ) REFERENCES project_status (
    id
  )
/

PROMPT ALTER TABLE cardio_project ADD CONSTRAINT fk_cardio_project_user FOREIGN KEY
ALTER TABLE cardio_project
  ADD CONSTRAINT fk_cardio_project_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE cardio_project ADD CONSTRAINT fk_partner_employe_cont FOREIGN KEY
ALTER TABLE cardio_project
  ADD CONSTRAINT fk_partner_employe_cont FOREIGN KEY (
    contact_pers_id
  ) REFERENCES partner_employe (
    id
  )
/

