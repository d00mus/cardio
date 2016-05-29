PROMPT CREATE INDEX idx_fk_psg_attr_toil_wake_fk
CREATE INDEX idx_fk_psg_attr_toil_wake_fk
  ON psg_attr_toilet_wake (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

