package com.yfs.array.binarysearch;

/**
 * 题目编号:[34]
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {5, 7, 7, 8, 8, 10};
        int[] arr2=new int[]{};
        int[] r1 = findFirstAndLastPositionOfElementInSortedArray(arr1, 8);
        int[] r2 = findFirstAndLastPositionOfElementInSortedArray(arr1, 6);
        int[] r3 = findFirstAndLastPositionOfElementInSortedArray(arr2, 0);
        System.out.println();

    }

    public static int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return new int[]{-1, -1};
        }
        int index = BinarySearch.binarySearch1(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int left=index;
        int right=index;
        while (left-1>=0&&nums[left-1]==target){
            left--;
        }
        while (right<=nums.length-2&&nums[right+1]==target){
            right++;
        }
        return new int[]{left,right};
    }


}
