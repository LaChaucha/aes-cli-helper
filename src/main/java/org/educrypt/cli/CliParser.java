package org.educrypt.cli;

import java.util.HashMap;
import java.util.Map;

public class CliParser {

  private final Map<String, String> arguments;

  public CliParser(final String[] externalArguments) {
    this.arguments = parseArguments(externalArguments);
  }

  public boolean isHelpRequested() {
    return arguments.containsKey("--help") || arguments.containsKey("-h");
  }
  public boolean isVersionRequested() {
    return arguments.containsKey("--version") || arguments.containsKey("-v");
  }

  public CryptoMode getMode() {
    return CryptoMode.getFromString(arguments.getOrDefault("--mode", arguments.get("-m")));
  }
  public String getKey() {
    return arguments.getOrDefault("--key", arguments.get("-k"));
  }
  public String getText() {
    return arguments.getOrDefault("--text", arguments.get("-t"));
  }


  private static Map<String, String> parseArguments(final String[] args) {
    final Map<String, String> params = new HashMap<>();

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "--mode", "-m", "--key", "-k", "--text", "-t" -> {
          if (i + 1 < args.length) {
            params.put(args[i], args[i + 1]);
            i++;
          }
        }
        case "--help", "-h", "--version", "-v" -> params.put(args[i], "");
        default -> throw new IllegalArgumentException("Unknown parameter: " + args[i]);
      }
    }
    return params;
  }
}
