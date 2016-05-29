PROMPT CREATE INDEX idx_project_event_date
CREATE INDEX idx_project_event_date
  ON project_event (
    event_date
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_project_event_employe
CREATE INDEX ifk_project_event_employe
  ON project_event (
    employe_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_project_event_subj
CREATE INDEX ifk_project_event_subj
  ON project_event (
    subj_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_project_event_type
CREATE INDEX ifk_project_event_type
  ON project_event (
    type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_project_event_user
CREATE INDEX ifk_project_event_user
  ON project_event (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

