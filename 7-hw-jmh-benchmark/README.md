Домашнее задание
Реализация benchmark для алгоритма

Цель:
Реализовать тесты по замеру производительности с помощью JMH

Описание/Пошаговая инструкция выполнения домашнего задания:
1) Использовать приложение из предыдущих заданий. Для выполнения задания потребуется сервис регистрации пользователя, реализованный ранее.
2) Добавить в сервис регистрации логику по хешированию пароля с последующим сохранением хеша в БД
3) Реализовать несколько тестов по производительности:
* тест на логику хэширвования пароля с применением 3 разных алгоритмов: Md5, sha256, sha512 (возможно, в качестве параметра использовать число итераций) - чтобы была сравнительная статистика (Замерить все доступные в JMH метрики:). Цель тестов - обоснованно выбрать более производительный вариант
4) Выбрать 3 различых теста от https://hg.openjdk.org/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/ и предоставить отчёт о запуске этих тестов.
---
Результат теста производительности HashService
```log
Benchmark                                                                               (pass)    Mode     Cnt       Score       Error  Units
HashServiceBenchmark.HashServiceMd5                                                     asdqwe   thrpt       5  240127,288 ± 15478,428  ops/s
HashServiceBenchmark.HashServiceMd5                               asdpokas2!2.,pfjiapj324asijd   thrpt       5  226139,573 ± 19226,293  ops/s
HashServiceBenchmark.HashServiceSha256                                                  asdqwe   thrpt       5  113532,455 ±  4542,715  ops/s
HashServiceBenchmark.HashServiceSha256                            asdpokas2!2.,pfjiapj324asijd   thrpt       5  121253,098 ±  8623,914  ops/s
HashServiceBenchmark.HashServiceSha512                                                  asdqwe   thrpt       5   54693,358 ±  5068,804  ops/s
HashServiceBenchmark.HashServiceSha512                            asdpokas2!2.,pfjiapj324asijd   thrpt       5   55033,513 ±  3607,035  ops/s
HashServiceBenchmark.HashServiceMd5                                                     asdqwe    avgt       5      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5                               asdpokas2!2.,pfjiapj324asijd    avgt       5      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256                                                  asdqwe    avgt       5      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256                            asdpokas2!2.,pfjiapj324asijd    avgt       5      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512                                                  asdqwe    avgt       5      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512                            asdpokas2!2.,pfjiapj324asijd    avgt       5      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5                                                     asdqwe  sample  293852      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.00                                asdqwe  sample              ≈ 10⁻⁶               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.50                                asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.90                                asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.95                                asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.99                                asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.999                               asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.9999                              asdqwe  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p1.00                                asdqwe  sample               0,003               s/op
HashServiceBenchmark.HashServiceMd5                               asdpokas2!2.,pfjiapj324asijd  sample  273692      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.00          asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁶               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.50          asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.90          asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.95          asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.99          asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.999         asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p0.9999        asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceMd5:HashServiceMd5·p1.00          asdpokas2!2.,pfjiapj324asijd  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha256                                                  asdqwe  sample  292106      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.00                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.50                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.90                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.95                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.99                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.999                         asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.9999                        asdqwe  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p1.00                          asdqwe  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha256                            asdpokas2!2.,pfjiapj324asijd  sample  293963      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.00    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.50    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.90    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.95    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.99    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.999   asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p0.9999  asdpokas2!2.,pfjiapj324asijd  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha256:HashServiceSha256·p1.00    asdpokas2!2.,pfjiapj324asijd  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha512                                                  asdqwe  sample  263327      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.00                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.50                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.90                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.95                          asdqwe  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.99                          asdqwe  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.999                         asdqwe  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.9999                        asdqwe  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p1.00                          asdqwe  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha512                            asdpokas2!2.,pfjiapj324asijd  sample  264183      ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.00    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.50    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.90    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.95    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁵               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.99    asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.999   asdpokas2!2.,pfjiapj324asijd  sample              ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p0.9999  asdpokas2!2.,pfjiapj324asijd  sample               0,001               s/op
HashServiceBenchmark.HashServiceSha512:HashServiceSha512·p1.00    asdpokas2!2.,pfjiapj324asijd  sample               0,001               s/op
HashServiceBenchmark.HashServiceMd5                                                     asdqwe      ss       5      ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceMd5                               asdpokas2!2.,pfjiapj324asijd      ss       5      ≈ 10⁻⁴               s/op
HashServiceBenchmark.HashServiceSha256                                                  asdqwe      ss       5      ≈ 10⁻³               s/op
HashServiceBenchmark.HashServiceSha256                            asdpokas2!2.,pfjiapj324asijd      ss       5      ≈ 10⁻³               s/op
HashServiceBenchmark.HashServiceSha512                                                  asdqwe      ss       5       0,001 ±     0,001   s/op
HashServiceBenchmark.HashServiceSha512                            asdpokas2!2.,pfjiapj324asijd      ss       5       0,001 ±     0,001   s/op
```
Исходя из результатов теста, выбираем реализацию с алгоритмом MD5

