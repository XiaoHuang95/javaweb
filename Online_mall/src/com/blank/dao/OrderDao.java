package com.blank.dao;

import com.blank.domain.Order;
import com.blank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    DBUtil util = new DBUtil();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //插入订单
    public int insertOrder(Order order){
        int res = 0;
        try {
            conn = util.getConnection();
            String sql = "insert into myorder (total,receiverAddress,receiverName,receiverPhone,ordertime,user_id,state) values (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,order.getTotal());
            ps.setString(2,order.getReceiverAddress());
            ps.setString(3,order.getReceiverName());
            ps.setString(4,order.getReceiverPhone());
            ps.setString(5,order.getDate());
            ps.setInt(6,order.getUser_id());
            ps.setString(7,order.getOrderstate());
            res = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return res;
    }
    //根据用户id查询订单
    public List<Order> queryOrderById(Integer uid){
        List<Order> orderList = new ArrayList<>();
        Order order = null;
        try{
            conn = util.getConnection();
            String sql = "select * from myorder where user_id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setTotal(rs.getDouble("total"));
                order.setReceiverAddress(rs.getString("receiverAddress"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setReceiverPhone(rs.getString("receiverPhone"));
                order.setDate(rs.getString("ordertime"));
                order.setOrderstate(rs.getString("state"));
                orderList.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return orderList;
    }
    //根据订单id删除订单
    public int deleteOrderById(Integer id){
        int res = 0;
        try {
            conn = util.getConnection();
            String sql = "delete from myorder where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return res;
    }
    //根据订单id更新订单状态
    public int paymentOrderById(Integer id,String state){
        int res = 0;
        try {
            conn = util.getConnection();
            String sql = "update myorder set state = ? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,state);
            ps.setInt(2,id);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return res;
    }
}
