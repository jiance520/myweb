package com.view;
import com.dao.*;

import java.util.*;

import com.entity.*;
import com.dao.impl.*;
/**
 * @version ʱ�䣺2018��5��12�� ����10:42:31
 *������Ϣ��������
 */
public class DeptView {
	//Dao����
	private IDeptDao deptDao = new DeptDao();
	//����
	public void start(){
		System.out.println("---������Ϣ����--");
		boolean stop = true;//ֹͣѭ����׼
		while(stop){
			System.out.println("1.�����в���");
			System.out.println("2.��ָ������");
			System.out.println("3.��������");
			System.out.println("4.�޸Ĳ���");
			System.out.println("5.ɾ������");
			Scanner input = new Scanner(System.in);
			System.out.println("��ѡ��");
			int num = input.nextInt();
			switch(num){
			case 1:
				showAll();
				break;
			case 2:
				showOne();
				break;
			case 3:
				addDept();
				break;
			case 4:
				updateDept();
				break;
			case 5:
				deleteDept();
				break;
			}
			//�Ƿ����
			System.out.print("�Ƿ��˳�ϵͳyes/no:");
			String ss = input.next();
			if (ss.equals("yes")) {
				stop = false;
				System.out.println("�˳�ϵͳ");
//				System.exit(-1);
			}
		}
	}
	//1.��ѯ���в���
	public void showAll(){
		System.out.println("--���в�����Ϣ--");
		List<Dept> list = deptDao.getAll();
		for(Dept d:list){
			System.out.println("���ű�ţ�"+d.getDeptno());
			System.out.println("�������ƣ�"+d.getDname());
			System.out.println("���ŵ�ַ��"+d.getLoc());
			System.out.println("--------------");
		}
	}
	//��ѯһ������
	public void showOne(){
		Scanner input = new Scanner(System.in);
		System.out.println("�����벿�ű�ţ�");
		int deptno = input.nextInt();
		Dept d2 = deptDao.getOne(deptno);
		if (d2==null) {
			System.out.println("---û���������");
		}
		else{
			System.out.println("���ű�ţ�"+d2.getDeptno());
			System.out.println("�������ƣ�"+d2.getDname());
			System.out.println("���ŵ�ַ��"+d2.getLoc());
			System.out.println("--------------");
		}
	}
	//�޸�
	public void updateDept(){
		Scanner input = new Scanner(System.in);
		System.out.println("�����벿�ű�ţ�");
		int deptno = input.nextInt();
		//��ѯԭʼ��Ϣ
		Dept d2 = deptDao.getOne(deptno);
		if(d2==null){
			System.out.println("----û���������");
		}
		else{
			System.out.println("���������ƣ�");
			String name = input.next();
			System.out.println("�������ַ��");
			String loc = input.next();
			//����ֵ
			d2.setDname(name);
			d2.setLoc(loc);
			//�޸�
			int num = deptDao.update(d2);
			if(num<1){
				System.out.println("--�޸�ʧ��");
			}
			else{
				System.out.println("--�޸ĳɹ�");
			}
		}
	}
	//��������
	public void addDept(){
		Scanner input = new Scanner(System.in);
		System.out.println("�����벿�ű�ţ�");
		int deptno = input.nextInt();
		System.out.println("���������ƣ�");
		String name = input.next();
		System.out.println("�������ַ��");
		String loc = input.next();
		Dept d2 = deptDao.getOne(deptno);
		int num = deptDao.insert(d2);
		if(num<1){
			System.out.println("--����ʧ��");
		}
		else{
			System.out.println("--�����ɹ�");
		}
	}
	//ɾ������
	public void deleteDept(){
		Scanner input = new Scanner(System.in);
		System.out.println("�����벿�ű�ţ�");
		int deptno = input.nextInt();
		int num = deptDao.delete(deptno);
		if(num<1){
			System.out.println("--ɾ��ʧ��");
		}
		else{
			System.out.println("--ɾ���ɹ�");
		}
	}
}