---

1) Результат запуска теста [JMHSample_11_Loops](https://hg.openjdk.org/code-tools/jmh/file/2be2df7dbaf8/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_11_Loops.java)
```log
pavel@mac jmh-samples % java -jar target/benchmarks.jar JMHSample_11 -f 1
# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureRight

# Run progress: 0,00% complete, ETA 00:11:40
# Fork: 1 of 1
# Warmup Iteration   1: 0,544 ns/op
# Warmup Iteration   2: 0,543 ns/op
# Warmup Iteration   3: 0,550 ns/op
# Warmup Iteration   4: 0,547 ns/op
# Warmup Iteration   5: 0,551 ns/op
Iteration   1: 0,549 ns/op
Iteration   2: 0,564 ns/op
Iteration   3: 0,548 ns/op
Iteration   4: 0,542 ns/op
Iteration   5: 0,544 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureRight":
  0,549 ±(99.9%) 0,033 ns/op [Average]
  (min, avg, max) = (0,542, 0,549, 0,564), stdev = 0,008
  CI (99.9%): [0,517, 0,582] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_1

# Run progress: 14,29% complete, ETA 00:10:01
# Fork: 1 of 1
# Warmup Iteration   1: 0,646 ns/op
# Warmup Iteration   2: 0,542 ns/op
# Warmup Iteration   3: 0,542 ns/op
# Warmup Iteration   4: 0,542 ns/op
# Warmup Iteration   5: 0,542 ns/op
Iteration   1: 0,541 ns/op
Iteration   2: 0,542 ns/op
Iteration   3: 0,542 ns/op
Iteration   4: 0,541 ns/op
Iteration   5: 0,542 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_1":
  0,542 ±(99.9%) 0,001 ns/op [Average]
  (min, avg, max) = (0,541, 0,542, 0,542), stdev = 0,001
  CI (99.9%): [0,541, 0,543] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_10

# Run progress: 28,57% complete, ETA 00:08:21
# Fork: 1 of 1
# Warmup Iteration   1: 0,057 ns/op
# Warmup Iteration   2: 0,057 ns/op
# Warmup Iteration   3: 0,058 ns/op
# Warmup Iteration   4: 0,058 ns/op
# Warmup Iteration   5: 0,057 ns/op
Iteration   1: 0,057 ns/op
Iteration   2: 0,057 ns/op
Iteration   3: 0,056 ns/op
Iteration   4: 0,057 ns/op
Iteration   5: 0,056 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_10":
  0,057 ±(99.9%) 0,001 ns/op [Average]
  (min, avg, max) = (0,056, 0,057, 0,057), stdev = 0,001
  CI (99.9%): [0,056, 0,057] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_100

# Run progress: 42,86% complete, ETA 00:06:40
# Fork: 1 of 1
# Warmup Iteration   1: 0,040 ns/op
# Warmup Iteration   2: 0,040 ns/op
# Warmup Iteration   3: 0,040 ns/op
# Warmup Iteration   4: 0,040 ns/op
# Warmup Iteration   5: 0,040 ns/op
Iteration   1: 0,040 ns/op
Iteration   2: 0,040 ns/op
Iteration   3: 0,040 ns/op
Iteration   4: 0,040 ns/op
Iteration   5: 0,040 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_100":
  0,040 ±(99.9%) 0,001 ns/op [Average]
  (min, avg, max) = (0,040, 0,040, 0,040), stdev = 0,001
  CI (99.9%): [0,040, 0,040] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_1000

# Run progress: 57,14% complete, ETA 00:05:00
# Fork: 1 of 1
# Warmup Iteration   1: 0,029 ns/op
# Warmup Iteration   2: 0,030 ns/op
# Warmup Iteration   3: 0,029 ns/op
# Warmup Iteration   4: 0,029 ns/op
# Warmup Iteration   5: 0,029 ns/op
Iteration   1: 0,030 ns/op
Iteration   2: 0,029 ns/op
Iteration   3: 0,029 ns/op
Iteration   4: 0,029 ns/op
Iteration   5: 0,029 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_1000":
  0,029 ±(99.9%) 0,001 ns/op [Average]
  (min, avg, max) = (0,029, 0,029, 0,030), stdev = 0,001
  CI (99.9%): [0,028, 0,030] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_10000

# Run progress: 71,43% complete, ETA 00:03:20
# Fork: 1 of 1
# Warmup Iteration   1: 0,040 ns/op
# Warmup Iteration   2: 0,040 ns/op
# Warmup Iteration   3: 0,041 ns/op
# Warmup Iteration   4: 0,041 ns/op
# Warmup Iteration   5: 0,040 ns/op
Iteration   1: 0,041 ns/op
Iteration   2: 0,040 ns/op
Iteration   3: 0,042 ns/op
Iteration   4: 0,041 ns/op
Iteration   5: 0,040 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_10000":
  0,041 ±(99.9%) 0,002 ns/op [Average]
  (min, avg, max) = (0,040, 0,041, 0,042), stdev = 0,001
  CI (99.9%): [0,039, 0,043] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_100000

# Run progress: 85,71% complete, ETA 00:01:40
# Fork: 1 of 1
# Warmup Iteration   1: 0,040 ns/op
# Warmup Iteration   2: 0,041 ns/op
# Warmup Iteration   3: 0,041 ns/op
# Warmup Iteration   4: 0,041 ns/op
# Warmup Iteration   5: 0,041 ns/op
Iteration   1: 0,041 ns/op
Iteration   2: 0,041 ns/op
Iteration   3: 0,041 ns/op
Iteration   4: 0,041 ns/op
Iteration   5: 0,041 ns/op


Result "org.openjdk.jmh.samples.JMHSample_11_Loops.measureWrong_100000":
  0,041 ±(99.9%) 0,001 ns/op [Average]
  (min, avg, max) = (0,041, 0,041, 0,041), stdev = 0,001
  CI (99.9%): [0,040, 0,042] (assumes normal distribution)


# Run complete. Total time: 00:11:41

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                               Mode  Cnt  Score    Error  Units
JMHSample_11_Loops.measureRight         avgt    5  0,549 ±  0,033  ns/op
JMHSample_11_Loops.measureWrong_1       avgt    5  0,542 ±  0,001  ns/op
JMHSample_11_Loops.measureWrong_10      avgt    5  0,057 ±  0,001  ns/op
JMHSample_11_Loops.measureWrong_100     avgt    5  0,040 ±  0,001  ns/op
JMHSample_11_Loops.measureWrong_1000    avgt    5  0,029 ±  0,001  ns/op
JMHSample_11_Loops.measureWrong_10000   avgt    5  0,041 ±  0,002  ns/op
JMHSample_11_Loops.measureWrong_100000  avgt    5  0,041 ±  0,001  ns/op
pavel@mac jmh-samples % 
```
2) Результат запуска теста [JMHSample_21_ConsumeCPU](https://hg.openjdk.org/code-tools/jmh/file/2be2df7dbaf8/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_21_ConsumeCPU.java)
```log
pavel@mac jmh-samples % java -jar target/benchmarks.jar JMHSample_21 -f 1
# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0000

# Run progress: 0,00% complete, ETA 00:20:00
# Fork: 1 of 1
# Warmup Iteration   1: 2,852 ns/op
# Warmup Iteration   2: 2,025 ns/op
# Warmup Iteration   3: 2,053 ns/op
# Warmup Iteration   4: 2,050 ns/op
# Warmup Iteration   5: 2,025 ns/op
Iteration   1: 2,056 ns/op
Iteration   2: 2,053 ns/op
Iteration   3: 2,053 ns/op
Iteration   4: 2,055 ns/op
Iteration   5: 2,051 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0000":
  2,054 ±(99.9%) 0,008 ns/op [Average]
  (min, avg, max) = (2,051, 2,054, 2,056), stdev = 0,002
  CI (99.9%): [2,045, 2,062] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0001

# Run progress: 8,33% complete, ETA 00:18:22
# Fork: 1 of 1
# Warmup Iteration   1: 2,690 ns/op
# Warmup Iteration   2: 2,603 ns/op
# Warmup Iteration   3: 2,409 ns/op
# Warmup Iteration   4: 2,504 ns/op
# Warmup Iteration   5: 2,432 ns/op
Iteration   1: 2,416 ns/op
Iteration   2: 2,418 ns/op
Iteration   3: 2,417 ns/op
Iteration   4: 2,413 ns/op
Iteration   5: 2,415 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0001":
  2,416 ±(99.9%) 0,007 ns/op [Average]
  (min, avg, max) = (2,413, 2,416, 2,418), stdev = 0,002
  CI (99.9%): [2,408, 2,423] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0002

# Run progress: 16,67% complete, ETA 00:16:42
# Fork: 1 of 1
# Warmup Iteration   1: 3,316 ns/op
# Warmup Iteration   2: 3,312 ns/op
# Warmup Iteration   3: 3,103 ns/op
# Warmup Iteration   4: 3,108 ns/op
# Warmup Iteration   5: 3,104 ns/op
Iteration   1: 3,106 ns/op
Iteration   2: 3,105 ns/op
Iteration   3: 3,104 ns/op
Iteration   4: 3,104 ns/op
Iteration   5: 3,116 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0002":
  3,107 ±(99.9%) 0,020 ns/op [Average]
  (min, avg, max) = (3,104, 3,107, 3,116), stdev = 0,005
  CI (99.9%): [3,087, 3,127] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0004

# Run progress: 25,00% complete, ETA 00:15:02
# Fork: 1 of 1
# Warmup Iteration   1: 4,038 ns/op
# Warmup Iteration   2: 4,038 ns/op
# Warmup Iteration   3: 4,038 ns/op
# Warmup Iteration   4: 4,034 ns/op
# Warmup Iteration   5: 4,037 ns/op
Iteration   1: 4,039 ns/op
Iteration   2: 4,050 ns/op
Iteration   3: 4,055 ns/op
Iteration   4: 4,039 ns/op
Iteration   5: 4,035 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0004":
  4,043 ±(99.9%) 0,033 ns/op [Average]
  (min, avg, max) = (4,035, 4,043, 4,055), stdev = 0,008
  CI (99.9%): [4,011, 4,076] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0008

# Run progress: 33,33% complete, ETA 00:13:21
# Fork: 1 of 1
# Warmup Iteration   1: 5,880 ns/op
# Warmup Iteration   2: 5,888 ns/op
# Warmup Iteration   3: 5,884 ns/op
# Warmup Iteration   4: 5,881 ns/op
# Warmup Iteration   5: 5,882 ns/op
Iteration   1: 5,876 ns/op
Iteration   2: 5,881 ns/op
Iteration   3: 5,885 ns/op
Iteration   4: 5,888 ns/op
Iteration   5: 6,309 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0008":
  5,968 ±(99.9%) 0,735 ns/op [Average]
  (min, avg, max) = (5,876, 5,968, 6,309), stdev = 0,191
  CI (99.9%): [5,233, 6,703] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0016

# Run progress: 41,67% complete, ETA 00:11:41
# Fork: 1 of 1
# Warmup Iteration   1: 11,767 ns/op
# Warmup Iteration   2: 11,633 ns/op
# Warmup Iteration   3: 11,655 ns/op
# Warmup Iteration   4: 11,636 ns/op
# Warmup Iteration   5: 11,616 ns/op
Iteration   1: 11,622 ns/op
Iteration   2: 11,624 ns/op
Iteration   3: 11,614 ns/op
Iteration   4: 11,643 ns/op
Iteration   5: 11,632 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0016":
  11,627 ±(99.9%) 0,042 ns/op [Average]
  (min, avg, max) = (11,614, 11,627, 11,643), stdev = 0,011
  CI (99.9%): [11,585, 11,670] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0032

# Run progress: 50,00% complete, ETA 00:10:01
# Fork: 1 of 1
# Warmup Iteration   1: 29,652 ns/op
# Warmup Iteration   2: 29,680 ns/op
# Warmup Iteration   3: 29,715 ns/op
# Warmup Iteration   4: 29,716 ns/op
# Warmup Iteration   5: 30,618 ns/op
Iteration   1: 31,162 ns/op
Iteration   2: 29,807 ns/op
Iteration   3: 29,657 ns/op
Iteration   4: 29,692 ns/op
Iteration   5: 29,635 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0032":
  29,991 ±(99.9%) 2,534 ns/op [Average]
  (min, avg, max) = (29,635, 29,991, 31,162), stdev = 0,658
  CI (99.9%): [27,456, 32,525] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0064

# Run progress: 58,33% complete, ETA 00:08:21
# Fork: 1 of 1
# Warmup Iteration   1: 81,171 ns/op
# Warmup Iteration   2: 81,183 ns/op
# Warmup Iteration   3: 81,037 ns/op
# Warmup Iteration   4: 81,017 ns/op
# Warmup Iteration   5: 81,085 ns/op
Iteration   1: 81,032 ns/op
Iteration   2: 81,082 ns/op
Iteration   3: 81,124 ns/op
Iteration   4: 81,229 ns/op
Iteration   5: 82,149 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0064":
  81,323 ±(99.9%) 1,799 ns/op [Average]
  (min, avg, max) = (81,032, 81,323, 82,149), stdev = 0,467
  CI (99.9%): [79,524, 83,123] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0128

# Run progress: 66,67% complete, ETA 00:06:41
# Fork: 1 of 1
# Warmup Iteration   1: 201,193 ns/op
# Warmup Iteration   2: 200,846 ns/op
# Warmup Iteration   3: 200,790 ns/op
# Warmup Iteration   4: 207,116 ns/op
# Warmup Iteration   5: 200,713 ns/op
Iteration   1: 200,810 ns/op
Iteration   2: 201,653 ns/op
Iteration   3: 200,705 ns/op
Iteration   4: 201,276 ns/op
Iteration   5: 206,238 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0128":
  202,136 ±(99.9%) 8,950 ns/op [Average]
  (min, avg, max) = (200,705, 202,136, 206,238), stdev = 2,324
  CI (99.9%): [193,186, 211,086] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0256

# Run progress: 75,00% complete, ETA 00:05:00
# Fork: 1 of 1
# Warmup Iteration   1: 440,116 ns/op
# Warmup Iteration   2: 442,540 ns/op
# Warmup Iteration   3: 440,972 ns/op
# Warmup Iteration   4: 439,930 ns/op
# Warmup Iteration   5: 439,903 ns/op
Iteration   1: 440,400 ns/op
Iteration   2: 440,055 ns/op
Iteration   3: 453,821 ns/op
Iteration   4: 440,249 ns/op
Iteration   5: 439,921 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0256":
  442,889 ±(99.9%) 23,541 ns/op [Average]
  (min, avg, max) = (439,921, 442,889, 453,821), stdev = 6,114
  CI (99.9%): [419,348, 466,430] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0512

# Run progress: 83,33% complete, ETA 00:03:20
# Fork: 1 of 1
# Warmup Iteration   1: 922,263 ns/op
# Warmup Iteration   2: 919,598 ns/op
# Warmup Iteration   3: 918,563 ns/op
# Warmup Iteration   4: 921,006 ns/op
# Warmup Iteration   5: 922,485 ns/op
Iteration   1: 918,788 ns/op
Iteration   2: 918,556 ns/op
Iteration   3: 919,582 ns/op
Iteration   4: 918,660 ns/op
Iteration   5: 919,186 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_0512":
  918,954 ±(99.9%) 1,634 ns/op [Average]
  (min, avg, max) = (918,556, 918,954, 919,582), stdev = 0,424
  CI (99.9%): [917,320, 920,588] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_1024

# Run progress: 91,67% complete, ETA 00:01:40
# Fork: 1 of 1
# Warmup Iteration   1: 1880,767 ns/op
# Warmup Iteration   2: 1875,932 ns/op
# Warmup Iteration   3: 1875,451 ns/op
# Warmup Iteration   4: 1931,910 ns/op
# Warmup Iteration   5: 1875,555 ns/op
Iteration   1: 1877,269 ns/op
Iteration   2: 1894,365 ns/op
Iteration   3: 1894,660 ns/op
Iteration   4: 1875,240 ns/op
Iteration   5: 1877,678 ns/op


Result "org.openjdk.jmh.samples.JMHSample_21_ConsumeCPU.consume_1024":
  1883,842 ±(99.9%) 37,677 ns/op [Average]
  (min, avg, max) = (1875,240, 1883,842, 1894,660), stdev = 9,785
  CI (99.9%): [1846,166, 1921,519] (assumes normal distribution)


# Run complete. Total time: 00:20:03

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                             Mode  Cnt     Score    Error  Units
JMHSample_21_ConsumeCPU.consume_0000  avgt    5     2,054 ±  0,008  ns/op
JMHSample_21_ConsumeCPU.consume_0001  avgt    5     2,416 ±  0,007  ns/op
JMHSample_21_ConsumeCPU.consume_0002  avgt    5     3,107 ±  0,020  ns/op
JMHSample_21_ConsumeCPU.consume_0004  avgt    5     4,043 ±  0,033  ns/op
JMHSample_21_ConsumeCPU.consume_0008  avgt    5     5,968 ±  0,735  ns/op
JMHSample_21_ConsumeCPU.consume_0016  avgt    5    11,627 ±  0,042  ns/op
JMHSample_21_ConsumeCPU.consume_0032  avgt    5    29,991 ±  2,534  ns/op
JMHSample_21_ConsumeCPU.consume_0064  avgt    5    81,323 ±  1,799  ns/op
JMHSample_21_ConsumeCPU.consume_0128  avgt    5   202,136 ±  8,950  ns/op
JMHSample_21_ConsumeCPU.consume_0256  avgt    5   442,889 ± 23,541  ns/op
JMHSample_21_ConsumeCPU.consume_0512  avgt    5   918,954 ±  1,634  ns/op
JMHSample_21_ConsumeCPU.consume_1024  avgt    5  1883,842 ± 37,677  ns/op
```
3) Результат запуска теста [JMHSample_31_InfraParams](https://hg.openjdk.org/code-tools/jmh/file/2be2df7dbaf8/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_31_InfraParams.java)
```log
 java -jar target/benchmarks.jar JMHSample_31 -t 4 -f 5
# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 4 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: org.openjdk.jmh.samples.JMHSample_31_InfraParams.measureDefault

# Run progress: 0,00% complete, ETA 00:16:40
# Fork: 1 of 5
# Warmup Iteration   1: 144377,368 ops/s
# Warmup Iteration   2: 147307,563 ops/s
# Warmup Iteration   3: 147921,090 ops/s
# Warmup Iteration   4: 134397,295 ops/s
# Warmup Iteration   5: 134516,399 ops/s
Iteration   1: 134750,506 ops/s
Iteration   2: 135025,657 ops/s
Iteration   3: 134149,891 ops/s
Iteration   4: 135516,107 ops/s
Iteration   5: 135696,251 ops/s

# Run progress: 10,00% complete, ETA 00:15:02
# Fork: 2 of 5
# Warmup Iteration   1: 143326,417 ops/s
# Warmup Iteration   2: 144707,770 ops/s
# Warmup Iteration   3: 146279,093 ops/s
# Warmup Iteration   4: 139039,435 ops/s
# Warmup Iteration   5: 141875,332 ops/s
Iteration   1: 140611,070 ops/s
Iteration   2: 140266,326 ops/s
Iteration   3: 141520,438 ops/s
Iteration   4: 141285,117 ops/s
Iteration   5: 141065,379 ops/s

# Run progress: 20,00% complete, ETA 00:13:21
# Fork: 3 of 5
# Warmup Iteration   1: 143940,481 ops/s
# Warmup Iteration   2: 145460,372 ops/s
# Warmup Iteration   3: 146203,490 ops/s
# Warmup Iteration   4: 140421,719 ops/s
# Warmup Iteration   5: 140071,520 ops/s
Iteration   1: 141640,977 ops/s
Iteration   2: 142423,946 ops/s
Iteration   3: 142880,983 ops/s
Iteration   4: 141078,052 ops/s
Iteration   5: 141178,667 ops/s

# Run progress: 30,00% complete, ETA 00:11:41
# Fork: 4 of 5
# Warmup Iteration   1: 145630,490 ops/s
# Warmup Iteration   2: 147948,549 ops/s
# Warmup Iteration   3: 149217,166 ops/s
# Warmup Iteration   4: 137007,406 ops/s
# Warmup Iteration   5: 135654,430 ops/s
Iteration   1: 135594,053 ops/s
Iteration   2: 134830,922 ops/s
Iteration   3: 135438,552 ops/s
Iteration   4: 136426,660 ops/s
Iteration   5: 134732,708 ops/s

# Run progress: 40,00% complete, ETA 00:10:01
# Fork: 5 of 5
# Warmup Iteration   1: 143315,278 ops/s
# Warmup Iteration   2: 145554,742 ops/s
# Warmup Iteration   3: 145830,155 ops/s
# Warmup Iteration   4: 140916,074 ops/s
# Warmup Iteration   5: 141568,113 ops/s
Iteration   1: 142173,772 ops/s
Iteration   2: 140305,271 ops/s
Iteration   3: 141075,017 ops/s
Iteration   4: 140332,642 ops/s
Iteration   5: 140635,416 ops/s


Result "org.openjdk.jmh.samples.JMHSample_31_InfraParams.measureDefault":
  138825,375 ±(99.9%) 2316,712 ops/s [Average]
  (min, avg, max) = (134149,891, 138825,375, 142880,983), stdev = 3092,745
  CI (99.9%): [136508,663, 141142,088] (assumes normal distribution)


# JMH version: 1.38-SNAPSHOT
# VM version: JDK 21.0.5, OpenJDK 64-Bit Server VM, 21.0.5
# VM invoker: /opt/homebrew/Cellar/openjdk@21/21.0.5/libexec/openjdk.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 4 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: org.openjdk.jmh.samples.JMHSample_31_InfraParams.measureFollowThreads

# Run progress: 50,00% complete, ETA 00:08:21
# Fork: 1 of 5
# Warmup Iteration   1: 143174,079 ops/s
# Warmup Iteration   2: 145214,262 ops/s
# Warmup Iteration   3: 145097,797 ops/s
# Warmup Iteration   4: 140342,102 ops/s
# Warmup Iteration   5: 142365,490 ops/s
Iteration   1: 140021,895 ops/s
Iteration   2: 139336,673 ops/s
Iteration   3: 139444,761 ops/s
Iteration   4: 139851,142 ops/s
Iteration   5: 141110,695 ops/s

# Run progress: 60,00% complete, ETA 00:06:40
# Fork: 2 of 5
# Warmup Iteration   1: 143599,352 ops/s
# Warmup Iteration   2: 146636,279 ops/s
# Warmup Iteration   3: 146775,905 ops/s
# Warmup Iteration   4: 135142,804 ops/s
# Warmup Iteration   5: 137014,383 ops/s
Iteration   1: 137808,806 ops/s
Iteration   2: 134366,392 ops/s
Iteration   3: 133891,330 ops/s
Iteration   4: 133910,314 ops/s
Iteration   5: 133279,877 ops/s

# Run progress: 70,00% complete, ETA 00:05:00
# Fork: 3 of 5
# Warmup Iteration   1: 141722,860 ops/s
# Warmup Iteration   2: 142986,904 ops/s
# Warmup Iteration   3: 142068,935 ops/s
# Warmup Iteration   4: 138441,784 ops/s
# Warmup Iteration   5: 139315,202 ops/s
Iteration   1: 138479,447 ops/s
Iteration   2: 140117,679 ops/s
Iteration   3: 140668,220 ops/s
Iteration   4: 135496,776 ops/s
Iteration   5: 129062,268 ops/s

# Run progress: 80,00% complete, ETA 00:03:20
# Fork: 4 of 5
# Warmup Iteration   1: 141010,627 ops/s
# Warmup Iteration   2: 138196,428 ops/s
# Warmup Iteration   3: 144124,942 ops/s
# Warmup Iteration   4: 134639,291 ops/s
# Warmup Iteration   5: 134736,742 ops/s
Iteration   1: 134753,724 ops/s
Iteration   2: 133390,172 ops/s
Iteration   3: 134551,296 ops/s
Iteration   4: 134924,221 ops/s
Iteration   5: 135185,249 ops/s

# Run progress: 90,00% complete, ETA 00:01:40
# Fork: 5 of 5
# Warmup Iteration   1: 144164,438 ops/s
# Warmup Iteration   2: 145885,192 ops/s
# Warmup Iteration   3: 145965,853 ops/s
# Warmup Iteration   4: 141582,669 ops/s
# Warmup Iteration   5: 141251,143 ops/s
Iteration   1: 142022,285 ops/s
Iteration   2: 141932,125 ops/s
Iteration   3: 141908,545 ops/s
Iteration   4: 140671,631 ops/s
Iteration   5: 136829,113 ops/s


Result "org.openjdk.jmh.samples.JMHSample_31_InfraParams.measureFollowThreads":
  137320,585 ±(99.9%) 2617,876 ops/s [Average]
  (min, avg, max) = (129062,268, 137320,585, 142022,285), stdev = 3494,790
  CI (99.9%): [134702,709, 139938,462] (assumes normal distribution)


# Run complete. Total time: 00:16:42

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                                       Mode  Cnt       Score      Error  Units
JMHSample_31_InfraParams.measureDefault        thrpt   25  138825,375 ± 2316,712  ops/s
JMHSample_31_InfraParams.measureFollowThreads  thrpt   25  137320,585 ± 2617,876  ops/s
```