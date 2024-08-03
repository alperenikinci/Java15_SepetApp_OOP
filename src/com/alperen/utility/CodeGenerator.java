package com.alperen.utility;

import java.util.UUID;

public class CodeGenerator {

    public static String generateCode() {
        String uuid = UUID.randomUUID().toString();
        StringBuilder siparisKodu = new StringBuilder();
        for (int i = 0; i < uuid.length(); i++) {
            Character character = uuid.charAt(i);
            if (Character.isDigit(character)) {
                siparisKodu.append(character);
            }
            if (siparisKodu.length() == 5) {
                break;
            }
        }
        return siparisKodu.toString();
    }
}
