PROMPT CREATE INDEX idx_fk_psg_attr_det_tune_fk
CREATE INDEX idx_fk_psg_attr_det_tune_fk
  ON psg_attr_detector_tune (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

