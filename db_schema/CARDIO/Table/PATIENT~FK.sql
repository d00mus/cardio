PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_adr_ua_state_id FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_adr_ua_state_id FOREIGN KEY (
    adr_ua_state_id
  ) REFERENCES ua_state (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_adr_ua_town_id FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_adr_ua_town_id FOREIGN KEY (
    adr_ua_town_id
  ) REFERENCES ua_town (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_ava_id FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_ava_id FOREIGN KEY (
    avatar_id
  ) REFERENCES patient_photo (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_contacts FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_contacts FOREIGN KEY (
    contacts_id
  ) REFERENCES contacts (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_created_by FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_created_by FOREIGN KEY (
    created_by_user_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_fam_mbr_phone FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_fam_mbr_phone FOREIGN KEY (
    fam_member_phone_id
  ) REFERENCES patient_phone (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_partner_phone FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_partner_phone FOREIGN KEY (
    partner_phone_id
  ) REFERENCES patient_phone (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_ref_info_type FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_ref_info_type FOREIGN KEY (
    ref_info_src_type_id
  ) REFERENCES ref_info_source_type (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_send_rank FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_send_rank FOREIGN KEY (
    ref_rank_id
  ) REFERENCES send_rank (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_snd_by_doc FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_snd_by_doc FOREIGN KEY (
    ref_info_doc_id
  ) REFERENCES doctors_external (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_snd_by_pat FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_snd_by_pat FOREIGN KEY (
    ref_info_patient_id
  ) REFERENCES patient (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_tracked_by FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_tracked_by FOREIGN KEY (
    tracked_by_user_id
  ) REFERENCES cardio_user (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patient_vip_rank FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patient_vip_rank FOREIGN KEY (
    vip_rank_id
  ) REFERENCES vip_rank (
    id
  )
/

PROMPT ALTER TABLE patient ADD CONSTRAINT fk_patinet_work_ua_town FOREIGN KEY
ALTER TABLE patient
  ADD CONSTRAINT fk_patinet_work_ua_town FOREIGN KEY (
    work_ua_town_id
  ) REFERENCES ua_town (
    id
  )
/

