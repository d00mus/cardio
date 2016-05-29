PROMPT CREATE TABLE psg_attr_breath_freq
CREATE TABLE psg_attr_breath_freq (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         DEFAULT sysdate NOT NULL,
  breath_freq    NUMBER(6,2)  NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_breath_freq IS '���, ������� �������';

COMMENT ON COLUMN psg_attr_breath_freq.psg_id IS '���';
COMMENT ON COLUMN psg_attr_breath_freq.measuring_time IS '����-����� ������';
COMMENT ON COLUMN psg_attr_breath_freq.breath_freq IS '������� �������';

