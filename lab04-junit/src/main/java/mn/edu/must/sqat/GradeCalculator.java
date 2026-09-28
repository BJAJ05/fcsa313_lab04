package mn.edu.must.sqat;

public class GradeCalculator {
  public String letterGrade(double score) {
    if (score > 100 || score < 0) {
      throw new IllegalArgumentException("Оноо 0-с 100 хооронд биш байна.");
    }
    if (score >= 90) {
      return "A";
    } else if (score >= 80) {
      return "B";
    } else if (score >= 70) {
      return "C";
    } else if (score >= 60) {
      return "D";
    } else {
      return "F";
    }
  }

  public double totalScore(double att, double lab, double quiz1, double quiz2, double exam) {
    if (att < 0
        || att > 10
        || lab < 0
        || lab > 40
        || quiz1 < 0
        || quiz1 > 10
        || quiz2 < 0
        || quiz2 > 10
        || exam < 0
        || exam > 30) {
      throw new IllegalArgumentException("Аль нэг оноо сөрөг эсвэл хязгаараас хэтэрсэн байна.");
    }
    return att + lab + quiz1 + quiz2 + exam;
  }
}
