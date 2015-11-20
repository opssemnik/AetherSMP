// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySentry, ModelBase, EntityLiving

public class RenderSentry extends RenderLiving
{

    public RenderSentry(ModelBase modelbase, float f)
    {
        super(modelbase, f);
        setRenderPassModel(modelbase);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        float f1 = 1.75F;
        GL11.glScalef(f1, f1, f1);
    }

    protected boolean a(EntitySentry entitysentry, int i, float f)
    {
        if(i != 0)
        {
            return false;
        }
        if(i != 0)
        {
            return false;
        }
        if(entitysentry.active)
        {
            loadTexture("/aether/mobs/SentryEye.png");
            float f1 = (1.0F - entitysentry.getEntityBrightness(1.0F)) * 0.75F;
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return a((EntitySentry)entityliving, i, f);
    }
}
