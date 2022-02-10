package znick_.riskofrain2.api.ror.items.list.lunar;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import znick_.riskofrain2.api.mc.data.PlayerData;
import znick_.riskofrain2.api.ror.buff.PlayerStat;
import znick_.riskofrain2.api.ror.items.RiskOfRain2Item;
import znick_.riskofrain2.api.ror.items.proc.type.OnHitItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnHurtItem;
import znick_.riskofrain2.api.ror.items.property.ItemCategory;
import znick_.riskofrain2.api.ror.items.property.ItemRarity;

public class ShapedGlass extends RiskOfRain2Item implements OnHitItem, OnHurtItem {

	public ShapedGlass() {
		super("shaped_glass");
	}
	
	@Override
	public void procOnHurt(LivingHurtEvent event, PlayerData player, int itemCount) {
		event.ammount *= 2;
	}

	@Override
	public boolean shouldProcOnHurt(LivingHurtEvent event, PlayerData player, int itemCount) {
		return true;
	}
 
	@Override
	public void procOnHit(LivingAttackEvent event, PlayerData player, EntityLivingBase enemy, int itemCount) {
		player.addToStat(PlayerStat.DAMAGE_MULTIPLIER, itemCount);
	}

	@Override
	public boolean shouldProcOnHit(LivingAttackEvent event, PlayerData player, EntityLivingBase enemy, int itemCount) {
		return true;
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.DAMAGE;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.LUNAR;
	}

	@Override
	public String getDescription() {
		return "Double your damage..."  + (EnumChatFormatting.RED + "BUT halve your health.");
	}
	
	@Override
	protected List<String> getSplicedDesc() {
		List<String> desc = new ArrayList<String>();
		desc.add("Double your damage...");
		desc.add(EnumChatFormatting.RED + "BUT halve your health.");
		return desc;
	}

}
