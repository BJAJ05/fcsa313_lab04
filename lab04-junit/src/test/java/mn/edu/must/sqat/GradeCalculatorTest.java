package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

  @Test
  @DisplayName("95 оноо нь A дүн байх ёстой (ердийн тохиолдол)")
  void normalScoreA() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(95.0);
    assertEquals("A", result);
  }

  @Test
  @DisplayName("85 оноо нь B дүн байх ёстой (ердийн тохиолдол)")
  void normalScoreB() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(85.0);
    assertEquals("B", result);
  }

  @Test
  @DisplayName("75 оноо нь C дүн байх ёстой (ердийн тохиолдол)")
  void normalScoreC() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(75.0);
    assertEquals("C", result);
  }

  @Test
  @DisplayName("65 оноо нь D дүн байх ёстой (ердийн тохиолдол)")
  void normalScoreD() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(65.0);
    assertEquals("D", result);
  }

  @Test
  @DisplayName("30 оноо нь F дүн байх ёстой (ердийн тохиолдол)")
  void normalScoreF() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(30.0);
    assertEquals("F", result);
  }

  @Test
  @DisplayName("90 оноо яг A байх ёстой (хязгаарын тохиолдол)")
  void boundaryScoreExactA() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(90.0);
    assertEquals("A", result);
  }

  @Test
  @DisplayName("89.99 оноо нь B байх ёстой (хязгаарын тохиолдол)")
  void boundaryScoreJustBelowAIsB() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(89.99);
    assertEquals("B", result);
  }

  @Test
  @DisplayName("60 оноо яг D байх ёстой (хязгаарын тохиолдол)")
  void boundaryScoreExactD() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(60.0);
    assertEquals("D", result);
  }

  @Test
  @DisplayName("59.99 оноо нь F байх ёстой (хязгаарын тохиолдол)")
  void boundaryScoreJustBelowDIsF() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(59.99);
    assertEquals("F", result);
  }

  @Test
  @DisplayName("0 оноо нь F байх ёстой (хязгаарын тохиолдол)")
  void boundaryScoreZero() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(0.0);
    assertEquals("F", result);
  }

  @Test
  @DisplayName("100 оноо нь A байх ёстой (хязгаарын тохиолдол)")
  void boundaryScoreMax() {
    GradeCalculator calc = new GradeCalculator();
    String result = calc.letterGrade(100.0);
    assertEquals("A", result);
  }

  @Test
  @DisplayName("Сөрөг оноо (-1) IllegalArgumentException шидэх ёстой")
  void invalidScoreNegative() {
    GradeCalculator calc = new GradeCalculator();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          calc.letterGrade(-1.0);
        });
  }

  @Test
  @DisplayName("100-аас их оноо (100.01) IllegalArgumentException шидэх ёстой")
  void invalidScoreTooHigh() {
    GradeCalculator calc = new GradeCalculator();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          calc.letterGrade(100.01);
        });
  }

  @Test
  @DisplayName("Бүх онооны задаргаанд зөв утга өгөхөд нийлбэр зөв гарах ёстой")
  void totalScoreNormal() {
    GradeCalculator calc = new GradeCalculator();
    double total = calc.totalScore(10.0, 40.0, 10.0, 10.0, 30.0);
    assertEquals(100.0, total, 0.001);
  }

  @Test
  @DisplayName("Ирцийн оноо сөрөг байвал (-5) IllegalArgumentException шидэх ёстой")
  void totalScoreNegativeAttendance() {
    GradeCalculator calc = new GradeCalculator();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          calc.totalScore(-5.0, 40.0, 10.0, 10.0, 30.0);
        });
  }

  @Test
  @DisplayName("Лабораторийн оноо дээд хязгаараас хэтэрвэл (41) IllegalArgumentException шидэх ёстой")
  void totalScoreLabExceeded() {
    GradeCalculator calc = new GradeCalculator();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          calc.totalScore(10.0, 41.0, 10.0, 10.0, 30.0);
        });
  }

  @Test
  @DisplayName("Шалгалтын оноо дээд хязгаараас хэтэрвэл (31) IllegalArgumentException шидэх ёстой")
  void totalScoreExamExceeded() {
    GradeCalculator calc = new GradeCalculator();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          calc.totalScore(10.0, 40.0, 10.0, 10.0, 31.0);
        });
  }
}
