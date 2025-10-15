Домашнее задание
Создать сертификат с помощью keytool

Цель:
Создать сертификат с помощью keytool, подключить его в приложение и продемонстрировать его использование (по REST, gRPS и прочее)

Описание/Пошаговая инструкция выполнения домашнего задания:
    keytool & jarsigner
1) Выпустить самоподписанный сертификат, подписать им jar-файл(из одного класса с методом main()), верифицировать подпись
    jlink
2) Написать класс с одним методом main(), и из него собрать custom lighthweight jre, и запустить свою программу с помощью этой jre
сделать скриншоты выполненной работы, запушить в виде отчета в репо с ДЗ

---
keytool & jarsigner
---
Выпускаем самоподписанные сертификат

```bash
keytool -genkeypair -alias selfcr \
-storetype PKCS12 \
-keyalg RSA -keysize 2048 \
-keystore keytool/src/main/resources/my-keystore.p12 \
-storepass keystore-pass \
-dname "CN=Pavel Antonov,OU=My Company,O=My Company,L=Lipetsk State,S=Lipetsk,C=Russia" \
-validity 365;
```
Посмотрим, на выпущенный сертификат
```bash
keytool -list -v -alias selfcr -storepass keystore-pass -keystore keytool/src/main/resources/my-keystore.p12
```
```log
pavel@mac 6-hw-jdk-tools % keytool -list -v -alias selfcr -storepass keystore-pass -keystore keytool/src/main/resources/my-keystore.p12
Alias name: selfcr
Creation date: 11 нояб. 2024 г.
Entry type: PrivateKeyEntry
Certificate chain length: 1
Certificate[1]:
Owner: CN=Pavel Antonov, OU=My Company, O=My Company, L=Lipetsk State, ST=Lipetsk, C=Russia
Issuer: CN=Pavel Antonov, OU=My Company, O=My Company, L=Lipetsk State, ST=Lipetsk, C=Russia
Serial number: fe57c1317db94d9d
Valid from: Mon Nov 11 00:08:02 MSK 2024 until: Tue Nov 11 00:08:02 MSK 2025
Certificate fingerprints:
         SHA1: 82:DC:B6:CA:F4:C8:8B:8B:9C:52:62:9C:E8:E8:1F:B6:B5:E2:EA:31
         SHA256: 47:80:20:19:C6:D0:31:66:43:39:5D:62:AE:75:BD:54:BD:33:1D:1F:5B:37:6B:7C:69:F8:A7:C9:A1:D4:76:65
Signature algorithm name: SHA384withRSA
Subject Public Key Algorithm: 2048-bit RSA key
Version: 3

Extensions: 

#1: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: EC 65 68 5A 45 6B E1 3B   98 F8 23 FE 42 9A B4 5E  .ehZEk.;..#.B..^
0010: 2C BA 61 75                                        ,.au
]
]
```

Собираем jar
```bash
./gradlew clean jar
```
Проверим, что jar не подписан
```bash
jarsigner -verify -verbose -certs keytool/build/libs/keytool.jar
```
```log
pavel@mac 6-hw-jdk-tools % jarsigner -verify -verbose -certs keytool/build/libs/keytool.jar

           0 Mon Nov 11 11:56:34 MSK 2024 META-INF/
           0 Mon Nov 11 11:56:34 MSK 2024 ru/
           0 Mon Nov 11 11:56:34 MSK 2024 ru/antonov/
          54 Mon Nov 11 11:56:34 MSK 2024 META-INF/MANIFEST.MF
    ?    538 Mon Nov 11 11:56:34 MSK 2024 ru/antonov/Main.class
    ?   2776 Mon Nov 11 11:56:34 MSK 2024 my-keystore.p12

  s = signature was verified 
  m = entry is listed in manifest
  k = at least one certificate was found in keystore
  ? = unsigned entry

jar is unsigned.
```

Подпишем jar
```bash
jarsigner keytool/build/libs/keytool.jar \
-keystore keytool/src/main/resources/my-keystore.p12 \
selfcr \
-storepass keystore-pass \
-tsa http://timestamp.digicert.com;
```

