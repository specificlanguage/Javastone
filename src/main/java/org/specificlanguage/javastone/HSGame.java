package org.specificlanguage.javastone;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.action.CompoundAction;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.listener.GameListener;

import java.util.*;

public class HSGame {

    private LinkedList<GameEvent> events;
    private LinkedList<GameListener> listeners;
    public List<Observer> observers = new ArrayList<>();
    public Player player1;
    public Player player2;
    public Board board;
    public int turn;

    public HSGame(Player p1, Player p2){
        p1.setGame(this); p2.setGame(this);
        events = new LinkedList<>();
    }

    public Player getOpponent(Player player){
        if (player.equals(player1)){
            return player2;
        } else if (player.equals(player2)){
            return player1;
        } else throw new IllegalArgumentException();
    }

    public int getSide(Player player){
        if (player.equals(player1)){
            return 0;
        } else if (player.equals(player2)){
            return 1;
        } else throw new IllegalArgumentException();
    }

    public Board getBoard(){
        return board;
    }

    public boolean processEvent(GameEvent event){

        events.push(event);
        Action a = event.getAction();

        if(a instanceof CompoundAction){
            for(Action action : ((CompoundAction) a).getActions()){
                action.execute(); // nest into the action and resolve those actions
            }
        } else for(GameListener gl : listeners){
            if(gl.checkAction(a)){
                gl.processEvent(event);
                listeners.remove(gl);
            }
        }

        return true;
    }

    public boolean addListeners(LinkedList<GameListener> listeners){
        if(listeners.size() == 0){
            return false;
        }
        this.listeners.addAll(listeners);
        return true;
    }

    private void listenerCheck(GameEvent e){
        for (GameListener listener : listeners) {
            if (listener.getEvent().getClass() == e.getClass()) {
                listeners.remove(listener);
                listener.processEvent(e);
            }
        }
    }

    public boolean removeListener(GameListener listener){
        this.listeners.remove(listener);
        return true;
    }

    public List<GameListener> getListeners(){
        return this.listeners;
    }

    public boolean isInGame(Entity entity){
        Player p = entity.getPlayerControlled();
        return p.equals(player1) || p.equals(player2);
    }

    //TODO: search for event in stack (for conditional things)
}
