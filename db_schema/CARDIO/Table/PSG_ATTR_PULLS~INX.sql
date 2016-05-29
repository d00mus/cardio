PROMPT CREATE INDEX idx_fk_psg_attr_pulls_fk
CREATE INDEX idx_fk_psg_attr_pulls_fk
  ON psg_attr_pulls (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

