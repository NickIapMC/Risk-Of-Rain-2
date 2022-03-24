package znick_.riskofrain2.item.ror.list.white.critglasses;

import net.minecraft.util.ResourceLocation;
import znick_.riskofrain2.api.mc.data.EntityData;
import znick_.riskofrain2.api.ror.buff.EntityStat;
import znick_.riskofrain2.api.ror.buff.StatBuff;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;

public class CritGlassesBuff extends StatBuff {

	public CritGlassesBuff(int itemCount) {
		super(EntityStat.CRIT_CHANCE, itemCount);
	}

	@Override
	public double getStatAdditionAmount(EntityData entity) {
		return this.getItemCount() * 0.1; 
	}

	@Override
	public ResourceLocation getIconTexture() {
		return null;
	}
	
	@Override
	public RiskOfRain2Item[] getItems() {
		return new RiskOfRain2Item[] {RiskOfRain2Items.CRIT_GLASSES};
	}

}
