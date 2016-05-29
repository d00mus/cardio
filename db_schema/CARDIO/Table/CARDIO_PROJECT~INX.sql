PROMPT CREATE INDEX ifk_contact_pers_id
CREATE INDEX ifk_contact_pers_id
  ON cardio_project (
    contact_pers_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_id
CREATE INDEX ifk_partner_id
  ON cardio_project (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_user_id
CREATE INDEX ifk_user_id
  ON cardio_project (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

