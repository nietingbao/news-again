package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*连接连接数据库的操作*/
public class UserDA {
	static User auser=null;
	static String url ="jdbc:mysql://localhost/xiaobaodata";
	static String user="root";
	static String pass="spongebob";
	static Connection con;
	static Statement st;
	static String username;
	static String password;
	
	
/*这里是数据库的初始化以及关闭数据库的函数，准备使用数据池的方法*/
	
	public static User findUser(String key) throws NotFoundException
	{
		auser=null;
		String sql="select * from newsuser where username="+"'"+key+"'";
		try
		{
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				username=rs.getString(1);
				password=rs.getString(2);
				auser = new User(username,password);
			}
			else
			{
				auser=null;
				throw(new NotFoundException("没有找到此用户"));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return auser;
	}
}
