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
        LinkedList<Minion> side = getSide(minion.getPlayerControlled());
        if(!slotsFull(side)){
            side.addLast(minion);
            return true;
        }
        return false;
    }

    public boolean summonMinion(Minion minion, int position){
        LinkedList<Minion> side = getSide(minion.getPlayerControlled());
        if(!slotsFull(side)){
            side.add(position - 1, minion);
            return true;
        }
        return false;
    }

    public boolean removeMinion(Minion minion){
        getSide(minion.getPlayerControlled()).remove(minion);
        return true;
    }

    public boolean isOnBoard(Minion minion){
        return getSide(minion.getPlayerControlled()).contains(minion);
    }

    public int getNumOpenSlots(Player player){
        return getSide(player).size() - 7;
    }

    public boolean slotsFull(LinkedList<Minion> side){
        return side.size() < 7;
    }

    public boolean tauntOnBoard(Player player){
        for(Minion m : getSide(player)){
            if (m.hasTaunt()){
                return true;
            }
        }
        return false;
    }

    public LinkedList<Minion> getSide(Player player){
        return board.get(player);
    }

}
