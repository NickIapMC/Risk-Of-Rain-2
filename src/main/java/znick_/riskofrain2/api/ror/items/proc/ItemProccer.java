package znick_.riskofrain2.api.ror.items.proc;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import znick_.riskofrain2.RiskOfRain2;
import znick_.riskofrain2.api.mc.PlayerData;
import znick_.riskofrain2.api.ror.buff.Buff;
import znick_.riskofrain2.api.ror.buff.DurationBuff;
import znick_.riskofrain2.api.ror.buff.PlayerStat;
import znick_.riskofrain2.api.ror.items.RiskOfRain2Item;
import znick_.riskofrain2.api.ror.items.proc.type.OnHealItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnHitItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnHurtItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnJumpItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnKeyPressItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnKillItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnPickupXPItem;
import znick_.riskofrain2.api.ror.items.proc.type.OnUpdateItem;
import znick_.riskofrain2.event.Tick;
import znick_.riskofrain2.event.handler.EventHandler;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.util.helper.InventoryHelper;
import znick_.riskofrain2.util.misc.UniqueDamageSource;

public class ItemProccer extends EventHandler {
	
	/**
	 * Called when the player attacks an enemy. Procs all on-hit items if they should.
	 * 
	 * @param event {@code LivingAttackEvent}
	 */
	@SubscribeEvent
	public void procOnHitItems(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer && 
		    !(event.source instanceof UniqueDamageSource) && 
		    event.source.getEntity() != null) {
			
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			PlayerData data = PlayerData.get(player);
			
			//Loops through all RoR2 Items
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				//Checks if the item is on-hit and the player has some
				if (count > 0 && item instanceof OnHitItem) {
					OnHitItem onHit = (OnHitItem) item;
					//Proc the item if it succeeds
					if (onHit.shouldProcOnHit(event, data, event.entityLiving, count)) {
						onHit.procOnHit(event, data, event.entityLiving, count);
					}
				}
			}
			
