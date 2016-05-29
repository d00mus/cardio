PROMPT ALTER TABLE psg_attr_ad ADD CONSTRAINT ck_psg_attr_ad CHECK
ALTER TABLE psg_attr_ad
  ADD CONSTRAINT ck_psg_attr_ad CHECK (
    SYSTOL_PRESSUE>=DIASTOL_PRESSUE
  )
/

