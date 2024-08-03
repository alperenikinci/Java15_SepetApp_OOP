package com.alperen.entities;

import com.alperen.databases.KullaniciDB;

import java.time.LocalDate;

public class Kullanici extends BaseEntity {
    private static int kullaniciCount;
    private String isim;
    private String soyisim;
    private String email;
    private String telNo;
    private String sifre;
    private String kullaniciAdi;
    private String tcKimlik;
    private LocalDate dogumTarihi;


    //init block
    {
        this.id = ++kullaniciCount;
        this.isim = "";
        this.soyisim = "";
        this.email = "";
        this.telNo = "";
        this.sifre = "";
        this.kullaniciAdi = "";
        this.tcKimlik = "";
    }
    public Kullanici(KullaniciDB kullaniciDB){
        kullaniciDB.save(this);
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public void setDogumTarihi(LocalDate dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public static int getKullaniciCount() {
        return kullaniciCount;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getEmail() {
        return email;
    }

    public String getTelNo() {
        return telNo;
    }

    public String getSifre() {
        return sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }



    public LocalDate getDogumTarihi() {
        return dogumTarihi;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", email='" + email + '\'' +
                ", telNo='" + telNo + '\'' +
                ", sifre='" + sifre + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", tcKimlik='" + tcKimlik + '\'' +
                ", kayitTarihi=" + this.getCreateDate() +
                ", dogumTarihi=" + dogumTarihi +
                '}';
    }
}
