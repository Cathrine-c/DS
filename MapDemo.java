package java_1029.java;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map的使用
 */
public class MapDemo {
    public static void main1(String[] args) {
        Map<String,Integer> map=new TreeMap<>();
        map.put("stf",123);
        map.put("cs",2333);
        Integer v1=map.get("cs");
        System.out.println(v1);
        map.remove("cs");
        System.out.println("----------------");
        Integer v2=map.get("cs");
        System.out.println(v2);

    }

    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<>();
        map.put("行者","武松");
        map.put("智多星","吴用");
        map.put("青面兽","杨智");
        map.put("及时雨","宋江");
        String v=map.get("智多星");
        System.out.println(v);
        System.out.println("---------------");
       // map.remove("行者");
        String s=map.get("行者");
        System.out.println(s);

        //Entry是一个嵌套类,调用它可以获取键和值
        Set<Map.Entry<String,String>> entries =map.entrySet();
        for (Map.Entry<String,String> entry:entries){
            String s1 =entry.getKey();
            String s2=entry.getValue();
            System.out.println(s1+" "+s2);
        }
    }
}
