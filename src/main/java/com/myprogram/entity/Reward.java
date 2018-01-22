package com.myprogram.entity;

import javax.persistence.*;

/**
 * Created by hjk on 2018/1/8.
 */
@Entity
@Table(name = "reward")
public class Reward {
    private int rno;//奖励编号
    private String rinfo;//奖励具体信息

    private Stu stu;

    public Reward() {
    }

    public Reward(int rno, String rinfo) {
        this.rno = rno;
        this.rinfo = rinfo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getRinfo() {
        return rinfo;
    }

    public void setRinfo(String rinfo) {
        this.rinfo = rinfo;
    }

    @ManyToOne
    @JoinColumn(name = "sno")
    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }
}
