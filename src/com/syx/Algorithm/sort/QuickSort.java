package com.syx.Algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums=new int[]{5,2,3,1};
//        shuffle(nums);
        quickSort(nums,0,nums.length-1);
    }

    static void quickSort(int[] nums,int lo,int hi){
        if(lo>hi)return;
        System.out.println(Arrays.toString(nums));
        int p=partition(nums,lo, hi);
        quickSort(nums,lo,p-1);
        quickSort(nums,p+1,hi);
    }
    static int partition(int[] nums,int lo,int hi){
        int pivot=nums[lo];
        int i=hi,j=hi;
        for(;i>lo;i--){
            if(nums[i]>pivot){
                swap(nums,i,j);
                j--;
            }
        }
        swap(nums,lo,j);
        return j;
    }

    static void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    static void shuffle(int[] nums){
        Random r=new Random();
        for(int i=0;i<nums.length;i++){
            int t=r.nextInt(nums.length-i)+i;
            swap(nums,i,t);
        }
    }

}

