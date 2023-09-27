

class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        StringBuilder sb = new StringBuilder();
        String Pattern = "[0-9]";

        String temp = phone_number.substring(0,length-4);
        sb.append(temp.replaceAll(Pattern, "*"));
        sb.append(phone_number.substring(length-4,length));


        return sb.toString();
    }
}





