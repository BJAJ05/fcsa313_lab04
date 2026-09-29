# Лаб 04 - B232270068 А.Баяржавхлан

## Туршилтын орчин

Java хувилбар:
```
openjdk version "21.0.12.1" 2026-08-18
OpenJDK Runtime Environment (build 21.0.12.1+1-1-24.04.4-Ubuntu)
OpenJDK 64-Bit Server VM (build 21.0.12.1+1-1-24.04.4-Ubuntu, mixed mode, sharing)
```

Maven хувилбар:
```
Apache Maven 3.8.7
Maven home: /usr/share/maven
Java version: 21.0.12.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-21-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.8.0-142-generic", arch: "amd64", family: "unix"
```

## Тестүүд

Тестийн 20 метод бичсэн.

- `normalScoreA`, `normalScoreB`, `normalScoreC`, `normalScoreD`, `normalScoreF` тестүүд нь ердийн тохиолдолд  зөв ажиллаж байгааг тестлэнэ.
- `boundaryScoreExactA`, `boundaryScoreExactD` тестүүд нь A болон D дүнгийн онооны доод хязгаарын тохиолдолд, `boundaryScoreJustBelowAIsB`, `boundaryScoreJustBelowDIsF` тестүүд нь онооны дээд хязгаараас үл ялиг бага утгуудад `letterGrade()` зөв ажиллаж байгааг тестлэнэ.
- `boundaryScoreZero`, `boundaryScoreMax` тестүүд нь хамгийн доод болон дээд тохиолдолд `letterGrade()` зөв ажиллаж байгааг тестлэнэ.
- `invalidScoreNegative`, `invalidScoreTooHigh` тестүүд нь хязгаараас гаднах тохиолдолд `letterGrade()` метод exception шидэж байгааг шалгана.
- `totalScoreNormal` тест нь `totalScore()` методод зөв оролт өгөхөд зөв ажиллаж байгааг шалгана.
- `totalScoreNegativeAttendance`, `totalScoreLabExceeded`, `totalScoreExamExceeded` тестүүд нь `totalScore()` методод буруу оролт өгөхөд exception шидэж байгааг шалгана.
- `letterGradeBoundaries` parameterized тест нь `letterGrade()` методын хязгаарын тохиолдол бүрийг тестлэнэ.
- `totalScoreParameterizedValid` parameterized тест нь `totalScore()` метод зөв оролттой үед зөв ажиллаж байгааг тестлэнэ.
- `totalScoreParameterizedInvalid` parameterized тест нь `totalScore()` метод буруу оролт өгөхөд exception шидэж байгааг тестлэнэ.

Parameterized тестийн CsvSource-ийн мөрийн тоо нэмэгдэж, нийт 41 тест ажилласан. [lab04-junit/results/mvn-test.txt](lab04-junit/results/mvn-test.txt)

Тестийн үр дүнг `mvn test 2>&1 | ansi2txt | tee results/mvn-test.txt` коммандаар хадгалсан. `ansi2txt`-ийг ANSI формат хадгалагдаж байсныг болиулж, зөвхөн plain text хадгалахад ашигласан.

## Санаатай унагаах (мутаци) туршилт
`letterGrade()` методын `if (score >= 90)` нөхцөлийг зориудаар `if (score > 90)` болгон мутаци хийж туршсан.

Үр дүнг `mvn test 2>&1 | ansi2txt | tee results/mvn-test-mutant.txt` коммандаар хадгалж авсан. [lab04-junit/results/mvn-test-mutant.txt](lab04-junit/results/mvn-test-mutant.txt)

41 тестээс 2 тест унасан:
- `GradeCalculatorTest.boundaryScoreExactA`
- `GradeCalculatorTest.letterGradeBoundaries`

Хоёулаа `expected: <A> but was: <B>` алдааны мессеж харуулсан.

Дээрх тестүүд нь 90 оноог A байх ёстой гэж шалгаж байсан бөгөөд мутаци хийсний дараа 90 оноо B болсон учир унасан. Үүний үр дүнд `Failures: 2` болон `BUILD FAILURE` гарсан.

Кодыг засаад `mvn test` ажиллуулахад бүх тест амжилттай давсан.

![proof that tests are successful after mutant test change was reverted](<lab04-junit/results/mutant then normal.png>)

## Дүгнэлт

Энэ лабораторийн ажлаар JUnit 5 ашиглан `GradeCalculator` класст зориулсан нэгжийн тест бичиж, туршсан. Ердийн утгуудаас гадна хязгаарын утга болох 90, 89.99, 100, 0 утгуудад `letterGrade()` метод зөв ажиллаж байгаа эсэхийг шалгаж, буруу оролтын үед `IllegalArgumentException` шидэж байгааг `assertThrows` ашиглан шалгасан. Ижил логиктой тестийн тохиолдлуудыг `@ParameterizedTest` ашиглан бичиж үзсэн.

Мутаци туршилтаар `letterGrade()` доторх нэг нөхцөлийг буруу болгон өөрчлөхөд ямар ямар тест унаж байгааг харж, алдааны мессежийг уншсан. Хоёр тест унасан бөгөөд хоёул `expected: <A> but was: <B>` алдааны мессеж харуулж байсан нь сонирхолтой байсан. Мутацийг буцаахад тестийн үр дүн эргээд амжилттай болсон.