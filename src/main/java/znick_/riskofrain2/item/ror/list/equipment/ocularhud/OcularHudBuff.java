package znick_.riskofrain2.item.ror.list.equipment.ocularhud;

import net.minecraft.util.ResourceLocation;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.api.ror.buff.DurationBuff;
import znick_.riskofrain2.api.ror.buff.stat.EntityStat;
import znick_.riskofrain2.event.handler.TickHandler;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.util.file.RiskOfRain2Resources;

public class OcularHudBuff extends DurationBuff {

	public OcularHudBuff(int itemCount) {
		super(itemCount, TickHandler.fromSeconds(8));
	}

	@Override
	public ResourceLocation getIconTexture() {
		return RiskOfRain2Resources.get(RiskOfRain2Resources.BUFFS + "ocular_hud");
	}

	@Override
	public void applyEffect(AbstractEntityData player) {
		player.addToStat(EntityStat.CRIT_CHANCE, 1);
	}

	@Override
	public void removeEffect(AbstractEntityData player) {
		player.addToStat(EntityStat.CRIT_CHANCE, -1);
	}
	
	@Override
	public RiskOfRain2Item[] getItems() {
		return new RiskOfRain2Item[] {RiskOfRain2Items.OCULAR_HUD};
	}

}
