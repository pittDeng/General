package com.dsh;
//进行堆排序
//ref:https://www.cnblogs.com/jetpie/p/3971382.html
public class HeapSort<T extends Comparable> {
     private int heapSize;
     private T [] A;
     public HeapSort(T [] A){
         heapSize=A.length;
         this.A=A;
     }
     private int left(int i){
         return i*2+1;
     }
     private int right(int i){
         return i*2+2;
     }
     private int parent(int i){
         return (i-1)/2;
     }
     private void exchange(int i,int j){
         T temp=A[i];
         A[i]=A[j];
         A[j]=temp;
     }
     //将节点i以下进行最大化堆
     private void maxify(int i){
         int l=left(i);
         int r=right(i);
         int largest=i;
         if(l<heapSize&&A[i].compareTo(A[l])<0){
             largest=l;
         }
         if(r<heapSize&&A[largest].compareTo(A[r])<0){
             largest=r;
         }
         if(largest!=i){
             exchange(largest,i);
             maxify(largest);
         }
     }
     private void buildMaxHeap(){
         for(int i=parent(A.length-1);i>=0;--i){
             maxify(i);
         }
     }
     private void heapSortUnStatic(){
         buildMaxHeap();
         for(int i=A.length-1;i>0;--i){
             exchange(i,0);
             --heapSize;
             maxify(0);
         }
     }
    public static void main(String [] args){
         Integer [] arr={3,2,5,4,2,1,100,20,30,45,4};
         new HeapSort<Integer>(arr).heapSortUnStatic();
         for(int i=0;i<arr.length;++i){
             System.out.print(arr[i]+" ");
         }
    }
}
