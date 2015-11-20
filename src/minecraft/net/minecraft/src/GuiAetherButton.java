// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, GuiMainMenu, RenderEngine, FontRenderer

public class GuiAetherButton extends GuiButton
{

    public GuiAetherButton(int i, int j, int k, String s)
    {
        super(i, j, k, s);
        scrollMax = 100;
        scrollHeight = scrollMax;
        scrollMin = 115;
        scrollCrop = 20;
        scrollCropMax = 90;
        retracting = false;
    }

    public GuiAetherButton(int i, int j, int k, int l, int i1, String s)
    {
        super(i, j, k, l, i1, s);
        scrollMax = 100;
        scrollHeight = scrollMax;
        scrollMin = 115;
        scrollCrop = 20;
        scrollCropMax = 90;
        retracting = false;
        enabled = true;
        enabled2 = true;
    }

    protected int getHoverState(boolean flag)
    {
        byte byte0 = 1;
        if(GuiMainMenu.themeOption)
        {
            if(!enabled)
            {
                byte0 = 0;
            } else
            if(flag)
            {
                if(byte0 < 2)
                {
                    byte0++;
                }
                if(scrollCrop < scrollCropMax)
                {
                    scrollCrop++;
                }
                if(scrollHeight < scrollMin)
                {
                    scrollHeight++;
                }
            } else
            {
                if(scrollCrop > scrollCropMax)
                {
                    scrollCrop--;
                }
                if(scrollHeight > scrollMax)
                {
                    scrollHeight--;
                }
                if(scrollHeight == scrollMax)
                {
                    retracting = false;
                }
            }
        } else
        if(!GuiMainMenu.themeOption)
        {
            if(!enabled)
            {
                byte0 = 0;
            } else
            if(flag)
            {
                byte0 = 2;
            }
        }
        return byte0;
    }

    public void drawButton(Minecraft minecraft, int i, int j)
    {
        if(!enabled2)
        {
            return;
        }
        if(GuiMainMenu.themeOption)
        {
            FontRenderer fontrenderer = minecraft.fontRenderer;
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/aether/gui/buttons.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
            int k = getHoverState(flag);
            drawTexturedModalRect((xPosition + scrollHeight) - 90, yPosition, 0, 46 + k * 20, width / 2, height);
            drawTexturedModalRect((xPosition + scrollHeight + width / 2) - 90, yPosition, 200 - width / 2, 46 + k * 20, width / 2, height);
            mouseDragged(minecraft, i, j);
            if(!enabled)
            {
                drawString(fontrenderer, displayString, (xPosition + width / 10 + scrollHeight) - 80, yPosition + (height - 8) / 2, 0xffa0a0a0);
            } else
            if(flag)
            {
                drawString(fontrenderer, displayString, (xPosition + width / 10 + scrollHeight) - 80, yPosition + (height - 8) / 2, 0x77cccc);
            } else
            {
                drawString(fontrenderer, displayString, (xPosition + width / 10 + scrollHeight) - 80, yPosition + (height - 8) / 2, 0xe0e0e0);
            }
        }
        if(!GuiMainMenu.themeOption)
        {
            FontRenderer fontrenderer1 = minecraft.fontRenderer;
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag1 = i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
            int l = getHoverState(flag1);
            drawTexturedModalRect(xPosition, yPosition, 0, 46 + l * 20, width / 2, height);
            drawTexturedModalRect(xPosition + width / 2, yPosition, 200 - width / 2, 46 + l * 20, width / 2, height);
            mouseDragged(minecraft, i, j);
            if(!enabled)
            {
                drawCenteredString(fontrenderer1, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xffa0a0a0);
            } else
            if(flag1)
            {
                drawCenteredString(fontrenderer1, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xffffa0);
            } else
            {
                drawCenteredString(fontrenderer1, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xe0e0e0);
            }
        }
    }

    protected void mouseDragged(Minecraft minecraft, int i, int j)
    {
    }

    public void mouseReleased(int i, int j)
    {
    }

    public boolean mousePressed(Minecraft minecraft, int i, int j)
    {
        return enabled && i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
    }

    public int scrollMax;
    public int scrollHeight;
    public int scrollMin;
    public int scrollCrop;
    public int scrollCropMax;
    public boolean retracting;
}
