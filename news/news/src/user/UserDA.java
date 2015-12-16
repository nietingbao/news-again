package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	
/*从数据源中获得数据库连接，用JNDI来获得DataSource对象的引用*/
/*连接数据库*/
	public static Connection getConnection()
	{
		try
		{
			//Context是java.name包中一个借口，用于查找数据库连接池的配置文件
			Context ctx = new InitialContext();
			ctx=(Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("DataPool");
			con=ds.getConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
/*用户登录的方法*/	
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
	
/*用户注册的方法*/	
	public static void addUser(String username,String password) throws DuplicateException
	{
		User buser=null;
		auser=null;
		String sql = "insert into newsuser(username,password) values('"+username+"','"+password+"');";
		try
		{
			buser=UserDA.findUser(username);
		}
		catch(NotFoundException e)
		{
			try
			{
				st.executeUpdate(sql);
			}
			catch(SQLException ee)
			{
				System.out.println(ee);
			}
		}
	}
}
	