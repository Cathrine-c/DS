package java_1121;

/**
 * 查询操作
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class SelectJDBC {
        public static void main(String[] args) throws SQLException {
            DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_1115?useUnicode=true&characterEncoding=UTF-8");
            ((MysqlDataSource) dataSource).setUser("root");
            ((MysqlDataSource) dataSource).setPassword("chen62487");


            Connection connection = dataSource.getConnection();
            //拼装sql语句
            String sql="select * from student";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int classId = resultSet.getInt("classId");
                System.out.printf("id=%s,name=%s,classId=%s", id, name,classId);

            }

            resultSet.close();
            statement.close();
            connection.close();
        }

    }


