package ch13;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_Servlet
 */
@WebServlet("/User_Servlet")
public class User_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error = "";
		 
 		try{
 			
 			//配列宣言
 			ArrayList<Accountinfo> list = new ArrayList<Accountinfo>();
 
 			//オブジェクト宣言
 			AccountDao objDao = new AccountDao();
 
 			//全検索メソッドを呼び出し
 			list = objDao.selectAll();
 			
 			//検索結果を持ってlist.jspにフォワード
 			request.setAttribute("list", list);
 			
 		}catch (IllegalStateException e) {
 			error ="DB接続エラーの為、一覧表示はできませんでした。";
 
 		}catch(Exception e){
 			error ="予期せぬエラーが発生しました。<br>"+e;
 
 		}finally{
 			request.setAttribute("error", error);
 			request.getRequestDispatcher("/list.jsp").forward(request, response);
 		}
 	}
	
	
	
	public void doPost(HttpServletRequest request ,HttpServletResponse response)
		 	throws ServletException ,IOException{
		 
		String error = "";
		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("insert") != null) {
	 		try{
	 		
	 
	 			//DTOオブジェクト宣言
	 			Accountinfo accountinfo = new Accountinfo();
	 
	 			//パラメータの取得
	 			accountinfo.setId(request.getParameter("id"));
	 			accountinfo.setStaffid(request.getParameter("staffid"));
	 			accountinfo.setName(request.getParameter("name"));
	
	 			System.out.print(request.getParameter("id"));
	 			//DAOオブジェクト宣言
	 			AccountDao objDao4 = new AccountDao();
	 
	 			//1件登録メソッドを呼び出し
	 			int count = objDao4.insert(accountinfo);
	 
	 			//登録された件数を持ってlist.jspにフォワード
	 			request.setAttribute("count", count);
	 
	 		}catch (IllegalStateException e) {
	 			error ="DB接続エラーの為、登録できませんでした。";
	 
	 		}catch(Exception e){
	 			error ="予期せぬエラーが発生しました。<br>"+e;
	 
	 		}finally{
	 			request.setAttribute("error", error);
	 			request.getRequestDispatcher("/InsertReceipt.jsp").forward(request, response);
	 		}
		}
		
		
		else if(request.getParameter("update") !=null) {
	 		try{
	 		
	 
	 			//DTOオブジェクト宣言
	 			Accountinfo accountinfo = new Accountinfo();
	 
	 			//パラメータの取得
	 			accountinfo.setId(request.getParameter("id"));
	 			accountinfo.setStaffid(request.getParameter("staffid"));
	 			accountinfo.setName(request.getParameter("name"));
	 	
	 			
	 
	 			//DAOオブジェクト宣言
	 			AccountDao objDao5 = new AccountDao();
	 
	 			//更新メソッドを呼び出し
	 			int count = objDao5.update(accountinfo);
	 
	 			//更新件数をリクエストスコープに登録
	 			request.setAttribute("count", count);
	 
	 		}catch (IllegalStateException e) {
	 			error ="DB接続エラーの為、登録できませんでした。";
	 
	 		}catch(Exception e){
	 			error ="予期せぬエラーが発生しました。<br>"+e;
	 
	 		}finally{
	 			request.setAttribute("error", error);
	 			request.getRequestDispatcher("/UpdateReceipt.jsp").forward(request, response);
	 		}
	 	}
		
		
		else if(request.getParameter("select") !=null) {

	 		try{
	 			//パラメータの取得
	 			String id = request.getParameter("id");
	
	 			//配列宣言
	 			ArrayList<Accountinfo> list = new ArrayList<Accountinfo>();
	
	 			//オブジェクト宣言
	 			AccountDao objDao2 = new AccountDao();
	
	 			//全検索メソッドを呼び出し
	 			list = objDao2.search(id);
	
	 			//検索結果を持ってlist2.jspにフォワード
	 			request.setAttribute("list", list);
	
	 		}catch (IllegalStateException e) {
	 			error ="DB接続エラーの為、一覧表示はできませんでした。";
	
	 		}catch(Exception e){
	 			error ="予期せぬエラーが発生しました。<br>"+e;
	
	 		}finally{
	 			request.setAttribute("error", error);
	 			request.getRequestDispatcher("/list2.jsp").forward(request, response);
	 		}
		}
		
		else if(request.getParameter("delete") != null) {
			try{
				
	 			//パラメータの取得
	 			String id = request.getParameter("id");
	 
	 			//DAOオブジェクト宣言
	 			AccountDao objDao6 = new AccountDao();
	 
	 			//削除メソッドを呼び出し
	 			int count = objDao6.delete(id);
	 
	 			//削除件数をリクエストスコープに登録
	 			request.setAttribute("count", count);
	 
	 		}catch (IllegalStateException e) {
	 			error ="DB接続エラーの為、登録できませんでした。";
	 
	 		}catch(Exception e){
	 			error ="予期せぬエラーが発生しました。<br>"+e;
	 
	 		}finally{
	 			request.setAttribute("error", error);
	 			request.getRequestDispatcher("/DeleteReceipt.jsp").forward(request, response);
	 		}
			
		}
		
	}
		
		
}





