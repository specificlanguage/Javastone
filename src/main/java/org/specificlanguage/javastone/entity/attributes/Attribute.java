package org.specificlanguage.javastone.entity.attributes;

import org.specificlanguage.javastone.action.Action;

public enum Attribute {

    TAUNT, CHARGE, RUSH, STEALTH, SPELL_DAMAGE, DEATHRATTLE, AURA, LIFESTEAL, POISONOUS, WINDFURY, CANT_ATTACK,
    CANT_ATTACK_HEROES;

    public static Attribute matchValue(String s){
        for(Attribute attribute : Attribute.values()){
            if(Attribute.valueOf(s) == attribute){
                return attribute;
            }
        }

        throw new IllegalArgumentException();
    }

}
