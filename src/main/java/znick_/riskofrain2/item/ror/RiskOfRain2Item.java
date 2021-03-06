package znick_.riskofrain2.item.ror;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import znick_.riskofrain2.RiskOfRain2Mod;
import znick_.riskofrain2.item.ror.dlc.DLC;
import znick_.riskofrain2.item.ror.property.CustomRarity;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;
import znick_.riskofrain2.item.util.Artist;
import znick_.riskofrain2.util.achievement.RiskOfRain2Achievement;
import znick_.riskofrain2.util.creativetabs.RiskOfRain2CreativeTabs;
import znick_.riskofrain2.util.file.RiskOfRain2Resources;

/**
 * Class used for creating items that are in the Risk of Rain 2 game. 
 * 
 * @author zNick_ 
 */
public abstract class RiskOfRain2Item extends Item {
	
	/**The name of the item.*/
	private final String name;

	/**
	 * Creates a new {@code RiskOfRain2Item} with the given name.
	 * 
	 * @param name The name of the item. The name is used as the unlocalized name to register the item into
	 * the game and the name of the location for the item's texture. The name should be in all lowercase 
	 * and not include whitespaces, but rather underscores.
	 */
	protected RiskOfRain2Item(String name) {
		this.name = name;
		this.setTextureName(RiskOfRain2Mod.MODID + ":items/" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(RiskOfRain2CreativeTabs.ITEMS);
	}
	
	/**
	 * Returns the texture of this item as a {@code ResourceLocation}.
	 */
	public ResourceLocation getTexture() {
		return RiskOfRain2Resources.get(RiskOfRain2Resources.ITEMS + "items/" + this.name + ".png");
	}

	/**
	 * Adds lines of information to the description of the item when hovering over it with the mouse in
	 * the inventory GUI. Specifies rarity, category, and description.
	 * 
	 * @param stack The item stack to hover over.
	 * @param player The player who has the item.
	 * @param info The tooltip list of strings to add to the description. Each string entry in the list
	 * is one line in the description.
	 * @param isAdvanced Whether or not advanced tooltips are enabled.
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean isAdvanced) {
		
		// Check if the shift key is NOT down
		if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			// Add the "shift for info" prompt
			info.add(EnumChatFormatting.DARK_GRAY + "Hold shift for info...");
		} 
		
		// Check if the shift key IS held down
		else {
			for (int i = 0; i < this.getSplicedDesc().size(); i++) {
				info.add(EnumChatFormatting.GRAY + this.getSplicedDesc().get(i));
			}
			// Add a blank line
			info.add("");

			// Add the rarity
			String rar = Character.toString(this.getRarity().toString().charAt(0)).toUpperCase() + this.getRarity().toString().substring(1).toLowerCase();
			info.add("Rarity: " + this.getRarity().getColor() + rar);
			
			// Add the category
			if (this.getCategory() != ItemCategory.UNKNOWN) {
				String cat = Character.toString(this.getCategory().toString().charAt(0)).toUpperCase() + this.getCategory().toString().substring(1).toLowerCase();
				info.add("Category: " + this.getCategory().getColor() + cat);
			}
			
			// Add the DLC info
			if (this.getDLC() != DLC.BASE_GAME) {
				info.add("DLC: " + (this.getDLC().getColor() + this.getDLC().toString()));
			}
			
			// Add artist info
			if (this.getArtist() != Artist.NICK) {
				info.add(EnumChatFormatting.DARK_GRAY + "Art by " + this.getArtist());
			}
		}
	}
	
	/**
	 * Returns the artist that drew the texture for this item. By default it is me, Nick.
	 * If it is not me, the artist will be credited in the item description.
	 * 
	 * @return The artist who made the sprite texture for this item. 
	 */
	protected Artist getArtist() {
		return Artist.NICK;
	}
	
	/**
	 * Returns the rarity of this item.
	 * 
	 * @param stack The item stack to get the rarity of.
	 * 
	 * @see znick_.riskofrain2.item.ror.property.CustomRarity CustomRarity
	 */
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		switch(this.getRarity()) {
		case GREEN: return CustomRarity.GREEN;
		case RED: return CustomRarity.RED;
		case LUNAR: return CustomRarity.BLUE;
		case BOSS: return EnumRarity.uncommon;
		case EQUIPMENT: return CustomRarity.EQUIPMENT;
		case VOID: return EnumRarity.epic;
		default: return EnumRarity.common;
		}
	}

