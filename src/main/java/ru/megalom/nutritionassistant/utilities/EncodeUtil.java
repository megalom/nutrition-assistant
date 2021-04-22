package ru.megalom.nutritionassistant.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String password="Nutrition21";
        System.out.println(bCryptPasswordEncoder.encode(password));
    }
}
