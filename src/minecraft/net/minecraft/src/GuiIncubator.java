// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerIncubator, FontRenderer, RenderEngine, 
//            TileEntityIncubator, InventoryPlayer

public class GuiIncubator extends GuiContainer
{

    public GuiIncubator(InventoryPlayer inventoryplayer, TileEntityIncubator tileentityincubator)
    {
        super(new ContainerIncubator(inventoryplayer, tileentityincubator));
        IncubatorInventory = tileentityincubator;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Incubator", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/aether/gui/incubator.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        if(IncubatorInventory.isBurning())
        {
            int l = IncubatorInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(j + 74, (k + 47) - l, 176, 12 - l, 14, l + 2);
        }
        int i1 = IncubatorInventory.getCookProgressScaled(54);
        drawTexturedModalRect(j + 103, (k + 70) - i1, 179, 70 - i1, 10, i1);
    }

    private TileEntityIncubator IncubatorInventory;
}
