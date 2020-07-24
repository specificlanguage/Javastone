package org.specificlanguage.javastone;

import com.sun.istack.internal.NotNull;
import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.action.CompoundAction;
import org.specificlanguage.javastone.entity.Entity;
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
    public int turn;

    public HSGame(Player p1, Player p2){
        p1.setGame(this); p2.setGame(this);
        eventStack = new Stack<GameEvent>();
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
        Action a = event.getAction();

        if(a instanceof CompoundAction){
            for(Action action : ((CompoundAction) a).getActions()){
                action.execute(); // nest into the action and resolve those actions
            }
        } else for(GameListener gl : listeners){
            if(gl.checkAction(a)){
                gl.processEvent(a);
                listeners.remove(gl);
            }
        }

        return true;
    }

    public boolean addListeners(GameListener[] listeners){
        if(listeners.length == 0) {
            return false;
        }
        this.listeners.addAll(Arrays.asList(listeners));
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

    public boolean removeListeners(GameListener[] listeners){
        for(GameListener l : listeners) {
            this.listeners.remove(l);
        }
        return true;
    }

    public boolean isInGame(Entity entity){
        Player p = entity.getPlayerControlled();
        return p.equals(player1) || p.equals(player2);
    }

    //TODO: search for event in stack (for conditional things)
}
