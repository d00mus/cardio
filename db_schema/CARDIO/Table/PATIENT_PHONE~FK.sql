PROMPT ALTER TABLE patient_phone ADD CONSTRAINT fk_patient_phone_patient_id FOREIGN KEY
ALTER TABLE patient_phone
  ADD CONSTRAINT fk_patient_phone_patient_id FOREIGN KEY (
    patient_id
  ) REFERENCES patient (
    id
  )
/

PROMPT ALTER TABLE patient_phone ADD CONSTRAINT fk_patient_phone_type_id FOREIGN KEY
ALTER TABLE patient_phone
  ADD CONSTRAINT fk_patient_phone_type_id FOREIGN KEY (
    tel_type_id
  ) REFERENCES tel_type (
    id
  )
/

