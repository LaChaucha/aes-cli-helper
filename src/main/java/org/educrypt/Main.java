package org.educrypt;

import org.educrypt.cli.CliParser;
import org.educrypt.cli.HelperPrinter;
import org.educrypt.crypto.AesEncryptor;

public class Main {

  public static void main(final String[] args) {
    try {
      final CliParser parser = new CliParser(args);

      // Show help or version and exit.
      if (parser.isHelpRequested()) {
        HelperPrinter.showHelp();
        System.exit(0);
      }

      if (parser.isVersionRequested()) {
        HelperPrinter.showVersion();
        System.exit(0);
      }
      // Process operation.
      System.out.println(AesEncryptor.process(parser.getMode(), parser.getKey(), parser.getText()));

    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }


}