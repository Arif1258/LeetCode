1class Solution{
2    public String longestPalindrome(String s){
3        int start=0,end=0;
4        for(int i=0;i<s.length();i++){
5            int len1=expand(s,i,i);
6            int len2=expand(s,i,i+1);
7            int len=Math.max(len1,len2);
8            if(len>end-start+1){
9                start=i-(len-1)/2;
10                end=i+len/2;
11            }
12        }
13        return s.substring(start,end+1);
14    }
15
16    private int expand(String s,int l,int r){
17        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
18            l--;
19            r++;
20        }
21        return r-l-1;
22    }
23}