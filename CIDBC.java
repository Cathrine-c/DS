package java_1121;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CIDBC {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource )dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_1115?useUnicode=true&characterEncoding=UTF-8");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("chen62487");

        Connection connection = dataSource.getConnection();

        int id = 1;
        String name = "刘备";
        int classId = 12;
        String sql = "insert into student values(?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        System.out.println("statement"+statement);

        int ret = statement.executeUpdate();
        System.out.println("ret:"+ret);

        statement.close();
        connection.close();
    }
}
