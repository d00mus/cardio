PROMPT ALTER TABLE psg_attr_snoring ADD CONSTRAINT fk_psg_attr_snoring FOREIGN KEY
ALTER TABLE psg_attr_snoring
  ADD CONSTRAINT fk_psg_attr_snoring FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

