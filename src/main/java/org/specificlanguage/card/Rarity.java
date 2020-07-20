package org.specificlanguage.card;

public enum Rarity {

    FREE, COMMON, RARE, EPIC, LEGENDARY;

    public Rarity stringToRarity(String s){
        switch(s){
            case "FREE":
                return FREE;
            case "COMMON":
                return COMMON;
            case "RARE":
                return RARE;
            case "EPIC":
                return EPIC;
            case "LEGENDARY":
                return LEGENDARY;
            default:
                throw new IllegalArgumentException();
        }
    }

}
