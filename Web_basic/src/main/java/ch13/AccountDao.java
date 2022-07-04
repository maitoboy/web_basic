package ch13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDao {

	//接続用の情報をフィールドに定数として定義
	private static String RDB_DRIVE = "org.postgresql.Driver";
 	private static String URL = "jdbc:postgresql://localhost:5432/iap_db";
 	private static String USER = "imart";
 	private static String PASS = "imart";
 
 	//データベース接続を行うメソッド
 	public static Connection getConnection(){
 		try{
 			Class.forName(RDB_DRIVE);
 			Connection con = DriverManager.getConnection(URL, USER, PASS);
 			return con;
 		}catch(Exception e){
 			throw new IllegalStateException(e);
 		}
 	}
 
 	//データベースから全てのアカウント情報の検索を行うメソッド
 	//戻り値としてArrayList<AccountInfo>型の変数を利用
 	public ArrayList<Accountinfo> selectAll(){
 		//変数宣言
 		Connection con = null;
 		Statement  smt = null;
 
 		//return用オブジェクトの生成
 		ArrayList<Accountinfo> list = new ArrayList<Accountinfo>();
 
 		//SQL文
 		String sql = "SELECT * FROM staff";
 
 		try{
 			con = getConnection();
 			smt = con.createStatement();
 
 			//SQLをDBへ発行
 			ResultSet rs = smt.executeQuery(sql);
 
 			//検索結果を配列に格納
 			while(rs.next()){
 				Accountinfo accountinfo =new Accountinfo();
 				accountinfo.setId(rs.getString("id"));
 				accountinfo.setStaffid(rs.getString("staffid"));
 				accountinfo.setName(rs.getString("name"));
 				list.add(accountinfo);
 			}
 			
 		}catch(Exception e){
 			throw new IllegalStateException(e);
 		}finally{
 			//リソースの開放
 			if(smt != null){
 				try{smt.close();}catch(SQLException ignore){}
 			}
 			if(con != null){
 				try{con.close();}catch(SQLException ignore){}
 			}
 		}
 		return list;
 	}
 	
 	
 	
 	
 	//データベースから全てのアカウント情報の検索を行うメソッド
 	public ArrayList<Accountinfo> search(String id){
 		//変数宣言
 		Connection con = null;
 		Statement  smt = null;
 
 		//return用オブジェクトの生成
 		ArrayList<Accountinfo> list = new ArrayList<Accountinfo>();
 
 		//SQL文
 		String sql = "SELECT * FROM staff WHERE id LIKE '%" + id + "%'";
 
 		try{
 			con = getConnection();
 			smt = con.createStatement();
 
 			//SQLをDBへ発行
 			ResultSet rs = smt.executeQuery(sql);
 
 			//検索結果を配列に格納
 			while(rs.next()){
 				Accountinfo accountinfo =new Accountinfo();
 				accountinfo.setId(rs.getString("id"));
 				accountinfo.setStaffid(rs.getString("staffid"));
 				accountinfo.setName(rs.getString("name"));
 				list.add(accountinfo);
 			}
 
 		}catch(Exception e){
 			throw new IllegalStateException(e);
 		}finally{
 			//リソースの開放
 			if(smt != null){
 				try{smt.close();}catch(SQLException ignore){}
 			}
 			if(con != null){
 				try{con.close();}catch(SQLException ignore){}
 			}
 		}
 		return list;
 	}
 

 	 
 	 	//データベースへデータを登録するメソッド
 	 	public int insert(Accountinfo accountinfo){
 	 		//変数宣言
 	 		System.out.print("a");
 	 		Connection con = null;
 	 		Statement  smt = null;
 	 
 	 		//return用変数
 	 		int count = 0;
 	 
 	 		//SQL文
 	 		String sql = "INSERT INTO staff VALUES('"
 	 					+ accountinfo.getId() + "','"
 	 					+ accountinfo.getStaffid() + "','"
 	 					+ accountinfo.getName() + "')";
 	 
 	 		try{
 	 			con = getConnection();
 	 			smt = con.createStatement();
 	 
 	 			//SQLをDBへ発行
 	 			count = smt.executeUpdate(sql);
 	 
 	 		}catch(Exception e){
 	 			throw new IllegalStateException(e);
 	 		}finally{
 	 			//リソースの開放
 	 			if(smt != null){
 	 				try{smt.close();}catch(SQLException ignore){}
 	 			}
 	 			if(con != null){
 	 				try{con.close();}catch(SQLException ignore){}
 	 			}
 	 		}
 	 		return count;
 	 }
 	 	
 	 
 	 	//データベースへデータを登録するメソッド
 	 	public int update(Accountinfo accountinfo){
 	 		//変数宣言
 	 		Connection con = null;
 	 		Statement  smt = null;
 	 
 	 		//return用変数
 	 		int count = 0;
 	 
 	 		//SQL文
 	 		String sql = "UPDATE staff SET "
 	 			+ "staffid = '" + accountinfo.getStaffid() + "', "
 	 			+ "name = '" + accountinfo.getName() + "' "
 	 			+ "WHERE id = '" + accountinfo.getId() + "'";
 	 
 	 		try{
 	 			con = getConnection();
 	 			smt = con.createStatement();
 	 
 	 			//SQLをDBへ発行
 	 			count = smt.executeUpdate(sql);
 	 
 	 		}catch(Exception e){
 	 			throw new IllegalStateException(e);
 	 		}finally{
 	 			//リソースの開放
 	 			if(smt != null){
 	 				try{smt.close();}catch(SQLException ignore){}
 	 			}
 	 			if(con != null){
 	 				try{con.close();}catch(SQLException ignore){}
 	 			}
 	 		}
 	 		return count;
 	 }
 	 	
 	 	
 	 	//データベースへデータを削除するメソッド
 	 	public int delete(String id){
 	 		//変数宣言
 	 		Connection con = null;
 	 		Statement  smt = null;
 	 
 	 		//return用変数
 	 		int count = 0;
 	 
 	 		//SQL文
 	 		String sql = "DELETE FROM staff WHERE id = '" + id + "'";
 	 
 	 		try{
 	 			con = getConnection();
 	 			smt = con.createStatement();
 	 
 	 			//SQLをDBへ発行
 	 			count = smt.executeUpdate(sql);
 	 
 	 		}catch(Exception e){
 	 			throw new IllegalStateException(e);
 	 		}finally{
 	 			//リソースの開放
 	 			if(smt != null){
 	 				try{smt.close();}catch(SQLException ignore){}
 	 			}
 	 			if(con != null){
 	 				try{con.close();}catch(SQLException ignore){}
 	 			}
 	 		}
 	 		return count;
 	 	}
 	 	
}
 	
