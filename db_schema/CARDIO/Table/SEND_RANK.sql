PROMPT CREATE TABLE send_rank
CREATE TABLE send_rank (
  id   NUMBER(18,0) NOT NULL,
  code VARCHAR2(16) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE send_rank IS 'Ссылочный ранг пациента(сколько раз он посылал других)';

COMMENT ON COLUMN send_rank.code IS 'Код ранга';
COMMENT ON COLUMN send_rank.name IS 'Название';

