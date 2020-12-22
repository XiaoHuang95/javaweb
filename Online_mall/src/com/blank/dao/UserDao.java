package com.blank.dao;

import com.blank.domain.User;
import com.blank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blank
 * @date 2020/8/29 10:23
 */
public class UserDao {
    DBUtil util = new DBUtil();
    //验证登录信息
    public int login(String userName, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "select count(*) from user where userName=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt("count(*)");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return result;
    }
    //注册用户信息
    public int register(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "insert into user (userName,password,gender,email,phoneNum) values (?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getGender());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPhoneNum());
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,null);
        }
        return result;
    }
    //查询用户信息
    public List queryUsers(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List <User> usersList = new ArrayList<>();
        try {
            conn = util.getConnection();
            String sql = "select *from user";
            ps =  conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id= rs.getInt("id");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phoneNum = rs.getString("phoneNum");
                User users = new User(id,userName,password,gender,email,phoneNum);
                usersList.add(users);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return usersList;
    }
    //删除用户信息
    public int deleteUserInfo(String id){
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = util.getConnection();
            String sql = "delete from user where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(id));
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,null);
        }
        return result;
    }
}
