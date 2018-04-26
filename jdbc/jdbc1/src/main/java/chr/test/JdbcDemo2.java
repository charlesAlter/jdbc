package chr.test;

import chr.utlis.DruidUtils;
import chr.utlis.DruidUtils2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo2 {


    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            //conn = DruidUtils.getConnection();
            conn = DruidUtils2.getConnection();
            String sql = "select * from emp ";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                String empno = rs.getString(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                System.out.println(empno +"\t"+ename+"\t" + job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(rs,stat,conn);
        }
    }
}
