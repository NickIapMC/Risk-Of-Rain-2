package znick_.riskofrain2.block.itemgen.lunarpod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import znick_.riskofrain2.RiskOfRain2Mod;
import znick_.riskofrain2.block.itemblock.IBlockItem;
import znick_.riskofrain2.util.creativetabs.RiskOfRain2CreativeTabs;

public class LunarPod extends Block implements IBlockItem {

	private final IIcon[] textures = new IIcon[6];
	
	//TODO: Add lunar pod generation
	public LunarPod() {
		super(Material.cloth);
		this.setBlockName("lunar_pod");
		this.setStepSound(soundTypeSnow);
		this.setBlockUnbreakable();
		this.setBlockTextureName(RiskOfRain2Mod.MODID + ":lunar_pod"); //TODO: Add lunar pod textures
		this.setCreativeTab(RiskOfRain2CreativeTabs.BLOCKS);
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 0; i < 6; i++) {
			switch(i) {
			case 0:
				this.textures[i] = reg.registerIcon(RiskOfRain2Mod.MODID + ":lunarPod/bottom");
				break;
			case 1:
				this.textures[i] = reg.registerIcon(RiskOfRain2Mod.MODID + ":lunarPod/top");
				break;
			case 2:
				this.textures[i] = reg.registerIcon(RiskOfRain2Mod.MODID + ":lunarPod/back");
				break;
			case 3:
				this.textures[i] = reg.registerIcon(RiskOfRain2Mod.MODID + ":lunarPod/front");
				break;
			default:
				this.textures[i] = reg.registerIcon(RiskOfRain2Mod.MODID + ":lunarPod/side");
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.textures[side];
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		TileEntityLunarPod tile = (TileEntityLunarPod) world.getTileEntity(x, y, z);
		return tile.open(player);
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemBlockLunarPod.class;
	}

}
