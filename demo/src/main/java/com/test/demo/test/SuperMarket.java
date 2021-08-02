package com.test.demo.test;

import javax.persistence.*;

@Entity
@Table(name="supermarket")
public class SuperMarket {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="NameArabic")
    String NameArabic;
    @Column(name="EnglishName")
    String EnglishName;
    @Column(name="Address")
    String Address;
    @Column(name="image")
            @Lob
    byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameArabic() {
        return NameArabic;
    }

    public void setNameArabic(String nameArabic) {
        NameArabic = nameArabic;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
