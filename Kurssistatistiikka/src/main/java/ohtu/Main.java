package src.main.java.ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String studentInfo = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        String studentBodyText = Request.Get(studentInfo).execute().returnContent().asString();

        String courseInfo = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String courseBodyText = Request.Get(courseInfo).execute().returnContent().asString();


//        System.out.println("json-muotoinen data:");
        System.out.println( courseBodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(studentBodyText, Submission[].class);

        Gson courseMapper = new Gson();
        Course[] courses = courseMapper.fromJson(courseBodyText, Course[].class);


        System.out.println("opiskelijanumero: " + studentNr);

        int totalExDone;
        int totalHrs;


        System.out.println("");

        for (Submission submission: subs) {
            totalExDone = 0;
            totalHrs = 0;

            for (Course c : courses) {
                if(submission.getCourse().equals(c.getName()) && submission.anyDone()) {
                    System.out.println(c);
                    System.out.println("\nViikko: " + submission.getWeek() + ":\n" +
                            " tehtyjä tehtäviä " + submission.getExercises().size() +
                            "/" + c.getExPerWeek(submission.getWeek()) +
                            " aikaa kului " + submission.getHours() +
                            " tehdyt tehtävät " + submission.getExercises() + "\n");
                    totalExDone += submission.getEx();
                    totalHrs += submission.getHours();
                    System.out.println("yhteensä: " + totalExDone + "/" + c.getTotalEx() +
                            " tehtävää " + totalHrs + " tuntia\n");
                }


            }

        }
    }
}