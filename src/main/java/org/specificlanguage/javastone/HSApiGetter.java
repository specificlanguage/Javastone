package org.specificlanguage.javastone;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.json.JSONObject;
import org.json.JSONWriter;

public class HSApiGetter {

    public static void main(String[] args) {
        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards")
                .header("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "a1ffbf4cb3mshe3ddc1c5abb2a7bp162759jsna19b890d239c")
                .asJson();

    }





}
