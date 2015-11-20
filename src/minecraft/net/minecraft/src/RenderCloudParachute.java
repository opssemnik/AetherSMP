// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, AetherBlocks, EntityCloudParachute, 
//            MathHelper, Block, World, RenderFloatingBlock, 
//            Entity

public class RenderCloudParachute extends Render
{

    public RenderCloudParachute()
    {
        renderBlocks = new RenderBlocks();
        shadowSize = 0.5F;
    }

    public void renderCloud(EntityCloudParachute entitycloudparachute, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        loadTexture("/terrain.png");
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        RenderFloatingBlock.renderBlockFallingSand(AetherBlocks.Aercloud, entitycloudparachute.getWorld(), MathHelper.floor_double(entitycloudparachute.posX), MathHelper.floor_double(entitycloudparachute.posY), MathHelper.floor_double(entitycloudparachute.posZ), entitycloudparachute.gold ? 2 : 0);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderCloud((EntityCloudParachute)entity, d, d1, d2, f, f1);
    }

    private RenderBlocks renderBlocks;
}