	/**
	 * Returns the description of this item broken up into lines of
	 * acceptable size. This is the method that is called to add the information to
	 * the item in the inventory GUI, so if an item needs a custom description it should
	 * override this method instead of {@link #getDescription()}.
	 */
	protected List<String> getSplicedDesc() {
		String localDesc = this.getDescription();
		List<String> splicedDesc = new ArrayList<String>();
		
		int maxLineLength = 25;
		int lastSpaceIndex = 0;
		
		EnumChatFormatting color = null;
		String colorName = "";
		boolean colorLine = false;
		
		while (true) {
			
			// If what's left is less than the max limit (the end of the desc) just add it and stop.
			if (localDesc.length() < maxLineLength) {
				if (!colorLine) splicedDesc.add(colorName + localDesc);
				else splicedDesc.add(localDesc);
				break;
			}
			
			// Otherwise, loop through every character
			for (int i = 0; i < maxLineLength; i++) {
				if (localDesc.charAt(i) == ' ') lastSpaceIndex = i;
				else if (localDesc.charAt(i) == '\u00a7') {
					char code = localDesc.charAt(i + 1);
					for (EnumChatFormatting ecf : EnumChatFormatting.values()) {
						if (ecf.getFormattingCode() == code) {
							color = ecf;
							colorName = color.toString();
							colorLine = true;
							break;
						}
					}
				}
			}
			
			// Splice the description at the last space to not cut words in half
			if (!colorLine) splicedDesc.add(colorName + localDesc.substring(0, lastSpaceIndex));
			else {
				splicedDesc.add(localDesc.substring(0, lastSpaceIndex));
				colorLine = false;
			}
			
			// Remove the used part of the description and loop
			localDesc = localDesc.substring(lastSpaceIndex + 1);
		}

		return splicedDesc;
	}
	
	/**Returns the category of this item. Used by category chests to determine if an item is valid for it.*/
	public abstract ItemCategory getCategory();
	
	/**Returns the rarity of this item.*/
	public abstract ItemRarity getRarity();
	
	/**
	 * Returns the description of this item. Descriptions should follow the Risk Of Rain 2 in-game descriptions
	 * exactly, unless there is a specific reason to not do so, such as if the item has different behavior in
	 * the mod than in the original game.
	 */
	public abstract String getDescription();
	
	/**
	 * Returns whether or not this is a special item that should not be included in the logbook, 
	 * such as consumed items.
	 */
	public boolean isExcludedFromLogbook() {
		return false;
	}
	
	/**
	 * Returns whether or not this item should be excluded from 3D printers. By default, this
	 * returns the same result as {@link #isExcludedFromChests()}. However, some items, such as
	 * regenerating scrap, can be found in chests, but not 3D printed. Such items should override
	 * this method. 
	 */
	public boolean isExcludedFrom3DPrinters() {
		return this.isExcludedFromChests();
	}
	
	/**
	 * Returns whether or not this item should be excluded from chest generation, such as 
	 * item scrap. By default this returns the result of {@link #isExcludedFromLogbook()}.
	 */
	public boolean isExcludedFromChests() {
		return this.isExcludedFromLogbook();
	}
	
	@Override
	public String toString() {
		return "Risk Of Rain 2 Item: " + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
	
	/**
	 * Returns the DLC pack that this item is from.
	 */
	public DLC getDLC() {
		return DLC.BASE_GAME;
	}

	/**
	 * Returns whether or not this item is unlocked by default, meaning it does not require any steps or
	 * achievement to unlock.
	 */
	public boolean isUnlockedByDefault() {
		return this.getAchievement() == null;
	}
	
	/**
	 * Returns the achievement required to unlock this item. null by default. Subclasses for items
	 * that require unlocking should override this and put an achievement
	 */
	public RiskOfRain2Achievement getAchievement() {
		return null;
	}
}
