PROMPT ALTER TABLE psg_attr_ecg ADD CONSTRAINT fk_psg_attr_ecg FOREIGN KEY
ALTER TABLE psg_attr_ecg
  ADD CONSTRAINT fk_psg_attr_ecg FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

