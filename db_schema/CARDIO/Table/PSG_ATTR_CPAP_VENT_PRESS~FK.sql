PROMPT ALTER TABLE psg_attr_cpap_vent_press ADD CONSTRAINT fk_psg_attr_cpap_pressue FOREIGN KEY
ALTER TABLE psg_attr_cpap_vent_press
  ADD CONSTRAINT fk_psg_attr_cpap_pressue FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  ) ON DELETE CASCADE
/

