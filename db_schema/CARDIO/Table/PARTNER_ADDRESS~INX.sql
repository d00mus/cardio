PROMPT CREATE INDEX ifk_partner_address
CREATE INDEX ifk_partner_address
  ON partner_address (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_address_state
CREATE INDEX ifk_partner_address_state
  ON partner_address (
    ua_state_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_address_town
CREATE INDEX ifk_partner_address_town
  ON partner_address (
    ua_town_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

