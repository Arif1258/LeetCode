1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter,
3                                int x1, int y1, int x2, int y2) {
4        int closestX = Math.max(x1, Math.min(xCenter, x2));
5        int closestY = Math.max(y1, Math.min(yCenter, y2));
6        int dx = closestX - xCenter;
7        int dy = closestY - yCenter;
8
9        return dx * dx + dy * dy <= radius * radius;
10    }
11}