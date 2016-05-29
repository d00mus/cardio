PROMPT CREATE TABLE psg_attr_cpap_curr_press
CREATE TABLE psg_attr_cpap_curr_press (
  id             NUMBER(18,0) NOT NULL,
  measuring_time DATE         DEFAULT sysdate NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  val1           NUMBER(4,1)  NULL,
  val2           NUMBER(4,1)  NULL,
  val3           NUMBER(4,1)  NULL,
  val4           NUMBER(4,1)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_cpap_curr_press IS '���, ��������� CPAP - ������� ��������';

COMMENT ON COLUMN psg_attr_cpap_curr_press.measuring_time IS '������ ������';
COMMENT ON COLUMN psg_attr_cpap_curr_press.psg_id IS '���';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val1 IS '����� 1';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val2 IS '����� 2';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val3 IS '����� 3';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val4 IS '����� 4';

