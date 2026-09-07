1import java.util.*;
2
3class Solution {
4    public List<String> letterCombinations(String digits) {
5        List<String> result = new ArrayList<>();
6
7        if (digits.length() == 0) {
8            return result;
9        }
10
11        String[] phone = {
12            ,     // 0
13            ,     // 1
14            abc,  // 2
15            def,  // 3
16            ghi,  // 4
17            jkl,  // 5
18            mno,  // 6
19            pqrs, // 7
20            tuv,  // 8
21            wxyz  // 9
22        };
23
24        backtrack(0, digits, phone, new StringBuilder(), result);
25
26        return result;
27    }
28
29    private void backtrack(
30        int index,
31        String digits,
32        String[] phone,
33        StringBuilder current,
34        List<String> result
35    ) {
36        if (index == digits.length()) {
37            result.add(current.toString());
38            return;
39        }
40
41        String letters = phone[digits.charAt(index) - '0'];
42
43        for (char c : letters.toCharArray()) {
44
45            current.append(c);
46            backtrack(index + 1, digits, phone, current, result);
47            current.deleteCharAt(current.length() - 1);
48        }
49    }
50}