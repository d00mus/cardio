PROMPT ALTER TABLE user_files ADD CONSTRAINT pk_user_files PRIMARY KEY
ALTER TABLE user_files
  ADD CONSTRAINT pk_user_files PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

