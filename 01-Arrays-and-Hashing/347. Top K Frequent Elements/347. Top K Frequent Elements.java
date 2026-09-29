1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        
5        for(int num : nums){
6            map.put(num, map.getOrDefault(num,0) + 1);
7        }
8        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
9
10        for(int num : map.keySet()){
11            pq.add(num);
12            if(pq.size() > k) pq.poll();
13        }
14        int ans [] = new int [k];
15        for(int i=0; i<k; i++){
16            ans[i] = pq.poll();
17        }
18        return ans;
19    }
20}