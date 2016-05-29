PROMPT CREATE TABLE partner_evnt_cp_subj
CREATE TABLE partner_evnt_cp_subj (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NULL,
  name VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_evnt_cp_subj IS 'Тематика события КП';

COMMENT ON COLUMN partner_evnt_cp_subj.code IS 'Код';
COMMENT ON COLUMN partner_evnt_cp_subj.name IS 'Название';

