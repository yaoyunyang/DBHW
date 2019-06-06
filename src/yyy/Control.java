package yyy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Control {
	// 声明Connection对象
	private Connection con;
	// 驱动程序名
	private String driver = "com.mysql.cj.jdbc.Driver";
	// URL指向要访问的数据库名mydata
	private String url = "jdbc:mysql://localhost:3306/mydb";
	// MySQL配置时的用户名
	private String user = "yyy";
	// MySQL配置时的密码
	private String password = "sanwai1222";
	private ResultSet rs;

//	public ResultSet getRs() {
//		return rs;
//	}

	//获取数据
	@SuppressWarnings("finally")
	public String[][] excute_get(String sql) {
		String[][] data = new String[200][3];
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
//			order = "insert into members values('yyy','2017','xunliangu')";
			
			// 3.ResultSet类，用来存放获取的结果集！！
			rs = statement.executeQuery(sql);
			
          int i=0;
          while(rs.next()){
           
              data[i][0]=rs.getString("name");
  
              data[i][1]=rs.getString("grade");
              data[i][2]=rs.getString("branch");
              i++;
              
          }
			rs.close();
			
            con.close();
          
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			System.out.println("数据库数据成功获取！！");
			return data;
		}
	}
	
	public void excute_insert(String sql) {
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 创建一个PreparedStatement对象
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            con.close();
           
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			System.out.println("数据库数据插入结束！！");
			
		}
	}
}