PROMPT CREATE OR REPLACE PACKAGE rep_utl
CREATE OR REPLACE package rep_utl is

  -- Author  : D00MUS
  -- Created : 08.12.2013 22:30:49
  -- Purpose : ������

  /**
  �������� ������ ���� ��� ���
  */
  function get_psg_dates(p_patient_id number) return varchar2;

  /**
  �������� ������ ����� ��������
  */
  function get_full_address_rus(p_patient_id number) return varchar2;

  function get_full_address_ukr(p_patient_id number) return varchar2;



 --�������� ��� ��������

  function get_fio(p_patient_id number) return varchar2;



end rep_utl;
/

