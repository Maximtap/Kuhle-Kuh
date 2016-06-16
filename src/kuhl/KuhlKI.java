package kuhl;

import net.canarymod.api.ai.AIBase;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.entity.living.humanoid.Player;

public class KuhlKI implements AIBase{
	Player besitzer;
	EntityLiving kuh;
	
	public KuhlKI(Player besitzer, EntityLiving kuh) {
		this.besitzer = besitzer;
		this.kuh = kuh;
	}
	
	@Override
	public void updateTask() {
		
		if(kuh.getMotionY() > 0) {
			
		}
		
		kuh.moveEntityToXYZ(besitzer.getLocation().getX(), besitzer.getLocation().getY(), besitzer.getLocation().getZ(), 1.0f);
	}
	
	@Override
	public void resetTask() {
	}
	
	@Override
	public void startExecuting() {
	}
	
	@Override
	public boolean isContinuous() {
		return true;
	}
	
	@Override
	public boolean continueExecuting() {
		return true;
	}
	
	@Override
	public boolean shouldExecute() {
		return true;
	}
}