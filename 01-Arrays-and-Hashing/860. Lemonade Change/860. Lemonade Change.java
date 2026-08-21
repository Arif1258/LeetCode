1class Solution {
2    public boolean lemonadeChange(int[] bills) {
3        int five =0;
4        int ten = 0;
5
6        for(int i=0; i<bills.length;i++){
7            if(bills[i] == 5){
8                five++;
9            }
10            else if(bills[i] == 10){
11                if(five >= 1){
12                    five--;
13                    ten++;
14                }else{
15                    return false;
16                }
17            }
18            else if(bills[i] == 20){
19                
20                if(ten >=1 && five >=1){
21                    ten--;
22                    five--;
23                }else if(five >=3){
24                    five -=3;
25                }else return false;
26            }
27        }
28        return true;
29    }
30}