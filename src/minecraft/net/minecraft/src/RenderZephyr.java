// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelZephyr, EntityZephyr, EntityLiving

public class RenderZephyr extends RenderLiving
{

    public RenderZephyr()
    {
        super(new ModelZephyr(), 0.5F);
    }

    protected void func_4014_a(EntityZephyr entityzephyr, float f)
    {
        EntityZephyr entityzephyr1 = entityzephyr;
        float f1 = ((float)entityzephyr1.prevAttackCounter + (float)(entityzephyr1.attackCounter - entityzephyr1.prevAttackCounter) * f) / 20F;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8F + f1) / 2.0F;
        float f3 = (8F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    protected void scalewhale()
    {
        GL11.glScalef(6F, 6F, 6F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        func_4014_a((EntityZephyr)entityliving, f);
    }
}
