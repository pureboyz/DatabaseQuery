package jdbc;

/**
 * <pre>
 * Date 		: 2019. 11. 14.
 * Author 		: pureboyz
 *
 * DB 정보를 담는 클래스.
 * 
 * </pre>
 */
public class DatabaseInfo
{
	private final String JDBC_DRIVER 	= "com.mysql.cj.jdbc.Driver";
	private final String URL 			= "jdbc:mysql://pureboyz.ml:2473/blog?characterEncoding=UTF-8&serverTimezone=UTC";
	private final String USER	 		= "root";
	private final String PASSWORD 		= "sung10820!";
	
	public String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}
	public String getURL() {
		return URL;
	}
	public String getUSER() {
		return USER;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	
}
