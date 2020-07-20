package org.specificlanguage;

import org.specificlanguage.action.Action;
import org.specificlanguage.entity.Minion;
import org.specificlanguage.entity.Player;

import java.util.Queue;

public class HSGame {

    public Queue<Action> actionQueue;
    public Player player1;
    public Player player2;
    public Minion[][] board;

    public HSGame(Player p1, Player p2){
        p1.game = this;
        p2.game = this;
        board = new Minion[2][7];
    }




    public Action getNextAction(){
        return actionQueue.peek();
    }


}
