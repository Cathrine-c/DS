package java_1121;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

    public class CreateJDBC {
        public static void main(String[] args) throws SQLException {
            //1.创建DataSource对象
            DataSource dataSource = new MysqlDataSource();
            //需要针对DataSource进行一些配置
            //主要配置三方面内容：URL，User，Password,需要进行向下转型,setURL括号中内容固定
            ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_1115?useUnicode=true&characterEncoding=UTF-8");
            ((MysqlDataSource) dataSource).setUser("root");
            ((MysqlDataSource) dataSource).setPassword("chen62487");

            //2.创建connection对象,和数据库建立连接,意义是为了验证当前的网络通信是否正常,
            //如果 不正常就会抛出SQLException
            //connection对象生命周期比较短，每次请求都要重新创建
            Connection connection= dataSource.getConnection();

            //动态拼接
            int id=1;
            String name="刘备";
            int classId=12;
            String sql="insert into student values(?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,classId);
            System.out.println("statement:"+statement);

            //4.拼装完毕后，可以执行sql了
            //insert delete update 都可以使用executeUpdate方法来执行
            //select就使用executeQuery来执行
            //返回值表示修改了多少行
            int ret = statement.executeUpdate();
            System.out.println("ret:"+ret);

            //5.执行完毕之后，关闭释放相关资源,后创建先释放
            statement.close();
            connection.close();

        }
    }


