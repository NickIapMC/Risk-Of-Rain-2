package znick_.riskofrain2.api.ror.items.list.white.energydrink;

import net.minecraft.util.ResourceLocation;
import znick_.riskofrain2.api.mc.PlayerData;
import znick_.riskofrain2.api.ror.buff.Buff;
import znick_.riskofrain2.api.ror.buff.PlayerStat;
import znick_.riskofrain2.api.ror.items.RiskOfRain2Item;
import znick_.riskofrain2.item.RiskOfRain2Items;

public class EnergyDrinkBuff extends Buff {

	public EnergyDrinkBuff(int itemCount) {
		super((RiskOfRain2Item) RiskOfRain2Items.ENERGY_DRINK, itemCount);
	}

	@Override
	public ResourceLocation getIconTexture() {
		return null;
	}

	@Override
	public void applyEffect(PlayerData player) {
		player.addToStat(PlayerStat.MOVEMENT_SPEED_MULTIPLIER, 0.25 * this.getItemCount());
	}

	@Override
	public void removeEffect(PlayerData player) {
		player.addToStat(PlayerStat.MOVEMENT_SPEED_MULTIPLIER, -0.25 * this.getItemCount());
	}

	@Override
	public boolean isDebuff() {
		return false;
	}

}