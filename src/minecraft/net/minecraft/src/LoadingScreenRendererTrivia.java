// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            LoadingScreenRenderer, MinecraftError, mod_Trivia, ScaledResolution, 
//            Tessellator, RenderEngine, FontRenderer

public class LoadingScreenRendererTrivia extends LoadingScreenRenderer
{

    public LoadingScreenRendererTrivia(Minecraft minecraft)
    {
        super(minecraft);
        string1 = "";
        string2 = "";
        time = System.currentTimeMillis();
        someRandomBoolean = false;
        game = minecraft;
        trivia = "";
    }

    public void printText(String s)
    {
        someRandomBoolean = false;
        func_597_c(s);
    }

    public void func_594_b(String s)
    {
        someRandomBoolean = true;
        func_597_c(string2);
    }

    public void func_597_c(String s)
    {
        if(!game.running)
        {
            if(someRandomBoolean)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        }
        string2 = s;
        if(string1 == "" && string2 == "")
        {
            trivia = "";
        }
        if(string2 != "" && trivia == "")
        {
            trivia = mod_Trivia.getNewString();
        }
        ScaledResolution scaledresolution = new ScaledResolution(game.gameSettings, game.displayWidth, game.displayHeight);
        GL11.glClear(256);
        GL11.glMatrixMode(5889 /*GL_PROJECTION*/);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.field_25121_a, scaledresolution.field_25120_b, 0.0D, 100D, 300D);
        GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
    }

    public void displayLoadingString(String s)
    {
        if(!game.running)
        {
            if(someRandomBoolean)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        }
        time = 0L;
        string1 = s;
        setLoadingProgress(-1);
        time = 0L;
        time = 0L;
        if(string1 == "" && string2 == "")
        {
            trivia = "";
        }
        if(string1 != "" && string2 == "" && trivia == "")
        {
            trivia = mod_Trivia.getNewString();
        }
    }

    public void setLoadingProgress(int i)
    {
        if(!game.running)
        {
            if(someRandomBoolean)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        }
        long l = System.currentTimeMillis();
        if(l - time < 20L)
        {
            return;
        }
        time = l;
        ScaledResolution scaledresolution = new ScaledResolution(game.gameSettings, game.displayWidth, game.displayHeight);
        int j = scaledresolution.getScaledWidth();
        int k = scaledresolution.getScaledHeight();
        GL11.glClear(256);
        GL11.glMatrixMode(5889 /*GL_PROJECTION*/);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.field_25121_a, scaledresolution.field_25120_b, 0.0D, 100D, 300D);
        GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glClear(16640);
        Tessellator tessellator = Tessellator.instance;
        int i1 = game.renderEngine.getTexture("/gui/background.png");
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, i1);
        float f = 32F;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x404040);
        tessellator.addVertexWithUV(0.0D, k, 0.0D, 0.0D, (float)k / f);
        tessellator.addVertexWithUV(j, k, 0.0D, (float)j / f, (float)k / f);
        tessellator.addVertexWithUV(j, 0.0D, 0.0D, (float)j / f, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.draw();
        if(i >= 0)
        {
            byte byte0 = 100;
            byte byte1 = 2;
            int j1 = j / 2 - byte0 / 2;
            int k1 = k / 2 + 16;
            GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
            tessellator.startDrawingQuads();
            tessellator.setColorOpaque_I(0x808080);
            tessellator.addVertex(j1, k1, 0.0D);
            tessellator.addVertex(j1, k1 + byte1, 0.0D);
            tessellator.addVertex(j1 + byte0, k1 + byte1, 0.0D);
            tessellator.addVertex(j1 + byte0, k1, 0.0D);
            tessellator.setColorOpaque_I(0x80ff80);
            tessellator.addVertex(j1, k1, 0.0D);
            tessellator.addVertex(j1, k1 + byte1, 0.0D);
            tessellator.addVertex(j1 + i, k1 + byte1, 0.0D);
            tessellator.addVertex(j1 + i, k1, 0.0D);
            tessellator.draw();
            GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        }
        game.fontRenderer.drawStringWithShadow(string2, (j - game.fontRenderer.getStringWidth(string2)) / 2, k / 2 - 4 - 16, 0xffffff);
        game.fontRenderer.drawStringWithShadow(string1, (j - game.fontRenderer.getStringWidth(string1)) / 2, (k / 2 - 4) + 8, 0xffffff);
        game.fontRenderer.drawStringWithShadow(trivia, (j - game.fontRenderer.getStringWidth(trivia)) / 2, k - 16, 0xffff99);
        Display.update();
        try
        {
            Thread.yield();
        }
        catch(Exception exception) { }
    }

    private String trivia;
    private String string1;
    private String string2;
    private long time;
    private boolean someRandomBoolean;
    private Minecraft game;
}
