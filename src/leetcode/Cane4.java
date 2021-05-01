package leetcode;

public class Cane4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int nums1Start = 0, nums1End = nums1.length - 1, nums2Start = 0, nums2End = nums2.length - 1;
    if(nums1End < 0 && nums2End < 0) {
      return -1;
    } else if (nums1End < 0) {
      
    }
    while (true) {

    }
  }

  public static void main(String[] args) {
    Cane4 cane4 = new Cane4();
    System.out.println(cane4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    System.out.println(cane4
        .findMedianSortedArrays(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}));
    System.out.println(cane4
        .findMedianSortedArrays(new int[]{-12, -10, -6, -3, 4, 10}, new int[]{-5, 3, 6, 12, 15}));
    System.out.println(cane4
        .findMedianSortedArrays(new int[]{0, 0, 0}, new int[]{0, 0}));
    System.out.println(cane4
        .findMedianSortedArrays(new int[]{1, 2, 6}, new int[]{3, 4, 5}));
    System.out.println(cane4
        .findMedianSortedArrays(new int[]{1, 1, 3, 3}, new int[]{1, 1, 3, 3}));
    System.out.println(cane4
        .findMedianSortedArrays(new int[]{}, new int[]{}));
  }
}
