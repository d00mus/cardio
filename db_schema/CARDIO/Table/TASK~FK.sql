PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_engineer FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_engineer FOREIGN KEY (
    engineer_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_partner FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_partner FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_pers FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_pers FOREIGN KEY (
    person_id
  ) REFERENCES partner_employe (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_pers_phone FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_pers_phone FOREIGN KEY (
    cont_pers_phone_id
  ) REFERENCES partner_employe_phone (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_status FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_status FOREIGN KEY (
    status_id
  ) REFERENCES task_status (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_town_id FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_town_id FOREIGN KEY (
    ua_town_id
  ) REFERENCES ua_town (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_type FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_type FOREIGN KEY (
    type_id
  ) REFERENCES task_type (
    id
  )
/

PROMPT ALTER TABLE task ADD CONSTRAINT fk_task_user FOREIGN KEY
ALTER TABLE task
  ADD CONSTRAINT fk_task_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

