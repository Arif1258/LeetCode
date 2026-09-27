1class Solution {
2    public List<Integer> getRow(int rowIndex) {
3        List<Integer> row = new ArrayList<>();
4
5        row.add(1);
6        for (int i = 1; i <= rowIndex; i++) {
7            row.add(1);
8
9            for (int j = i - 1; j > 0; j--) {
10                row.set(j, row.get(j) + row.get(j - 1));
11            }
12        }
13
14        return row;
15    }
16}