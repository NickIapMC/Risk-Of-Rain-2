package znick_.riskofrain2.api.ror.survivor.ability.phase;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;

public interface ActivatedAbilityPhase<T extends Event> {
	
	/**
	 * Listens for the event that activates this ability. Note that this must be annotated manually with the
	 * {@code @SubscribeEvent} annotation because it's not inherited. 
	 * 
	 * @param event The event to listen for.
	 */
	public abstract void listenForActivation(T event);
	
	/**
	 * Registers the class to listen for events.
	 */
	default void register() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
}
