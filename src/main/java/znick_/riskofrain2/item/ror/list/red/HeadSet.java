package znick_.riskofrain2.item.ror.list.red;

import java.util.List;

import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.proc.type.OnHurtItem;
import znick_.riskofrain2.item.ror.proc.type.OnJumpItem;
import znick_.riskofrain2.item.ror.proc.type.OnKeyPressItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public class HeadSet extends RiskOfRain2Item implements OnJumpItem, OnHurtItem, OnKeyPressItem {

	public HeadSet() {
		super("head_set");
	}
	
	@Override
	public boolean shouldProcOnKeypress(KeyInputEvent event, AbstractEntityData player, int itemCount) {
		return Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed();
	}
	
	@Override
	public void procOnKeyPress(KeyInputEvent event, AbstractEntityData player, int itemCount) {
		player.getEntity().addVelocity(0, -3, 0);
		List<EntityLivingBase> entities = player.getWorld().getEntitiesWithinAABB(EntityLivingBase.class, player.radialBox(4));
		for (EntityLivingBase entity : entities) {
			if (entity == player.getEntity()) continue;
			entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player.getEntity()), 10);
		}
	}
	
	@Override
	public boolean shouldProcOnHurt(LivingHurtEvent event, AbstractEntityData player, int itemCount) {
		return event.source == DamageSource.fall;
	}
	
	@Override
	public void procOnHurt(LivingHurtEvent event, AbstractEntityData player, int itemCount) {
		event.setCanceled(true);
	}

	@Override
	public boolean shouldProcOnJump(LivingJumpEvent event, AbstractEntityData player, int itemCount) {
		return true;
	}
	
	@Override
	public void procOnJump(LivingJumpEvent event, AbstractEntityData player, int itemCount) {
		player.getEntity().addVelocity(0, itemCount, 0);
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.UTILITY;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.RED;
	}

	@Override
	public String getDescription() {
		return "Increase jump height. Crouch to slam down on the ground.";
	}
}
