package utile;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static{
        try {
            Properties ps = new Properties();

            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            System.out.println(is);
            ps.load(is);
            ds = DruidDataSourceFactory.createDataSource(ps);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Statement stmt, Connection conn) throws SQLException {
        if(stmt != null){
            stmt.close();//归还连接
        }
        if(conn != null){
            conn.close();
        }
    }
    public static void close(Statement stmt, Connection conn, ResultSet rs) throws SQLException {
        if(rs != null){
            rs.close();//归还连接
        }
        close(stmt,conn);
    }
    /**
     * 获取连接池的方法
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
