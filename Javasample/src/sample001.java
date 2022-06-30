import java.sql.Connection;				//java.sql](notion://java.sql/) パッケージ名　Connection クラス名
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sample001 {

public static void main(String[] args) {
// データベース接続情報を格納する変数
Connection conn = null;

// JDBCドライバの読み込み
try {
  // postgresSQLのJDBCドライバを読みこみ
  Class.forName("org.postgresql.Driver");
} catch(ClassNotFoundException e) {
  // JDBCドライバが見つからない場合
  e.printStackTrace();
}

try {
  // データベースへの接続
  conn = DriverManager.getConnection(
	  "jdbc:postgresql://localhost:5432/iap_db", // データベース名
      "imart",                     // ユーザー名
      "imart"                        // パスワード
    );

  // SELECT文の発行と結果の取得
  // Statement オブジェクトを生成
  Statement stmt = conn.createStatement();

  //UPDATE文の発行
  String sql = "UPDATE staff SET name = '佐藤さおり' WHERE id = '0002'";
  stmt.executeUpdate(sql);
  
  // SELECT文の(ソート)発行と結果の取得
  sql = "select * from staff ";
  ResultSet rset = stmt.executeQuery(sql);
 
  System.out.println();
  System.out.println("id | 従業員id | 氏名");
  // 結果の表示
  while(rset.next()) {
	
	System.out.println(rset.getString("id")+ " | " + rset.getString("staffid") + "| " + rset.getString("name"));

//    System.out.print(rset.getString("name"));
  }


} catch(SQLException e) {
  // 接続、SELECT文でエラーが発生した場合
  e.printStackTrace();
} finally {
  // データベース接続の切断
  if(conn != null) {
    try {
      conn.close();
      conn = null;
    } catch(SQLException e) {
      // データベースの切断でエラーが発生した場合
      e.printStackTrace();
    }
  }
}

}

}