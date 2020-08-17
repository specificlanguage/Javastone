package org.specificlanguage.javastone.config;

import org.json.JSONArray;
import org.json.JSONObject;
import org.specificlanguage.javastone.card.*;

import java.io.FileInputStream;
import java.util.Iterator;

public class Config {

    public static Card getCardConfig(int id){
        String id_string = (String.valueOf(id));

        FileInputStream dbfInput = (FileInputStream) Config.class.getResourceAsStream("dbf.json");
        JSONObject dbf = new JSONObject(dbfInput);
        JSONObject rawCard = dbf.getJSONObject(id_string);

        assert rawCard != null;
        FileInputStream cardFile = getSetPath(rawCard.getString("set"));
        assert cardFile != null;

        JSONObject card = new JSONObject(cardFile).getJSONObject(id_string);
        CardType type = CardType.valueOf(card.getString("type"));


        // make a new card
        CardBuilder newCard = new CardBuilder()
                .setCardClass(CardClass.valueOf(card.getString("playerClass")))
                .setCardType(type)
                .setImagePath(card.getString("img"))
                .setMana(card.getInt("cost"))
                .setName(card.getString("name"))
                .setFlavor(card.getString("flavor"))
                .setRarity(Rarity.valueOf(card.getString("rarity")));

        if(type == CardType.SPELL){
            // GameAction.makeAction();
            // newCard.makeAction();
            newCard.setText("text");
        } else if(type == CardType.MINION){
            JSONArray array = card.getJSONArray("mechanics");
            newCard.setAttack(card.getInt("attack"));
            newCard.setMaxHealth(card.getInt("health"));
            if (array != null) {
                newCard.setText(card.getString("text"));
                for (int i = 0; i < array.length(); i++) {
                    String attribute = array.getString(i);
                    if (attribute.equalsIgnoreCase("Battlecry")) {
                        // GameAction.makeAction();
                        // newCard.makeAction();
                    }
                }
                newCard.setAttack(card.getInt("attack"));
                newCard.setMaxHealth(card.getInt("health"));
            }
        } else if(type == CardType.WEAPON){
            newCard.setAttack(card.getInt("attack"));
            newCard.setMaxHealth(card.getInt("health"));
        }


        return newCard.create();
    }

    private static FileInputStream getSetPath(String setName){
        FileInputStream file = (FileInputStream) Config.class.getResourceAsStream("sets.json");
        JSONObject sets = new JSONObject(file);
        Iterator set_iterator = sets.getJSONArray("sets").iterator();
        while(set_iterator.hasNext()){
            JSONObject set = (JSONObject) set_iterator.next();
            if(set.getString("name").equals(setName)){
                return (FileInputStream) Config.class.getResourceAsStream(set.getString("setLocation"));
            }
        }

        return null;
    }


}
