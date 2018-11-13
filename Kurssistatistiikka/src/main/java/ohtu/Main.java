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

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("opiskelijanumero: " + studentNr);

        int totalEx = 0;
        int totalHrs = 0;

        System.out.println("");

        for (Submission submission : subs) {
            System.out.println(submission);
            totalEx += submission.getEx();
            totalHrs += submission.getHours();
        }

        System.out.println("");
        System.out.println("yhteensä: " + totalEx + " tehtävää " + totalHrs + " tuntia");

    }
}