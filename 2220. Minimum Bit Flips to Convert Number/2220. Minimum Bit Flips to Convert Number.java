1class Solution {
2    public int minBitFlips(int start, int goal) {
3        return Integer.bitCount(start ^ goal);
4    }
5}