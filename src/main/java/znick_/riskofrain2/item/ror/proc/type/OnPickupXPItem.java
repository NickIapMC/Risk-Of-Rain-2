package znick_.riskofrain2.item.ror.proc.type;

import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;

public interface OnPickupXPItem {

	public abstract void procOnXPPickup(PlayerPickupXpEvent event, AbstractEntityData player, int itemCount);
}
