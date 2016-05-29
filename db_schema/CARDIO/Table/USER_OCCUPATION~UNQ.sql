PROMPT ALTER TABLE user_occupation ADD CONSTRAINT pk_user_occupation PRIMARY KEY
ALTER TABLE user_occupation
  ADD CONSTRAINT pk_user_occupation PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

