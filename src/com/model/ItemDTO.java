package com.model;


import java.io.Serializable;
import java.sql.Blob;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "item_master")
public class ItemDTO implements Serializable {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int itemno;
   
   @Column(name = "item_name")
   private String itemname;
   
   @Column(name = "unit")
   private String unit;
   
   
   @Column(name = "price")
   private float price;
   
   @Column(name = "shopno" , nullable = false)
   private int shopno;
   
//   @Type(type="org.hibernate.type.BinaryType")
   @Column(name = "Image")
   @Lob
   private byte[] data;
   @Transient
   private String base64Image;
public int getItemno() {
	return itemno;
}


public void setItemno(int itemno) {
	this.itemno = itemno;
}


public String getItemname() {
	return itemname;
}


public void setItemname(String itemname) {
	this.itemname = itemname;
}


public String getUnit() {
	return unit;
}


public void setUnit(String unit) {
	this.unit = unit;
}


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}


public int getShopno() {
	return shopno;
}


public void setShopno(int shopno) {
	this.shopno = shopno;
}


@Override
public String toString() {
	return "ItemDTO [itemno=" + itemno + ", itemname=" + itemname + ", unit=" + unit + ", price=" + price + ", shopno="
			+ shopno + "]";
}


public byte[] getData() {
	return data;
}


public void setData(byte[] data) {
	this.data = data;
}


public String getBase64Image() {
	base64Image = Base64.getEncoder().encodeToString(this.data);
	return base64Image;
}


public void setBase64Image(String base64Image) {
	
	this.base64Image = base64Image;
}


}

