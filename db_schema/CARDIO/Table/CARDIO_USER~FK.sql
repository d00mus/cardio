PROMPT ALTER TABLE cardio_user ADD CONSTRAINT fk_cardio_user_ava FOREIGN KEY
ALTER TABLE cardio_user
  ADD CONSTRAINT fk_cardio_user_ava FOREIGN KEY (
    avatar_file_id
  ) REFERENCES user_files (
    id
  )
/

PROMPT ALTER TABLE cardio_user ADD CONSTRAINT fk_cardio_user_mbr_phone FOREIGN KEY
ALTER TABLE cardio_user
  ADD CONSTRAINT fk_cardio_user_mbr_phone FOREIGN KEY (
    fam_mbr_phone_id
  ) REFERENCES user_phone (
    id
  )
/

PROMPT ALTER TABLE cardio_user ADD CONSTRAINT fk_cardio_user_state FOREIGN KEY
ALTER TABLE cardio_user
  ADD CONSTRAINT fk_cardio_user_state FOREIGN KEY (
    adr_state_id
  ) REFERENCES ua_state (
    id
  )
/

PROMPT ALTER TABLE cardio_user ADD CONSTRAINT fk_cardio_user_theme FOREIGN KEY
ALTER TABLE cardio_user
  ADD CONSTRAINT fk_cardio_user_theme FOREIGN KEY (
    theme_name
  ) REFERENCES pf_theme (
    theme_name
  )
/

PROMPT ALTER TABLE cardio_user ADD CONSTRAINT fk_cardio_user_town FOREIGN KEY
ALTER TABLE cardio_user
  ADD CONSTRAINT fk_cardio_user_town FOREIGN KEY (
    adr_town_id
  ) REFERENCES ua_town (
    id
  )
/

