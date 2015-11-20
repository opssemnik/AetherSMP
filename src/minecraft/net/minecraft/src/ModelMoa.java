// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper

public class ModelMoa extends ModelBase
{

    public ModelMoa()
    {
        byte byte0 = 16;
        random = new Random();
        head = new ModelRenderer(0, 13);
        head.addBox(-2F, -4F, -6F, 4, 4, 8, 0.0F);
        head.setRotationPoint(0.0F, -8 + byte0, -4F);
        jaw = new ModelRenderer(24, 13);
        jaw.addBox(-2F, -1F, -6F, 4, 1, 8, -0.1F);
        jaw.setRotationPoint(0.0F, -8 + byte0, -4F);
        body = new ModelRenderer(0, 0);
        body.addBox(-3F, -3F, 0.0F, 6, 8, 5, 0.0F);
        body.setRotationPoint(0.0F, 0 + byte0, 0.0F);
        legs = new ModelRenderer(22, 0);
        legs.addBox(-1F, -1F, -1F, 2, 9, 2);
        legs.setRotationPoint(-2F, 0 + byte0, 1.0F);
        legs2 = new ModelRenderer(22, 0);
        legs2.addBox(-1F, -1F, -1F, 2, 9, 2);
        legs2.setRotationPoint(2.0F, 0 + byte0, 1.0F);
        wings = new ModelRenderer(52, 0);
        wings.addBox(-1F, -0F, -1F, 1, 8, 4);
        wings.setRotationPoint(-3F, -4 + byte0, 0.0F);
        wings2 = new ModelRenderer(52, 0);
        wings2.addBox(0.0F, -0F, -1F, 1, 8, 4);
        wings2.setRotationPoint(3F, -4 + byte0, 0.0F);
        neck = new ModelRenderer(44, 0);
        neck.addBox(-1F, -6F, -1F, 2, 6, 2);
        neck.setRotationPoint(0.0F, -2 + byte0, -4F);
        feather1 = new ModelRenderer(30, 0);
        feather1.addBox(-1F, -5F, 5F, 2, 1, 5, -0.3F);
        feather1.setRotationPoint(0.0F, 1 + byte0, 1.0F);
        feather2 = new ModelRenderer(30, 0);
        feather2.addBox(-1F, -5F, 5F, 2, 1, 5, -0.3F);
        feather2.setRotationPoint(0.0F, 1 + byte0, 1.0F);
        feather3 = new ModelRenderer(30, 0);
        feather3.addBox(-1F, -5F, 5F, 2, 1, 5, -0.3F);
        feather3.setRotationPoint(0.0F, 1 + byte0, 1.0F);
        feather1.rotationPointY += 0.5F;
        feather2.rotationPointY += 0.5F;
        feather3.rotationPointY += 0.5F;
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        jaw.render(f5);
        body.render(f5);
        legs.render(f5);
        legs2.render(f5);
        wings.render(f5);
        wings2.render(f5);
        neck.render(f5);
        feather1.render(f5);
        feather2.render(f5);
        feather3.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = 3.141593F;
        head.rotateAngleX = f4 / 57.29578F;
        head.rotateAngleY = f3 / 57.29578F;
        jaw.rotateAngleX = head.rotateAngleX;
        jaw.rotateAngleY = head.rotateAngleY;
        body.rotateAngleX = 1.570796F;
        legs.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        legs2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        if(f2 > 0.001F)
        {
            wings.rotationPointZ = -1F;
            wings2.rotationPointZ = -1F;
            wings.rotationPointY = 12F;
            wings2.rotationPointY = 12F;
            wings.rotateAngleX = 0.0F;
            wings2.rotateAngleX = 0.0F;
            wings.rotateAngleZ = f2;
            wings2.rotateAngleZ = -f2;
            legs.rotateAngleX = 0.6F;
            legs2.rotateAngleX = 0.6F;
        } else
        {
            wings.rotationPointZ = -3F;
            wings2.rotationPointZ = -3F;
            wings.rotationPointY = 14F;
            wings2.rotationPointY = 14F;
            wings.rotateAngleX = f6 / 2.0F;
            wings2.rotateAngleX = f6 / 2.0F;
            wings.rotateAngleZ = 0.0F;
            wings2.rotateAngleZ = 0.0F;
        }
        feather1.rotateAngleY = -0.375F;
        feather2.rotateAngleY = 0.0F;
        feather3.rotateAngleY = 0.375F;
        feather1.rotateAngleX = 0.25F;
        feather2.rotateAngleX = 0.25F;
        feather3.rotateAngleX = 0.25F;
        neck.rotateAngleX = 0.0F;
        neck.rotateAngleY = head.rotateAngleY;
        jaw.rotateAngleX += 0.35F;
    }

    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer legs;
    public ModelRenderer legs2;
    public ModelRenderer wings;
    public ModelRenderer wings2;
    public ModelRenderer jaw;
    public ModelRenderer neck;
    public ModelRenderer feather1;
    public ModelRenderer feather2;
    public ModelRenderer feather3;
    public Random random;
}
