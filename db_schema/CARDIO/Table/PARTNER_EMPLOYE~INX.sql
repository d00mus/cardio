PROMPT CREATE INDEX ifk_partner_employe
CREATE INDEX ifk_partner_employe
  ON partner_employe (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_doc_assoc
CREATE INDEX ifk_partner_employe_doc_assoc
  ON partner_employe (
    doctor_assoc_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_doc_div
CREATE INDEX ifk_partner_employe_doc_div
  ON partner_employe (
    doctor_division_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_doc_pos
CREATE INDEX ifk_partner_employe_doc_pos
  ON partner_employe (
    doctor_position_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_doc_pri
CREATE INDEX ifk_partner_employe_doc_pri
  ON partner_employe (
    doctor_priority_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_doc_type
CREATE INDEX ifk_partner_employe_doc_type
  ON partner_employe (
    doctor_type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_man
CREATE INDEX ifk_partner_employe_man
  ON partner_employe (
    manager_id,
    manager2_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_posi
CREATE INDEX ifk_partner_employe_posi
  ON partner_employe (
    position_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_partner_employe_state
CREATE INDEX ifk_partner_employe_state
  ON partner_employe (
    ua_state_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

