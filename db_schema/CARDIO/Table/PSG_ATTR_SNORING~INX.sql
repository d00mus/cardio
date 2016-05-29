PROMPT CREATE INDEX idx_fk_psg_attr_snoring_fk
CREATE INDEX idx_fk_psg_attr_snoring_fk
  ON psg_attr_snoring (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

