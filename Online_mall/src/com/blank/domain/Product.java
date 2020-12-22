package com.blank.domain;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private String type;
    private Integer pnum;
    private String imgurl;
    private double salenum;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    private Integer cid;
    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public double getSalenum() {
        return salenum;
    }

    public void setSalenum(double salenum) {
        this.salenum = salenum;
    }
}
