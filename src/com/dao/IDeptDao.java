package com.dao;
import java.util.*;
import com.entity.*;
/**
 * @version ʱ�䣺2018��5��12�� ����9:07:35
 *�ӿ�
 */
public interface IDeptDao {
	//������
	List<Dept> getAll();
	//�鵥��
	Dept getOne(int deptno);
	//����
	int insert (Dept d2);
	//�޸�
	int update(Dept d2);
	//ɾ��
	int delete(int deptno);
}
