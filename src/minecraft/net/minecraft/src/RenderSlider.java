// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySlider, ModelBase, EntityLiving

public class RenderSlider extends RenderLiving
{

    public RenderSlider(ModelBase modelbase, float f)
    {
        super(modelbase, f);
        renderPassModel = modelbase;
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        EntitySlider entityslider = (EntitySlider)entityliving;
        if(entityslider.harvey > 0.01F)
        {
            GL11.glRotatef(entityslider.harvey * -30F, entityslider.rennis, 0.0F, entityslider.dennis);
        }
    }

    protected boolean setSliderEyeBrightness(EntitySlider entityslider, int i, float f)
    {
        if(i != 0)
        {
            return false;
        }
        if(entityslider.awake)
        {
            if(entityslider.criticalCondition())
            {
                loadTexture("/aether/mobs/sliderAwakeGlow_red.png");
            } else
            {
                loadTexture("/aether/mobs/sliderAwakeGlow.png");
            }
        } else
        {
            loadTexture("/aether/mobs/sliderSleepGlow.png");
        }
        float f1 = (1.0F - entityslider.getEntityBrightness(1.0F)) * 0.5F;
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
        return true;
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return setSliderEyeBrightness((EntitySlider)entityliving, i, f);
    }
}
