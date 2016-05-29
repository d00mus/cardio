PROMPT CREATE INDEX idx_patient_document_date
CREATE INDEX idx_patient_document_date
  ON patient_document (
    file_date
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX idx_patient_document_name
CREATE INDEX idx_patient_document_name
  ON patient_document (
    file_name
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_patient_document
CREATE INDEX ifk_patient_document
  ON patient_document (
    patient_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

