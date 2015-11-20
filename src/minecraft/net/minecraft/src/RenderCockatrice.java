// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityCockatrice, MathHelper, ModelBase, 
//            EntityLiving, Entity

public class RenderCockatrice extends RenderLiving
{

    public RenderCockatrice(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void renderChicken(EntityCockatrice entitycockatrice, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entitycockatrice, d, d1, d2, f, f1);
    }

    protected float getWingRotation(EntityCockatrice entitycockatrice, float f)
    {
        float f1 = entitycockatrice.field_756_e + (entitycockatrice.field_752_b - entitycockatrice.field_756_e) * f;
        float f2 = entitycockatrice.field_757_d + (entitycockatrice.destPos - entitycockatrice.field_757_d) * f;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float func_170_d(EntityLiving entityliving, float f)
    {
        return getWingRotation((EntityCockatrice)entityliving, f);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderChicken((EntityCockatrice)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderChicken((EntityCockatrice)entity, d, d1, d2, f, f1);
    }

    protected void scalemoa()
    {
        GL11.glScalef(1.8F, 1.8F, 1.8F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        scalemoa();
    }
}
