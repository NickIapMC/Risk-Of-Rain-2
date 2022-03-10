package znick_.riskofrain2.block.lunarpod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import znick_.riskofrain2.RiskOfRain2;
import znick_.riskofrain2.block.itemblock.IBlockItem;
import znick_.riskofrain2.event.rorevents.ObjectInteractionEvent;
import znick_.riskofrain2.item.itemblock.ItemBlockLunarPod;
import znick_.riskofrain2.util.misc.customs.RiskOfRain2CreativeTabs;

public class LunarPod extends Block implements IBlockItem {

	private final IIcon[] textures = new IIcon[6];
	
	//TODO: Add lunar pod generation
	public LunarPod() {
		super(Material.cloth);
		this.setStepSound(soundTypeSnow);
		this.setBlockUnbreakable();
		this.setBlockTextureName(RiskOfRain2.MODID + ":lunarPod"); //TODO: Add lunar pod textures
		this.setCreativeTab(RiskOfRain2CreativeTabs.MISC);
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 0; i < 6; i++) {
			switch(i) {
			case 0:
				this.textures[i] = reg.registerIcon(RiskOfRain2.MODID + ":lunarPod/bottom");
				break;
			case 1:
				this.textures[i] = reg.registerIcon(RiskOfRain2.MODID + ":lunarPod/top");
				break;
			case 2:
				this.textures[i] = reg.registerIcon(RiskOfRain2.MODID + ":lunarPod/back");
				break;
			case 3:
				this.textures[i] = reg.registerIcon(RiskOfRain2.MODID + ":lunarPod/front");
				break;
			default:
				this.textures[i] = reg.registerIcon(RiskOfRain2.MODID + ":lunarPod/side");
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.textures[side];
	}

	//TODO: Add lunar coins
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		TileEntityLunarPod tile = (TileEntityLunarPod) world.getTileEntity(x, y, z);
		ObjectInteractionEvent event = new ObjectInteractionEvent(player, tile);
		if (!MinecraftForge.EVENT_BUS.post(event)) return false;
		//TODO: Add Lunar pod opening
		return true;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemBlockLunarPod.class;
	}

}