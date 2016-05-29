PROMPT CREATE TABLE psg_result_author
CREATE TABLE psg_result_author (
  id         NUMBER(8,0)   NOT NULL,
  name       VARCHAR2(255) NOT NULL,
  short_name VARCHAR2(64)  NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_result_author IS 'Авторы заключений по ПСГ';


