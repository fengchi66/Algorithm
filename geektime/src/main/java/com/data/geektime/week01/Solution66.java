package com.data.geektime.week01;

// 66. 加一
public class Solution66 {

  // 过滤器思想: 从数组尾部向头部遍历，判断nums[i] + 1后是否等于10，如果不等于，则直接返回
  public int[] plusOne(int[] digits) {
    int length = digits.length;

    for (int i = length - 1; i >= 0; i--) {
      // and one
      digits[i] = (digits[i] + 1) % 10;
      // filter
      if (digits[i] != 0) { // 加1后不等于10
        return digits;
      }
    }

    // 如果整个数组遍历后都没有return，说明digits的所有元素均为9
    int[] ans = new int[length + 1];
    ans[0] = 1;
    return ans;
  }

}