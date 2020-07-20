package org.specificlanguage;

import org.specificlanguage.action.Action;
import org.specificlanguage.entity.Minion;
import org.specificlanguage.entity.Player;

import java.util.Queue;

public class HSGame {

    public Queue<Action> actionQueue;
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

}
