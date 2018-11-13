package src.main.java.ohtu;

import java.util.ArrayList;

public class Submission {
    private String course;
    private int week;
    private int hours;
    private ArrayList<Integer> exercises;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public int getEx() { return exercises.size(); }

    public int getHours() { return hours; }

    @Override
    public String toString() {
        return course +
                ", viikko "+ week +
                " tehtyjä tehtäviä yhteensä " + exercises.size() +
                " aikaa kului " + hours +
                " tehdyt tehtävät " + exercises;
    }
}