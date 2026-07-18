class Solution {
public:
    int findGCD(vector<int>& A) {
        uint16_t n = A.size();
        uint16_t mod = n & 1;
        uint16_t i = 2 - mod;
        uint16_t b = max(A[0], A[1 - mod]);
        uint16_t a = min(A[0], A[1 - mod]);

        for (; i < n; i += 2) {
            uint16_t x = A[i];
            uint16_t y = A[i + 1];
            if (x > y) {
                b = max(b, x);
                a = min(a, y);
            } else {
                b = max(b, y);
                a = min(a, x);
            }
        }

        if (!a) return b;
        if (!b) return a;

        uint16_t mask = a | b;
        uint16_t shift = countr_zero(mask);
        a >>= countr_zero(a);

        while (b) {
            b >>= countr_zero(b);
            uint16_t mn = min(a, b);
            b = max(a, b) - mn;
            a = mn;
        }

        return a << shift;
    }
};