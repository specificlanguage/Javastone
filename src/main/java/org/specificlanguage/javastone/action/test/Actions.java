package org.specificlanguage.javastone.action.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;

import java.util.Iterator;
import java.util.LinkedList;

public class Actions {

    /**
     *
     * @param onPlay - A JSONObject formatted in onPlay formatted to make actions
     * @param player - A player object that is creating (or casting) the gameAction.
     * @return
     */
    public static LinkedList<GameAction> createNewAction(JSONObject onPlay, final Player player){
        JSONArray actions = onPlay.getJSONArray("action");
        boolean targetable = onPlay.getBoolean("targetable");
        if(targetable){
            String targetType = onPlay.getString("targetType");
            String restrictions = onPlay.getString("restrictions");
            // TODO: make sure you get these parameters all set
        }

        LinkedList<GameAction> actionsParsed = new LinkedList<>();

        Iterator<Object> parsedAction = actions.iterator();
        int i = 0;

        while(parsedAction.hasNext()){
            final LinkedList<Object> infoForAction = getAction((String) parsedAction.next(), targetable);
            if(!(boolean)infoForAction.get(0)){
                throw new IllegalArgumentException();
            }
            GameAction<Entity> action = ActionBuilder.createAction(player, (Command) infoForAction.get(1), infoForAction);
            actionsParsed.add(action);
        }
        return actionsParsed;
    }

    /**
     *
     * @param s - a command string, usually in "onPlay" with a list of actions.
     * @return An object linked list where:
     * index 0 - whether found
     * index 1 - the command,
     * index 2 - whether it's targetable,
     * index 3+ - and then arguments.
     */

    private static LinkedList<Object> getAction(String s, boolean targetable){
        StringBuilder commandReq = new StringBuilder();
        String args = "";

        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals("(")){
                args = s.substring(i+1, s.length() - 1).replace(" ", "");
                break;
            }
            commandReq.append(s, i, i+1);
        }

        LinkedList<Object> result = new LinkedList<>();
        result.add(0, false);

        for(Command command : Command.values()){
            if(command.toString().toLowerCase() != commandReq.toString().toLowerCase()){
                continue;
            }

            result.set(0, true);
            result.add(1, command);
            break;
        }

        if(! (boolean) result.get(0)) {
            return result;
        }

        result.add(2, targetable);
        String[] allArgs = args.split(",");

        for(int i = 0; i < allArgs.length; i++){
            result.add(3 + i, allArgs[i]);
        }

        return result;
    }

}
