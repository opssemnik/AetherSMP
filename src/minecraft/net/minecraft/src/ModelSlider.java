// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelSlider extends ModelBase
{

    public ModelSlider()
    {
        this(0.0F);
    }

    public ModelSlider(float f)
    {
        this(f, 0.0F);
    }

    public ModelSlider(float f, float f1)
    {
        head = new ModelRenderer(0, 0);
        head.addBox(-8F, -16F, -8F, 16, 16, 16, f);
        head.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        head.render(f5);
        GL11.glPopMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        head.rotateAngleY = 0.0F;
        head.rotateAngleX = 0.0F;
    }

    public ModelRenderer head;
}
