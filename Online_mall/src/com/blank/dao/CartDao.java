package com.blank.dao;

import com.blank.domain.Cart;
import com.blank.domain.Product;
import com.blank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    DBUtil util = new DBUtil();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //向购物车中插入商品
    public int InsertCart(Integer uid,Product product,Integer pnum) {
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "insert into cart(uid,pid,pnum,pname,price) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.setInt(2, product.getId());
            ps.setInt(3, pnum);
            ps.setString(4, product.getName());
            ps.setDouble(5, product.getPrice());
            result = ps.executeUpdate();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,null);
        }
        return result;
    }
    //更新购物车信息
    public int updateCart(Integer pid) {
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "update cart set pnum = pnum+1 where pid =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            result = ps.executeUpdate();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,null);
        }
        return result;
    }
    //重写更新方法，传两个参数
    public int updateCart(Integer pid,Integer pnum) {
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "update cart set pnum = ? where pid =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pnum);
            ps.setInt(2, pid);
            result = ps.executeUpdate();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,null);
        }
        return result;
    }
    //查询购物车中商品
    public List<Cart> queryCart(Integer uid){
        List<Cart> carts = new ArrayList<>();
        Cart cart = null;
        try {
            conn = util.getConnection();
            String sql = "select uid,pid,pnum,pname,price from cart where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            while (rs.next()){
                cart = new Cart();
                cart.setUid(rs.getInt("uid"));
                cart.setPid(rs.getInt("pid"));
                cart.setPnum(rs.getInt("pnum"));
                cart.setPname(rs.getString("pname"));
                cart.setPrice(rs.getDouble("price"));
                carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return carts;
    }
    //查询用户是否已加购商品
    public int queryProduct(Integer pid){
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "select uid from cart where pid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,pid);
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return result;
    }
    //根据商品id删除购物车中的商品
    public int deleteProduct(Integer pid){
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "delete from cart where pid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,pid);
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return result;
    }
    //根据用户id删除购物车中的商品
    public int deleteProductByUid(Integer uid){
        int result = 0;
        try {
            conn = util.getConnection();
            String sql = "delete from cart where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uid);
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return result;
    }

}
