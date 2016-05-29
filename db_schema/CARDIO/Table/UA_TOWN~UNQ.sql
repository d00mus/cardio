PROMPT ALTER TABLE ua_town ADD CONSTRAINT pk_ua_town PRIMARY KEY
ALTER TABLE ua_town
  ADD CONSTRAINT pk_ua_town PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

