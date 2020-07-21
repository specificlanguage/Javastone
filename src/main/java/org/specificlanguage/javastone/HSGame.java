package org.specificlanguage.javastone;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.listener.GameListener;

import java.util.*;

public class HSGame {

    private Stack<GameEvent> eventStack;
    private List<GameListener> listeners;
    private Queue<Action> actionQueue;
    public List<Observer> observers = new ArrayList<>();
    public Player player1;
    public Player player2;
    public Board board;

    public HSGame(Player p1, Player p2){
        p1.setGame(this); p2.setGame(this);
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

    public Action getNextAction(){
        return actionQueue.peek();
    }

    public Board getBoard(){
        return board;
    }

    public boolean processEvent(GameEvent event){
        eventStack.push(event);
        List<GameListener> validListeners = listeners;

        for(GameListener listener : listeners){
            if(listener.getEvent().getClass() == event.getClass()){
                listeners.remove(listener);
                validListeners.add(listener);
                listener.processEvent();
            }
        }

        eventStack.pop();

        return true;
    }



}
