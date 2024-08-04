package com.alperen.utility;

import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;
import com.alperen.entities.Urun;
import com.alperen.modules.KullaniciModule;
import com.alperen.modules.SepetModule;
import com.alperen.utility.enums.EKategori;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;


public class DataInitializer {
    public static KullaniciDB kullaniciDB = new KullaniciDB();
    public static SiparisDB siparisDB = new SiparisDB();
    public static UrunDB urunDB = new UrunDB();
    public static SepetDB sepetDB = new SepetDB();
    private static final Random RANDOM = new Random();
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");


    public static void generateAllData(){
        generateKullaniciData();
        generateUrunData();
    }

    public static void generateKullaniciData() {
        for (int i = 1; i < 10; i++) {
            Kullanici kullanici = new Kullanici(kullaniciDB);
            kullanici.setIsim("kullanici" + i);
            kullanici.setSoyisim("soyisim" + i);
            kullanici.setEmail(kullanici.getIsim() + "@gmail.com");
            kullanici.setTelNo("123123121" + i);
            kullanici.setTcKimlik("1234567891" + i);
            kullanici.setKullaniciAdi(kullanici.getIsim());
            kullanici.setSifre("12345678");
            kullanici.setDogumTarihi(LocalDate.of((1990 + i), i, i));
        }
    }
    public static void generateUrunData() {
        for (int i = 1; i <= 20; i++) {
            Urun urun = new Urun(urunDB);
            urun.setName("Elektronik Ürün " + i);

            // Rastgele fiyat (örneğin, 50.0 ile 500.0 arasında)
            double randomFiyat = 50.0 + (450.0 * RANDOM.nextDouble());
            String formattedFiyat = DECIMAL_FORMAT.format(randomFiyat);
            urun.setFiyat(Double.parseDouble(formattedFiyat));

            // Rastgele adet (örneğin, 1 ile 100 arasında)
            int randomAdet = 1 + RANDOM.nextInt(100);
            urun.setAdet(randomAdet);

            urun.setKategori(EKategori.ELEKTRONIK); // EKategori enum'unun ELEKTRONIK değerini kullanıyoruz
            urun.setAciklama("Bu bir elektronik ürün açıklamasıdır. Ürün no: " + i);
        }
    }
}
