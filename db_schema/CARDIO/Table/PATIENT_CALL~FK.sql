PROMPT ALTER TABLE patient_call ADD CONSTRAINT fk_patient_call_nurse_id FOREIGN KEY
ALTER TABLE patient_call
  ADD CONSTRAINT fk_patient_call_nurse_id FOREIGN KEY (
    nurse_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE patient_call ADD CONSTRAINT fk_patient_call_patient_id FOREIGN KEY
ALTER TABLE patient_call
  ADD CONSTRAINT fk_patient_call_patient_id FOREIGN KEY (
    patient_id
  ) REFERENCES patient (
    id
  )
/

PROMPT ALTER TABLE patient_call ADD CONSTRAINT fk_pat_call_feel_id FOREIGN KEY
ALTER TABLE patient_call
  ADD CONSTRAINT fk_pat_call_feel_id FOREIGN KEY (
    cmn_feeling_id
  ) REFERENCES patient_feeling (
    id
  )
/

PROMPT ALTER TABLE patient_call ADD CONSTRAINT fk_pat_call_phone_id FOREIGN KEY
ALTER TABLE patient_call
  ADD CONSTRAINT fk_pat_call_phone_id FOREIGN KEY (
    phone_id
  ) REFERENCES patient_phone (
    id
  )
/

