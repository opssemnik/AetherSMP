// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySheepuff, EntitySheep, ModelBase, 
//            EntityLiving

public class RenderSheepuff extends RenderLiving
{

    public RenderSheepuff(ModelBase modelbase, ModelBase modelbase1, ModelBase modelbase2, float f)
    {
        super(modelbase1, f);
        setRenderPassModel(modelbase);
        wool = modelbase;
        puffed = modelbase2;
    }

    protected boolean setWoolColorAndRender(EntitySheepuff entitysheepuff, int i, float f)
    {
        if(i == 0 && !entitysheepuff.getSheared())
        {
            if(entitysheepuff.getPuffed())
            {
                setRenderPassModel(puffed);
                loadTexture("/aether/mobs/sheepuff_fur.png");
            } else
            {
                setRenderPassModel(wool);
                loadTexture("/aether/mobs/sheepuff_fur.png");
            }
            float f1 = entitysheepuff.getEntityBrightness(f);
            int j = entitysheepuff.getFleeceColor();
            GL11.glColor3f(f1 * EntitySheep.fleeceColorTable[j][0], f1 * EntitySheep.fleeceColorTable[j][1], f1 * EntitySheep.fleeceColorTable[j][2]);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return setWoolColorAndRender((EntitySheepuff)entityliving, i, f);
    }

    private ModelBase wool;
    private ModelBase puffed;
}
