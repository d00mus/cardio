PROMPT ALTER TABLE user_education ADD CONSTRAINT pk_user_educaion PRIMARY KEY
ALTER TABLE user_education
  ADD CONSTRAINT pk_user_educaion PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

