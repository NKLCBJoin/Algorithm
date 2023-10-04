
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(!s.equals("1")){
            String moveZero = "";
            //0제거 및 개수 측정
            for(int i = 0 ; i < s.length(); i++){
                char cur = s.charAt(i);

                if(cur == '0')
                    answer[1]++;
                else
                    moveZero += "1";
            }

            //이진수로 변환
            int len = moveZero.length();
            s = Integer.toBinaryString(len);

            answer[0]++;
        }
        return answer;
    }
}