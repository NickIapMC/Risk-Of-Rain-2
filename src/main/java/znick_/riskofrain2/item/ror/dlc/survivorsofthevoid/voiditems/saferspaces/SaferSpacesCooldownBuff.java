package znick_.riskofrain2.item.ror.dlc.survivorsofthevoid.voiditems.saferspaces;

import net.minecraft.util.ResourceLocation;
import znick_.riskofrain2.api.mc.data.PlayerData;
import znick_.riskofrain2.api.ror.buff.DurationBuff;
import znick_.riskofrain2.event.handler.TickHandler;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;

public class SaferSpacesCooldownBuff extends DurationBuff {

	public SaferSpacesCooldownBuff(int itemCount) {
		super((RiskOfRain2Item) RiskOfRain2Items.SAFER_SPACES, itemCount, (int) (TickHandler.fromSeconds(15) * Math.pow(0.9, itemCount)));
	}

	@Override
	public ResourceLocation getIconTexture() {
		return null;
	}

	@Override
	public void applyEffect(PlayerData player) {
		
	}

	@Override
	public void removeEffect(PlayerData player) {
		player.addBuff(new SaferSpacesBuff(this.getItemCount()));
	}

}