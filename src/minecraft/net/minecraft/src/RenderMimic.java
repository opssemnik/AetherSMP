// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelMimic, EntityMimic, Entity

public class RenderMimic extends Render
{

    public RenderMimic()
    {
        model = new ModelMimic();
    }

    public void render(EntityMimic entitymimic, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-1F, -1F, 1.0F);
        loadTexture("/aether/mobs/Mimic1.png");
        model.render1(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, entitymimic);
        loadTexture("/aether/mobs/Mimic2.png");
        model.render2(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, entitymimic);
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        render((EntityMimic)entity, d, d1, d2, f, f1);
    }

    private ModelMimic model;
}
