1
2class Solution {
3    public int countDaysTogether(String arriveAlice, String leaveAlice,
4                                 String arriveBob, String leaveBob) {
5        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
6
7        int aliceStart = getDay(arriveAlice, days);
8        int aliceEnd = getDay(leaveAlice, days);
9        int bobStart = getDay(arriveBob, days);
10        int bobEnd = getDay(leaveBob, days);
11
12        int start = Math.max(aliceStart, bobStart);
13        int end = Math.min(aliceEnd, bobEnd);
14
15        return Math.max(0, end - start + 1);
16    }
17
18    private int getDay(String date, int[] days) {
19        int month = Integer.parseInt(date.substring(0, 2));
20        int day = Integer.parseInt(date.substring(3, 5));
21
22        for (int i = 0; i < month - 1; i++) {
23            day += days[i];
24        }
25
26        return day;
27    }
28}
29