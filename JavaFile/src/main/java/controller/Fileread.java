package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fileread
 */
@WebServlet("/Fileread")
public class Fileread extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fileread() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// TODO Auto-generated method stub
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		ServletContext application=this.getServletContext();
		String path=application.getRealPath("/WEB-INF/data/memo.txt");
		BufferedReader br=null;
			try {
				FileInputStream fis = new FileInputStream(path);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				br=new BufferedReader(isr);
				List<String> lines=new ArrayList<>();
				String line;
				while((line=br.readLine())!=null){
						lines.add(0,line);
				}
				request.setAttribute("lines", lines);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/fileread.jsp");
				rd.forward(request, response);
			} 
			catch (FileNotFoundException e) {
				//ファイル未生成の場合書き込みに飛ばす処理
				response.sendRedirect("/JavaFile/Filewrite");
			}finally{
				if(br != null){
					br.close();
				}
			}
		}
	}

