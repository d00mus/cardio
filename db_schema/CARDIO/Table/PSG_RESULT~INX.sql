PROMPT CREATE INDEX ifk_psg_result_author_id
CREATE INDEX ifk_psg_result_author_id
  ON psg_result (
    author_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

