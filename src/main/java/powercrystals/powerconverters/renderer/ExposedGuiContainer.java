package powercrystals.powerconverters.renderer;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.inventory.Container;

public abstract class ExposedGuiContainer extends GuiContainer 
{

    public ExposedGuiContainer(Container container) 
    {
        super(container);
    }

    @Override
    public void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) 
    {
        super.drawGradientRect(par1, par2, par3, par4, par5, par6);
    }

    public RenderItem getItemRenderer() 
    {
        return GuiScreen.itemRender;
    }

    public int getGuiTop() 
    {
        return guiTop;
    }

    public void setZLevel(float zLevel) 
    {
        this.zLevel = zLevel;
    }

    public FontRenderer getFontRenderer() 
    {
        return fontRendererObj;
    }
}
