package com.syx.Algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    static int[] temp;
    public static void main(String[] args) {
        int[] nums=new int[]{33,4,5,4,54,2,8,31,5,4,76};
        temp=new int[nums.length];
        mergeSort(nums,0, nums.length-1);
    }
    static void mergeSort(int[] nums,int lo,int hi){
        if(lo>hi)return;
        System.out.println(Arrays.toString(nums));
        int mid=lo+(hi-lo)/2;
        mergeSort(nums,lo,mid-1);
        mergeSort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    static void merge(int[] nums,int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++)temp[i]=nums[i];
        int i=lo,j=mid+1;
        for(int p=lo;p<=hi;p++){
            if(i>mid) {
                nums[p]= temp[j];
                j++;
            }else if(j>hi){
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
