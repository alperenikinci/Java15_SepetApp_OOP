package com.alperen.entities;

import com.alperen.databases.SepetDB;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sepet extends BaseEntity{
    private static int sepetCount;
    private int kullaniciId;
    private double sepetTutari;
    private boolean satildiMi;
    private List<Urun> urunList = new ArrayList<>();

    {
        this.satildiMi = false;
        this.kullaniciId = -1;
    }

    public Sepet(SepetDB sepetDB) {
        this.id = ++sepetCount;
        sepetDB.save(this);
    }
    public Sepet(){
    }

    public Sepet sepeteUrunEkle(Urun urun){
        this.urunList.add(urun);
        sepetTutariHesapla();
        return this;
    }
    public Sepet sepeteUrunEkle(List<Urun> urunler){
        this.urunList.addAll(urunler);
        sepetTutariHesapla();

        return this;
    }

    public void sepetTutariHesapla(){
        double total = 0;
        for (Urun urun : urunList){
            total += urun.getAdet()*urun.getFiyat();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedFiyat = df.format(total);
        this.sepetTutari =Double.parseDouble(formattedFiyat);
    }


    public void urunleriListele(){
        urunList.forEach(urun -> System.out.println(urun.sepetBilgi()));
    }
    public static int getSepetCount() {
        return sepetCount;
    }

    public static void setSepetCount(int sepetCount) {
        Sepet.sepetCount = sepetCount;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public double getSepetTutari() {
        return sepetTutari;
    }

    public void setSepetTutari(double sepetTutari) {
        this.sepetTutari = sepetTutari;
    }

    public boolean isSatildiMi() {
        return satildiMi;
    }

    public void setSatildiMi(boolean satildiMi) {
        this.satildiMi = satildiMi;
    }

    public List<Urun> getUrunList() {
        return urunList;
    }

    public void setUrunList(List<Urun> urunList) {
        this.urunList = urunList;
    }

    public void sepetiGoruntule(){
        System.out.println("Sepetiniz {");
        System.out.println("id : " + id);
        System.out.println("kullaniciId : "+ kullaniciId);
        urunleriListele();
        System.out.println("Sepet Tutari : " + sepetTutari +"\n}");
    }

    @Override
    public String toString() {
        return "Sepet{" +
                "kullaniciId=" + kullaniciId +
                ", sepetTutari=" + sepetTutari +
                ", satildiMi=" + satildiMi +
                ", urunList=" + urunList +
                ", id=" + id +
                '}';
    }
}
