1class Solution {
2    public int maxProduct(int n) {
3        int largest = 0;
4        int secondLargest = 0;
5        while(n > 0){
6            int r = n%10;
7            if(r > largest){
8                secondLargest = largest;
9                largest = r;
10            }else if(r > secondLargest){
11                secondLargest = r;
12            }
13            n=n/10;
14        }
15        return secondLargest * largest;
16    }
17}