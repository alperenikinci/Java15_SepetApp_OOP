package com.alperen.databases;

import com.alperen.entities.Kullanici;
import com.alperen.entities.Sepet;
import com.alperen.utility.DatabaseManager;

public class SepetDB extends DatabaseManager<Sepet> {

    public Sepet findActiveSepetByUserId(int id){
        for (Sepet sepet : veriListesi){
            if (sepet.getKullaniciId()==id && sepet.isSatildiMi()==false){
                return sepet;
            }
        }
        return null;
    }

    public boolean isUserHasSepet(Kullanici kullanici) {
        for (Sepet sepet : veriListesi){
            if (sepet.getKullaniciId()==kullanici.getId() && !sepet.isSatildiMi()){
                return true;
            }
        }
        return false;
    }
}
