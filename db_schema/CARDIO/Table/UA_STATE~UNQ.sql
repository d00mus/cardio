PROMPT ALTER TABLE ua_state ADD CONSTRAINT pk_ua_state PRIMARY KEY
ALTER TABLE ua_state
  ADD CONSTRAINT pk_ua_state PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

