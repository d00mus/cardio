PROMPT ALTER TABLE patient_photo ADD CONSTRAINT fk_patient_photo FOREIGN KEY
ALTER TABLE patient_photo
  ADD CONSTRAINT fk_patient_photo FOREIGN KEY (
    patient_id
  ) REFERENCES patient (
    id
  )
/

