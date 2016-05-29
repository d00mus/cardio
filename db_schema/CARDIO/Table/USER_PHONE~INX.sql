PROMPT CREATE INDEX ifk_user_phone_type
CREATE INDEX ifk_user_phone_type
  ON user_phone (
    phone_type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_user_phone_user
CREATE INDEX ifk_user_phone_user
  ON user_phone (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

