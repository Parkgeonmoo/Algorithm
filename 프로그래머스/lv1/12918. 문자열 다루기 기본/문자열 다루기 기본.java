
class Solution {
    public boolean solution(String s) {
        boolean check = false;
        int length = s.length();

        if (length == 4 || length == 6) {
            check = s.matches("[0-9]{4}|[0-9]{6}");
        }


        return check;
    }
}






