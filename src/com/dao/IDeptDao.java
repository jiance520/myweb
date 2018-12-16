package com.dao;
import java.util.*;
import com.entity.*;
/**
 * @version 时间：2018年5月12日 上午9:07:35
 *接口
 */
public interface IDeptDao {
	//查所有
	List<Dept> getAll();
	//查单个
	Dept getOne(int deptno);
	//新增
	int insert (Dept d2);
	//修改
	int update(Dept d2);
	//删除
	int delete(int deptno);
}
