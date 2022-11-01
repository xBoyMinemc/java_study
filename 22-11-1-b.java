import java.io.*;
import java.math.*;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Map employees = new HashMap();
        employees.put("09001",new Employee("盖茨", "09001", 99f));
        employees.put("09001",new Employee("埃里森", "09002", 92f));
        employees.put("09001", new Employee("施瓦茨", "09005", 89f));
        System.out.println("考核开始！..…");
        Iterator it = employees.keySet()
            .iterator();
        while (it.hasNext()) {
            String num = (String) it.next();
            Employee e = (Employee) employees.get(num);
            float f = (float) Math.random() * 100;
            BigDecimal b = new BigDecimal(f);
            //格式化,四舍五入保留两位
            float newScore = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            e.setScore(newScore);
            //小于60,移出集合
            if (e.getScore() < 60) {
                employees.remove(num);
            }
        }
        System.out.println("考核合格的员工！");
        it = employees.values()
            .iterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            System.out.println(e);
        }
        if (employees.size() == 0) {
            System.out, println("考核全部不合格！");

        }


    }
}



class Employee {
    private float score;
    private String number;
    private String name;


    public Employee(String na, String nu, float sc) {
        this.number = nu;
        this.name = na;
        this.score = sc;
    }
    public String toString() {
        return name + "\t" + number + "\t" + score;
    }
    public void setScore(float f) {
        this.score = f;
    }
    public float getScore() {
        return this.score;
    }
}
