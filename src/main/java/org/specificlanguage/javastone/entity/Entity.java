package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.HSGame;

public abstract class Entity {

    protected int health;
    protected int maxHealth;
    protected HSGame game;

    public int getHealth(){
        return health;
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



}
