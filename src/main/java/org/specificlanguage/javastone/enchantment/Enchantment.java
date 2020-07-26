package org.specificlanguage.javastone.enchantment;

import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.attributes.Attribute;

import java.util.List;

public class Enchantment {

    Minion target;
    int attack;
    int health;
    List<Attribute> attribute;

    Enchantment(Minion target){
        this.target = target;
    }

    public void setTarget(Minion target) {
        this.target = target;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void addAttribute(Attribute attribute){
        this.attribute.add(attribute);
    }

    public void execute(){

        target.setAttack(target.getAttack() + attack);
        target.setHealth(target.getHealth() + health);
        if(!attribute.isEmpty()){

        }
    }

}
