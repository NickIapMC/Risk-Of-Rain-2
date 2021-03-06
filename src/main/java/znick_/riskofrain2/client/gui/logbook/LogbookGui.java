package znick_.riskofrain2.client.gui.logbook;

import java.awt.Color;
import java.awt.Point;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import znick_.riskofrain2.RiskOfRain2Mod;
import znick_.riskofrain2.client.gui.GuiHandler;
import znick_.riskofrain2.client.render.RenderHelper;
import znick_.riskofrain2.item.RiskOfRain2Items;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.util.file.RiskOfRain2Resources;

/**
 * The GUI class for the Logbook.
 * 
 * @author zNick_
 */
public class LogbookGui extends GuiScreen {

	/**The GUI ID for the Logbook GUI*/
	public static final int GUI_ID = GuiHandler.getNextID(LogbookGui.class);
	
	private Point itemsUpperLeft;
	private Point itemsUpperRight;
	private Point itemsLowerLeft;
	private Point padding;
	
	/**
	 * Creates a new {@code LogbookGui} at the given coordinates.
	 * 
	 * @param x The x-coordinate of the GUI
	 * @param y The y-coordinate of the GUI
	 * @param z The z-coordinate of the GUI
	 */
	public LogbookGui(int x, int y, int z) {
		super();
	}
	
	@Override
	public void initGui() {
		this.initPoints();
		this.addItemButtons();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTick) {
		this.drawBackground();
		super.drawScreen(mouseX, mouseY, partialTick);
		this.drawItemOutline();
		this.drawSelectedButtonOutline();
		this.drawLabel();
	}
	
	/**
	 * Draws the logbook title label.
	 */
	private void drawLabel() {
		this.drawString(
			this.mc.fontRenderer, 
			"Item & Equipment", 
			this.itemsUpperLeft.x - this.padding.x, 
			this.itemsUpperLeft.y - this.width/25, 
			Color.WHITE.getRGB()
		);
	}
	
	/**
	 * Initializes the points for where items will be drawn. 
	 */
	private void initPoints() {
		this.padding = new Point(this.width/50, this.width/100);
		this.itemsUpperLeft = new Point(this.width/12, this.width/6);
		this.itemsUpperRight = new Point(0, this.width/10);
		this.itemsLowerLeft = new Point();
	}
	
	private void drawItemOutline() {
		RenderHelper.drawRectOutline(this, 
			this.itemsUpperLeft.x - this.padding.x, 
			this.itemsUpperLeft.y - this.padding.y, 
			this.itemsUpperRight.x + this.padding.x - this.width/300, 
			this.itemsLowerLeft.y + this.padding.y, 
			this.width/300, 
			new Color(28, 38, 50)
		);
	}
	
	/**
	 * Draws the outline of the selected button. This method would be preferable in the 
	 * {@link ItemButton} class, howevever if it was, the outline would be drawn underneath
	 * other buttons. Thus, it must be here to draw the outline overtop of all buttons.
	 */
	private void drawSelectedButtonOutline() {
		int p = 2;
		for (Object obj : this.buttonList) {
			GuiButton button = (GuiButton) obj;
			if (button instanceof ItemButton) {
				ItemButton itemButton = (ItemButton) button;
				if (itemButton.isSelected()) {
					RenderHelper.drawRectOutline(
						this, 
						itemButton.xPosition - p - 1, 
						itemButton.yPosition - p - 1, 
						itemButton.xPosition + itemButton.width + p, 
						itemButton.yPosition + itemButton.height + p, 
						1, 
						Color.WHITE
					);
				}
			}
		}
	}

	/**
	 * Draws the background image for the logbook gui.
	 */
	private void drawBackground() {
		GL11.glPushMatrix();
		this.mc.getTextureManager().bindTexture(RiskOfRain2Resources.get(RiskOfRain2Mod.MODID + ":textures/gui/logbook/background.png"));
		int d = 256;
		int s = 3;
		int i = 0;
		int j = 0;
		GL11.glScaled(1d / s, 1d / s, 1d / s);
		while (j <= this.height * s) {
			this.drawTexturedModalRect(i, j, 0, 0, d, d);
			i += d;
			if (i > this.width * s) {
				i = 0;
				j += d;
			}
		}
		GL11.glPopMatrix();
	}

	/**
	 * Adds all of the {@link ItemButton ItemButtons} to the button list.
	 */
	private void addItemButtons() {
		int d = this.width/24;
		Point itemPoint = new Point();
		int column = 0;
		int row = 0;
		int nextID = 0;
		int space = d/12;
		for (RiskOfRain2Item item : RiskOfRain2Items.itemSubset(item -> !item.isExcludedFromLogbook())) {
			if (item.isExcludedFromLogbook()) continue;
			this.buttonList.add(new ItemButton(nextID++, item, this.itemsUpperLeft.x + itemPoint.x, this.itemsUpperLeft.y + itemPoint.y, d, d));
			itemPoint.x += d + space;
			
			column++;
			
			if (column > 13) {
				this.itemsUpperRight.x = itemPoint.x + this.itemsUpperLeft.x;
				column = 0;
				row++;
				itemPoint.x = 0;
				itemPoint.y += d + space;
			}
			
			if (row > 8) {
				break;
			}
		}
		this.itemsLowerLeft.y = this.itemsUpperLeft.y + itemPoint.y + d;
	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button instanceof ItemButton) {
			ItemButton itemButton = (ItemButton) button;
		}
	}
}
