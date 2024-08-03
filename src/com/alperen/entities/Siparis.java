package com.alperen.entities;

import com.alperen.utility.CodeGenerator;

import java.time.LocalDate;

public class Siparis extends BaseEntity{
    private static int siparisCount;
    private String siparisNo;
    private String teslimatKodu;
    private int sepetId;
    private LocalDate teslimatTarihi;
    private boolean teslimEdildiMi;
    {
        teslimEdildiMi = false;
        this.id = ++ siparisCount;
        this.teslimatKodu = CodeGenerator.generateCode();
    }
}
