
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();               
        for(int i=0; i<ingredient.length; i++) {
            sb.append(ingredient[i]);                      
            if(sb.length()>3) {                             
                if(sb.charAt(sb.length()-1) == '1' &&       
                        sb.charAt(sb.length()-2) == '3' &&      
                        sb.charAt(sb.length()-3) == '2' &&      
                        sb.charAt(sb.length()-4) == '1') {       
                    answer++;                               
                    sb = new StringBuilder(sb.substring(0, sb.length()-4)); 
                }
            }
        }
        return answer;
    }
}






