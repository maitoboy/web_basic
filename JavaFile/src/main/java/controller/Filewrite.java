package controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class File
 */
@WebServlet("/Filewrite")
public class Filewrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filewrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/filewrite.jsp");
		 rd.forward(request, response);
		 //		 filewrite.jspに遷移

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String staffid=request.getParameter("staffid");
		String name=request.getParameter("name");
		JSONObject json = new JSONObject();
		json.put("id",id);
		json.put("staffid",staffid);
		json.put("name",name);
		request.setCharacterEncoding("UTF-8");
		
		ServletContext application=this.getServletContext();
		String path=application.getRealPath("/WEB-INF/data/memo.txt");
		System.out.println(path);
		FileOutputStream fos=new FileOutputStream(path,true);
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw=new BufferedWriter(osw);
		json.write(bw);
		bw.newLine();
		bw.close();
		
		response.sendRedirect("/JavaFile/Fileread");	
	}	
				
	
}
	


