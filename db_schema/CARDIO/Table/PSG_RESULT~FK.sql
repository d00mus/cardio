PROMPT ALTER TABLE psg_result ADD CONSTRAINT fk_psg_result_author_id FOREIGN KEY
ALTER TABLE psg_result
  ADD CONSTRAINT fk_psg_result_author_id FOREIGN KEY (
    author_id
  ) REFERENCES psg_result_author (
    id
  )
/

PROMPT ALTER TABLE psg_result ADD CONSTRAINT fk_psg_result_psg FOREIGN KEY
ALTER TABLE psg_result
  ADD CONSTRAINT fk_psg_result_psg FOREIGN KEY (
    psg_id
  ) REFERENCES psg (
    id
  ) ON DELETE CASCADE
/

