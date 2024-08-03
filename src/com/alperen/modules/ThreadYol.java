package com.alperen.modules;

import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;

public class ThreadYol {
    public static void main(String[] args) {
        KullaniciDB kullaniciDB = new KullaniciDB();
        SiparisDB siparisDB = new SiparisDB();
        UrunDB urunDB = new UrunDB();
        SepetDB sepetDB = new SepetDB();

        SepetModule sepetModule = new SepetModule(kullaniciDB,siparisDB,urunDB,sepetDB);
        KullaniciModule kullaniciModule = new KullaniciModule(kullaniciDB,siparisDB,urunDB,sepetDB);
        Kullanici kullanici = kullaniciModule.girisYap();

        SepetModule.sepetOlustur();
        SepetModule.sepetiKullaniciyaAta(kullanici);
        System.out.println(sepetDB.findByID(1));
    }
}
