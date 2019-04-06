package skypebot;
import com.samczsun.skype4j.*;
import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;
public class Main {

	public static void main(String[] args) {
		Skype skype = new SkypeBuilder("live:9c426c48a05f373", "skypeBotTest").withAllResources().build();
		try {
			skype.login();
		} catch (NotParticipatingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidCredentialsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		skype.getEventDispatcher().registerListener(new Listener() {
		  @EventHandler
		  public void onMessage(MessageReceivedEvent e) {
		    System.out.println("Got message: " + e.getMessage().getContent());
		  }
		});
		try {
			skype.subscribe();
		} catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Do stuff
		try {
			skype.logout();
		} catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
