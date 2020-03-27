package Dao.impl;

import Bean.User;
import Dao.IUserDao;
import util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean login(String username, String pwd) {
        boolean flag = false;
        try {
            DBUtil.init();
            ResultSet rs = DBUtil.query("select * from user where name = '"+username+"'");
            while (rs.next()){
                if (rs.getString("pwd").equals(pwd)){
                    flag = true;
                }
            }
        } catch (Exception e){

        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        boolean flag = false;
        DBUtil.init();
        int i = DBUtil.addUpdDel("insert into user(name,sex,pwd,home,info)" +
                "values('" +user.getName()+"','"+user.getSex()+"','"+user.getPwd()+"','"+
                user.getHome()+"','"+user.getInfo()+"')");
        if (i > 0) {
            flag = true;
        }
        DBUtil.close();
        return flag;
    }

    @Override
    public List<User> getUserAll() {
        List<User> list = new ArrayList<>();
        try{
            DBUtil.init();
            ResultSet rs = DBUtil.query("select * from user");
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setPwd(rs.getString("pwd"));
                user.setInfo(rs.getString("info"));
                list.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        DBUtil.close();
        return list;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        DBUtil.init();
        try {
            int result = DBUtil.addUpdDel("delete from user where id = "+id);
            if (result > 0){
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        DBUtil.close();
        return flag;
    }

    @Override
    public boolean update(int id, String name, String pwd, String sex, String home, String info) {
        boolean flag = false;
        try{
            DBUtil.init();
            String sql ="update user set name ='"+name
                    +"' , pwd ='"+pwd
                    +"' , sex ='"+sex
                    +"' , home ='"+home
                    +"' , info ='"+info+"' where id = "+id;
            int result = DBUtil.addUpdDel(sql);
            if (result > 0){
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtil.close();
        return flag;
    }
}
