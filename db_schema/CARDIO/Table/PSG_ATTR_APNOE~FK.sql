PROMPT ALTER TABLE psg_attr_apnoe ADD CONSTRAINT fk_psg_attr_apnoe FOREIGN KEY
ALTER TABLE psg_attr_apnoe
  ADD CONSTRAINT fk_psg_attr_apnoe FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

PROMPT ALTER TABLE psg_attr_apnoe ADD CONSTRAINT fk_psg_attr_apnoe_type FOREIGN KEY
ALTER TABLE psg_attr_apnoe
  ADD CONSTRAINT fk_psg_attr_apnoe_type FOREIGN KEY (
    apnoe_type_id
  ) REFERENCES psg_attr_apnoe_type (
    id
  )
/

