PROMPT ALTER TABLE psg_attr_sp_o2 ADD CONSTRAINT fk_psg_attr_sp_o2_psg FOREIGN KEY
ALTER TABLE psg_attr_sp_o2
  ADD CONSTRAINT fk_psg_attr_sp_o2_psg FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  )
/

