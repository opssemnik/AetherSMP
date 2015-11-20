// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderBiped, ModelValkyrie, EntityValkyrie, EntityLiving, 
//            ModelBiped

public class RenderValkyrie extends RenderBiped
{

    public RenderValkyrie(ModelBiped modelbiped, float f)
    {
        super(modelbiped, f);
        mv1 = (ModelValkyrie)modelbiped;
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        EntityValkyrie entityvalkyrie = (EntityValkyrie)entityliving;
        mv1.sinage = entityvalkyrie.sinage;
        mv1.gonRound = entityvalkyrie.onGround;
        mv1.halow = !entityvalkyrie.otherDimension();
    }

    public ModelValkyrie mv1;
}
