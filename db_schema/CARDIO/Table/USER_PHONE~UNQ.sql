PROMPT ALTER TABLE user_phone ADD CONSTRAINT pk_user_phone PRIMARY KEY
ALTER TABLE user_phone
  ADD CONSTRAINT pk_user_phone PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

