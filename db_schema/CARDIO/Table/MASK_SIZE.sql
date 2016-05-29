PROMPT CREATE TABLE mask_size
CREATE TABLE mask_size (
  id   NUMBER(10,0) NOT NULL,
  code VARCHAR2(32) NULL,
  name VARCHAR2(64) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE mask_size IS 'Справочник размеров масок';


