package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {

	public static void main(String[] args) throws SQLException{
		Connection conn=null;
		String sql;
		String url="jdbc:mysql:///test?"
				+"user=root&password=root&useUnicode=true&"
				+"characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			conn=DriverManager.getConnection(url);
			Statement stmt=conn.createStatement();
			sql="select * from me";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
	}
}
