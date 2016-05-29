PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_cabinet FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_cabinet FOREIGN KEY (
    cabinet_id
  ) REFERENCES cabinet (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_cpap_msk_s_id FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_cpap_msk_s_id FOREIGN KEY (
    cpap_mask_size_id
  ) REFERENCES mask_size (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_cpap_msk_t_id FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_cpap_msk_t_id FOREIGN KEY (
    cpap_mask_type_id
  ) REFERENCES mask_type (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_cpap_type FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_cpap_type FOREIGN KEY (
    cpap_type_id
  ) REFERENCES cpap_type (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_cush_type_id FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_cush_type_id FOREIGN KEY (
    cushion_type_id
  ) REFERENCES cushion_type (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_nurse FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_nurse FOREIGN KEY (
    nurse_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_oxymat_type_id FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_oxymat_type_id FOREIGN KEY (
    oxymat_type_id
  ) REFERENCES oxymat_type (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_oxy_msk_s_id FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_oxy_msk_s_id FOREIGN KEY (
    oxymat_mask_size_id
  ) REFERENCES mask_size (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_oxy_msk_t_id FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_oxy_msk_t_id FOREIGN KEY (
    oxymat_mask_type_id
  ) REFERENCES mask_type (
    id
  )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT fk_psg_patient FOREIGN KEY
ALTER TABLE psg
  ADD CONSTRAINT fk_psg_patient FOREIGN KEY (
    patient_id
  ) REFERENCES patient (
    id
  )
/

