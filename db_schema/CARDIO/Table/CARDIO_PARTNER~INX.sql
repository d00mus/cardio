PROMPT CREATE INDEX ifk_cardio_partner_state
CREATE INDEX ifk_cardio_partner_state
  ON cardio_partner (
    jur_addr_ua_state_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_cardio_partner_town
CREATE INDEX ifk_cardio_partner_town
  ON cardio_partner (
    jur_addr_ua_town_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_cardio_partner_type
CREATE INDEX ifk_cardio_partner_type
  ON cardio_partner (
    type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_cardio_partner_user
CREATE INDEX ifk_cardio_partner_user
  ON cardio_partner (
    manager_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

