class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Person person=new Person();
        try {
            Person person2= (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


    public static int divide(int x,int y) throws ArithmeticException{
        if(y==0){
            throw new ArithmeticException("y==0");
        }
        return x/y;
    }


    public static void main2(String[] args) {
        try {
            int ret = divide(20, 10);
            System.out.println(ret);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("hhhhh");
        }
        System.out.println("继续执行");
    }

    public static void main1(String[] args) {
        int x=0;
        if (x == 0) {
            throw new UnsupportedOperationException("x=0");
        }
    }
}
