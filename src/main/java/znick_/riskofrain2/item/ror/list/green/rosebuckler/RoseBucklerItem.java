package znick_.riskofrain2.item.ror.list.green.rosebuckler;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import znick_.riskofrain2.api.mc.data.EntityData;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.proc.type.OnUpdateItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public class RoseBucklerItem extends RiskOfRain2Item implements OnUpdateItem {

	public RoseBucklerItem() {
		super("rose_buckler");
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.UTILITY;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.GREEN;
	}

	@Override
	public String getDescription() {
		return "Reduce incoming damage while sprinting.";
	}

	@Override
	public boolean shouldProcOnUpdate(LivingUpdateEvent event, EntityData player, int itemCount) {
		return true;
	}

	
	@Override
	public void procOnUpdate(LivingUpdateEvent event, EntityData player, int itemCount) {
		if (player.isSprinting()) player.addBuff(new RoseBucklerBuff(itemCount));
		else player.removeBuff(RoseBucklerBuff.class);
	}
}
