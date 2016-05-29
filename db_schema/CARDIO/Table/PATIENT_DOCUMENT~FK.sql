PROMPT ALTER TABLE patient_document ADD CONSTRAINT fk_patient_document FOREIGN KEY
ALTER TABLE patient_document
  ADD CONSTRAINT fk_patient_document FOREIGN KEY (
    patient_id
  ) REFERENCES patient (
    id
  ) ON DELETE CASCADE
/

