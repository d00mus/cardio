PROMPT CREATE TABLE psg_result
CREATE TABLE psg_result (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  dg_iag         NUMBER(6,2)  NULL,
  dg_oa_epis     NUMBER(6,0)  NULL,
  dg_gipo_epis   NUMBER(6,0)  NULL,
  dg_ca_epis     NUMBER(6,0)  NULL,
  dg_avg_spo2    NUMBER(6,2)  NULL,
  dg_min_spo2    NUMBER(6,2)  NULL,
  dg_desatur_idx NUMBER(6,2)  NULL,
  neck_size      NUMBER(5,2)  NULL,
  height         NUMBER(5,2)  NULL,
  weigth         NUMBER(5,2)  NULL,
  wg_idx         NUMBER(5,2)  NULL,
  waist          NUMBER(5,2)  NULL,
  stegna         NUMBER(5,2)  NULL,
  chest          NUMBER(5,2)  NULL,
  tr_iag         NUMBER(6,2)  NULL,
  tr_oa_epis     NUMBER(6,0)  NULL,
  tr_gipo_epis   NUMBER(6,0)  NULL,
  tr_ca_epis     NUMBER(6,0)  NULL,
  tr_avg_spo2    NUMBER(6,2)  NULL,
  tr_min_spo2    NUMBER(6,2)  NULL,
  tr_desatur_idx NUMBER(6,2)  NULL,
  author_id      NUMBER(8,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_result IS '���������� ������������';

COMMENT ON COLUMN psg_result.psg_id IS '������ �� ���';
COMMENT ON COLUMN psg_result.dg_iag IS '��������������� ����, ���';
COMMENT ON COLUMN psg_result.dg_oa_epis IS '��������������� ����. ������  ��';
COMMENT ON COLUMN psg_result.dg_gipo_epis IS '��������������� ����. ������ �������';
COMMENT ON COLUMN psg_result.dg_ca_epis IS '��������������� ����. ������   ��';
COMMENT ON COLUMN psg_result.dg_avg_spo2 IS '��������������� ����. ���. SpO2';
COMMENT ON COLUMN psg_result.dg_min_spo2 IS '��������������� ����. ̳�.SpO2';
COMMENT ON COLUMN psg_result.dg_desatur_idx IS '��������������� ����. ������ �����������';
COMMENT ON COLUMN psg_result.neck_size IS '������ ���';
COMMENT ON COLUMN psg_result.height IS '����';
COMMENT ON COLUMN psg_result.weigth IS '���';
COMMENT ON COLUMN psg_result.wg_idx IS '������ ����� ����';
COMMENT ON COLUMN psg_result.waist IS '�����, ��';
COMMENT ON COLUMN psg_result.stegna IS '������ ����, ��';
COMMENT ON COLUMN psg_result.chest IS '����� �����, ��';
COMMENT ON COLUMN psg_result.tr_iag IS '��������������� ����, ���';
COMMENT ON COLUMN psg_result.tr_oa_epis IS '��������������� ����, ������  ��';
COMMENT ON COLUMN psg_result.tr_gipo_epis IS '��������������� ����, ������ �������';
COMMENT ON COLUMN psg_result.tr_ca_epis IS '��������������� ����, ������   ��';
COMMENT ON COLUMN psg_result.tr_avg_spo2 IS '��������������� ����, ���. SpO2';
COMMENT ON COLUMN psg_result.tr_min_spo2 IS '��������������� ����, ̳�.SpO2';
COMMENT ON COLUMN psg_result.tr_desatur_idx IS '��������������� ����, ������ �����������';
COMMENT ON COLUMN psg_result.author_id IS '����� ����������';

