PROMPT ALTER TABLE psg_attr_cpap_curr_press ADD CONSTRAINT fk_psg_attr_cpap_curr_press FOREIGN KEY
ALTER TABLE psg_attr_cpap_curr_press
  ADD CONSTRAINT fk_psg_attr_cpap_curr_press FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  ) ON DELETE CASCADE
/

