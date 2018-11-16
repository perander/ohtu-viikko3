package src.main.java.ohtu;

public class Course {
    private String name;
    private String fullName;
    private String term;
    private int year;
    private int exPerWeek;
    private int[] exercises;

    public String getName() { return name; }

    public int getExPerWeek(int week) { return exercises[week]; }

    public int getTotalEx() {
        int total = 0;
        for (int ex: exercises) {
            total += ex;
        }
        return total;
    }

    @Override
    public String toString() {
        return fullName + " " + term + " " + year;
    }
}
