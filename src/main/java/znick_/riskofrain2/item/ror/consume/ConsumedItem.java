package znick_.riskofrain2.item.ror.consume;

import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.dlc.DLC;
import znick_.riskofrain2.item.ror.property.ItemCategory;
import znick_.riskofrain2.item.ror.property.ItemRarity;

public abstract class ConsumedItem extends RiskOfRain2Item {

	private final RiskOfRain2Item item;
	
	protected ConsumedItem(String name, RiskOfRain2Item item) {
		super(name);
		this.item = item;
	}

	@Override
	public ItemCategory getCategory() {
		return this.item.getCategory();
	}

	@Override
	public ItemRarity getRarity() {
		return this.item.getRarity();
	}
	
	@Override
	public DLC getDLC() {
		return this.item.getDLC();
	}
	
	@Override
	public boolean isExcludedFromLogbook() {
		return true;
	}

}
