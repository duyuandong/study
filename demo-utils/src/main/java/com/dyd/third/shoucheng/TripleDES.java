package com.dyd.third.shoucheng;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * TripleDES
 *
 * @author michael
 * @version 1.0.0
 * @date 2020-01-03
 */
public class TripleDES {

  /**
   * 初始化密钥
   *
   * @return byte[] 密钥
   * @throws Exception
   */
  public static byte[] initSecretKey() throws Exception {
    // 返回生成指定算法的秘密密钥的 KeyGenerator 对象
    KeyGenerator kg = KeyGenerator.getInstance("DESede");
    // 初始化此密钥生成器，使其具有确定的密钥大小
    kg.init(168);
    // 生成一个密钥
    SecretKey secretKey = kg.generateKey();
    return secretKey.getEncoded();
  }

  /**
   *
   *
   * <ul>
   *   <li>1、开发日期：2014-4-17
   *   <li>2、开发时间：上午10:33:39
   *   <li>4、返回类型：SecretKey
   *   <li>5、方法含义：
   *   <li>6、方法说明：
   * </ul>
   *
   * @param key
   * @return
   * @throws Exception
   */
  private static SecretKey getKey(final String key, final String charset) throws Exception {

    final DESedeKeySpec dks = new DESedeKeySpec(BASE64.decode(key));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
    final SecretKey securekey = keyFactory.generateSecret(dks);
    return securekey;
  }

  /**
   * 加密方法
   *
   * @param text 明文
   * @param key 密钥 BASE64
   * @param charset 字符集
   * @return 密文
   * @throws Exception
   */
  public static String encrypt(final String text, final String key, final String charset)
      throws Exception {

    final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    SecretKey secKey = getKey(key, charset);
    cipher.init(Cipher.ENCRYPT_MODE, secKey);
    byte[] textBytes = text.getBytes(charset);
    byte[] bytes = cipher.doFinal(textBytes);
    String encryptBase64EncodeString = StringToByteTools.parseByte2HexStr(bytes);
    return StringUtils.trimToEmpty(encryptBase64EncodeString);
  }

  /**
   * 解密方法
   *
   * @param text 密文
   * @param key 密钥 BASE64
   * @param charset 字符集
   * @return 明文
   * @throws Exception
   */
  public static String decrypt(final String text, final String key, final String charset)
      throws Exception {

    Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, getKey(key, charset));
    byte[] textBytes = StringToByteTools.parseHexStr2Byte(text);
    byte[] bytes = cipher.doFinal(textBytes);
    String decryptString = new String(bytes, charset);
    return StringUtils.trimToEmpty(decryptString);
  }

  public static void main(String[] args) {
    /*JSONObject jsonObject = new JSONObject();
    jsonObject.put("abc", 1223);
    jsonObject.put("kkki", "发顺丰");
    try {
      String encryptStr =
          TripleDES.encrypt(jsonObject.toJSONString(), "E4Otx5GiMXMpDg0snXrQzacWwUrm", "UTF-8");
      System.out.println(encryptStr);

    } catch (Exception e) {
      e.printStackTrace();
    }*/
    try {
      String encryptStr =
          TripleDES.decrypt(
              "960ba3923c4cb5b099dd01c283d19f9f5949230a48a3acfe0c0ae578ccfb1380",
              "E4Otx5GiMXMpDg0snXrQzacWwUrm",
              "UTF-8");
      System.out.println(encryptStr);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
