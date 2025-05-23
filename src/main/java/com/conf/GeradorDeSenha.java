package com.conf;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenha {
    public static void main(String[] args) {
        String senhaCriptografada = new BCryptPasswordEncoder().encode("123456");
        System.out.println(senhaCriptografada);
    }
}

