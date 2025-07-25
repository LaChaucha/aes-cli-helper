package org.educrypt.cli;

public enum CryptoMode {
  ENCRYPT("encrypt", "e"),
  DECRYPT("decrypt", "d");

  private final String longName;
  private final String shortName;

  CryptoMode(final String longName, final String shortName) {
    this.longName = longName;
    this.shortName = shortName;
  }

  public static CryptoMode getFromString(final String stringMode) {
    for (CryptoMode mode : values()) {
      if (mode.longName.equalsIgnoreCase(stringMode) || mode.shortName.equalsIgnoreCase(stringMode)) {
        return mode;
      }
    }
    throw new IllegalArgumentException("Invalid mode. Use 'encrypt'/'e' o 'decrypt'/'d'");
  }
}
