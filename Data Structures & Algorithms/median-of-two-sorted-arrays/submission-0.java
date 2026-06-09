class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] mergedArray = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] <= nums2[j]) {
                mergedArray[k] = nums1[i];
                i++;
                k++;
            } else {
                mergedArray[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i < n1) {
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n2) {
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        if(k % 2 == 0) {
            double left = mergedArray[(k - 2) / 2];
            double right = mergedArray[k / 2];
            return (double) ((left + right) / 2);
        } else {
            return (double) mergedArray[(k-1) / 2];
        }
    }
}
