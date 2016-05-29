PROMPT CREATE INDEX ifk_user_files_user
CREATE INDEX ifk_user_files_user
  ON user_files (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

