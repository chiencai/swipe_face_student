package com.example.swipe_face_student.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Class extends ClassId{
    public Class() {

    }

    private String class_id;
    private String class_name;
    private Integer class_team_total;
    private Integer student_total;
    private String teacher_email;
    private String class_year;
    private ArrayList<String> student_id =new ArrayList<String>();
    private Integer class_totalpoints; //出席占學期總分
    private Integer class_totalteam;
    private Integer class_answerbonus; //點人回答(加分)
    private Integer class_rdanswerbonus; //隨機問題加分(加分)
    private Integer class_absenteeminus; //缺席扣分 (出席)
    private Integer class_lateminus; //遲到扣分(出席)
    private Integer class_ewtimes; //預警 次數達到
    private Integer class_ewpoints; //預警 分數低於
    private ArrayList<String> group_leader = new ArrayList<>();// 小組 組長列表
    private boolean group_state_go;//小組 分組狀態
    private boolean group_state;//小組 分組狀態
    private Integer group_num;//小組數量
    private Integer group_numHigh;//小組人數上限
    private Integer group_numLow;//小組人數下限
    private Date create_time;//小組創立時間

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getClass_team_total() {
        return class_team_total;
    }

    public void setClass_team_total(Integer class_team_total) {
        this.class_team_total = class_team_total;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getClass_year() {

        return class_year;
    }

    public void setClass_year(String class_year) {
        this.class_year = class_year;
    }

    public ArrayList<String> getStudent_id() {
        return student_id;
    }

    public void setStudent_id(ArrayList<String> student_id) {
        this.student_id = student_id;
    }

    public Integer getStudent_total() {
        if (!student_id.isEmpty()) {
            student_total = student_id.size();
        }
        else{
            student_total=0;
        }
        return student_total;
    }

    public void setStudent_total(Integer student_total) {
        this.student_total = student_total;
    }

    public Integer getClass_totalpoints() {
        return class_totalpoints;
    }

    public void setClass_totalpoints(Integer class_totalpoints) {
        this.class_totalpoints = class_totalpoints;
    }

    public Integer getClass_totalteam() {
        return class_totalteam;
    }

    public void setClass_totalteam(Integer class_totalteam) {
        this.class_totalteam = class_totalteam;
    }

    public Integer getClass_answerbonus() {
        return class_answerbonus;
    }

    public void setClass_answerbonus(Integer class_answerbonus) {
        this.class_answerbonus = class_answerbonus;
    }

    public Integer getClass_rdanswerbonus() {
        return class_rdanswerbonus;
    }

    public void setClass_rdanswerbonus(Integer class_rdanswerbonus) {
        this.class_rdanswerbonus = class_rdanswerbonus;
    }

    public Integer getClass_absenteeminus() {
        return class_absenteeminus;
    }

    public void setClass_absenteeminus(Integer class_absenteeminus) {
        this.class_absenteeminus = class_absenteeminus;
    }

    public Integer getClass_lateminus() {
        return class_lateminus;
    }

    public void setClass_lateminus(Integer class_lateminus) {
        this.class_lateminus = class_lateminus;
    }

    public Integer getClass_ewtimes() {
        return class_ewtimes;
    }

    public void setClass_ewtimes(Integer class_ewtimes) {
        this.class_ewtimes = class_ewtimes;
    }

    public Integer getClass_ewpoints() {
        return class_ewpoints;
    }

    public void setClass_ewpoints(Integer class_ewpoints) {
        this.class_ewpoints = class_ewpoints;
    }

    public boolean isGroup_state() {
        return group_state;
    }

    public void setGroup_state(boolean group_state) {
        this.group_state = group_state;
    }

    public Integer getGroup_numLow() {
        return group_numLow;
    }

    public void setGroup_numLow(Integer group_numLow) {
        this.group_numLow = group_numLow;
    }

    public Integer getGroup_numHigh() {
        return group_numHigh;
    }

    public void setGroup_numHigh(Integer group_numHigh) {
        this.group_numHigh = group_numHigh;
    }

    public ArrayList<String> getGroup_leader() {
        return group_leader;
    }

    public void setGroup_leader(ArrayList<String> group_leader) {
        this.group_leader = group_leader;
    }

    public boolean isGroup_state_go() {
        return group_state_go;
    }

    public void setGroup_state_go(boolean group_state_go) {
        this.group_state_go = group_state_go;
    }

    public Integer getGroup_num() {
        return group_num;
    }

    public void setGroup_num(Integer group_num) {
        this.group_num = group_num;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}