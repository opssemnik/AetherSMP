// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityMoa, MathHelper, ModelBase, 
//            EntityLiving, Entity

public class RenderMoa extends RenderLiving
{

    public RenderMoa(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void renderChicken(EntityMoa entitymoa, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entitymoa, d, d1, d2, f, f1);
    }

    protected float getWingRotation(EntityMoa entitymoa, float f)
    {
        float f1 = entitymoa.field_756_e + (entitymoa.field_752_b - entitymoa.field_756_e) * f;
        float f2 = entitymoa.field_757_d + (entitymoa.destPos - entitymoa.field_757_d) * f;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float func_170_d(EntityLiving entityliving, float f)
    {
        return getWingRotation((EntityMoa)entityliving, f);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderChicken((EntityMoa)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderChicken((EntityMoa)entity, d, d1, d2, f, f1);
    }

    protected void scalemoa()
    {
        GL11.glScalef(1.8F, 1.8F, 1.8F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        if((entityliving instanceof EntityMoa) && ((EntityMoa)entityliving).baby)
        {
            return;
        } else
        {
            scalemoa();
            return;
        }
    }
}
