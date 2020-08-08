package org.specificlanguage.javastone.action.test;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.entity.attributes.Attribute;

import java.util.LinkedList;
import java.util.List;

public class ActionBuilder {

    public static GameAction<Entity> createAction(final Player player, final Command command, final LinkedList<Object> args){
        switch(command) {
            case ARMOR:
                return new GameAction<Entity>() {
                    @Override
                    public boolean execute(Entity entity) {
                        entity.getPlayerControlled().addArmor((int) args.get(3));
                        return true;
                    }

                    @Override
                    public Entity getCaster() {
                        return null;
                    }

                    @Override
                    public Command getGameAction() {
                        return null;
                    }
                };
            case HEAL:
                return new GameAction<Entity>() {
                    @Override
                    public boolean execute(Entity entity) {
                        entity.heal((int) args.get(3));
                        return true;
                    }

                    @Override
                    public Entity getCaster() {
                        return player;
                    }

                    @Override
                    public Command getGameAction() {
                        return command;
                    }
                };
            case DAMAGE:
                return new GameAction<Entity>() {
                    @Override
                    public boolean execute(Entity entity) {
                        entity.damage((int) args.get(3));
                        return true;
                    }

                    @Override
                    public Entity getCaster() {
                        return player;
                    }

                    @Override
                    public Command getGameAction() {
                        return command;
                    }
                };
            case DRAW_CARD:
                return new GameAction<Entity>() {
                    @Override
                    public boolean execute(Entity entity) {
                        for (int i = 0; i < (int) args.get(3); i++) {
                            entity.getPlayerControlled().drawCard();
                        }
                        return true;
                    }

                    @Override
                    public Entity getCaster() {
                        return player;
                    }

                    @Override
                    public Command getGameAction() {
                        return command;
                    }
                };
            case GIVE:
                return new GameAction<Entity>() {
                    @Override
                    public boolean execute(Entity entity) {
                        List<Attribute> attributesToGive = new LinkedList<>();
                        for (int i = 0; i < command.getMaxArgs(); i++){
                            String attribute = (String) args.get(i + 3);
                            attributesToGive.add(Attribute.matchValue(attribute));
                        }
                        entity.addAttributes(attributesToGive);
                        return true;
                    }

                    @Override
                    public Entity getCaster() {
                        return player;
                    }

                    @Override
                    public Command getGameAction() {
                        return command;
                    }
                };
            default:
                throw new IllegalArgumentException();
        }
    }

}
