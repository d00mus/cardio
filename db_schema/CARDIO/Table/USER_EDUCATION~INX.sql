PROMPT CREATE INDEX ifk_user_educaion_user
CREATE INDEX ifk_user_educaion_user
  ON user_education (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

