PROMPT ALTER TABLE psg_attr_detector_tune ADD CONSTRAINT fk_psg_attr_detector_id FOREIGN KEY
ALTER TABLE psg_attr_detector_tune
  ADD CONSTRAINT fk_psg_attr_detector_id FOREIGN KEY (
    detector_id
  ) REFERENCES psg_attr_detector (
    id
  )
/

PROMPT ALTER TABLE psg_attr_detector_tune ADD CONSTRAINT fk_psg_attr_detector_tune FOREIGN KEY
ALTER TABLE psg_attr_detector_tune
  ADD CONSTRAINT fk_psg_attr_detector_tune FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

