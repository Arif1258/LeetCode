1class Solution {
2    public int numberOfSubstrings(String s) {
3        int n = s.length();
4        int left = 0; int count = 0;
5        int freq [] = new int [3];
6
7        for(int right =0; right<n; right++){
8            freq[s.charAt(right) - 'a']++;
9
10            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
11                count += n-right;
12                freq[s.charAt(left) - 'a']--;
13                left++;
14            }
15        }
16        return count;
17    }
18}