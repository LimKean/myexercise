package Dao;

import Bean.User;

import java.util.List;

public interface IUserDao {

    //登录
    boolean login(String username, String pwd);

    //注册
    boolean register(User user);

    public List<User> getUserAll();//返回用户信息集合

    public boolean delete(int id);//根据id删除用户

    public boolean update(int id, String name, String pwd, String sex, String home, String info);//更新用户信息
}
