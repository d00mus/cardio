PROMPT CREATE INDEX idx_fk_psg_attr_ad_fk
CREATE INDEX idx_fk_psg_attr_ad_fk
  ON psg_attr_ad (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

