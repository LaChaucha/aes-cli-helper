package org.educrypt.cli;

public class HelperPrinter {
  private static final String VERSION = "1.0.0";
  private static final String LOGO = """
        ███████╗██████╗ ██╗   ██╗ ██████╗██████╗ ██╗   ██╗██████╗ ████████╗
        ██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗╚██╗ ██╔╝██╔══██╗╚══██╔══╝
        █████╗  ██║  ██║██║   ██║██║     ██████╔╝ ╚████╔╝ ██████╔╝   ██║   
        ██╔══╝  ██║  ██║██║   ██║██║     ██╔══██╗  ╚██╔╝  ██╔═══╝    ██║   
        ███████╗██████╔╝╚██████╔╝╚██████╗██║  ██║   ██║   ██║        ██║   
        ╚══════╝╚═════╝  ╚═════╝  ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚═╝        ╚═╝   
                              v%s | @LaChaucha
        """.formatted(VERSION);
  private static final String HELP = """
        %s
        Autor: Eduardo David Angeleri (angeleridavid@gmail.com)
        GitHub: https://github.com/LaChaucha
        Description:
          Encrypts/decrypts text using AES-128 (ECB mode with PKCS5 padding).
          - Input text must be in UTF-8 format
          - Secret key length determines AES variant (16 chars = AES-128)
          - Output is Base64-encoded for encryption

        Usage: program.jar [OPTIONS] --mode <mode> --key <key> --text <text>
        
        Options:
          -m, --mode     Set operation mode (encrypt/e or decrypt/d)
          -k, --key      Specify encryption/decryption key
          -t, --text     Provide input text (use quotes for spaces)
          -h, --help     Display this help information
          -v, --version  Show program version
        
        Examples:
          Encrypt a message:
            java -jar educrypt.jar --mode encrypt --key EducrypPassword1 --text "Hello world"

          Quick encryption:
            java -jar educrypt.jar -m e -k EducrypPassword1 -t "Sample text"

          Decrypt a message:
            java -jar educrypt.jar -m d -k EducrypPassword1 -t "EncryptedTextHere"
        """.formatted(LOGO);


  public static void showHelp() {
    System.out.println(HELP);
  }
  public static void showVersion() {
    System.out.println(VERSION);
  }
}
