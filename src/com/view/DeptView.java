package com.view;
import com.dao.*;

import java.util.*;

import com.entity.*;
import com.dao.impl.*;
/**
 * @version 时间：2018年5月12日 上午10:42:31
 *部门信息操作界面
 */
public class DeptView {
	//Dao对象
	private IDeptDao deptDao = new DeptDao();
	//启动
	public void start(){
		System.out.println("---部门信息管理--");
		boolean stop = true;//停止循环标准
		while(stop){
			System.out.println("1.查所有部门");
			System.out.println("2.查指定部门");
			System.out.println("3.新增部门");
			System.out.println("4.修改部门");
			System.out.println("5.删除部门");
			Scanner input = new Scanner(System.in);
			System.out.println("请选择：");
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
			//是否继续
			System.out.print("是否退出系统yes/no:");
			String ss = input.next();
			if (ss.equals("yes")) {
				stop = false;
				System.out.println("退出系统");
//				System.exit(-1);
			}
		}
	}
	//1.查询所有部门
	public void showAll(){
		System.out.println("--所有部门信息--");
		List<Dept> list = deptDao.getAll();
		for(Dept d:list){
			System.out.println("部门编号："+d.getDeptno());
			System.out.println("部门名称："+d.getDname());
			System.out.println("部门地址："+d.getLoc());
			System.out.println("--------------");
		}
	}
	//查询一个部门
	public void showOne(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入部门编号：");
		int deptno = input.nextInt();
		Dept d2 = deptDao.getOne(deptno);
		if (d2==null) {
			System.out.println("---没有这个部门");
		}
		else{
			System.out.println("部门编号："+d2.getDeptno());
			System.out.println("部门名称："+d2.getDname());
			System.out.println("部门地址："+d2.getLoc());
			System.out.println("--------------");
		}
	}
	//修改
	public void updateDept(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入部门编号：");
		int deptno = input.nextInt();
		//查询原始信息
		Dept d2 = deptDao.getOne(deptno);
		if(d2==null){
			System.out.println("----没有这个部门");
		}
		else{
			System.out.println("请输入名称：");
			String name = input.next();
			System.out.println("请输入地址：");
			String loc = input.next();
			//设置值
			d2.setDname(name);
			d2.setLoc(loc);
			//修改
			int num = deptDao.update(d2);
			if(num<1){
				System.out.println("--修改失败");
			}
			else{
				System.out.println("--修改成功");
			}
		}
	}
	//新增部门
	public void addDept(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入部门编号：");
		int deptno = input.nextInt();
		System.out.println("请输入名称：");
		String name = input.next();
		System.out.println("请输入地址：");
		String loc = input.next();
		Dept d2 = deptDao.getOne(deptno);
		int num = deptDao.insert(d2);
		if(num<1){
			System.out.println("--新增失败");
		}
		else{
			System.out.println("--新增成功");
		}
	}
	//删除部门
	public void deleteDept(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入部门编号：");
		int deptno = input.nextInt();
		int num = deptDao.delete(deptno);
		if(num<1){
			System.out.println("--删除失败");
		}
		else{
			System.out.println("--删除成功");
		}
	}
}
