PROMPT CREATE INDEX ifk_fk_proj_event_atrs_pay_st
CREATE INDEX ifk_fk_proj_event_atrs_pay_st
  ON project_event_attrs (
    pay_status
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_proj_event_atrs_company
CREATE INDEX ifk_proj_event_atrs_company
  ON project_event_attrs (
    company_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_proj_event_atrs_cp_subj
CREATE INDEX ifk_proj_event_atrs_cp_subj
  ON project_event_attrs (
    cp_subject_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_proj_event_atrs_user
CREATE INDEX ifk_proj_event_atrs_user
  ON project_event_attrs (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

