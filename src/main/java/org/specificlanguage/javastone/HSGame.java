package org.specificlanguage.javastone;

import com.sun.tools.javac.code.Attribute;
import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.action.CompoundAction;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.listener.GameListener;

import java.util.*;

public class HSGame {

    private Stack<GameEvent> eventStack;
    private List<GameListener> listeners;
    public List<Observer> observers = new ArrayList<>();
    public Player player1;
    public Player player2;
    public Board board;
    public int inControl;

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

    public Board getBoard(){
        return board;
    }

    public boolean processEvent(GameEvent event){
        eventStack.push(event);
        List<GameListener> validListeners = listeners;
        Action a = event.getAction();

        if(a instanceof CompoundAction){
            for(Action action : ((CompoundAction) a).getActions()){

            }
        }

        if(event.getAction() instanceof CompoundAction){
            List<Action> actions = ((CompoundAction) event.getAction()).getActions()
            for(Action action : actions){

            }
        } else {

        }
        eventStack.pop().getAction().execute();
        return true;
    }

    private void listenerCheck(GameEvent e){
        for (GameListener listener : listeners) {
            if (listener.getEvent().getClass() == e.getClass() && listener.checkAction(e.getAction())) {
                listeners.remove(listener);
                listener.processEvent(e.getAction());
            }
        }
    }



}
