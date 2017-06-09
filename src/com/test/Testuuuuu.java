package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import org.apache.xml.security.utils.Base64;


public class Testuuuuu {
	public static void main(String[] args) throws Exception {
        String path = "D://111.pfx";
        InputStream in = new FileInputStream(new File(path));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(in, "111".toCharArray());
        keyStore.store(out, "111".toCharArray());
        String b64 = new String(Base64.encode(out.toByteArray()));
        System.out.println(b64);
        Enumeration<String> aliases = keyStore.aliases();
        String enumeration = null;
        while (true) {
            try {
                enumeration = aliases.nextElement();
                System.out.println(enumeration);
            } catch (NoSuchElementException e) {
                System.out.println("∂¡»°ÕÍ±œ");
                break;
            }
        }
        java.security.cert.Certificate cert =  keyStore.getCertificate(enumeration);
        System.out.println(cert.toString());
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(enumeration, "111".toCharArray());
        System.out.println(privateKey);
    }

}
