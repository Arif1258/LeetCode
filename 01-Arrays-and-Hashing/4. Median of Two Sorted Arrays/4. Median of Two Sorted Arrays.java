1class Solution{
2    public double findMedianSortedArrays(int[] nums1,int[] nums2){
3        if(nums1.length>nums2.length){
4            int[] t=nums1;
5            nums1=nums2;
6            nums2=t;
7        }
8        int m=nums1.length,n=nums2.length;
9        int l=0,r=m,half=(m+n+1)/2;
10        while(l<=r){
11            int p1=(l+r)/2;
12            int p2=half-p1;
13            int l1=p1==0?Integer.MIN_VALUE:nums1[p1-1];
14            int r1=p1==m?Integer.MAX_VALUE:nums1[p1];
15            int l2=p2==0?Integer.MIN_VALUE:nums2[p2-1];
16            int r2=p2==n?Integer.MAX_VALUE:nums2[p2];
17            if(l1<=r2&&l2<=r1){
18                if((m+n)%2==1)return Math.max(l1,l2);
19                return(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
20            }else if(l1>r2)r=p1-1;
21            else l=p1+1;
22        }
23        return 0.0;
24    }
25}