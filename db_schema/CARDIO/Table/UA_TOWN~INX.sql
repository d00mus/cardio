PROMPT CREATE INDEX idx_ua_town_rus
CREATE INDEX idx_ua_town_rus
  ON ua_town (
    rus_name
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX idx_ua_town_ukr
CREATE INDEX idx_ua_town_ukr
  ON ua_town (
    ukr_name
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_ua_town_district
CREATE INDEX ifk_ua_town_district
  ON ua_town (
    district_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_ua_town_state
CREATE INDEX ifk_ua_town_state
  ON ua_town (
    state_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

