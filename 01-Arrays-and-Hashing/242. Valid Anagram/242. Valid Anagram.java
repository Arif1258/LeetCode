1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if(s.length() != t.length()) return false;
4        int frequency [] = new int[26];
5        for(int i=0;i<s.length();i++){
6            frequency[s.charAt(i) - 'a']++;
7            frequency[t.charAt(i) - 'a']--;
8        }
9        for(int x : frequency) {
10            if(x != 0) return false;
11        }
12        return true;
13    }
14}