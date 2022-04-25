package com.jt808.commons.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Utils for encryption
 */
public class EncryptUtils {

    private static final String MODE = "AES/CTR/NoPadding";
    private static volatile SecretKeySpec DefKey;
    private static volatile IvParameterSpec DefInitVector;
//    private static final String MODE = "AES/CBC/PKCS5Padding";

    static {
        initial();
    }

    /**
     * initialization key
     *
     * @param privateKey The private key AES fixed format for 128/192/256 bits. Namely: 16/24/32 bytes. DES fixed format for 128 bits, or 8 bytes.
     * @param initVector AES, an initialization vector is 16 bytes. DES is 8 bytes
     */
    public static void initial(byte[] privateKey, byte[] initVector) {
        DefKey = new SecretKeySpec(privateKey, "AES");
        DefInitVector = new IvParameterSpec(initVector);
    }

    public static void initial() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

            SecureRandom keyRandom = SecureRandom.getInstance("SHA1PRNG");
            keyRandom.setSeed("test~!@_128".getBytes(StandardCharsets.UTF_8));
            keyGenerator.init(128, keyRandom);
            byte[] key = keyGenerator.generateKey().getEncoded();

            SecureRandom ivRandom = SecureRandom.getInstance("SHA1PRNG");
            ivRandom.setSeed("test~!@_128".getBytes(StandardCharsets.UTF_8));
            keyGenerator.init(128, ivRandom);
            byte[] initVector = keyGenerator.generateKey().getEncoded();

            initial(key, initVector);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Initialize the key failure", e);
        }
    }

    public static byte[] encrypt(SecretKeySpec key, IvParameterSpec initVector, byte[] message) {
        try {
            Cipher cipher = Cipher.getInstance(MODE);
            cipher.init(Cipher.ENCRYPT_MODE, key, initVector);

            return cipher.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(String key, String initVector, byte[] message) {
        return encrypt(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"), new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8)), message);
    }

    public static byte[] encrypt(byte[] message) {
        return encrypt(DefKey, DefInitVector, message);
    }

    public static byte[] decrypt(SecretKeySpec key, IvParameterSpec initVector, byte[] message) {
        try {
            Cipher cipher = Cipher.getInstance(MODE);
            cipher.init(Cipher.DECRYPT_MODE, key, initVector);

            return cipher.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decrypt(String key, String initVector, byte[] message) {
        return decrypt(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"), new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8)), message);
    }

    public static byte[] decrypt(byte[] message) {
        return decrypt(DefKey, DefInitVector, message);
    }
}