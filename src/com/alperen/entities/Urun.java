package com.alperen.entities;

import com.alperen.databases.UrunDB;
import com.alperen.utility.enums.EKategori;

public class Urun extends BaseEntity{
    private static int urunCount;
    private String name;
    private Double fiyat;
    private int adet;
    private EKategori kategori;
    private String aciklama;

    {
        this.id = ++urunCount;
        this.name = "Urun adi giriniz...";
        this.fiyat = 0.0;
        this.aciklama = "Aciklama giriniz...";
    }
    public Urun(UrunDB urunDB) {
        urunDB.save(this);
    }

    public static int getUrunCount() {
        return urunCount;
    }

    public static void setUrunCount(int urunCount) {
        Urun.urunCount = urunCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public EKategori getKategori() {
        return kategori;
    }

    public void setKategori(EKategori kategori) {
        this.kategori = kategori;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
