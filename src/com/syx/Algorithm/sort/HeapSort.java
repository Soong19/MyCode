package com.syx.Algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums=new int[]{3,557,61,2,6,8,1,3,56,6,68,32};
        System.out.println("初始数组为");
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
    }
    static void heapSort(int[] nums){
        /*
        * 为什么要从 nums.length/2-1 开始？
        * 因为nums.length/2-1是第一个非叶子节点（按照从下到上，从右向左的顺序），而且i--也是非叶子节点
        *
        * 为什么叶子节点顺序是从下到上，从右向左？
        * 因为这样可以保证操作上面的堆时，下面的已经是大顶堆了；
        * 从右向左纯属为了方便：只需要i--就行了
        * */
        for(int i= nums.length/2-1;i>=0;i--){
            buildMaxHeap(nums, i, nums.length);
        }

        // 把最大的交换到最后，并且调整因为交换造成的堆结构破坏
        for(int j= nums.length-1;j>0;j--){
            swap(nums,0,j);
            buildMaxHeap(nums,0,j);
            System.out.println(Arrays.toString(nums));
        }
    }
    /*
    * @method void buildMaxHeap: 将以i为顶点，数组长度为length的堆调整为大顶堆
    * @param int[] nums:操作数组
    * @param int i: 操作的初始下标，即堆的顶点
    * @param int length: 操作的数组的长度，也可以理解为操作数组的终止下标（因为是从0开始的）
    * */
    static void buildMaxHeap(int[] nums,int i,int length){
        int t=nums[i];
        /*
        * 为什么起始为 k=2*i+1，为什么变换为 k=k*2+1 ?
        * 因为以i为顶点的堆，2*i+1为其左节点
        * k=2*k+1即指向其左节点
        *
        * */
        for(int k=2*i+1;k<length;k=2*k+1){
            // i指向二者之中最大的，可能越界所以加条件
            if(k+1<length && nums[k]<nums[k+1]){
                k=k+1;
            }
            if(nums[k]>t){
                nums[i]=nums[k];
                // i放到k的位置上，继续向下进行调整
                i=k;
            }else{
                //因为顺序是从下往上的，所以如果上层没问题，下层一定没问题
                break;
            }
        }
        nums[i]=t;
    }

    static void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
