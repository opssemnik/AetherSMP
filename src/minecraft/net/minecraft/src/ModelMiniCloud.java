// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelMiniCloud extends ModelBase
{

    public ModelMiniCloud()
    {
        this(0.0F);
    }

    public ModelMiniCloud(float f)
    {
        this(f, 0.0F);
    }

    public ModelMiniCloud(float f, float f1)
    {
        head = new ModelRenderer[5];
        head[0] = new ModelRenderer(0, 0);
        head[1] = new ModelRenderer(36, 0);
        head[2] = new ModelRenderer(36, 0);
        head[3] = new ModelRenderer(36, 8);
        head[4] = new ModelRenderer(36, 8);
        head[0].addBox(-4.5F, -4.5F, -4.5F, 9, 9, 9, f);
        head[0].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        head[1].addBox(-3.5F, -3.5F, -5.5F, 7, 7, 1, f);
        head[1].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        head[2].addBox(-3.5F, -3.5F, 4.5F, 7, 7, 1, f);
        head[2].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        head[3].addBox(-5.5F, -3.5F, -3.5F, 1, 7, 7, f);
        head[3].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        head[4].addBox(4.5F, -3.5F, -3.5F, 1, 7, 7, f);
        head[4].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        for(int i = 0; i < 5; i++)
        {
            head[i].render(f5);
        }

    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        for(int i = 0; i < 5; i++)
        {
            head[i].rotateAngleY = f3 / 57.29578F;
            head[i].rotateAngleX = f4 / 57.29578F;
        }

    }

    public ModelRenderer head[];
}
