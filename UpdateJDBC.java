package java_1121;

/**
 * 修改操作
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的学生id");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的学生姓名");
        String name = scanner.next();
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_1115?useUnicode=true&characterEncoding=UTF-8");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("chen62487");

        Connection connection = dataSource.getConnection();

        String sql = "update student set name = ? where id= ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);

        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

        statement.close();
        connection.close();

    }
}
