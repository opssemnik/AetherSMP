// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiIngame, GuiMainMenu, EntityRenderer

public class GuiIngameAether extends GuiIngame
{

    public GuiIngameAether(Minecraft minecraft)
    {
        super(minecraft);
        mc = minecraft;
    }

    public void renderGameOverlay(float f, boolean flag, int i, int j)
    {
        if(GuiMainMenu.mmactive)
        {
            GL11.glViewport(0, 0, mc.displayWidth, mc.displayHeight);
            GL11.glMatrixMode(5889 /*GL_PROJECTION*/);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
            GL11.glLoadIdentity();
            mc.entityRenderer.func_905_b();
        } else
        {
            super.renderGameOverlay(f, flag, i, j);
        }
    }

    private Minecraft mc;
}
