# 🔐 EDUCRYPT
CLI tool to encrypt/decrypt text using AES-128 (ECB mode) from the terminal. 

## 🚀 Features  
- AES-128 encryption/decryption (ECB + PKCS5Padding)  
- Support for long (`--mode`) and short (`-m`) parameters  
- Base64-encoded output for encrypted text  
- Built-in help and version info  

## 📦 Installation  
1. **Requirements**:  
   - Java 17+  
   - Maven (to build)  

2. **Build JAR**:  
   ```bash  
   mvn clean package

## 🛠 The executable JAR will be at:
   `target/educrypt-1.0.0-jar-with-dependencies.jar`

### Encrypt  
   ``` bash 
   java -jar educrypt.jar --mode encrypt --key "mySecretKey" --text "Hello World"   ```
   ```
### Decrypt (use output from above)  
   ``` bash
   java -jar educrypt.jar -m d -k "mySecretKey" -t "k4t9P3XYZzV...Base64..."
   ```
### Help  
   ``` bash
   java -jar educrypt.jar --help   
   ```

### Version  
   ``` bash
   java -jar educrypt.jar --version   
   ```

## 🏗 Project Structure
   ```
   aes-cli-helper/  
   ├── src/  
   │   ├── main/  
   │   │   ├── java/org/educrypt/  
   │   │   │   ├── cli/          # Command-line logic  
   │   │   │   ├── crypto/       # AES implementation  
   │   │   │   └── Main.java     # Entry point  
   │   └── test/                 # Unit tests  
   ├── pom.xml                   # Maven config  
   └── README.md  
   ```


## ⚠️ Limitations
- ECB mode is not production-ready (consider CBC/GCM for future versions).
- Key must be exactly 16 characters (AES-128).


## 🤝 Contributing
- Fork the project
- Create a branch (git checkout -b feature/new-feature)
- Commit changes (git commit -am 'Add X feature')
- Push to the branch (git push origin feature/new-feature)
- Open a Pull Request