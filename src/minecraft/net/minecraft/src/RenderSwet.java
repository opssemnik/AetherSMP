// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySwet, Entity, ModelBase, 
//            EntityLiving

public class RenderSwet extends RenderLiving
{

    public RenderSwet(ModelBase modelbase, ModelBase modelbase1, float f)
    {
        super(modelbase, f);
        field_22001_a = modelbase1;
    }

    protected boolean a(EntitySwet entityswet, int i, float f)
    {
        if(i == 0)
        {
            setRenderPassModel(field_22001_a);
            GL11.glEnable(2977 /*GL_NORMALIZE*/);
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glBlendFunc(770, 771);
            return true;
        }
        if(i == 1)
        {
            GL11.glDisable(3042 /*GL_BLEND*/);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        return false;
    }

    protected void a(EntitySwet entityswet, float f)
    {
        float f1;
        float f2 = f1 = 1.0F;
        float f3 = 1.5F;
        if(!entityswet.onGround)
        {
            if(entityswet.motionY > 0.85000002384185791D)
            {
                f2 = 1.425F;
                f1 = 0.575F;
            } else
            if(entityswet.motionY < -0.85000002384185791D)
            {
                f2 = 0.575F;
                f1 = 1.425F;
            } else
            {
                float f4 = (float)entityswet.motionY * 0.5F;
                f2 += f4;
                f1 -= f4;
            }
        }
        if(entityswet.riddenByEntity != null)
        {
            f3 = 1.5F + (entityswet.riddenByEntity.width + entityswet.riddenByEntity.height) * 0.75F;
        }
        GL11.glScalef(f1 * f3, f2 * f3, f1 * f3);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        a((EntitySwet)entityliving, f);
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return a((EntitySwet)entityliving, i, f);
    }

    private ModelBase field_22001_a;
}
