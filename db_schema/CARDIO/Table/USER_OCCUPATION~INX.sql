PROMPT CREATE INDEX ifk_user_occupation_comp
CREATE INDEX ifk_user_occupation_comp
  ON user_occupation (
    company_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_user_occupation_user
CREATE INDEX ifk_user_occupation_user
  ON user_occupation (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