			/*
			 * The damage in LivingAttackEvent cannot be changed, so the event must be canceled
			 * and a new event must be fired with the new damage value. A UniqueDamageSource must
			 * be used to prevent a stack overflow of infinite recursion. I could change the final
			 * value with reflection, but I'm unsure about whether it would actually affect the
			 * damage or how it would behave, so this is safest.
			 */
			if (data.getStat(PlayerStat.DAMAGE_MULTIPLIER) != 1) {
				event.setCanceled(true);
				event.entity.attackEntityFrom(new UniqueDamageSource(player), (float) (event.ammount * data.getStat(PlayerStat.DAMAGE_MULTIPLIER)));
			}
		}
	}
	
	/**
	 * Called when the player kills an entity. Procs any Risk of Rain 2 items that should proc.
	 * 
	 * @param event The {@code LivingDeathEvent event}
	 */
	@SubscribeEvent
	public void procOnKillItems(LivingDeathEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			PlayerData data = PlayerData.get(player);
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				if (count > 0 && item instanceof OnKillItem) {
					OnKillItem onKill = (OnKillItem) item;
					onKill.procOnKill(event, data, event.entityLiving, count);
				}
			}
		}
	}
	
	/**
	 * Called every time the player is updated. Procs any items the player has that
	 * should be procced on update if the roll suceeds.
	 * 
	 * @param event The {@code LivingUpdateEvent} to use.
	 */
	@SubscribeEvent
	public void procOnUpdateItems(LivingUpdateEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			PlayerData data = PlayerData.get(player);
			
			//Loop through all Risk Of Rain 2 Items
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				if (item instanceof OnUpdateItem) {
					
					//Proc the item if meant to
					if (count > 0) {
						OnUpdateItem onUpdate = (OnUpdateItem) item;
						if (onUpdate.shouldProcOnUpdate(event, data, count)) {
							onUpdate.procOnUpdate(event, data, count);
						}
					}
				}
			}
			
			//Check all buffs
			for (Buff buff : data.getBuffs()) {
				//Remove all expired duration buffs
				if (buff instanceof DurationBuff) {
					DurationBuff db = (DurationBuff) buff;
					if (db.getStartTick() + db.getDuration() < Tick.server()) {
						data.removeBuff(db);
					}
				}
				//Remove all buffs that correspond to the items that the player no longer has 
				if (InventoryHelper.amountOfItems(player, buff.getItem()) <= 0) data.removeBuff(buff);
			}
			
			data.applyStat(PlayerStat.MOVEMENT_SPEED_MULTIPLIER);
		}
	}
	
	/**
	 * Called when the player is healed. Procs all on-heal items if they should proc.
	 * 
	 * @param event The {@code LivingHealEvent} 
	 */
	@SubscribeEvent
	public void procOnHealItems(LivingHealEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			PlayerData data = PlayerData.get(player);
			
			//Loop Through all Risk of Rain 2 Items
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				//Check if the item is an on-heal item and the player has one
				if (count > 0 && item instanceof OnHealItem) {
					OnHealItem onHeal = (OnHealItem) item;
					//Proc the item
					onHeal.procOnHeal(event, data, count);
				}
			}
		}
	}
	
	/**
	 * Called when the player jumps. Procs all on-jump items that should proc.
	 * 
	 * @param event The {@code LivingJumpEvent}.
	 */
	@SubscribeEvent
	public void procOnJumpItems(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			PlayerData data = PlayerData.get(player);
			
			//Loop through all Risk of Rain 2 Items
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				//Check if the item is meant to proc on-jump and if the player has it
				if (count > 0 && item instanceof OnJumpItem) {
					OnJumpItem onJump = (OnJumpItem) item;
					//Procs the item if it should
					if (onJump.shouldProcOnJump(event, data, count)) {
						onJump.procOnJump(event, data, count);
					}
				}
			}
		}
	}
	
	/**
	 * Called when an entity is hurt. If it is a player, it will proc all necessary items the player has
	 * if they should proc.
	 * 
	 * @param event The {@code LivingHurtEvent}.
	 */
	@SubscribeEvent
	public void procOnHurtItems(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			PlayerData data = PlayerData.get(player);
			if (RiskOfRain2.DEBUG) System.out.println("Player " + player.getDisplayName() + " has taken damage...");
			
			//Proc all on-hurt items if able to
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				//Check if the item is an on-hurt item and if the player has it
				if (count > 0 && item instanceof OnHurtItem) {
					if (RiskOfRain2.DEBUG) System.out.println("Attempting to proc " + item.getClass().getSimpleName());
					OnHurtItem onHurt = (OnHurtItem) item;
					//Rolls if the event should proc and if so, procs it
					if (onHurt.shouldProcOnHurt(event, data, count)) {
						onHurt.procOnHurt(event, data, count);
						if (RiskOfRain2.DEBUG) System.out.println("Sucessfully procced " + item.getClass().getSimpleName());
					} else if (RiskOfRain2.DEBUG) System.out.println("Failed! Not proccing " + item.getClass().getSimpleName());
				}
			}
			
			//Apply damage reduction from armor
			double armor = data.getStat(PlayerStat.ARMOR);
			event.ammount *= (1 - (armor/(100 + Math.abs(armor))));
		}
	}
	
	/**
	 * Called when a key is pressed. Procs all Risk Of Rain 2 items that should proc on
	 * key press. 
	 * 
	 * @param event The {@code KeyInputEvent event}
	 */
	@SubscribeEvent
	public void procOnKeyPressItems(KeyInputEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		PlayerData data = PlayerData.get(player);
		
		//Loop through all Risk Of Rain 2 items
		for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
			int count = InventoryHelper.amountOfItems(player, item);
			//Checks if the item procs on key press and if the player has any
			if (count > 0 && item instanceof OnKeyPressItem) {
				if (RiskOfRain2.DEBUG) System.out.println("Attempting to proc " + item.getClass().getSimpleName() + "...");
				OnKeyPressItem onKeyPress = (OnKeyPressItem) item;
				//Attempts to proc the item
				if (onKeyPress.shouldProcOnKeypress(event, data, count)) {
					onKeyPress.procOnKeyPress(event, data, count);
					if (RiskOfRain2.DEBUG) System.out.println("Sucessfully procced " + item.getClass().getSimpleName());
				} else if (RiskOfRain2.DEBUG) System.out.println("Failed! Not proccing " + item.getClass().getSimpleName());
			}
		}
	}
	
	/**
	 * Called when the player picks up XP. Procs any Risk Of Rain 2 items that should proc on
	 * XP pickup. 
	 * 
	 * @param event The {@code PlayerPickupXpEvent}.
	 */
	@SubscribeEvent
	public void procOnXPPickupItems(PlayerPickupXpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			PlayerData data = PlayerData.get(player);
			
			//Loops through all Risk Of Rain 2 Items
			for (RiskOfRain2Item item : RiskOfRain2Items.ITEM_SET) {
				int count = InventoryHelper.amountOfItems(player, item);
				//Checks if the item is on-xp-pickup and if the player has it
				if (count > 0 && item instanceof OnPickupXPItem) {
					OnPickupXPItem onXP = (OnPickupXPItem) item;
					//Procs the item
					onXP.procOnXPPickup(event, data, count);
				}
			}
		}
	}
	
}