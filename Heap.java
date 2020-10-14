package java16_1014.java;

/**
 * 堆的向下调整
 * 1.判断index对应的下标是不是叶子节点-》如果是叶子，直接return
 * 2.判断两个孩子哪个比较大
 * 3.把小的孩子的值和index位置的值进行比较
 * 4.交换小孩子的值和index的值
 * 5.把最小的孩子视为index，循环回去
 */
public class Heap {
    public static void shiftDown(int[] array,int size,int index){
        int left=2*index+1;
        if (left > size) {
            return;
        }
        int min=left;
        int right=left+1;
        if(right<size&&array[right]<array[left]){
            min=right;
        }
        if (array[min]<array[left]) {
            return;
        }
        //if (array[min]<array[index]){
            int tmp=array[min];
            array[min]=array[index];
            array[index]=tmp;

            index=min;
            right=2*index+2;
        }


    public static void createHeap(int[] array,int size){
        for (int i=(size-2)/2;i>=0;i--){
            shiftDown(array,size,i);
        }
    }
}
