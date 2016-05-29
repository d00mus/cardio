PROMPT ALTER TABLE project_person ADD CONSTRAINT fk_project_person_empl FOREIGN KEY
ALTER TABLE project_person
  ADD CONSTRAINT fk_project_person_empl FOREIGN KEY (
    employe_id
  ) REFERENCES partner_employe (
    id
  )
/

PROMPT ALTER TABLE project_person ADD CONSTRAINT fk_project_person_prj FOREIGN KEY
ALTER TABLE project_person
  ADD CONSTRAINT fk_project_person_prj FOREIGN KEY (
    project_id
  ) REFERENCES cardio_project (
    id
  )
/

