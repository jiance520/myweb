package com.dao.impl;
import java.util.ArrayList;
import java.util.List;

import com.dao.IDeptDao;
import com.entity.Dept;

import java.sql.*;

/**
 * @version ʱ�䣺2018��5��12�� ����9:21:31
 *����ʵ����
 */
public class DeptDao extends BaseDao implements IDeptDao{

	@Override
	public List<Dept> getAll() {
		init();//��ʼ��
		List<Dept> list = new ArrayList<Dept>();//�ü��ϴ�����ݣ�����Ľ��������ʹclose�ر������ӣ�����Ľ���������ͷ���Դ
		try {
			String sql = " select * from dept order by deptno desc";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//�ö��� ��װһ�����ݣ�ȡ�ֶΣ���������
				Dept temp = new Dept();
				temp.setDeptno(rs.getInt("deptno"));
				temp.setDname(rs.getString("dname"));
				temp.setLoc(rs.getString("loc"));
				//�Ѷ�����뼯��
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//�ͷ���Դ
		return list;
	}

	@Override
	public Dept getOne(int deptno) {
		init();//��ʼ��
		Dept d2 = null;//�ü��ϴ�����ݣ�����Ľ��������ʹclose�ر������ӣ�����Ľ���������ͷ���Դ
		try {
			String sql = " select * from dept where deptno=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, deptno);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//ȡ�ֶΣ���������
				d2 = new Dept();
				d2.setDeptno(rs.getInt("deptno"));
				d2.setDname(rs.getString("dname"));
				d2.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//�ͷ���Դ
		return d2;
	}

	@Override
	public int insert(Dept d2) {
		init();//��ʼ��
		int num = 0;
		try {
			String sql = " insert into dept values(?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, d2.getDeptno());
			stmt.setString(2, d2.getDname());
			stmt.setString(3, d2.getLoc());
			num = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//�ͷ���Դ
		return num;
	}

	@Override
	public int update(Dept d2) {
		init();//��ʼ��
		int num = 0;
		try {
			String sql = " update dept set dname=?,loc=? where deptno=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, d2.getDname());
			stmt.setString(2, d2.getLoc());
			stmt.setInt(3, d2.getDeptno());
			num = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//�ͷ���Դ
		return num;
	}

	@Override
	public int delete(int deptno) {
		init();//��ʼ��
		int num = 0;
		try {
			String sql = " delete from dept where deptno=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,deptno);
			num = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//�ͷ���Դ
		return num;
	}
	
}
