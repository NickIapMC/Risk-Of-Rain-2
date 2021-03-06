package znick_.riskofrain2.block.itemgen.printer;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import znick_.riskofrain2.block.itemgen.ItemGenerator;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.property.ItemRarity;
import znick_.riskofrain2.util.creativetabs.RiskOfRain2CreativeTabs;
import znick_.riskofrain2.util.helper.ArrayHelper;

/**
 * Class for creating the {@link znick_.riskofrain2.block.RiskOfRain2Blocks#PRINTER_3D 3DPrinter} block.
 * 
 * @author zNick_
 */
public class Printer3D extends Block implements ITileEntityProvider {
	
	/**
	 * Creates a new 3D Printer block.
	 */
	public Printer3D() {
		super(Material.rock);
		this.setBlockName("printer");
		this.setBlockUnbreakable();
		this.opaque = false;
		this.setCreativeTab(RiskOfRain2CreativeTabs.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntity3DPrinter(generateItem()); //TODO: Add Boss printer
	}
	
	private static RiskOfRain2Item generateItem() {
		double rand = Math.random();
		if (rand < 0.099) return ArrayHelper.randomElement(RiskOfRain2Items.itemSubset(item -> !item.isExcludedFrom3DPrinters() && item.getRarity() == ItemRarity.RED));
		if (rand < 0.198) return ArrayHelper.randomElement(RiskOfRain2Items.itemSubset(item -> !item.isExcludedFrom3DPrinters() && item.getRarity() == ItemRarity.GREEN));
		return ArrayHelper.randomElement(RiskOfRain2Items.itemSubset(item -> !item.isExcludedFrom3DPrinters() && item.getRarity() == ItemRarity.RED));
	}
	
	/**
	 * Called when the printer is right clicked. If it 
	 * {@link znick_.riskofrain2.block.itemgen.printer.TileEntity3DPrinter#print(EntityPlayer) prints}, the printer sound
	 * will play.
	 * 
	 * @param world The world the block is in
	 * @param x The x-coordinate of the block
	 * @param y The y-coordinate of the block
	 * @param z The z-coordinate of the block
	 * @param player The player who clicked the block
	 * @param side The side of the block that was clicked
	 * @param hitX Where in the x-direction the block was clicked
	 * @param hitY Where in the y-direction the block was clicked
	 * @param hitZ Where in the z-direction the block was clicked
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity3DPrinter tile = (TileEntity3DPrinter) world.getTileEntity(x, y, z);
		if (!tile.isOnCooldown()) tile.preOpen(player);
		return true;
	}

	@Override
	public boolean isBlockNormalCube() {
		return false;
	}

	@Override
	public boolean isNormalCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
        return false;
    }

	@Override
	public int getRenderType() {
		return Render3DPrinter.RENDER_ID;
	}
	
}
