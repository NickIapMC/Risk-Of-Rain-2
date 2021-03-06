package znick_.riskofrain2.item.ror.list.white;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.proc.type.OnUpdateItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public class BisonSteak extends RiskOfRain2Item implements OnUpdateItem {

	public BisonSteak() {
		super("bison_steak");
	}
	
	@Override
	public void procOnUpdate(LivingUpdateEvent event, AbstractEntityData player, int itemCount) {
		player.addToMaxHealth(2 * itemCount);
	}

	@Override
	public boolean shouldProcOnUpdate(LivingUpdateEvent event, AbstractEntityData player, int itemCount) {
		return true;
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.HEALING;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.WHITE;
	}

	@Override
	public String getDescription() {
		return "Regenerate health after killing an enemy.";
	}
}
