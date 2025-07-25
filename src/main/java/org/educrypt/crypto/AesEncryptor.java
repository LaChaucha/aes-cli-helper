package org.educrypt.crypto;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.educrypt.cli.CryptoMode;

public class AesEncryptor {
  private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
  private static final String ALGORITHM = "AES";
  private static final String CHARSET_NAME = "UTF-8";

  public static String process(final CryptoMode mode, final String key, final String text)
      throws Exception {
    if (mode == null || key == null || text == null) {
      throw new IllegalArgumentException(
          "Missing required params. Use:\n"
              + "  Long format : --mode <encrypt|decrypt> --key <key> --text \"<text>\"\n"
              + "  Quick format: -m <e|d> -k <key> -t \"<text>\""
              + "  Help: --version or -v to see a help."
      );
    }
    return CryptoMode.ENCRYPT.equals(mode) ? encrypt(key, text) : decrypt(key, text);
  }

  private static String encrypt(final String secret, final String text) throws Exception {
    final SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), ALGORITHM);
    final Cipher cipher = Cipher.getInstance(TRANSFORMATION);

    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    final byte[] encryptedBytes = cipher.doFinal(text.getBytes(CHARSET_NAME));

    return Base64.getEncoder().encodeToString(encryptedBytes);
  }

  private static String decrypt(final String secret, final String base64EncryptedText)
      throws Exception {
    final SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), ALGORITHM);
    final Cipher cipher = Cipher.getInstance(TRANSFORMATION);

    cipher.init(Cipher.DECRYPT_MODE, secretKey);
    final byte[] decodedBytes = Base64.getDecoder().decode(base64EncryptedText);
    final byte[] decryptedBytes = cipher.doFinal(decodedBytes);

    return new String(decryptedBytes, CHARSET_NAME);
  }

}
