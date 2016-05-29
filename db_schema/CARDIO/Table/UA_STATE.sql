PROMPT CREATE TABLE ua_state
CREATE TABLE ua_state (
  id       NUMBER(8,0)   NOT NULL,
  rus_name VARCHAR2(128) NOT NULL,
  ukr_name VARCHAR2(128) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE ua_state IS 'ќбласти ”краины';

COMMENT ON COLUMN ua_state.rus_name IS '–усское название области';
COMMENT ON COLUMN ua_state.ukr_name IS '”краинское название области';

