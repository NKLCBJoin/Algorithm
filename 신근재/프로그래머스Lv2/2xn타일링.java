class Solution {
    static int[] tile = new int[60001];
    public int solution(int n) {
        int answer = 0;
        tile[1] = 1;
        tile[2] = 2;
        tiling(n);
        return tile[n];
    }

    public static int tiling(int n){
        if(tile[n] != 0)
            return tile[n];

        return tile[n] = (tiling(n-1) + tiling(n-2)) % 1000000007;
    }
}