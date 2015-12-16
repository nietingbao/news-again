package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*�����������ݿ�Ĳ���*/
public class UserDA {
	static User auser=null;
	static String url ="jdbc:mysql://localhost/xiaobaodata";
	static String user="root";
	static String pass="spongebob";
	static Connection con;
	static Statement st;
	static String username;
	static String password;
	
	
/*���������ݿ�ĳ�ʼ���Լ��ر����ݿ�ĺ�����׼��ʹ�����ݳصķ���*/
	
/*������Դ�л�����ݿ����ӣ���JNDI�����DataSource���������*/
/*�������ݿ�*/
	public static Connection getConnection()
	{
		try
		{
			//Context��java.name����һ����ڣ����ڲ������ݿ����ӳص������ļ�
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
	
/*�û���¼�ķ���*/	
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
				throw(new NotFoundException("û���ҵ����û�"));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return auser;
	}
	
/*�û�ע��ķ���*/	
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
	