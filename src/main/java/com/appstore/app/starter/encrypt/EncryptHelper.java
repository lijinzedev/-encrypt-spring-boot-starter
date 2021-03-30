package com.appstore.app.starter.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 加密接口
 */
public interface EncryptHelper {


    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    String encrypt(byte[] data, byte[] key) throws Exception;

    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    byte[] decrypt(byte[] data, byte[] key) throws Exception;
}
