package zv2.com.cn.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lb
 * @date 2019/8/19 21:48
 */
public class RSAUtils {

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    public static synchronized Map<String, String> generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024, new SecureRandom());
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            String privateKey = encoder.encodeToString(rsaPrivateKey.getEncoded());
            String publicKey = encoder.encodeToString(rsaPublicKey.getEncoded());
            Map<String, String> keyPairMap = new HashMap<>(2);
            keyPairMap.put("privateKey", privateKey);
            keyPairMap.put("publicKey", publicKey);
            return keyPairMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RSAPrivateKey getPrivateKey(String privateKey) {
        byte[] decodedPrivateKey = decoder.decode(privateKey);
        KeySpec keySpec = new X509EncodedKeySpec(decodedPrivateKey);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
            return rsaPrivateKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RSAPublicKey getPublicKey(String publicKey) {
        byte[] decodedPublicKey = decoder.decode(publicKey);
        KeySpec keySpec = new X509EncodedKeySpec(decodedPublicKey);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
            return rsaPublicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(String src, String publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            RSAPublicKey rsaPublicKey = getPublicKey(publicKey);
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            return org.apache.commons.codec.binary.Base64.encodeBase64String(cipher.doFinal(src.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    public static String decrypt(String src, String privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            RSAPrivateKey rsaPrivateKey = getPrivateKey(privateKey);
            cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            byte[] inputBytes = decoder.decode(src.getBytes("UTF-8"));
            return new String(cipher.doFinal(inputBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    public static String encode(String src) throws UnsupportedEncodingException {
        return encoder.encodeToString(src.getBytes("UTF-8"));
    }

    public static String decode(String encodedStr) throws UnsupportedEncodingException {
        return new String(decoder.decode(encodedStr), "UTF-8");
    }
}
