Домашнее задание
Оптимизация SerialGC

Цель:
Данная работа позволит закрепить изученный материал по работе с параметрами GC и с инструментами мониторинга работы GC


Описание/Пошаговая инструкция выполнения домашнего задания:
Скачать visualVm ( https://visualvm.github.io/)
Запустить visualVm
Установить плагин Visual GC для visualVm
Создать проект Practice (или скачать с репозитория https://github.com/OtusTeam/Java-Advanced.git java-memory/gc_serial_parallel_cms )

```java
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) throws InterruptedException {

        Map<String, String> stringContainer = new HashMap<>();

        System.out.println("Start of program!");


        String stringWithPrefix = "stringWithPrefix";
        
        final long startTime = System.currentTimeMillis();


        while (System.currentTimeMillis() - startTime <= 30_000) {

            for (int i = 0; i < 200_000; i++) {

                String newString = stringWithPrefix + i;

                stringContainer.put(newString, newString);

            }

            for (int i = 0; i < 200_000; i++) {

                String newString = stringWithPrefix + i;

                stringContainer.remove(newString);

            }

            Thread.sleep(100);

        }

    }

}
```


Установить параметры запуска приложения -XX:+UseSerialGC -Xms128m -Xmx128m -Xlog:gc*::time
Запустить приложение
В логах найти хотя бы одно Pause Full
Настроить -XX:SurvivorRatio=? или/и -XX:NewRatio=? Так что бы приложение не запускало полную сборку до конца своего выполнения

Решение

Анализируя код Practice, можно понять, что происходит сначала создание объектов, а потом их удаление, для того
что бы не допустить полной сборки мусора, необходимо настроить область young памяти таким образом, что бы gc не передвигал объекты
в old область. Те если выделить 64 мб для young и поделить ее между Eden, S0, S1 поровну (21мб), то объекты
будут удаляться раньше, чем gc переместит их в old область.
Те нужно выделить память в young область таким образом, что бы удаление происходило раньше, чем перемещение в old область.

NewRatio - отношение областей памяти (old/young)
при -Xmx128m и NewRatio=1, соотношение будет 1к1: old = 64мб, young = 64мб
SurvivorRatio - отношение памяти между Eden и (S0/S1)
например при размере общей памяти в young = 64мб (-Xmx128m -XX:NewRatio=1) и SurvivorRatio=1, память в young
выделится следующим образом:
Eden =+-21мб
S0 = +-21мб
S1 = +-21мб

таким образом, параметры запуска будут следующими:
-XX:SurvivorRatio=1 -XX:NewRatio=1

сборка
```bash
./gradlew clean jar
```
Запуск
```bash
java -XX:+UseSerialGC -Xms128m -Xmx128m -XX:SurvivorRatio=1 -XX:NewRatio=1 '-Xlog:gc*::time' -Xloggc:serialgc -jar build/libs/2-hw-serialgc-0.0.1.jar  
```