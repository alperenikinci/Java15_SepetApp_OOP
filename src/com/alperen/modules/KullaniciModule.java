package com.alperen.modules;

import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;

public class KullaniciModule {
    private static KullaniciDB kullaniciDB;
    private static SiparisDB siparisDB;
    private static UrunDB urunDB;
    private static SepetDB sepetDB;

    public KullaniciModule(KullaniciDB kullaniciDB, SiparisDB siparisDB, UrunDB urunDB, SepetDB sepetDB) {
        KullaniciModule.kullaniciDB = kullaniciDB;
        KullaniciModule.siparisDB =siparisDB;
        KullaniciModule.sepetDB = sepetDB;
        KullaniciModule.urunDB = urunDB;
    }

    public Kullanici girisYap(){
        return new Kullanici(kullaniciDB);
    }
}
