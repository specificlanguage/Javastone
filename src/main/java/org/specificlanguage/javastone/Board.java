package org.specificlanguage.javastone;

import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class Board {

    public HSGame game;

    public HashMap<Player, LinkedList<Minion>> board;

    public Board(HSGame game){
        this.game = game;
        this.board = new HashMap<>();
        board.put(game.player1, new LinkedList<Minion>());
        board.put(game.player2, new LinkedList<Minion>());
    }

    public boolean summonMinion(Minion minion){
        LinkedList<Minion> side = board.get(minion.getPlayerControlled());
        if(!slotsFull(side)){
            side.addLast(minion);
            return true;
        }
        return false;
    }

    public boolean summonMinion(Minion minion, int position){
        LinkedList<Minion> side = board.get(minion.getPlayerControlled());
        if(!slotsFull(side)){
            side.add(position - 1, minion);
            return true;
        }
        return false;
    }

    public boolean removeMinion(Minion minion){
        LinkedList<Minion> side = board.get(minion.getPlayerControlled());
        side.remove(minion);
        return true;
    }

    public boolean isOnBoard(HSGame game, Minion minion){
        LinkedList<Minion> side = board.get(minion.getPlayerControlled());
        return side.contains(minion);
    }

    public int getNumOpenSlots(Player player){
        LinkedList<Minion> side = board.get(player);
        return side.size() - 7;
    }

    public boolean slotsFull(LinkedList<Minion> side){
        return side.size() < 7;
    }

}
