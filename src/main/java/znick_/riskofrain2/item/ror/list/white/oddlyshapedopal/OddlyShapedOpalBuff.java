package znick_.riskofrain2.item.ror.list.white.oddlyshapedopal;

import net.minecraft.util.ResourceLocation;
import znick_.riskofrain2.api.mc.data.PlayerData;
import znick_.riskofrain2.api.ror.buff.Buff;
import znick_.riskofrain2.api.ror.buff.PlayerStat;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.util.file.RiskOfRain2Files;

public class OddlyShapedOpalBuff extends Buff {

	public OddlyShapedOpalBuff(int itemCount) {
		super(RiskOfRain2Items.ODDLY_SHAPED_OPAL, itemCount);
	}

	@Override
	public ResourceLocation getIconTexture() {
		return new ResourceLocation(RiskOfRain2Files.BUFFS + "oddly_shaped_opal.png");
	}

	@Override
	public void applyEffect(PlayerData player) {
		player.addToStat(PlayerStat.ARMOR, 100 * this.getItemCount());
	}

	@Override
	public void removeEffect(PlayerData player) {
		player.addToStat(PlayerStat.ARMOR, -100 * this.getItemCount());
		player.addBuff(new OddlyShapedOpalCooldownBuff(this.getItemCount()));
	}

}