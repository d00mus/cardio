PROMPT CREATE TABLE pf_theme
CREATE TABLE pf_theme (
  theme_name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE pf_theme IS 'Темы PrimeFaces';

COMMENT ON COLUMN pf_theme.theme_name IS 'название темы';

