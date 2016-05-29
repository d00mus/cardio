PROMPT ALTER TABLE project_event ADD CONSTRAINT fk_project_event FOREIGN KEY
ALTER TABLE project_event
  ADD CONSTRAINT fk_project_event FOREIGN KEY (
    project_id
  ) REFERENCES cardio_project (
    id
  )
/

PROMPT ALTER TABLE project_event ADD CONSTRAINT fk_project_event_employe FOREIGN KEY
ALTER TABLE project_event
  ADD CONSTRAINT fk_project_event_employe FOREIGN KEY (
    employe_id
  ) REFERENCES partner_employe (
    id
  )
/

PROMPT ALTER TABLE project_event ADD CONSTRAINT fk_project_event_subj FOREIGN KEY
ALTER TABLE project_event
  ADD CONSTRAINT fk_project_event_subj FOREIGN KEY (
    subj_id
  ) REFERENCES partner_event_subj (
    id
  )
/

PROMPT ALTER TABLE project_event ADD CONSTRAINT fk_project_event_type FOREIGN KEY
ALTER TABLE project_event
  ADD CONSTRAINT fk_project_event_type FOREIGN KEY (
    type_id
  ) REFERENCES partner_event_type (
    id
  )
/

PROMPT ALTER TABLE project_event ADD CONSTRAINT fk_project_event_user FOREIGN KEY
ALTER TABLE project_event
  ADD CONSTRAINT fk_project_event_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  ) ON DELETE CASCADE
/

