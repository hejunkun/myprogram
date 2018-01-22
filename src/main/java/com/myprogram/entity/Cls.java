package com.myprogram.entity;

import javax.persistence.*;

/**
 * Created by hjk on 2017/12/24.
 */
@Entity
@Table(name = "cls")
public class Cls {
    private int cno;
    private String cname;


    public Cls() {
    }

    public Cls(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}


