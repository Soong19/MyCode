package com.syx.Algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    //临时数组
    static int[] temp;
    public static void main(String[] args) {
        int[] nums=new int[]{33,1,5,4,54,2,8,31,6,4,76};
        temp=new int[nums.length];
        mergeSort(nums,0, nums.length-1);
    }
    static void mergeSort(int[] nums,int lo,int hi){
        // 此处必须是带等于号的，不然
        if(lo>=hi)return;
        int mid=lo+(hi-lo)/2;
        // 这里不能是mid-1，必须是mid
        mergeSort(nums,lo,mid);
        mergeSort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    static void merge(int[] nums,int lo,int mid,int hi){
        // 数组复制，for的简化用法,if条件是判断hi-lo至少为1,不然可能会出错或者没有意义
        if (hi + 1 - lo >= 0) System.arraycopy(nums, lo, temp, lo, hi + 1 - lo);

        int i=lo,j=mid+1;
        // 粘贴数组的值
        for(int p=lo;p<=hi;p++){
            //如果i到头了，直接用j的
            if(i>mid) {
                nums[p]= temp[j];
                j++;
            }else if(j>hi){//如果j到头了，直接用i的
                nums[p]=temp[i];
                i++;
            }else if(temp[i]>temp[j]){
                nums[p]=temp[j];
                j++;
            }else if(temp[i]<=temp[j]){
                nums[p]=temp[i];
                i++;
            }
        }
    }
}
