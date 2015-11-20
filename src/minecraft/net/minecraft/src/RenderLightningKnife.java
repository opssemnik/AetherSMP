// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, EntityLightningKnife, AetherItems, Item, 
//            Tessellator, Entity

public class RenderLightningKnife extends Render
{

    public RenderLightningKnife()
    {
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        doRenderKnife((EntityLightningKnife)entity, d, d1, d2, f, f1);
    }

    public void doRenderKnife(EntityLightningKnife entitylightningknife, double d, double d1, double d2, 
            float f, float f1)
    {
        String s = "/gui/items.png";
        int i = AetherItems.LightningKnife.iconIndex;
        float f2 = ((float)((i % 16) * 16) + 0.0F) / 256F;
        float f3 = ((float)((i % 16) * 16) + 15.99F) / 256F;
        float f4 = ((float)((i / 16) * 16) + 0.0F) / 256F;
        float f5 = ((float)((i / 16) * 16) + 15.99F) / 256F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(entitylightningknife.prevRotationPitch + (entitylightningknife.rotationPitch - entitylightningknife.prevRotationPitch) * f1), 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
        loadTexture(s);
        Tessellator tessellator = Tessellator.instance;
        float f6 = 1.0F;
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        float f7 = 0.0625F;
        GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, f3, f5);
        tessellator.addVertexWithUV(f6, 0.0D, 0.0D, f2, f5);
        tessellator.addVertexWithUV(f6, 0.0D, 1.0D, f2, f4);
        tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, f3, f4);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        tessellator.addVertexWithUV(0.0D, 0.0F - f7, 1.0D, f3, f4);
        tessellator.addVertexWithUV(f6, 0.0F - f7, 1.0D, f2, f4);
        tessellator.addVertexWithUV(f6, 0.0F - f7, 0.0D, f2, f5);
        tessellator.addVertexWithUV(0.0D, 0.0F - f7, 0.0D, f3, f5);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        for(int j = 0; j < 16; j++)
        {
            float f8 = (float)j / 16F;
            float f12 = (f3 + (f2 - f3) * f8) - 0.001953125F;
            float f16 = f6 * f8;
            tessellator.addVertexWithUV(f16, 0.0F - f7, 0.0D, f12, f5);
            tessellator.addVertexWithUV(f16, 0.0D, 0.0D, f12, f5);
            tessellator.addVertexWithUV(f16, 0.0D, 1.0D, f12, f4);
            tessellator.addVertexWithUV(f16, 0.0F - f7, 1.0D, f12, f4);
        }

        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        for(int k = 0; k < 16; k++)
        {
            float f9 = (float)k / 16F;
            float f13 = (f3 + (f2 - f3) * f9) - 0.001953125F;
            float f17 = f6 * f9 + 0.0625F;
            tessellator.addVertexWithUV(f17, 0.0F - f7, 1.0D, f13, f4);
            tessellator.addVertexWithUV(f17, 0.0D, 1.0D, f13, f4);
            tessellator.addVertexWithUV(f17, 0.0D, 0.0D, f13, f5);
            tessellator.addVertexWithUV(f17, 0.0F - f7, 0.0D, f13, f5);
        }

        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        for(int l = 0; l < 16; l++)
        {
            float f10 = (float)l / 16F;
            float f14 = (f5 + (f4 - f5) * f10) - 0.001953125F;
            float f18 = f6 * f10 + 0.0625F;
            tessellator.addVertexWithUV(0.0D, 0.0D, f18, f3, f14);
            tessellator.addVertexWithUV(f6, 0.0D, f18, f2, f14);
            tessellator.addVertexWithUV(f6, 0.0F - f7, f18, f2, f14);
            tessellator.addVertexWithUV(0.0D, 0.0F - f7, f18, f3, f14);
        }

        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        for(int i1 = 0; i1 < 16; i1++)
        {
            float f11 = (float)i1 / 16F;
            float f15 = (f5 + (f4 - f5) * f11) - 0.001953125F;
            float f19 = f6 * f11;
            tessellator.addVertexWithUV(f6, 0.0D, f19, f2, f15);
            tessellator.addVertexWithUV(0.0D, 0.0D, f19, f3, f15);
            tessellator.addVertexWithUV(0.0D, 0.0F - f7, f19, f3, f15);
            tessellator.addVertexWithUV(f6, 0.0F - f7, f19, f2, f15);
        }

        tessellator.draw();
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }
}
