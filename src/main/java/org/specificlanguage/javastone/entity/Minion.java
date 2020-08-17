package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.card.CardClass;
import org.specificlanguage.javastone.enchantment.Enchantment;
import org.specificlanguage.javastone.entity.attributes.Attribute;
import org.specificlanguage.javastone.entity.attributes.Tribe;
import org.specificlanguage.javastone.listener.GameListener;

import java.util.LinkedList;
import java.util.List;

public class Minion extends Entity{

    private int cost;
    private String name;
    private CardClass cardClass;
    private String id;
    private LinkedList<GameListener> listeners;
    // deathrattles
    private Tribe tribe;
    private List<Attribute> attributes;
    private List<Enchantment> enchantments;

    public Minion(int cost, int attack, int maxHealth, String name, Player player, CardClass cardClass){
        super();
        setCost(cost);
        setAttack(attack);
        initHealth(maxHealth);
        this.name = name;
        this.playerControlled = player;
        this.cardClass = cardClass;
        this.attributes = new LinkedList<>();
        this.enchantments = new LinkedList<>();
        // this.deathrattles = new LinkedList<>();
        this.listeners = new LinkedList<>();
    }

    public Minion(int cost, int attack, int maxHealth, String name, Player player, CardClass cardClass, String id){
        this(cost, attack, maxHealth, name, player, cardClass);
        this.id = id;
    }

    public boolean setAttack(int attack){
        if (attack < 0)
            return false;
        this.attack = attack;
        return true;
    }

    private boolean setCost(int cost){
        if (cost < 0)
            return false;
        this.cost = cost;
        return true;
    }

    public boolean initHealth(int health){
        if (health <= 0)
            return false;
        this.health = health;
        this.maxHealth = health;
        return true;
    }

    public void addListener(){
        game.addListeners(this.listeners);
    }

    public void deathSequence(){
        for(GameListener gl : game.getListeners()){
            game.removeListener(gl);
        }

        //for(GameEvent e : deathrattles){
          //  e.getAction().execute();
        // }
        game.getBoard().removeMinion(this);
    }

    public void onDeath(){
        // new DeathAction(this).execute();
        deathSequence();
    }

    // public boolean attack(Entity target){
    //     return new AttackAction(this, target).execute();
    // }

    public boolean hasTaunt(){
        if(attributes.contains(Attribute.TAUNT))
            return true;
        return false;
    }

    public boolean clearAttributes(){
        this.attributes.clear();
        return true;
    }

    public boolean addEnchantments(List<Enchantment> enchantments){
        for(Enchantment e : enchantments){
            if(e == null){
                throw new IllegalArgumentException();
            }

        }
        this.enchantments.addAll(enchantments);
        return true;
    }

    public void removeAllEnchantments(){
        this.enchantments.clear();
    }

    public boolean removeEnchantment(Enchantment enchantment){
        this.enchantments.remove(enchantment);
        return true;
    }

    public List<Enchantment> getEnchantments(){
        return this.enchantments;
    }

    // public List<GameEvent> getDeathrattles(){
    //    return this.deathrattles;
    // }

    public int getCost() {
        return cost;
    }

    public CardClass getCardClass(){
        return cardClass;
    }

    public String getName(){
        return name;
    }


}
