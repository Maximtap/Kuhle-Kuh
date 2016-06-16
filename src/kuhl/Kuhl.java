package kuhl;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;
import com.pragprog.ahmine.ez.EZPlugin;
import net.canarymod.logger.Logman;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.ai.AIBase;

public class Kuhl extends Plugin implements CommandListener{
	@Override
	public boolean enable(){
		try {
			Canary.commands().registerCommands(this, this, false);
		} catch(Exception e) {
			getLogman().error("Befehl konnte nicht registriert werden.");
		}
		return true;
	}
	@Override
	public void disable(){
	}
	
	
	
	@Command(aliases = {"kuhl"},
			 description = "Erzeugt eine Hauskuh",
			 permissions = {""},
			 toolTip = "/kuhl")
	
	public void hauskuh(MessageReceiver caller, String[] parameter) {
		if(caller instanceof Player) {
			Player spieler = (Player) caller;
			Location position = spieler.getLocation();
			EntityLiving kuh = Canary.factory().getEntityFactory().newEntityLiving(EntityType.COW, position);
			while(kuh.getAITaskManager().hasTask(AIBase.class)) {
				kuh.getAITaskManager().removeTask(AIBase.class);
			}
			
			KuhlKI ki = new KuhlKI(spieler, kuh);
			kuh.getAITaskManager().addTask(100, ki);
			
			kuh.spawn();
		}
	}
}