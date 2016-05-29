PROMPT CREATE INDEX idx_fk_psg_attr_ecg_fk
CREATE INDEX idx_fk_psg_attr_ecg_fk
  ON psg_attr_ecg (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

