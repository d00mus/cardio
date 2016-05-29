PROMPT CREATE INDEX ifk_cardio_user_ava
CREATE INDEX ifk_cardio_user_ava
  ON cardio_user (
    avatar_file_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_cardio_user_mbr_phone
CREATE INDEX ifk_cardio_user_mbr_phone
  ON cardio_user (
    fam_mbr_phone_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_cardio_user_state
CREATE INDEX ifk_cardio_user_state
  ON cardio_user (
    adr_state_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_cardio_user_town
CREATE INDEX ifk_cardio_user_town
  ON cardio_user (
    adr_town_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

