PROMPT ALTER TABLE user_files ADD CONSTRAINT fk_user_files_user FOREIGN KEY
ALTER TABLE user_files
  ADD CONSTRAINT fk_user_files_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  ) ON DELETE CASCADE
/

