package org.example.other;

public class FurthestPointFromOrigin {
    public int maxDistance(String moves) {
        int l = 0, r = 0, d = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                l++;
            } else if (move == 'R') {
                r++;
            } else {
                d++;
            }
        }

        return Math.abs(l - r) + d;
    }
}
