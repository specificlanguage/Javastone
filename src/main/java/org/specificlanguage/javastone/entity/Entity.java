package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.entity.attributes.Attribute;

import java.util.List;

public abstract class Entity {

    protected int health;
    protected int maxHealth;
    protected int attack;
    protected HSGame game;
    protected Player playerControlled;
    protected List<Attribute> attributes;

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){ return maxHealth; }

    public Player getPlayerControlled(){
        return playerControlled;
    }

    public boolean damage(int damage){
        if(damage < 0){
            return false;
        }
        health -= damage;
        return true;
    }

    public boolean setHealth(int health){
        if(health <= 0){
            return false; // there's pretty much no way that can happen
        }
        if (health > maxHealth) {
            this.health = maxHealth;
            return true;
        }
        this.health = health;
        return true;
    }

    public boolean heal(int health){
        if(health <= 0){
            return false;
        }
        if(this.health + health > maxHealth){
            this.health = maxHealth;
            return true;
        }
        this.health += health;
        return true;
    }

    public void setGame(HSGame game) {
        this.game = game;
    }

    public HSGame getGame(){
        return game;
    }

    public boolean canAttack(){
        return attack > 0 || !attributes.contains(Attribute.CANT_ATTACK);
    }

    public abstract void onDeath();

    public boolean isDead(){
        if(health <= 0){
            return true;
        }
        return false;
    }

    public boolean attack(Entity target){
        if(target == this || !canAttack()){
            // send message saying you can't attack yourself!
            throw new IllegalArgumentException();
        }
        new AttackAction(this, target).execute();
        return true;
    }

    public int getAttack(){
        return attack;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void addAttributes(List<Attribute> attribute) {
        this.attributes.addAll(attribute);
    }

    public boolean removeAttribute(Attribute attribute){
        this.attributes.remove(attribute);
        return true;
    }
}
