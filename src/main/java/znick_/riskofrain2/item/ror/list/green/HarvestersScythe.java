package znick_.riskofrain2.item.ror.list.green;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.proc.type.OnHitItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public class HarvestersScythe extends RiskOfRain2Item implements OnHitItem {

	public HarvestersScythe() {
		super("harvesters_scythe");
	}
	
	@Override
	public void procOnHit(LivingAttackEvent event, AbstractEntityData player, EntityLivingBase enemy, int itemCount) {
		if (!player.getWorld().isRemote) player.heal(2 + itemCount * 2);
	}

	@Override
	public boolean shouldProcOnHit(LivingAttackEvent event, AbstractEntityData player, EntityLivingBase enemy, int itemCount) {
		return false; //Only procced manually in CritGlasses.java
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.HEALING;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.GREEN;
	}

	@Override
	public String getDescription() {
		return "\'Critical Strikes\' heal you.";
	}
}
