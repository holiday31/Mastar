import java.sql.*;
public class createdb {
	public static void main(String[] args) {
		String url="jdbc:mysql://Mastar.c1uzyvfb0tlv.us-east-2.rds.amazonaws.com:3306/Mastar?autoReconnect=true&useSSL=false&user=Mastar&password=06231019";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 연결 성공!");
			
			conn=DriverManager.getConnection(url);
			System.out.println("데이터베이스 접속 성공!");
			
			stmt=conn.createStatement();
			String create_db="create database mastar;";
			stmt.executeUpdate(create_db);
			
			String usemastar="use mastar";
			stmt.executeUpdate(usemastar);
			
			String create_tb;
			create_tb="create table info("
					+"id varchar(50) NOT NULL,"
					+"nickname varchar(50) NOT NULL,"
					+"password varchar(50) NOT NULL,"
					+"balance int NOT NULL," 
					+"primary key(id));";
			stmt.executeUpdate(create_tb);
			
		}
		
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			if(conn!=null) try { conn.close();} catch(SQLException se) {}
			if(stmt!=null) try { stmt.close();} catch(SQLException se) {}
			if(rs!=null) try { rs.close();} catch(SQLException se) {}
			
		}
	}
}
