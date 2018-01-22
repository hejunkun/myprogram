package com.myprogram.entity;

import javax.persistence.*;

/**
 * Created by hjk on 2018/1/8.
 */
@Entity
@Table(name = "grade")
public class Grade {
    private int gno;
    private String gname;//学生名字
    private int gchinese;//语文成绩
    private int gmath;//数学成绩
    private int genglish;//英语成绩

    private Cls cls;

    @ManyToOne
    @JoinColumn(name = "cno")
    public Cls getCls() {
        return cls;
    }

    public void setCls(Cls cls) {
        this.cls = cls;
    }

    public Grade() {
    }

    public Grade(int gno, String gname, int gchinese, int gmath, int genglish) {
        this.gno = gno;
        this.gname = gname;
        this.gchinese = gchinese;
        this.gmath = gmath;
        this.genglish = genglish;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGchinese() {
        return gchinese;
    }

    public void setGchinese(int gchinese) {
        this.gchinese = gchinese;
    }

    public int getGmath() {
        return gmath;
    }

    public void setGmath(int gmath) {
        this.gmath = gmath;
    }

    public int getGenglish() {
        return genglish;
    }

    public void setGenglish(int genglish) {
        this.genglish = genglish;
    }
}
