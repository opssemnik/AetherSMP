// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelAerwhale, Entity, ModelBase

public class RenderAerwhale extends Render
{

    public RenderAerwhale()
    {
        model = new ModelAerwhale();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        loadTexture("/aether/mobs/Mob_Aerwhale.png");
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(90F - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180F - entity.rotationPitch, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(5F, 5F, 5F);
        model.render(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    private ModelBase model;
}
