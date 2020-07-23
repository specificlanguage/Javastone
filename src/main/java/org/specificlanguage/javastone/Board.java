package org.specificlanguage.javastone;

import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;

public class Board {

    public HSGame game;
    public Minion[][] board;

    public Board(HSGame game){
        this.game = game;
        board = new Minion[2][7];
    }

    public boolean summonMinion(Minion minion, Player player){
        int side = game.getSide(player);
        if(slotsFull(player)) return false;
        for(int i = 0; i < board[side].length; i++){
            if(board[side][i] == null){
                board[side][i] = minion;
                return true;
            }
        }
        return false; //unable to summon in any position
    }

    public boolean summonMinion(Minion minion, Player player, int position){
        int side = game.getSide(player);
        if(board[side][position - 1] == null){

        }
        return false;
    }

    public boolean removeMinion(HSGame game, Minion minion){
        int side = game.getSide(minion.getPlayerControlled());
        for(int i = 0; i < board[side].length; i++){
            if(board[side][i].equals(minion)){
                for(int j = i + 1; j < board[side].length; j++){
                    if(j == board[side].length - 1){
                        board[side][j] = null;
                        return true;
                    }
                    board[side][j] = board[side][j - 1];
                }
            }
        }
        return false; // minion was never on board
    }

    public boolean isOnBoard(HSGame game, Minion minion){ ;
        int side = game.getSide(minion.getPlayerControlled());
        for(int i = 0; i < board[side].length; i++){
            if(board[side][i].equals(minion)){
                return true;
            }
        }
        return false;
    }

    public int getNumOpenSlots(Player player){
        int side = player.getGame().getSide(player);
        int slots = 7;
        for(int i = 0; i < board[side].length; i++){
            if(board[side][i] != null){
                slots--;
            }
        }
        return slots;
    }

    public boolean slotsFull(Player player){
        if(getNumOpenSlots(player) == 0){
            return true;
        }
        return false;
    }

}
