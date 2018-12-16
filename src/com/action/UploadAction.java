package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
/**
 * @version ʱ�䣺2018��5��31�� ����9:05:22
 *
 */
public class UploadAction extends HttpServlet {
	private static Logger logger = Logger.getLogger(UploadAction.class.getName());

	/**
	 * Constructor of the object.
	 */
	public UploadAction() {
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
		doPost(request, response);
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
		String savepath = request.getServletContext().getRealPath("/upload");
		System.out.println("�ļ�����·��"+savepath);
		//�ж�
		boolean ckenc = ServletFileUpload.isMultipartContent(request);
		if(ckenc){
//			String title = request.getParameter("title");
//			System.out.println(title);//null
			String title = "";
			//�½��ϴ�����
			DiskFileItemFactory df = new DiskFileItemFactory();// �������������ļ�
			ServletFileUpload sfu = new ServletFileUpload(df);//�ϴ�
			//����
//			sfu.setSizeMax(sizeMax);//���ļ���С
			sfu.setSizeMax(500*1024*1024);//�����ļ���С 500mb
			try {
				//ȡ����
				List<FileItem> flist = sfu.parseRequest(request);//������������ݣ������ϴ����ݵļ��ϣ�һ��name�������ݾ���һ��FileItem
				for(FileItem fit:flist){
					//���ж�
					if(fit.isFormField()){//��ͨ������
						if(fit.getFieldName().equals("title")){
							title = fit.getString("UTF-8");
						}
					}
					else{//�ļ�
						//ȡ�ļ�����
						String filename = fit.getName();
						//C:\\demo\\1.png
						//C:/demo/1.png
						//�ݴ������ǵ�б�ܣ�һ���������磬������˫б�ܣ�һ�����ڱ��ء�
						if(filename.lastIndexOf("\\")!=-1){
							int num = filename.lastIndexOf("\\")+1;
							filename = filename.substring(num);
						}
						System.out.println("�ļ�����"+filename);
						//д�ļ�
						File file = new File(savepath,filename);
						fit.write(file);
					}
				}
				System.out.println("����:"+title);
				System.out.println("---�ϴ��ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			throw new ServletException("enctype ����multipart");
		}
		response.sendRedirect("index.jsp");
		
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
