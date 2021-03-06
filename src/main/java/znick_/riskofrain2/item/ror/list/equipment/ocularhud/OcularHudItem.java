package znick_.riskofrain2.item.ror.list.equipment.ocularhud;

import znick_.riskofrain2.api.mc.data.AbstractEntityData;
import znick_.riskofrain2.item.ror.list.equipment.RiskOfRain2Equipment;

/**
 * Class for creating the Ocular Hud equipment item.
 * 
 * @author zNick_
 */
public class OcularHudItem extends RiskOfRain2Equipment {

	public OcularHudItem() {
		super("ocular_hud");
	}

	@Override
	public void activateEffect(AbstractEntityData player) {
		player.addBuff(new OcularHudBuff(1));
	}

	@Override
	public String getDescription() {
		return "Gain 100% Critical Strike Chance for 8 seconds.";
	}

}
