package znick_.riskofrain2.item.ror.list.equipment;

import java.util.List;

import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.api.mc.data.PlayerData;
import znick_.riskofrain2.api.ror.buff.stat.EntityStat;
import znick_.riskofrain2.client.keybind.RiskOfRain2KeyBinds;
import znick_.riskofrain2.event.rorevents.EquipmentUsedEvent;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.proc.type.OnKeyPressItem;
import znick_.riskofrain2.item.ror.proc.type.OnUpdateItem;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public abstract class RiskOfRain2Equipment extends RiskOfRain2Item {

	/**
	 * The base cooldown for this equipment, meaning it is before any reductions from items 
	 * the player has. This is in ticks, not seconds.
	 *
	 */
	private int baseCooldown;
	
	//TODO: Add equipment gui
	protected RiskOfRain2Equipment(String name) {
		super(name);
		this.maxStackSize = 1;
	}
	
	/**
	 * Called when the player uses the equipment item. Used by subclasses to add the 
	 * activation behavior. This is activated after an equipment item is used, so if
	 * the {@link znick_.riskofrain2.event.rorevents.EquipmentUsedEvent EquipmentUsedEvent}
	 * is canceled, this will not be called. 
	 * 
	 * @param entity The entity that used the equipment. Usually a player, but certain special
	 * cases (such as scavengers) can use equipment as non-player entities, so implementations
	 * of this method should not assume the activator was a player.
	 */
	public abstract void activateEffect(AbstractEntityData entity);
	
	private void activate(AbstractEntityData player) {
		EquipmentUsedEvent event = new EquipmentUsedEvent(player.getEntity(), this);
		if (MinecraftForge.EVENT_BUS.post(event)) return;
		this.activateEffect(player);
	}
	
	protected void setBaseCooldown(int ticks) {
		this.baseCooldown = ticks;
	}
	
	/**Returns the {@link #baseCooldown} of this equipment. */
	public int getBaseCooldown() {
		return this.baseCooldown;
	}
	
	public int getModifiedCooldown(AbstractEntityData entity) {
		return this.getBaseCooldown() * (int) entity.getStat(EntityStat.EQUIPMENT_COOLDOWN_REDUCTION_PERCENTAGE);
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.EQUIPMENT;
	}

	@Override
	public ItemRarity getRarity() {
		return ItemRarity.EQUIPMENT;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean someParam) {
		super.addInformation(stack, player, info, someParam);
	}
}
