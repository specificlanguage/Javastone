package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;

public interface GameEvent {

    /**
     * Yeah that's it, it's just a basic class to categorize all future events.
     */

    Action executeAction();

}
