package org.specificlanguage.javastone;

import jdk.nashorn.internal.parser.JSONParser;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class HSApiGetter {

    public static void main(String[] args){
        try {
            File file = new File(HSApiGetter.class.getResource("api_key.txt").getFile());
            InputStream is = new FileInputStream(HSApiGetter.class.getResource("sets.json").getFile());

            // API request

            Scanner scanner = new Scanner(file);
            String api_key = scanner.next();
            scanner.close();

            HttpResponse<String> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards")
                    .header("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", api_key)
                    .asString();

            String string = response.getBody();
            JSONObject all_cards = new JSONObject(string);
            JSONObject all_sets = new JSONObject();

            Iterator<String> keys = all_cards.keys();




        } catch(Exception e){
            e.printStackTrace();
        }
    }

    




}