```log
pavel@mac 6-hw-jdk-tools % jarsigner keytool/build/libs/keytool.jar \
> -keystore keytool/src/main/resources/my-keystore.p12 \
> selfcr \
> -storepass keystore-pass \
> -tsa http://timestamp.digicert.com;
jar signed.

Warning: 
The signer's certificate is self-signed.
POSIX file permission and/or symlink attributes detected. These attributes are ignored when signing and are not protected by the signature.

The timestamp will expire on 2031-11-10.
```

Проверим, что jar подписан
```bash
jarsigner -verify -verbose -certs keytool/build/libs/keytool.jar
```
```log
jarsigner -verify -verbose -certs keytool/build/libs/keytool.jar
pavel@mac 6-hw-jdk-tools % jarsigner -verify -verbose -certs keytool/build/libs/keytool.jar

s        280 Mon Nov 11 11:58:34 MSK 2024 META-INF/MANIFEST.MF

      >>> Signer
      X.509, CN=Pavel Antonov, OU=My Company, O=My Company, L=Lipetsk State, ST=Lipetsk, C=Russia
      Signature algorithm: SHA384withRSA, 2048-bit key
      [certificate is valid from 11.11.2024, 00:08 to 11.11.2025, 00:08]
      [Invalid certificate chain: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target]
      >>> TSA
      X.509, CN=DigiCert Timestamp 2024, O=DigiCert, C=US
      Signature algorithm: SHA256withRSA, 4096-bit key
      [certificate is valid from 26.09.2024, 03:00 to 26.11.2035, 02:59]
      X.509, CN=DigiCert Trusted G4 RSA4096 SHA256 TimeStamping CA, O="DigiCert, Inc.", C=US
      Signature algorithm: SHA256withRSA, 4096-bit key
      [certificate is valid from 23.03.2022, 03:00 to 23.03.2037, 02:59]
      X.509, CN=DigiCert Trusted Root G4, OU=www.digicert.com, O=DigiCert Inc, C=US
      Signature algorithm: SHA384withRSA, 4096-bit key
      [certificate is valid from 01.08.2022, 03:00 to 10.11.2031, 02:59]

         487 Mon Nov 11 11:58:34 MSK 2024 META-INF/SELFCR.SF
        7599 Mon Nov 11 11:58:34 MSK 2024 META-INF/SELFCR.RSA
           0 Mon Nov 11 11:56:34 MSK 2024 META-INF/
           0 Mon Nov 11 11:56:34 MSK 2024 ru/
           0 Mon Nov 11 11:56:34 MSK 2024 ru/antonov/
sm       538 Mon Nov 11 11:56:34 MSK 2024 ru/antonov/Main.class

      [entry was signed on 11.11.2024, 11:58]
      >>> Signer
      X.509, CN=Pavel Antonov, OU=My Company, O=My Company, L=Lipetsk State, ST=Lipetsk, C=Russia
      Signature algorithm: SHA384withRSA, 2048-bit key
      [certificate is valid from 11.11.2024, 00:08 to 11.11.2025, 00:08]
      [Invalid certificate chain: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target]
      >>> TSA
      X.509, CN=DigiCert Timestamp 2024, O=DigiCert, C=US
      Signature algorithm: SHA256withRSA, 4096-bit key
      [certificate is valid from 26.09.2024, 03:00 to 26.11.2035, 02:59]
      X.509, CN=DigiCert Trusted G4 RSA4096 SHA256 TimeStamping CA, O="DigiCert, Inc.", C=US
      Signature algorithm: SHA256withRSA, 4096-bit key
      [certificate is valid from 23.03.2022, 03:00 to 23.03.2037, 02:59]
      X.509, CN=DigiCert Trusted Root G4, OU=www.digicert.com, O=DigiCert Inc, C=US
      Signature algorithm: SHA384withRSA, 4096-bit key
      [certificate is valid from 01.08.2022, 03:00 to 10.11.2031, 02:59]

sm      2776 Mon Nov 11 11:56:34 MSK 2024 my-keystore.p12

      [entry was signed on 11.11.2024, 11:58]
      >>> Signer
      X.509, CN=Pavel Antonov, OU=My Company, O=My Company, L=Lipetsk State, ST=Lipetsk, C=Russia
      Signature algorithm: SHA384withRSA, 2048-bit key
      [certificate is valid from 11.11.2024, 00:08 to 11.11.2025, 00:08]
      [Invalid certificate chain: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target]
      >>> TSA
      X.509, CN=DigiCert Timestamp 2024, O=DigiCert, C=US
      Signature algorithm: SHA256withRSA, 4096-bit key
      [certificate is valid from 26.09.2024, 03:00 to 26.11.2035, 02:59]
      X.509, CN=DigiCert Trusted G4 RSA4096 SHA256 TimeStamping CA, O="DigiCert, Inc.", C=US
      Signature algorithm: SHA256withRSA, 4096-bit key
      [certificate is valid from 23.03.2022, 03:00 to 23.03.2037, 02:59]
      X.509, CN=DigiCert Trusted Root G4, OU=www.digicert.com, O=DigiCert Inc, C=US
      Signature algorithm: SHA384withRSA, 4096-bit key
      [certificate is valid from 01.08.2022, 03:00 to 10.11.2031, 02:59]


  s = signature was verified 
  m = entry is listed in manifest
  k = at least one certificate was found in keystore

- Signed by "CN=Pavel Antonov, OU=My Company, O=My Company, L=Lipetsk State, ST=Lipetsk, C=Russia"
    Digest algorithm: SHA-384
    Signature algorithm: SHA384withRSA, 2048-bit key
  Timestamped by "CN=DigiCert Timestamp 2024, O=DigiCert, C=US" on пн нояб. 11 08:58:34 UTC 2024
    Timestamp digest algorithm: SHA-384
    Timestamp signature algorithm: SHA384withRSA, 4096-bit key

jar verified.

Warning: 
This jar contains entries whose certificate chain is invalid. Reason: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
This jar contains entries whose signer certificate is self-signed.
POSIX file permission and/or symlink attributes detected. These attributes are ignored when signing and are not protected by the signature.

The signer certificate will expire on 2025-11-11.
The timestamp will expire on 2031-11-10.
```
---

