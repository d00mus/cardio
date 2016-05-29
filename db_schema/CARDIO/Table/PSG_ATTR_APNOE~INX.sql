PROMPT CREATE INDEX idx_fk_psg_attr_apnoe_fk
CREATE INDEX idx_fk_psg_attr_apnoe_fk
  ON psg_attr_apnoe (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

