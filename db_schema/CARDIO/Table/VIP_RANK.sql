PROMPT CREATE TABLE vip_rank
CREATE TABLE vip_rank (
  id   NUMBER(18,0) NOT NULL,
  code VARCHAR2(16) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE vip_rank IS 'Уровень крутости пациента';

COMMENT ON COLUMN vip_rank.code IS 'Код';
COMMENT ON COLUMN vip_rank.name IS 'Название';

