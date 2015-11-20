// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelHomeShot, EntityHomeShot, ModelBase, 
//            EntityLiving

public class RenderHomeShot extends RenderLiving
{

    public RenderHomeShot(ModelBase modelbase, float f)
    {
        super(modelbase, f);
        shotty = (ModelHomeShot)modelbase;
    }

    public void preRenderCallback(EntityLiving entityliving, float f)
    {
        EntityHomeShot entityhomeshot = (EntityHomeShot)entityliving;
        for(int i = 0; i < 3; i++)
        {
            shotty.sinage[i] = entityhomeshot.sinage[i];
        }

    }

    private ModelHomeShot shotty;
}
