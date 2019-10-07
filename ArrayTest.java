package com.kuangkung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    // 寻找数组的中心索引
    public static int pivotIndex(int[] nums) {
        int result = -1;
        for(int i = 0; i < nums.length; i++) {
            // 使用两次循环分别计算 index 左右两侧的和
            int leftSum = 0;
            int rightSum = 0;
            for(int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for(int k = i + 1; k < nums.length; k++) {
                rightSum += nums[k];
            }
            if(leftSum == rightSum) {
                result = i;
                // 此处若不加break，那么返回的索引就是最靠近右边的那一个
                break;
            }
        }
        return result;
    }

    // 至少是其他数字两倍的最大数
    public static int dominantIndex(int[] nums) {
        int result = -1;
        for(int i = 0; i < nums.length; i++) {
            // 记次，若超过两倍的次数等于（length-1），则返回该索引值index，否则返回-1
            int count = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] >= 2 * nums[j]) {
                    count++;
                }
            }
            for(int k = i + 1; k < nums.length; k++) {
                if(nums[i] >= 2 * nums[k]) {
                    count++;
                }
            }
            if(count == nums.length - 1) {
                result = i;
            }
        }
        return result;
    }

    // 加一
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 对角线遍历
     *
     * ----分析思路----
     * 1. 索引和为偶数
     *    a. 元素在第一行，往右走
     *    b. 元素在最后一列，往下走
     *    c. 其他情况，往右上走
     * 2. 索引和为奇数
     *    a. 元素在第一列，往下走
     *    b. 元素在最后一行，往右走
     *    c. 其他情况，往左下走
     *
     * @param matrix
     * @return result
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        // 获取待处理矩阵的行数和列数分别赋值给 row 和 col
        int row = matrix.length, col = matrix[0].length;
        // 定义数组 result 用以存放遍历结果
        int[] result = new int[row * col];
        // 设置遍历起始点，这里设为待处理矩阵的第一个元素：matrix[0][0]
        int r = 0, c = 0;
        for(int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];
            if((r + c) % 2 == 0) { // 索引和（r + c）为偶数
                if(c == col - 1) { // 元素在最后一列，往下走
                    r++;
                } else if(r == 0) { // 元素在第一行，往右走
                    c++;
                } else { // 其他情况，往右上方走
                    r--;
                    c++;
                }
            } else {
                if(r == row - 1) { // 元素在最后一行，往右走
                    c++;
                } else if(c == 0) { // 元素在第一列，往下走
                    r++;
                } else { // 其他情况，往左下走
                    r++;
                    c--;
                }
            }
        }
        return result;
    }

    /**
     * 螺旋式遍历矩阵
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        return result;
    }
    
    public static void main(String[] args){
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] b = findDiagonalOrder(a);
        System.out.println(Arrays.toString(b));
    } 
    
}
