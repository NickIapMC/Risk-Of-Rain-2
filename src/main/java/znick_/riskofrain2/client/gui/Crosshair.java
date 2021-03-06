package znick_.riskofrain2.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import znick_.riskofrain2.RiskOfRain2Mod;
import znick_.riskofrain2.util.file.RiskOfRain2Resources;

/**
 * Class for creating custom crosshairs for different characters.
 * 
 * @author zNick_
 */
public class Crosshair {

	/**The texture of the crosshair*/
	private final ResourceLocation texture;
	/**The scale of the crosshair*/
	private final double scale;
	
	/**
	 * Creates a new {@code Crosshair}. 
	 * 
	 * @param texture The texture of the crosshair
	 * @param scale The scale factor of the crosshair
	 */
	public Crosshair(String texture, double scale) {
		this.texture = RiskOfRain2Resources.get(RiskOfRain2Resources.GUI + "survivor/" + texture);
		this.scale = scale;
	}
	
	/**
	 * Returns the texture of this crosshair as a {@code ResourceLocation}.
	 */
	public ResourceLocation getTexture() {
		return this.texture;
	}
	
	/**
	 * Renders the crosshair onto the screen.
	 * 
	 * @param gui The GUI instance to render the crosshair on.
	 */
	public void render(Gui gui) {
		GuiIngameForge.renderCrosshairs = false;
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.getTexture());
		GL11.glPushMatrix();
		
		GL11.glScaled(this.scale, this.scale, this.scale);
        gui.drawTexturedModalRect((int) ((1/this.scale) * width/2 - 128), (int) ((1/this.scale) * height/2 - 128), 0, 0, 256, 256);
        
        GL11.glPopMatrix();
	}
}
