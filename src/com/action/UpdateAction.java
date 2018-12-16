package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.dao.impl.*;

import java.util.*;

import com.entity.*;

/**
 * @version ʱ�䣺2018��5��17�� ����11:17:04
 *
 */
public class UpdateAction extends HttpServlet {
	private IDeptDao deptDao = new DeptDao();
	/**
	 * Constructor of the object.
	 */
	public UpdateAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	//���봦��
		request.setCharacterEncoding("UTF-8");
		//���ղ���
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc= request.getParameter("loc");
		//ת��
		int num = 0;
		try {
			num = Integer.parseInt(deptno);
		} catch (Exception e) {
			num =0;
			e.printStackTrace();
		}
		//�ö����װ����
		Dept d2 = new Dept(num,dname,loc);
		//�޸�
		int n2 = deptDao.update(d2);
		//�Զ���ת��ע����Ҫȥ������Ϣҳ���߼��仯����Ҫת���ˣ����ض���,Ҫȥservlet����Ҫȥjsp����Ϊҳ�滹��Ҫȡֵ��
		response.sendRedirect("DeptAction");//dept.jsp
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
