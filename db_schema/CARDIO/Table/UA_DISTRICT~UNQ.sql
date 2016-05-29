PROMPT ALTER TABLE ua_district ADD CONSTRAINT pk_ua_district PRIMARY KEY
ALTER TABLE ua_district
  ADD CONSTRAINT pk_ua_district PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

