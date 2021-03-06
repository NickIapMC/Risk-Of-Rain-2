package znick_.riskofrain2.item.ror.property;

import net.minecraft.util.EnumChatFormatting;

/**
 * Rarities for {@link znick_.riskofrain2.item.ror.RiskOfRain2Item RiskOfRain2Items}, such as white or red.
 * 
 * @author zNick_
 */
public enum ItemRarity {
	
	/**The white rarity, used for common items.*/
	WHITE(EnumChatFormatting.WHITE),
	GREEN(EnumChatFormatting.GREEN),
	RED(EnumChatFormatting.RED),
	BOSS(EnumChatFormatting.YELLOW),
	LUNAR(EnumChatFormatting.BLUE),
	EQUIPMENT(EnumChatFormatting.GOLD),
	VOID(EnumChatFormatting.LIGHT_PURPLE);
	
	/**The color associated with the rarity.*/
	private final EnumChatFormatting color;
	
	/**
	 * Creates a new rarity with the given color.
	 * 
	 * @param color The color associated with the rarity.
	 */
	private ItemRarity(EnumChatFormatting color) {
		this.color = color;
	}
	
	/**
	 * Returns the color of the rarity.
	 */
	public EnumChatFormatting getColor() {
		return this.color;
	}
}
