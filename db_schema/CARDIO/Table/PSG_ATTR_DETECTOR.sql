PROMPT CREATE TABLE psg_attr_detector
CREATE TABLE psg_attr_detector (
  id   NUMBER(8,0)  NOT NULL,
  code VARCHAR2(16) NOT NULL,
  name VARCHAR2(64) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_detector IS 'Датчики, используемые во время ПСГ, которые можно поправлять';

COMMENT ON COLUMN psg_attr_detector.code IS 'Код датчика';
COMMENT ON COLUMN psg_attr_detector.name IS 'Название датчика';

