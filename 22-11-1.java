import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        List < Score > scoreList = new ArrayList < Score > ();
        Score scorel = new Score("203", "张三","Java", 80);
        Score score2 = new Score("102","李四","C语言",75);
        Score score3 = new Score("201", "王五", "Java", 55);
        Score score4 = new Score("101", "赵六", "JSP",65);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);
        //逐一添加对象元素
        System.out.println("原有集合元素如下"));
        print(scoreList);
        System.out.println("排序后集合元素如下");
        Collections.sort(scoreList);
        print(scoreList);
        //对List集合排序
        System.out.println("删除后集合元素如下");
        scoreList.remove(score2);
        print(scoreList);
        System.out.print("修改学生成绩如下\n");
        System.out.println(update(scoreList, "201", 60));
        print(scoreList);
        System.out.print("查找学生成绩如下\n");
        System.out.println(query(scoreList, "101"));
        //删除一个对象元素
    }
    public static void print(List < Score > scoreList) {
        System.out.print("学号\t姓名\t课程名\t 成绩\n");
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.print(scoreList.get(i));
        }
        System.out.println();
    }
    public static Score query(List < Score > scoreList, String sid) {
        for (int i = 0; i < scoreList.size(); i++) {
            Score score = (Score) scoreList.get(i);
            if (score.getSid()
                .equals(sid)) {
                return score;
            }
        }
        return null;


    }
    public static Score update(List < Score > scoreList, String sid, double score) {
        for (int i = 0; i < scoreList.size(); i++) {
            Score objScore = (Score) scoreList.get(i);
            if (objScore.getSid()
                .equals(sid)) {
                objScore.setScore(score);
                return objScore;
            }
        }
        return null;
    }
}


class Score implements Comparable < Score > {
    private String sid;
    private String sname;
    private String cname;
    private String score;

    public Score(String sid, String sname, String cname, double score) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.cname = cname;
        this.score = score;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public int compareTo(Score score) {
        if (this.cname.equals(score.getCname())) {
            return this.sid.compareTo(score.getSid());
        } else {
            return this.cname.compareTo(score.getCname());
        }
    }
    public String toString() {
        return this.sid + "\t" + this.sname + "\t" + this.cname + "\n";
    }
}
