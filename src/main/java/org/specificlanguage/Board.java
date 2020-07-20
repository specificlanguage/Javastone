package org.specificlanguage;

import org.specificlanguage.entity.Minion;
import org.specificlanguage.entity.Player;

public class Board {

    public Minion[][] board = new Minion[2][7];

    public boolean summonMinion(HSGame game, Minion minion, Player player){
        int side = game.getSide(player);
        for(int i = 0; i < board[side].length; i++){
            if(board[side][i] == null){
                board[side][i] = minion;
                return true;
            }
        }
        return false; //unable to summon in any position
    }

    public boolean summonMinion(HSGame game, Minion minion, Player player, int position){
        int side = game.getSide(player);
        if(board[side][position - 1] == null){
            board[side][position - 1] = minion;
            return true;
        }
        return false;
    }

}
