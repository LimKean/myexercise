package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库连接工具类
 */
public class DBUtil {

    static String url = "jdbc:mysql://localhost:3306/webmaven?useunicuee=true& characterEncoding=utf8";
    static String username = "root";
    static String password = "rootadmin123";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps =null;

    /**
     * 初始化
     */
    public static void init(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e){
            System.out.println("初始化失败……");
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param sql
     * @return
     */
    public static int addUpdDel(String sql){
        int i = 0;
        try{
            ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (Exception e){
            System.out.println("查询失败……");
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询
     * @param sql
     * @return
     */
    public static ResultSet query(String sql){
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e){
            System.out.println("查询失败……");
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭资源
     */
    public static void close(){
        try{
            if (conn != null){
                conn.close();
            }
        } catch (Exception e){
            System.out.println("关闭资源失败……");
            e.printStackTrace();
        }
    }
}
