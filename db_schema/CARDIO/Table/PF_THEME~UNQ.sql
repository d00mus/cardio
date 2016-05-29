PROMPT ALTER TABLE pf_theme ADD CONSTRAINT pk_pf_theme PRIMARY KEY
ALTER TABLE pf_theme
  ADD CONSTRAINT pk_pf_theme PRIMARY KEY (
    theme_name
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

