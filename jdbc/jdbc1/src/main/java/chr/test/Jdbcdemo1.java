package chr.test;

import org.junit.Test;

import java.sql.*;

public class Jdbcdemo1 {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Test
    public void test1() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day21";
        connection = DriverManager.getConnection(url,"root","0123");
        String sql = "SELECT * FROM emp ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String empno = resultSet.getString(1);
            String ename = resultSet.getString(2);
            String job = resultSet.getString(3);
            System.out.println(empno +"\t"+ename+"\t" + job);
        }
        if (connection!=null){
            connection.close();
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }
    }

}
