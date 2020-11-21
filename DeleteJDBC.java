package java_1121;

/**
 * 删除操作
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名");
        String name = scanner.next();
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_1115?useUnicode=true&characterEncoding=UTF-8");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("chen62487");

        Connection connection = dataSource.getConnection();

        String sql = "delete from student where name = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);

        int ret  = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        statement.close();
        connection.close();

    }
}
