package com.alperen.modules;

import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;
import com.alperen.entities.Sepet;

public class SepetModule {
    private static KullaniciDB kullaniciDB;
    private static SiparisDB siparisDB;
    private static UrunDB urunDB;
    private static SepetDB sepetDB;

    public SepetModule(KullaniciDB kullaniciDB, SiparisDB siparisDB, UrunDB urunDB, SepetDB sepetDB) {
        SepetModule.kullaniciDB = kullaniciDB;
        SepetModule.siparisDB =siparisDB;
        SepetModule.sepetDB = sepetDB;
        SepetModule.urunDB = urunDB;
    }

    public static void sepetOlustur(){
        Sepet sepet = new Sepet(sepetDB);
    }

    public static void sepetiKullaniciyaAta(Kullanici kullanici){
        Sepet sepet = sepetDB.findByID(1);
        sepet.setKullaniciId(kullanici.getId());
    }
}
