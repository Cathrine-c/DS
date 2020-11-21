package java_1121;

/**
 * 另一种JDBC编程
 */

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectJDBC1 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_1115?user=root&password=chen62487&characterEncoding=UTF-8&useSSL=false");
            System.out.println(connection);
            //创建操作命令对象
            statement = connection.createStatement();
            //执行sql
            String sql = "select id,name,role,salary from emp";
            resultSet = statement.executeQuery(sql);

            List<Emp> empList = new ArrayList<>();
            //处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                System.out.printf("id = %s,name = %s,role = %s,salary = %s%n", id, name, role, salary);
                Emp emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setRole(role);
                emp.setSalary(salary);
            }
            System.out.println(empList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (resultSet != null)
                    resultSet.close();
                    if (statement != null)
                        statement.close();
                    if (connection != null)
                        connection.close();
                } catch(SQLException throwables){
                    throwables.printStackTrace();
                }
            }
        }

    }

