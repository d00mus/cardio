PROMPT CREATE INDEX idx_partner_event_date
CREATE INDEX idx_partner_event_date
  ON partner_event (
    event_date
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_event_employe
CREATE INDEX ifk_partner_event_employe
  ON partner_event (
    employe_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_event_part
CREATE INDEX ifk_partner_event_part
  ON partner_event (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_event_subj
CREATE INDEX ifk_partner_event_subj
  ON partner_event (
    subj_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_event_type
CREATE INDEX ifk_partner_event_type
  ON partner_event (
    type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_event_user
CREATE INDEX ifk_partner_event_user
  ON partner_event (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

