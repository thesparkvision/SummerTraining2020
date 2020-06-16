
package com.adroit.eshop.dto;

public class SubCategory 
{
 private int subcateId;
 private String subcateName;
 private int cateid;
 private String cateName;
  
 public SubCategory(){
    
 }

  public SubCategory(int subcateId, String subcateName, int cateid)
  {
        this.subcateId = subcateId;
        this.subcateName = subcateName;
        this.cateid = cateid;
    }

    public int getSubcateId() {
        return subcateId;
    }

    public void setSubcateId(int subcateId) {
        this.subcateId = subcateId;
    }

    public String getSubcateName() {
        return subcateName.toUpperCase();
    }

    public void setSubcateName(String subcateName) {
        this.subcateName = subcateName.toUpperCase();
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

 
 
}
