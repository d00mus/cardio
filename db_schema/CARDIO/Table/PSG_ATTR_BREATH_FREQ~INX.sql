PROMPT CREATE INDEX ifk_psg_attr_breath_freq
CREATE INDEX ifk_psg_attr_breath_freq
  ON psg_attr_breath_freq (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

