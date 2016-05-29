PROMPT ALTER TABLE ua_district ADD CONSTRAINT fk_ua_district_state FOREIGN KEY
ALTER TABLE ua_district
  ADD CONSTRAINT fk_ua_district_state FOREIGN KEY (
    state_id
  ) REFERENCES ua_state (
    id
  )
/

