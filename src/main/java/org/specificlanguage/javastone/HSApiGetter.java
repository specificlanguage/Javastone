package org.specificlanguage.javastone;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.File;
import java.util.Scanner;

public class HSApiGetter {

    public static void main(String[] args){
        try {
            File file = new File(HSApiGetter.class.getResource("api_key.txt").getFile());
            Scanner scanner = new Scanner(file);
            String api_key = scanner.next();

            HttpResponse<String> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards")
                    .header("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", api_key)
                    .asString();
        } catch(Exception e){
            e.printStackTrace();
        }


    }

    




}
