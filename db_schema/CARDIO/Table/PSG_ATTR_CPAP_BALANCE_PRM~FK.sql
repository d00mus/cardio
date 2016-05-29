PROMPT ALTER TABLE psg_attr_cpap_balance_prm ADD CONSTRAINT fk_psg_attr_cpap_balance_prm FOREIGN KEY
ALTER TABLE psg_attr_cpap_balance_prm
  ADD CONSTRAINT fk_psg_attr_cpap_balance_prm FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  ) ON DELETE CASCADE
/

