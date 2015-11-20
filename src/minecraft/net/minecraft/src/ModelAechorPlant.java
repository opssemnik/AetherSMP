// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelAechorPlant extends ModelBase
{

    public ModelAechorPlant()
    {
        this(0.0F);
    }

    public ModelAechorPlant(float f)
    {
        this(f, 0.0F);
    }

    public ModelAechorPlant(float f, float f1)
    {
        pie = 6.283186F;
        size = 1.0F;
        petal = new ModelRenderer[petals];
        leaf = new ModelRenderer[petals];
        for(int i = 0; i < petals; i++)
        {
            petal[i] = new ModelRenderer(0, 0);
            if(i % 2 == 0)
            {
                petal[i] = new ModelRenderer(29, 3);
                petal[i].addBox(-4F, -1F, -12F, 8, 1, 9, f - 0.25F);
                petal[i].setRotationPoint(0.0F, 1.0F + f1, 0.0F);
            } else
            {
                petal[i].addBox(-4F, -1F, -13F, 8, 1, 10, f - 0.125F);
                petal[i].setRotationPoint(0.0F, 1.0F + f1, 0.0F);
            }
            leaf[i] = new ModelRenderer(38, 13);
            leaf[i].addBox(-2F, -1F, -9.5F, 4, 1, 8, f - 0.15F);
            leaf[i].setRotationPoint(0.0F, 1.0F + f1, 0.0F);
        }

        stamen = new ModelRenderer[stamens];
        stamen2 = new ModelRenderer[stamens];
        for(int j = 0; j < stamens; j++)
        {
            stamen[j] = new ModelRenderer(36, 13);
            stamen[j].addBox(0.0F, -9F, -1.5F, 1, 6, 1, f - 0.25F);
            stamen[j].setRotationPoint(0.0F, 1.0F + f1, 0.0F);
        }

        for(int k = 0; k < stamens; k++)
        {
            stamen2[k] = new ModelRenderer(32, 15);
            stamen2[k].addBox(0.0F, -10F, -1.5F, 1, 1, 1, f + 0.125F);
            stamen2[k].setRotationPoint(0.0F, 1.0F + f1, 0.0F);
        }

        head = new ModelRenderer(0, 12);
        head.addBox(-3F, -3F, -3F, 6, 2, 6, f + 0.75F);
        head.setRotationPoint(0.0F, 1.0F + f1, 0.0F);
        stem = new ModelRenderer(24, 13);
        stem.addBox(-1F, 0.0F, -1F, 2, 6, 2, f);
        stem.setRotationPoint(0.0F, 1.0F + f1, 0.0F);
        thorn = new ModelRenderer[thorns];
        for(int l = 0; l < thorns; l++)
        {
            thorn[l] = new ModelRenderer(32, 13);
            thorn[l].setRotationPoint(0.0F, 1.0F + f1, 0.0F);
        }

        thorn[0].addBox(-1.75F, 1.25F, -1F, 1, 1, 1, f - 0.25F);
        thorn[1].addBox(-1F, 2.25F, 0.75F, 1, 1, 1, f - 0.25F);
        thorn[2].addBox(0.75F, 1.25F, 0.0F, 1, 1, 1, f - 0.25F);
        thorn[3].addBox(0.0F, 2.25F, -1.75F, 1, 1, 1, f - 0.25F);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 1.2F, 0.0F);
        GL11.glScalef(size, size, size);
        for(int i = 0; i < petals; i++)
        {
            petal[i].render(f5);
            leaf[i].render(f5);
        }

        for(int j = 0; j < stamens; j++)
        {
            stamen[j].render(f5);
            stamen2[j].render(f5);
        }

        head.render(f5);
        stem.render(f5);
        for(int k = 0; k < thorns; k++)
        {
            thorn[k].render(f5);
        }

        GL11.glPopMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        head.rotateAngleX = 0.0F;
        head.rotateAngleY = f4 / 57.29578F;
        float f6 = sinage2;
        stem.rotateAngleY = head.rotateAngleY;
        stem.rotationPointY = f6 * 0.5F;
        for(int i = 0; i < thorns; i++)
        {
            thorn[i].rotateAngleY = head.rotateAngleY;
            thorn[i].rotationPointY = f6 * 0.5F;
        }

        for(int j = 0; j < petals; j++)
        {
            petal[j].rotateAngleX = j % 2 != 0 ? -0.4125F : -0.25F;
            petal[j].rotateAngleX += sinage;
            petal[j].rotateAngleY = head.rotateAngleY;
            petal[j].rotateAngleY += (pie / (float)petals) * (float)j;
            leaf[j].rotateAngleX = j % 2 != 0 ? 0.2F : 0.1F;
            leaf[j].rotateAngleX += sinage * 0.75F;
            leaf[j].rotateAngleY = head.rotateAngleY + pie / (float)petals / 2.0F;
            leaf[j].rotateAngleY += (pie / (float)petals) * (float)j;
            petal[j].rotationPointY = f6;
            leaf[j].rotationPointY = f6;
        }

        for(int k = 0; k < stamens; k++)
        {
            stamen[k].rotateAngleX = 0.2F + (float)k / 15F;
            stamen[k].rotateAngleY = head.rotateAngleY + 0.1F;
            stamen[k].rotateAngleY += (pie / (float)stamens) * (float)k;
            stamen[k].rotateAngleX += sinage * 0.4F;
            stamen2[k].rotateAngleX = 0.2F + (float)k / 15F;
            stamen2[k].rotateAngleY = head.rotateAngleY + 0.1F;
            stamen2[k].rotateAngleY += (pie / (float)stamens) * (float)k;
            stamen2[k].rotateAngleX += sinage * 0.4F;
            stamen[k].rotationPointY = f6 + sinage * 2.0F;
            stamen2[k].rotationPointY = f6 + sinage * 2.0F;
        }

        head.rotationPointY = f6 + sinage * 2.0F;
    }

    private ModelRenderer petal[];
    private ModelRenderer leaf[];
    private ModelRenderer stamen[];
    private ModelRenderer stamen2[];
    private ModelRenderer thorn[];
    private ModelRenderer stem;
    private ModelRenderer head;
    private static int petals = 10;
    private static int thorns = 4;
    private static int stamens = 3;
    public float sinage;
    public float sinage2;
    public float size;
    private float pie;

}
