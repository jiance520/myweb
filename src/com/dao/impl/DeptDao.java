package com.dao.impl;
import java.util.ArrayList;
import java.util.List;

import com.dao.IDeptDao;
import com.entity.Dept;

import java.sql.*;

/**
 * @version 时间：2018年5月12日 上午9:21:31
 *部门实现类
 */
public class DeptDao extends BaseDao implements IDeptDao{

	@Override
	public List<Dept> getAll() {
		init();//初始化
		List<Dept> list = new ArrayList<Dept>();//用集合打包数据，打包的结果集，即使close关闭了连接，打包的结果集不会释放资源
		try {
			String sql = " select * from dept order by deptno desc";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//用对象 封装一行数据，取字段，设置属性
				Dept temp = new Dept();
				temp.setDeptno(rs.getInt("deptno"));
				temp.setDname(rs.getString("dname"));
				temp.setLoc(rs.getString("loc"));
				//把对象放入集合
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//释放资源
		return list;
	}

	@Override
	public Dept getOne(int deptno) {
		init();//初始化
		Dept d2 = null;//用集合打包数据，打包的结果集，即使close关闭了连接，打包的结果集不会释放资源
		try {
			String sql = " select * from dept where deptno=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, deptno);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//取字段，设置属性
				d2 = new Dept();
				d2.setDeptno(rs.getInt("deptno"));
				d2.setDname(rs.getString("dname"));
				d2.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//释放资源
		return d2;
	}

	@Override
	public int insert(Dept d2) {
		init();//初始化
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
		close();//释放资源
		return num;
	}

	@Override
	public int update(Dept d2) {
		init();//初始化
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
		close();//释放资源
		return num;
	}

	@Override
	public int delete(int deptno) {
		init();//初始化
		int num = 0;
		try {
			String sql = " delete from dept where deptno=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,deptno);
			num = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();//释放资源
		return num;
	}
	
}
