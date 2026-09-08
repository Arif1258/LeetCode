1class Solution{
2    public String intToRoman(int num){
3        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
4        String[] symbols={M,CM,D,CD,C,XC,L,XL,X,IX,V,IV,I};
5        StringBuilder sb=new StringBuilder();
6        for(int i=0;i<values.length;i++){
7            while(num>=values[i]){
8                num-=values[i];
9                sb.append(symbols[i]);
10            }
11        }
12        return sb.toString();
13    }
14}
15