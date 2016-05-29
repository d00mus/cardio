PROMPT ALTER TABLE psg_attr_ad ADD CONSTRAINT fk_psg_attr_ad FOREIGN KEY
ALTER TABLE psg_attr_ad
  ADD CONSTRAINT fk_psg_attr_ad FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

