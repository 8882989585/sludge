package leetcode;

import java.util.Arrays;

public class Cane1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int max1 = horizontalCuts[0];
        for(int i=1;i<horizontalCuts.length;i++) {
            int t = horizontalCuts[i] -  horizontalCuts[i-1];
            if(t > max1) {
                max1 = t;
            }
        }
        int t = h - horizontalCuts[horizontalCuts.length-1];
        if(t > max1) {
            max1 = t;
        }
        int max2 = verticalCuts[0];
        for(int i=1;i<verticalCuts.length;i++) {
            t = verticalCuts[i] -  verticalCuts[i-1];
            if(t > max2) {
                max2 = t;
            }
        }
        t = w - verticalCuts[verticalCuts.length-1];
        if(t > max2) {
            max2 = t;
        }
        return (int)(((long) max1 * max2) % 1000000007L);
    }
}
