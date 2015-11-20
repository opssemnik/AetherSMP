// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBiped, ModelRenderer, MathHelper

public class ModelFireMonster extends ModelBiped
{

    public ModelFireMonster()
    {
        this(0.0F);
    }

    public ModelFireMonster(float f)
    {
        this(f, 0.0F);
    }

    public ModelFireMonster(float f, float f1)
    {
        field_1279_h = false;
        field_1278_i = false;
        isSneak = false;
        bipedHead = new ModelRenderer(0, 0);
        bipedHead.addBox(-4F, -8F, -3F, 8, 5, 7, f);
        bipedHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedHeadwear = new ModelRenderer(32, 0);
        bipedHeadwear.addBox(-4F, -3F, -4F, 8, 3, 8, f);
        bipedHeadwear.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody = new ModelRenderer(0, 12);
        bipedBody.addBox(-5F, 0.0F, -2.5F, 10, 6, 5, f);
        bipedBody.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody2 = new ModelRenderer(0, 23);
        bipedBody2.addBox(-4.5F, 6F, -2F, 9, 5, 4, f);
        bipedBody2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody3 = new ModelRenderer(30, 27);
        bipedBody3.addBox(-4.5F, 11F, -2F, 5, 1, 4, f + 0.5F);
        bipedBody3.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody4 = new ModelRenderer(30, 27);
        bipedBody4.addBox(-0.5F, 11F, -2F, 5, 1, 4, f + 0.5F);
        bipedBody4.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedRightArm = new ModelRenderer(30, 11);
        bipedRightArm.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, f + 0.5F);
        bipedRightArm.setRotationPoint(-8F, 2.0F + f1, 0.0F);
        bipedRightArm2 = new ModelRenderer(30, 11);
        bipedRightArm2.addBox(-2.5F, 2.5F, -2.5F, 5, 10, 5, f);
        bipedRightArm2.setRotationPoint(-8F, 2.0F + f1, 0.0F);
        bipedRightArm3 = new ModelRenderer(30, 26);
        bipedRightArm3.addBox(-2.5F, 7.5F, -2.5F, 5, 1, 5, f + 0.25F);
        bipedRightArm3.setRotationPoint(-8F, 2.0F + f1, 0.0F);
        bipedLeftArm = new ModelRenderer(30, 11);
        bipedLeftArm.mirror = true;
        bipedLeftArm.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, f + 0.5F);
        bipedLeftArm.setRotationPoint(8F, 2.0F + f1, 0.0F);
        bipedLeftArm2 = new ModelRenderer(30, 11);
        bipedLeftArm2.mirror = true;
        bipedLeftArm2.addBox(-2.5F, 2.5F, -2.5F, 5, 10, 5, f);
        bipedLeftArm2.setRotationPoint(8F, 2.0F + f1, 0.0F);
        bipedLeftArm3 = new ModelRenderer(30, 26);
        bipedLeftArm3.mirror = true;
        bipedLeftArm3.addBox(-2.5F, 7.5F, -2.5F, 5, 1, 5, f + 0.25F);
        bipedLeftArm3.setRotationPoint(8F, 2.0F + f1, 0.0F);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glScalef(2.25F, 2.25F, 2.25F);
        GL11.glTranslatef(0.0F, -0.25F, 0.0F);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        bipedHead.render(f5);
        bipedHeadwear.render(f5);
        bipedBody.render(f5);
        bipedBody2.render(f5);
        bipedBody3.render(f5);
        bipedBody4.render(f5);
        bipedRightArm.render(f5);
        bipedRightArm2.render(f5);
        bipedRightArm3.render(f5);
        bipedLeftArm.render(f5);
        bipedLeftArm2.render(f5);
        bipedLeftArm3.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        bipedHead.rotateAngleY = f3 / 57.29578F;
        bipedHead.rotateAngleX = f4 / 57.29578F;
        bipedHeadwear.rotateAngleY = bipedHead.rotateAngleY;
        bipedHeadwear.rotateAngleX = bipedHead.rotateAngleX;
        bipedRightArm.rotateAngleX = 0.0F;
        bipedLeftArm.rotateAngleX = 0.0F;
        bipedRightArm.rotateAngleZ = 0.0F;
        bipedLeftArm.rotateAngleZ = 0.0F;
        if(field_1279_h)
        {
            bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F;
        }
        if(field_1278_i)
        {
            bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F;
        }
        bipedRightArm.rotateAngleY = 0.0F;
        bipedLeftArm.rotateAngleY = 0.0F;
        if(onGround > -9990F)
        {
            float f6 = onGround;
            bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
            bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
            bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
            bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
            f6 = 1.0F - onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            float f7 = MathHelper.sin(f6 * 3.141593F);
            float f8 = MathHelper.sin(onGround * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
            bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
            bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
            bipedRightArm.rotateAngleZ = MathHelper.sin(onGround * 3.141593F) * -0.4F;
        }
        bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
        bipedBody4.rotateAngleX = bipedBody3.rotateAngleX = bipedBody2.rotateAngleX = bipedBody.rotateAngleX;
        bipedBody4.rotateAngleY = bipedBody3.rotateAngleY = bipedBody2.rotateAngleY = bipedBody.rotateAngleY;
        bipedLeftArm3.rotateAngleX = bipedLeftArm2.rotateAngleX = bipedLeftArm.rotateAngleX;
        bipedLeftArm3.rotateAngleY = bipedLeftArm2.rotateAngleY = bipedLeftArm.rotateAngleY;
        bipedLeftArm3.rotateAngleZ = bipedLeftArm2.rotateAngleZ = bipedLeftArm.rotateAngleZ;
        bipedRightArm3.rotateAngleX = bipedRightArm2.rotateAngleX = bipedRightArm.rotateAngleX;
        bipedRightArm3.rotateAngleY = bipedRightArm2.rotateAngleY = bipedRightArm.rotateAngleY;
        bipedRightArm3.rotateAngleZ = bipedRightArm2.rotateAngleZ = bipedRightArm.rotateAngleZ;
    }

    public ModelRenderer bipedBody2;
    public ModelRenderer bipedBody3;
    public ModelRenderer bipedBody4;
    public ModelRenderer bipedRightArm2;
    public ModelRenderer bipedLeftArm2;
    public ModelRenderer bipedRightArm3;
    public ModelRenderer bipedLeftArm3;
}
