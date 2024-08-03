package com.alperen.databases;



import com.alperen.entities.Kullanici;
import com.alperen.utility.DatabaseManager;

public class KullaniciDB extends DatabaseManager<Kullanici> {

    public boolean existsByUsername(String username) {
//        if(Kullanici.getKullaniciCount()>1) {
            for (Kullanici kullanici : veriListesi) {
                if (kullanici.getKullaniciAdi().equals(username)) {
                    return true;
                }
            }
//        }
        return false;
    }

    public boolean existsByTcKimlik(String tcKimlik) {
        for (Kullanici kullanici : veriListesi) {
//            if(Kullanici.getKullaniciCount()>1){
                if (kullanici.getTcKimlik().equals(tcKimlik)){
                    return true;
                }
//            }

        }
        return false;
    }
    public boolean existsByEmail(String email) {
//        if (Kullanici.getKullaniciCount() > 1) {
            for (Kullanici kullanici : veriListesi) {
                if (kullanici.getEmail().equals(email)) {
                    return true;
                }
            }
//        }
            return false;
    }

    public Kullanici findByUsernameAndPassword(String username, String password){
//        if(Kullanici.getKullaniciCount()>1) {
            for (Kullanici kullanici : veriListesi) {
                if (kullanici.getKullaniciAdi().equals(username) && kullanici.getSifre().equals(password)) {
                    return kullanici;
                }
            }
//        }
        return null;
    }

    public Kullanici findByTcEmailPhoneNo(String tcKimlik, String email, String telNo) {
//        if(Kullanici.getKullaniciCount()>1) {
            for (Kullanici kullanici : veriListesi) {
                if (kullanici.getTcKimlik().equals(tcKimlik) && kullanici.getEmail().equals(email) && kullanici.getTelNo().equals(telNo)) {
                    return kullanici;
                }
            }
//        }
        return null;
    }

    public Kullanici findByEmail(String email) {
        for (Kullanici kullanici  : veriListesi){
            if(kullanici.getEmail().equals(email)){
                return kullanici;
            }
        }
        return null;
    }

}
