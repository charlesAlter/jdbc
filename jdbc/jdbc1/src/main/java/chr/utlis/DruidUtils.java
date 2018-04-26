package chr.utlis;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidUtils {

    private static DruidDataSource ds =  new DruidDataSource();

    static {
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/day21");
        ds.setUsername("root");
        ds.setPassword("0123");
        ds.setMaxActive(10);
        ds.setMinIdle(5);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closeAll(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
