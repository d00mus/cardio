PROMPT ALTER TABLE psg_attr_pulls ADD CONSTRAINT fk_psg_attr_pulls FOREIGN KEY
ALTER TABLE psg_attr_pulls
  ADD CONSTRAINT fk_psg_attr_pulls FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

