package java_1015.java;



import java.util.Arrays;

public class SevenSort {

    //稳定性：两个相同的数经过排序后，相对位置不变，则排序比较稳定
    //1.插入排序:时间复杂度O(n^2),空间复杂度O(1)
    public static void insertSort(int[] array){
        //[0,bound]表示已排序区间
        //[bound,size]表示待排序区间
        for (int bound=1;bound<array.length;bound++) {
            int v = array[bound];
            int cur = bound - 1;//cur表示已排序区间的最后一个元素的下标
            for (; cur >= 0; cur--) {//从后往前遍历
                if (array[cur] > v) {//如果待排序元素大于当前元素，则互相交换
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur+1]=v;
        }
    }


//2.希尔排序:时间复杂的O（n^1.3)，空间复杂度O(1),不稳定
    public static void shellSort(int[] array){
        //把整个数组分成gap组,常见gap取值：size，size/2，size/4，...1
        //针对每一组进行插入排序再进行拼接
        //gap--，重复上述操作
        //当gap=1时，只剩下一组，此时对数组进行插入排序
        int gap=array.length/2;
        while (gap>1){
            insertSortGap(array,gap);
        }
        insertSortGap(array,1);

    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound=gap;bound<array.length;bound++) {
            int v = array[bound];
            int cur = bound - gap;//cur表示同组中的上一个元素
            for (; cur >= 0; cur-=gap) {//找同组中的相邻元素
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur+gap]=v;
        }
    }

    //3.选择排序：时间复杂度O(n^2)，空间复杂度O(1),不稳定
    public static void selectSort(int[] array){
        //打擂台思想，以bound位置作为擂主，从其他位置循环挑战
        //如果挑战赢了bound,两者互相交换
        for (int bound=0;bound<array.length;bound++){
            for (int cur=bound+1;cur<array.length;cur++){
                if (array[cur]<array[bound]){
                    int t=array[cur];
                    array[cur]=array[bound];
                    array[bound]=t;
                }
            }
        }
    }


    private static void swap(int[] array, int i, int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    //4.堆排序：时间复杂度O(N*logN),空间复杂度O(1)，不稳定
    public static void heapSort(int[] array){
        createHeap(array);
        for (int i=0;i<array.length-1;i++){
            swap(array,0,array.length-1-i);//把堆顶元素放到最后一个位置
            //已排序区间：[array.length-i-1,size]
            //未排序区间：[0,array.length-1-i]
            shiftDown(array,array.length-1-i,0);
        }
    }

    public static void shiftDown(int[] array,int heapLength,int index){
        int parent=index;//把待调整的节点赋值给父节点
        int child=2*parent+1;//左孩子下标=父节点下标*2+1
        while (child<heapLength){
            //如果右孩子小于堆长度，并且右孩子值大于左孩子的值
            if (child+1<heapLength&&array[child+1]>array[child]){
                child=child+1;
            }
            //如果左孩子值大于父节点的值，就互相交换
            if (array[child]>array[parent]){
                swap(array,child,parent);
            }else{
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }

    private static void createHeap(int[] array) {
        for (int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }

    //5.冒泡排序：时间复杂度O(N^2)，空间复杂度O(1),稳定排序
    public static void bubbleSort(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j=array.length-1;j>i;j--){
                if (array[j-1]<array[j]){
                    int t=array[j-1];
                    array[j-1]=array[j];
                    array[j]=t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array={2,9,6,3,10,7,1};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
