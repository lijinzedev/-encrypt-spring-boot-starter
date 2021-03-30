package com.appstore.app.starter.encrypt.impl;

import com.appstore.app.starter.encrypt.EncryptHelper;
import com.appstore.app.starter.utils.AESUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Component;

@ConditionalOnMissingBean({EncryptHelper.class})
@Component
public class DefalutEncryptHelper implements EncryptHelper {
    @Override
    public String encrypt(byte[] data, byte[] key) throws Exception {
        return AESUtils.encrypt(data, key);
    }

    @Override
    public byte[] decrypt(byte[] data, byte[] key) throws Exception {
        return AESUtils.decrypt(data, key);
    }
}
