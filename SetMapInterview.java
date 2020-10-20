package java16_1020.java;

import java.util.HashMap;
import java.util.Map;


public class SetMapInterview {
    //统计只出现过一次的数值并返回
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int x:nums){
            Integer Value=map.get(x);
            if (Value == null) {
                map.put(x,1);
            }else{
                map.put(x,Value+1);
            }
        }
        //遍历
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue().equals(1)){//如果某个数据只出现过一次
                return entry.getKey();//返回它本身key
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,2,4,4,0};
        System.out.println(singleNumber(nums));
    }
}
