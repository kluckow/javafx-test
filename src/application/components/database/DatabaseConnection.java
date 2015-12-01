package application.components.database;

import java.sql.*;

/**
 * The Class DatabaseConnection.
 */
// TODO: create a "framework"
public class DatabaseConnection {

	/** The Constant JDCB_DRIVER. */
	private static final String JDCB_DRIVER = "com.mysql.jdbc.Driver";
	
	/** The Constant DB_URL. */
	private static final String DB_URL = "jdbc:mysql://localhost:3306/rpg-test";
	
	/** The Constant DB_USER. */
	private static final String DB_USER = "root";
	
	/** The Constant DB_PASS. */
	private static final String DB_PASS = "";
	
	/**
	 * Establish.
	 */
	private void establish() {
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			System.out.println("Database connected!");
		
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect to the database!", e);
		}
	}
	
	/**
	 * Destroy.
	 *
	 * @param conn the conn
	 */
	private void destroy(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect to the database!", e);
		}
		
	}
	
	/**
	 * Execute query.
	 *
	 * @param conn the conn
	 */
	private void executeQuery(Connection conn) {
		try {
			Statement stmt = null;
			stmt = conn.createStatement();
			String sql = "INSERT INTO user (`account`) VALUES (2)";
			int code = stmt.executeUpdate(sql);
			System.out.println(code);
			stmt.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
	}
	
	/**
	 * Instantiates a new database connection.
	 */
	public DatabaseConnection() {
		
		    
//		    sql = "SELECT * FROM user";
//		    ResultSet rs = stmt.executeQuery(sql);
//		    sql = "DELETE FROM user";
//		    stmt.executeUpdate(sql);
		    
		    
//		try {
//		    Class.forName("com.mysql.jdbc.Driver");
//		    System.out.println("Driver loaded!");
//		} catch (ClassNotFoundException e) {
//		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
//		}
//		Context context = new InitialContext();
//		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		
//		MysqlDataSource dataSource = new MysqlDataSource();
//		dataSource.setUser("scott");
//		dataSource.setPassword("tiger");
//		dataSource.setServerName("myDBHost.example.org");
		
//		try {
//			Class.forName(JDCB_DRIVER);
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//		} catch (SQLException se1) {
//			se1.printStackTrace();
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException se2) {
//				se2.printStackTrace();
//			}
//		}
	}
}
