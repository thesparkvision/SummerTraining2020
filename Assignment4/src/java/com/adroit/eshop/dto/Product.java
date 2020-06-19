
package com.adroit.eshop.dto;


public class Product {
 private int prodId;
 private String prodName,company;
 private float price;
 private String pic1,pic2,pic3;
 private int category,subcategory;
 private boolean isActive;

    public Product() {
    }

    public Product(int prodId, String prodName, String company, float price, String pic1, String pic2, String pic3, int category, int subcategory, boolean isActive) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.company = company;
        this.price = price;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.category = category;
        this.subcategory = subcategory;
        this.isActive = isActive;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
 
 
}
