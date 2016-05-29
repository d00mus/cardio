PROMPT ALTER TABLE ua_town ADD CONSTRAINT fk_ua_town_district FOREIGN KEY
ALTER TABLE ua_town
  ADD CONSTRAINT fk_ua_town_district FOREIGN KEY (
    district_id
  ) REFERENCES ua_district (
    id
  )
/

PROMPT ALTER TABLE ua_town ADD CONSTRAINT fk_ua_town_state FOREIGN KEY
ALTER TABLE ua_town
  ADD CONSTRAINT fk_ua_town_state FOREIGN KEY (
    state_id
  ) REFERENCES ua_state (
    id
  )
/

