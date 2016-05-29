PROMPT CREATE INDEX ifk_patient_photo
CREATE INDEX ifk_patient_photo
  ON patient_photo (
    patient_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

