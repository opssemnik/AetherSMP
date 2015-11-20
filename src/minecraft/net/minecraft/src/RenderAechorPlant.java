// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityAechorPlant, ModelAechorPlant, EntityLiving

public class RenderAechorPlant extends RenderLiving
{

    public RenderAechorPlant(ModelAechorPlant modelaechorplant, float f)
    {
        super(modelaechorplant, f);
        setRenderPassModel(modelaechorplant);
        xd = modelaechorplant;
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        EntityAechorPlant entityaechorplant = (EntityAechorPlant)entityliving;
        float f1 = (float)Math.sin(entityaechorplant.sinage);
        float f2;
        if(entityaechorplant.hurtTime > 0)
        {
            f1 *= 0.45F;
            f1 -= 0.125F;
            f2 = 1.75F + (float)Math.sin(entityaechorplant.sinage + 2.0F) * 1.5F;
        } else
        if(entityaechorplant.seeprey)
        {
            f1 *= 0.25F;
            f2 = 1.75F + (float)Math.sin(entityaechorplant.sinage + 2.0F) * 1.5F;
        } else
        {
            f1 *= 0.125F;
            f2 = 1.75F;
        }
        xd.sinage = f1;
        xd.sinage2 = f2;
        float f3 = 0.625F + (float)entityaechorplant.size / 6F;
        xd.size = f3;
        shadowSize = f3 - 0.25F;
    }

    protected boolean a(EntityAechorPlant entityaechorplant, int i, float f)
    {
        if(i != 0)
        {
            return false;
        }
        if(i != 0)
        {
            return false;
        } else
        {
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.325F);
            return true;
        }
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return a((EntityAechorPlant)entityliving, i, f);
    }

    public ModelAechorPlant xd;
}
