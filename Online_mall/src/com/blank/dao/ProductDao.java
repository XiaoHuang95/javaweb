package com.blank.dao;

import com.blank.domain.Product;
import com.blank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    DBUtil util = new DBUtil();
    //查询商品信息
    public List<Product> queryProduct(){
        List <Product> productList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = util.getConnection();
            String sql = "select id,name,price,type,pnum,imgurl,salenum from product order by salenum DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setPnum(rs.getInt("pnum"));
                product.setImgurl(rs.getString("imgurl"));
                product.setSalenum(rs.getInt("salenum"));
                productList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return productList;
    }
    //按商品的分类查询
    public List<Product> queryProductByType(String Typename){
        List <Product> productList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = util.getConnection();
            String sql = "select id,name,price,type,pnum,imgurl from product where type like '%"+Typename+"%'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setType(Typename);
                product.setPnum(rs.getInt("pnum"));
                product.setImgurl(rs.getString("imgurl"));
                productList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return productList;
    }
    //按商品id查询
    public Product queryProductById(Integer id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = new Product();
        try {
            conn = util.getConnection();
            String sql = "select id,name,price,type,imgurl from product where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImgurl(rs.getString("imgurl"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return product;
    }
    //模糊匹配
    public Product matchProducts(String name){
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Product product = new Product();
            try {
                conn = util.getConnection();
                String sql = "select id,name,price,type,pnum,imgurl from product where name like '%"+name+"%'";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setType(rs.getString("type"));
                    product.setImgurl(rs.getString("imgurl"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                util.close(conn,ps,rs);
            }
            return product;
        }
    }
}
