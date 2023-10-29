class Solution {
    public int solution(int[] arr) {
        int cur = arr[0];

        for(int i = 1 ;i < arr.length; i++){
            //최대공약수 구하고
            int lcm = getLCM(cur, arr[i]);
            System.out.println(lcm);
            //최대공배수 구하자
            cur = cur * arr[i] / lcm;
            System.out.println(cur);
        }
        return cur;
    }

    public int getLCM(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        //큰 수에서 작은 수 나누기
        if(a%b == 0)
            return b;

        return getLCM(b, a%b);
    }
}