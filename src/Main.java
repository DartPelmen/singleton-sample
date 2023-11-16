
class Data{
    private int a;
    private long time;
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

class DataSingleton{
    private static volatile Data instance = null;
    public static Data getInstance(){
        if(instance == null){
            synchronized (DataSingleton.class){
                if(instance == null){
                    instance = new Data();
                    instance.setA(1);
                    instance.setTime(System.currentTimeMillis());
                }
            }
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        var data = DataSingleton.getInstance();
        System.out.println(data.getA());
        System.out.println(data.getTime());
        System.out.println("============");
        var data2 = DataSingleton.getInstance();
        System.out.println(data2.getA());
        System.out.println(data2.getTime());

    }
}