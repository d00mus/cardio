PROMPT ALTER TABLE psg_attr_breath_freq ADD CONSTRAINT fk_psg_attr_breath_freq FOREIGN KEY
ALTER TABLE psg_attr_breath_freq
  ADD CONSTRAINT fk_psg_attr_breath_freq FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  ) ON DELETE CASCADE
/

