package znick_.riskofrain2.api.ror.items.list.white;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import znick_.riskofrain2.api.mc.PlayerData;
import znick_.riskofrain2.api.ror.buff.PlayerStat;
import znick_.riskofrain2.api.ror.items.RiskOfRain2Item;
import znick_.riskofrain2.api.ror.items.proc.type.OnHitItem;
import znick_.riskofrain2.api.ror.items.property.ItemCategory;
import znick_.riskofrain2.api.ror.items.property.ItemRarity;

public class Crowbar extends RiskOfRain2Item implements OnHitItem {
	
	public Crowbar() {
		super("crowbar");
	}
	
	@Override
	public void procOnHit(LivingAttackEvent event, PlayerData player, EntityLivingBase enemy, int itemCount) {
		player.multiplyStat(PlayerStat.DAMAGE_MULTIPLIER, 1 + 0.75 * itemCount);
		player.playSound("ror2:crowbar");
	}
	
	@Override
	public boolean shouldProcOnHit(LivingAttackEvent event, PlayerData player, EntityLivingBase enemy, int itemCount) {
		return enemy.getHealth() > 0.9 * enemy.getMaxHealth();
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
		return "Deal more damage to healthy enemies.";
	}

}