PROMPT ALTER TABLE psg_attr_sp_o2 ADD CONSTRAINT pk_psg_attr_sp_o2 PRIMARY KEY
ALTER TABLE psg_attr_sp_o2
  ADD CONSTRAINT pk_psg_attr_sp_o2 PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

