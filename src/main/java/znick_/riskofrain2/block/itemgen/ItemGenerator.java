package znick_.riskofrain2.block.itemgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.list.ScrapItem;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public interface ItemGenerator {
	
	public abstract RiskOfRain2Item generateItem(EntityPlayer player);
}
