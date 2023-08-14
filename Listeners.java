package listeners;

import com.slack.api.bolt.App;
import listeners.events.EventListeners;
import listeners.messages.MessageListeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listeners {

    public static Logger logger = LoggerFactory.getLogger(Listeners.class);

    public static void register(App app) {
        for (ListenerProvider provider : getAllListeners()) {
            provider.register(app);
            logger.info("{} Registered", provider.getClass().getSimpleName());
        }
    }

    private static ListenerProvider[] getAllListeners() {
        System.out.println("**************************");
        return new ListenerProvider[] {
            // new ActionListeners(),
            // new CommandListeners(),
            new EventListeners(), new MessageListeners(),
            // new ShortcutListeners(),
            // new ViewListeners()
        };
    }
}
