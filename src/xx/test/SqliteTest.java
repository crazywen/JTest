package xx.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Sqlite 数据库测试
 * 
 * @Description:
 * @Author <a href="xnxxljw@163.com">crazywen</a>
 * @Date 2014-10-15
 * @Version 1.0.0
 */
public class SqliteTest {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:db/single-web.db");
			Statement stat = conn.createStatement();
			stat.executeUpdate(getSgUserSql());// 创建一个表，两列
			stat.executeUpdate(getSgMenuSql());
			stat.executeUpdate(getSgEntitySql());
			// stat.executeUpdate("insert into sg_user(name,account,pwd,type,email,phone,address,remark) values('ZhangSan','c','123',0,'','','','');");
			// // 插入数据
			ResultSet rs = stat.executeQuery("select * from sg_user;"); // 查询数据
			while (rs.next()) { // 将查询到的数据打印出来
				System.out.println("id = " + rs.getString("id")); // 列属性二
				System.out.println("name = " + rs.getString("name") + " "); // 列属性一
				System.out.println("account = " + rs.getString("account")); // 列属性二
				System.out.println("pwd = " + rs.getString("pwd")); // 列属性二
				System.out.println("type = " + rs.getInt("type")); // 列属性二
				System.out.println("email = " + rs.getString("email")); // 列属性二
				System.out.println("phone = " + rs.getString("phone")); // 列属性二
				System.out.println("address = " + rs.getString("address")); // 列属性二
				System.out.println("remark = " + rs.getString("remark")); // 列属性二
			}
			rs.close();
			conn.close(); // 结束数据库的连接

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String getSgUserSql() {
		return "CREATE TABLE `sg_user`("
				+ "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "`name` VARCHAR(25) NOT NULL,"
				+ "`account` VARCHAR(25) NOT NULL ,"
				+ "`pwd` VARCHAR(50) NOT NULL ," + "`type` INTEGER NOT NULL ,"
				+ "`email` VARCHAR(50) NULL ," + "`phone` VARCHAR(15) NULL ,"
				+ "`address` VARCHAR(80) NULL ,"
				+ "`remark` VARCHAR(200) NULL);";
	}

	public static String getSgMenuSql() {
		return "CREATE TABLE `sg_menu`( "
				+ "`id` INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "`name` VARCHAR(50) NOT NULL , "
				+ "`display_name` VARCHAR(50) NOT NULL , "
				+ "`link_url` VARCHAR(150) , " + "`pic_url` VARCHAR(150) , "
				+ "`type` INTEGER NOT NULL, " + "`remark` VARCHAR(200) );";
	}

	public static String getSgEntitySql() {
		return "CREATE TABLE `sg_entity`( "
				+ "`id` INTEGER PRIMARY KEY AUTOINCREMENT , "
				+ "`name` VARCHAR(50) NOT NULL , "
				+ "`create_time` DATETIME NOT NULL ,"
				+ "`type` INTEGER NOT NULL , "
				+ "`url` VARCHAR(150) NOT NULL, " + "`tag` VARCHAR(50) , "
				+ "`link_url` VARCHAR(150));";
	}
}