jlink
---

Скомпилируем и запустим код
```bash
javac -d jlink/build/target jlink/src/main/java/module-info.java
javac -d jlink/build/target --module-path jlink/build/target jlink/src/main/java/ru/antonov/Jlink.java
java --module-path jlink/build/target --module jlink/ru.antonov.Jlink
```
Результат

```log
pavel@mac 6-hw-jdk-tools % java --module-path jlink/build/target --module jlink/ru.antonov.Jlink
нояб. 11, 2024 11:52:58 AM ru.antonov.Jlink main
INFO: 
version: [21.0.5]
runtime: [OpenJDK Runtime Environment]
vm:      [OpenJDK 64-Bit Server VM]
home:    [/opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home]
```

Просмотр зависимостей модуля
```bash
jdeps --module-path jlink/build/target -s --module jlink
```
```log
pavel@mac 6-hw-jdk-tools % jdeps --module-path jlink/build/target -s --module jlink
jlink -> java.base
jlink -> java.logging
```

Соберем леговесную jre
```bash

jlink --module-path "$PWD/jlink/build/target"  --add-modules jlink --output jlink/build/jre/jlink-customjre
```

```bash
./jlink/build/jre/jlink-customjre/bin/java --module jlink/ru.antonov.Jlink
```
```log
pavel@mac 6-hw-jdk-tools % ./jlink/build/jre/jlink-customjre/bin/java --module jlink/ru.antonov.Jlink
Nov 11, 2024 12:00:20 PM ru.antonov.Jlink main
INFO: 
version: [21.0.5]
runtime: [OpenJDK Runtime Environment]
vm:      [OpenJDK 64-Bit Server VM]
home:    [/Users/pavel/IdeaProjects/Java-Advanced-08-homework/antonov/6-hw-jdk-tools/jlink/build/jre/jlink-customjre]
```