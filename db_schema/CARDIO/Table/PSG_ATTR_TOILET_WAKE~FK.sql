PROMPT ALTER TABLE psg_attr_toilet_wake ADD CONSTRAINT fk_psg_attr_toilet_wake FOREIGN KEY
ALTER TABLE psg_attr_toilet_wake
  ADD CONSTRAINT fk_psg_attr_toilet_wake FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

