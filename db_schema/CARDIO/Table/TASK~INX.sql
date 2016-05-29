PROMPT CREATE INDEX ifk_task_engineer
CREATE INDEX ifk_task_engineer
  ON task (
    engineer_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_partner
CREATE INDEX ifk_task_partner
  ON task (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_pers
CREATE INDEX ifk_task_pers
  ON task (
    person_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_pers_phone
CREATE INDEX ifk_task_pers_phone
  ON task (
    cont_pers_phone_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_status
CREATE INDEX ifk_task_status
  ON task (
    status_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_town_id
CREATE INDEX ifk_task_town_id
  ON task (
    ua_town_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_type
CREATE INDEX ifk_task_type
  ON task (
    type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_task_user
CREATE INDEX ifk_task_user
  ON task (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

