PROMPT CREATE INDEX ifk_ua_district_state
CREATE INDEX ifk_ua_district_state
  ON ua_district (
    state_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

