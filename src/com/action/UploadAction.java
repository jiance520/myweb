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
 * @version 时间：2018年5月31日 上午9:05:22
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
		System.out.println("文件保存路径"+savepath);
		//判断
		boolean ckenc = ServletFileUpload.isMultipartContent(request);
		if(ckenc){
//			String title = request.getParameter("title");
//			System.out.println(title);//null
			String title = "";
			//新建上传对象
			DiskFileItemFactory df = new DiskFileItemFactory();// 工厂用来解析文件
			ServletFileUpload sfu = new ServletFileUpload(df);//上传
			//设置
//			sfu.setSizeMax(sizeMax);//总文件大小
			sfu.setSizeMax(500*1024*1024);//单个文件大小 500mb
			try {
				//取数据
				List<FileItem> flist = sfu.parseRequest(request);//解析请求的内容，返回上传内容的集合，一个name请求数据就是一个FileItem
				for(FileItem fit:flist){
					//做判断
					if(fit.isFormField()){//普通表单字体
						if(fit.getFieldName().equals("title")){
							title = fit.getString("UTF-8");
						}
					}
					else{//文件
						//取文件名：
						String filename = fit.getName();
						//C:\\demo\\1.png
						//C:/demo/1.png
						//容错，反的是单斜杠，一般用于网络，正的是双斜杠，一般用于本地。
						if(filename.lastIndexOf("\\")!=-1){
							int num = filename.lastIndexOf("\\")+1;
							filename = filename.substring(num);
						}
						System.out.println("文件名："+filename);
						//写文件
						File file = new File(savepath,filename);
						fit.write(file);
					}
				}
				System.out.println("标题:"+title);
				System.out.println("---上传成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			throw new ServletException("enctype 不是multipart");
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
