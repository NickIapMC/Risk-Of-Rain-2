package znick_.riskofrain2.api.ror.buff;

import znick_.riskofrain2.event.handler.TickHandler;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;

/**
 * Represents a temporary {@code Buff} that wears off after a certain amount of time.
 * 
 * @author zNick_
 */
public abstract class DurationBuff extends Buff {
	
	private int startTick;
	private int duration;
	
	public DurationBuff(int itemCount, int duration) {
		super(itemCount);
		this.startTick = TickHandler.server();
		this.duration = duration;
	}
	
	public DurationBuff setDuration(int duration) {
		this.duration = duration;
		return this;
	}
	
	public int getStartTick() {
		return this.startTick;
	}
	
	public void setStartTick(int newTick) {
		this.startTick = newTick;
	}
	
	public void resetStartTick() {
		this.startTick = TickHandler.server();
	}
	
	public int getDuration() {
		return this.duration;
	}

}
