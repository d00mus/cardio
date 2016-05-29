PROMPT ALTER TABLE project_event_attrs ADD CONSTRAINT fk_project_event_attrs FOREIGN KEY
ALTER TABLE project_event_attrs
  ADD CONSTRAINT fk_project_event_attrs FOREIGN KEY (
    event_id
  ) REFERENCES project_event (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE project_event_attrs ADD CONSTRAINT fk_proj_event_atrs_company FOREIGN KEY
ALTER TABLE project_event_attrs
  ADD CONSTRAINT fk_proj_event_atrs_company FOREIGN KEY (
    company_id
  ) REFERENCES cardio_company (
    id
  )
/

PROMPT ALTER TABLE project_event_attrs ADD CONSTRAINT fk_proj_event_atrs_cp_subj FOREIGN KEY
ALTER TABLE project_event_attrs
  ADD CONSTRAINT fk_proj_event_atrs_cp_subj FOREIGN KEY (
    cp_subject_id
  ) REFERENCES partner_evnt_cp_subj (
    id
  )
/

PROMPT ALTER TABLE project_event_attrs ADD CONSTRAINT fk_proj_event_atrs_pay_stat FOREIGN KEY
ALTER TABLE project_event_attrs
  ADD CONSTRAINT fk_proj_event_atrs_pay_stat FOREIGN KEY (
    pay_status
  ) REFERENCES partner_evnt_attr_pay_stat (
    id
  )
/

PROMPT ALTER TABLE project_event_attrs ADD CONSTRAINT fk_proj_event_atrs_user FOREIGN KEY
ALTER TABLE project_event_attrs
  ADD CONSTRAINT fk_proj_event_atrs_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

