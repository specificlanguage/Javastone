package org.specificlanguage.javastone.action.test;

public enum Command {
    HEAL(true, 1, 1),
    DAMAGE(true, 1, 1),
    SUMMON(false,1, 1), // should change for however many you need
    GIVE(true, 1, 1000000),
    DRAW_CARD(false, 1, 60); // max deckLength

    boolean targetable;
    int minArgs;
    int maxArgs;

    Command(boolean targetable, int minArgs, int maxArgs) {
        this.targetable = targetable;
        this.minArgs = minArgs;
        this.maxArgs = maxArgs;
    }

    public boolean isTargetable() {
        return targetable;
    }

    public int getMaxArgs() {
        return maxArgs;
    }

    public int getMinArgs(){
        return minArgs;
    }

    @Override
    public String toString() {
        switch(this){
            case HEAL:
                return "HEAL";
            case DAMAGE:
                return "DAMAGE";
            case GIVE:
                return "GIVE";
            case SUMMON:
                return "SUMMON";
            case DRAW_CARD:
                return "DRAW_CARD";
            default:
                throw new IllegalArgumentException();
        }
    }
}
