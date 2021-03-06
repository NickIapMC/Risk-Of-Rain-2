package znick_.riskofrain2.item.ror.list.white;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.proc.type.OnHitItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public class TriTipDagger extends RiskOfRain2Item implements OnHitItem {
	
	public TriTipDagger() {
		super("tritip_dagger");
	}
	
	@Override
	public void procOnHit(LivingAttackEvent event, AbstractEntityData player, EntityLivingBase enemy, int count) {
		enemy.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
	}

	@Override
	public boolean shouldProcOnHit(LivingAttackEvent event, AbstractEntityData player, EntityLivingBase enemy, int itemCount) {
		return player.rollStat(0.15f * itemCount);
	}
	
	@Override
	public ItemCategory getCategory() {
		return ItemCategory.DAMAGE;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.WHITE;
	}

	@Override
	public String getDescription() {
		return "Chance to bleed enemies on hit.";
	}
}