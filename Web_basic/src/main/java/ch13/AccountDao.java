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
 			System.out.print(list);
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
 }