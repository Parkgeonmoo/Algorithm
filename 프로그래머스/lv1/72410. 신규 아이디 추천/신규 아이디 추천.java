class Solution {
    public String solution(String new_id) {
        // 1. 대문자를 소문자로 변경
        new_id = new_id.toLowerCase();

        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 이외의 모든 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. 연속된 마침표(.)를 하나의 마침표로 치환
        new_id = new_id.replaceAll("[.]+", ".");

        // 4. 문자열의 처음이나 끝에 위치한 마침표(.) 제거
        new_id = new_id.replaceAll("^[.]|[.]+$", "");

        // 5. 빈 문자열인 경우 "a"로 대체
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6. 길이가 16자 이상이면 첫 15개의 문자를 남기고 나머지 제거, 마지막에 위치한 마침표(.) 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        // 7. 길이가 2자 이하면 마지막 문자를 3자까지 반복해서 추가
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}

