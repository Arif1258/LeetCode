1class Solution {
2    public boolean checkIfExist(int[] arr) {
3        HashSet<Integer> set = new HashSet<>();
4        for (int num : arr) {
5            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2))){
6                return true;
7            }
8            set.add(num);
9        }
10
11        return false;
12    }
13}