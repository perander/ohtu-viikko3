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

    public String getCourse() { return course; }

    public ArrayList<Integer> getExercises() { return exercises; }

    public boolean anyDone() {
        for (int ex: exercises) {
            if (ex != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nViikko: " + week + ": \n" +
                "\rtehtyjä tehtäviä " + exercises.size() +
                " aikaa kului " + hours +
                " tehdyt tehtävät " + exercises + "\n";
    }
}