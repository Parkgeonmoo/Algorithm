class Solution {
  public int[] solution(String s) {
    int[] answer = new int[2]; //값을 담을 int 배열을 2크기로 선언
 
    while(s.length() > 1) { //문자의 길이가 1보다 클때까지만 즉 문자의 자리가 1이 되면 종료
 
      int cntOne = 0; //1자리 갯수를 센다
      for(int i=0; i<s.length(); i++) { //문자열의 길이만큼 반복
 
        if(s.charAt(i) == '0') answer[1]++; //한자리씩을 문자로 바꾸고 해당 문자가 0이면 answer[1] 배열 값을 증가
        else cntOne++;  //아닐 경우 2진법이기에 1밖에 없음,따라서 1을 세는 변수 증가
      }
 
      s = Integer.toBinaryString(cntOne); // toBinaryString이란 정수를 2진수 형태의 값을 가진 문자열로 바꿔주는 것을 뜻한다.동일한 문법으로는 Integer.toString(cntOne,2); 가 있다.
      answer[0]++; //한 번 변환되었으니 변환값인 answer[0]째의 값을 증가
    }
 
    return answer;
  }
}