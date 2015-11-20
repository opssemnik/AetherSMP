// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelAerbunny, EntityAerbunny, ModelBase, 
//            EntityLiving

public class RenderAerbunny extends RenderLiving
{

    public RenderAerbunny(ModelBase modelbase, float f)
    {
        super(modelbase, f);
        mb = (ModelAerbunny)modelbase;
    }

    protected void rotAerbunny(EntityAerbunny entityaerbunny)
    {
        if(!entityaerbunny.onGround && entityaerbunny.ridingEntity == null)
        {
            if(entityaerbunny.motionY > 0.5D)
            {
                GL11.glRotatef(15F, -1F, 0.0F, 0.0F);
            } else
            if(entityaerbunny.motionY < -0.5D)
            {
                GL11.glRotatef(-15F, -1F, 0.0F, 0.0F);
            } else
            {
                GL11.glRotatef((float)(entityaerbunny.motionY * 30D), -1F, 0.0F, 0.0F);
            }
        }
        mb.puffiness = entityaerbunny.puffiness;
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        rotAerbunny((EntityAerbunny)entityliving);
    }

    public ModelAerbunny mb;
}
