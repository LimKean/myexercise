package Dao.impl;

import util.DBUtil;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    @org.junit.jupiter.api.Test
    void login() {
        String username = "123";
        String pwd = "122";
        try{
            DBUtil.init();
            ResultSet rs = DBUtil.query("select * from user where name = '"+username+"'");
            while (rs.next()){
                if (rs.getString("pwd").equals(pwd)){
                    System.out.println("1111111");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}