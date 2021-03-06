package znick_.riskofrain2.item.ror.list.green;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.list.red.brilliantbehemoth.FriendlyExplosion;
import znick_.riskofrain2.item.ror.proc.type.OnKillItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public class WillOTheWisp extends RiskOfRain2Item implements OnKillItem {

	public WillOTheWisp() {
		super("will_o_the_wisp");
	}
	
	@Override
	public void procOnKill(LivingDeathEvent event, AbstractEntityData player, EntityLivingBase enemy, int itemCount) {
		FriendlyExplosion.explodeMob(enemy, player.getEntity(), itemCount);
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.DAMAGE;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.GREEN;
	}

	@Override
	public String getDescription() {
		return "Detonate enemies on kill.";
	}
}
