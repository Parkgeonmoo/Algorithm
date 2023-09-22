class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String line = quiz[i];
            String[] temp = line.split(" ");
            int firstNumber = Integer.parseInt(temp[0]);
            String firstOperation = temp[1];
            int secondNumber = Integer.parseInt(temp[2]);
            int resultNumber = Integer.parseInt(temp[4]);

            if (firstOperation.equals("-")) {
                int tempNumber = firstNumber - secondNumber;
                if (tempNumber == resultNumber){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }
            else {
                int tempNumber = firstNumber + secondNumber;
                if (tempNumber == resultNumber) {
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }


        }



    return answer;
    }
}