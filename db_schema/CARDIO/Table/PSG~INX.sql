PROMPT CREATE INDEX idx_psg_date
CREATE INDEX idx_psg_date
  ON psg (
    psg_date
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX idx_psg_nurse_id
CREATE INDEX idx_psg_nurse_id
  ON psg (
    nurse_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX idx_psg_patient_id
CREATE INDEX idx_psg_patient_id
  ON psg (
    patient_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

