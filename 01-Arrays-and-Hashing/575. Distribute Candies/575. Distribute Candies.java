1class Solution {
2    public int distributeCandies(int[] candyType) {
3        HashSet<Integer> set = new HashSet<>();
4        for(int n: candyType){
5            set.add(n);
6        }
7        return set.size() > candyType.length/2 ? candyType.length/2 : set.size();
8    }
9}