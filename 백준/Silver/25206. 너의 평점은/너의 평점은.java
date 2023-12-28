
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalScore = 0;
        double creditScore = 0;
        Score[] answer = new Score[20];

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            double numericGrade;
            switch (grade) {
                case "A+":
                    numericGrade = 4.5;
                    break;
                case "A0":
                    numericGrade = 4.0;
                    break;
                case "B+":
                    numericGrade = 3.5;
                    break;
                case "B0":
                    numericGrade = 3.0;
                    break;
                case "C+":
                    numericGrade = 2.5;
                    break;
                case "C0":
                    numericGrade = 2.0;
                    break;
                case "D+":
                    numericGrade = 1.5;
                    break;
                case "D0":
                    numericGrade = 1.0;
                    break;
                case "F":
                    numericGrade = 0.0;
                    break;
                default:
                    numericGrade = 10.0;
            }

            answer[i] = new Score(subject, credit, numericGrade);

            if (numericGrade != 10.0) {
                totalScore += (credit * numericGrade);
                creditScore += answer[i].Credit;
            }
        }

        System.out.println(totalScore / creditScore);
    }

    static class Score {
        String Object;
        double Credit;
        double Grade;

        public Score(String Object, double Credit, double Grade) {
            this.Object = Object;
            this.Credit = Credit;
            this.Grade = Grade;
        }
    }
}
