package 数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author XieDuoLiang
 * @date 2020/11/27 下午2:11
 */
public class JdbcTest {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = ".xdl9257xdl.";

    public static void main(String[] args) throws SQLException {
        String userName = "测试事物和异步线程 or userId = 2";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT userId, userName, age FROM user WHERE userName=?")) {
                ps.setObject(1, userName); // 注意：索引从1开始
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong("userId");
                        String name = rs.getString("userName");
                        short age = rs.getShort("age");
                        System.out.println(id+name+age);
                    }
                }
            }
        }
    }
}
