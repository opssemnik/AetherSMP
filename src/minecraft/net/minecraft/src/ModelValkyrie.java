// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBiped, ModelRenderer, MathHelper

public class ModelValkyrie extends ModelBiped
{

    public ModelValkyrie()
    {
        this(0.0F);
    }

    public ModelValkyrie(float f)
    {
        this(f, 0.0F);
    }

    public ModelValkyrie(float f, float f1)
    {
        field_1279_h = false;
        field_1278_i = false;
        isSneak = false;
        bipedHead = new ModelRenderer(0, 0);
        bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
        bipedHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody = new ModelRenderer(12, 16);
        bipedBody.addBox(-3F, 0.0F, -1.5F, 6, 12, 3, f);
        bipedBody.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody2 = new ModelRenderer(12, 16);
        bipedBody2.addBox(-3F, 0.5F, -1.25F, 6, 5, 3, f + 0.75F);
        bipedBody2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedRightArm = new ModelRenderer(30, 16);
        bipedRightArm.addBox(-3F, -1.5F, -1.5F, 3, 12, 3, f);
        bipedRightArm.setRotationPoint(-4F, 1.5F + f1, 0.0F);
        bipedLeftArm = new ModelRenderer(30, 16);
        bipedLeftArm.mirror = true;
        bipedLeftArm.addBox(-1F, -1.5F, -1.5F, 3, 12, 3, f);
        bipedLeftArm.setRotationPoint(5F, 1.5F + f1, 0.0F);
        bipedRightArm2 = new ModelRenderer(30, 16);
        bipedRightArm2.addBox(-3F, -1.5F, -1.5F, 3, 3, 3, f + 0.75F);
        bipedRightArm2.setRotationPoint(-4F, 1.5F + f1, 0.0F);
        bipedLeftArm2 = new ModelRenderer(30, 16);
        bipedLeftArm2.mirror = true;
        bipedLeftArm2.addBox(-1F, -1.5F, -1.5F, 3, 3, 3, f + 0.75F);
        bipedLeftArm2.setRotationPoint(5F, 1.5F + f1, 0.0F);
        bipedRightLeg = new ModelRenderer(0, 16);
        bipedRightLeg.addBox(-2F, 0.0F, -1.5F, 3, 12, 3, f);
        bipedRightLeg.setRotationPoint(-1F, 12F + f1, 0.0F);
        bipedLeftLeg = new ModelRenderer(0, 16);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.addBox(-2F, 0.0F, -1.5F, 3, 12, 3, f);
        bipedLeftLeg.setRotationPoint(2.0F, 12F + f1, 0.0F);
        sword = new ModelRenderer[5];
        sword[0] = new ModelRenderer(9, 16);
        sword[0].addBox(-2.5F, 8F, 1.5F, 2, 2, 1, f);
        sword[0].setRotationPoint(-4F, 1.5F + f1, 0.0F);
        sword[1] = new ModelRenderer(32, 10);
        sword[1].addBox(-3F, 6.5F, -2.75F, 3, 5, 1, f + 0.5F);
        sword[1].setRotationPoint(-4F, 1.5F + f1, 0.0F);
        sword[2] = new ModelRenderer(42, 18);
        sword[2].addBox(-2F, 7.5F, -12.5F, 1, 3, 10, f);
        sword[2].setRotationPoint(-4F, 1.5F + f1, 0.0F);
        sword[3] = new ModelRenderer(42, 18);
        sword[3].addBox(-2F, 7.5F, -22.5F, 1, 3, 10, f);
        sword[3].setRotationPoint(-4F, 1.5F + f1, 0.0F);
        sword[4] = new ModelRenderer(28, 17);
        sword[4].addBox(-2F, 8.5F, -23.5F, 1, 1, 1, f);
        sword[4].setRotationPoint(-4F, 1.5F + f1, 0.0F);
        wingLeft = new ModelRenderer(24, 31);
        wingLeft.addBox(0.0F, -4.5F, 0.0F, 19, 8, 1, f);
        wingLeft.setRotationPoint(0.5F, 4.5F + f1, 2.625F);
        wingRight = new ModelRenderer(24, 31);
        wingRight.mirror = true;
        wingRight.addBox(-19F, -4.5F, 0.0F, 19, 8, 1, f);
        wingRight.setRotationPoint(-0.5F, 4.5F + f1, 2.625F);
        skirt = new ModelRenderer[6];
        skirt[0] = new ModelRenderer(0, 0);
        skirt[0].addBox(0.0F, 0.0F, -1F, 3, 6, 1, f);
        skirt[0].setRotationPoint(-3F, 9F + f1, -1.5F);
        skirt[1] = new ModelRenderer(0, 0);
        skirt[1].addBox(0.0F, 0.0F, -1F, 3, 6, 1, f);
        skirt[1].setRotationPoint(0.0F, 9F + f1, -1.5F);
        skirt[2] = new ModelRenderer(0, 0);
        skirt[2].addBox(0.0F, 0.0F, 0.0F, 3, 6, 1, f);
        skirt[2].setRotationPoint(-3F, 9F + f1, 1.5F);
        skirt[3] = new ModelRenderer(0, 0);
        skirt[3].addBox(0.0F, 0.0F, 0.0F, 3, 6, 1, f);
        skirt[3].setRotationPoint(0.0F, 9F + f1, 1.5F);
        skirt[4] = new ModelRenderer(55, 19);
        skirt[4].addBox(-1F, 0.0F, 0.0F, 1, 6, 3, f);
        skirt[4].setRotationPoint(-3F, 9F + f1, -1.5F);
        skirt[5] = new ModelRenderer(55, 19);
        skirt[5].addBox(0.0F, 0.0F, 0.0F, 1, 6, 3, f);
        skirt[5].setRotationPoint(3F, 9F + f1, -1.5F);
        strand = new ModelRenderer[22];
        for(int i = 0; i < 22; i++)
        {
            strand[i] = new ModelRenderer(42 + i % 7, 17);
        }

        strand[0].addBox(-5F, -7F, -4F, 1, 3, 1, f);
        strand[0].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[1].addBox(4F, -7F, -4F, 1, 3, 1, f);
        strand[1].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[2].addBox(-5F, -7F, -3F, 1, 4, 1, f);
        strand[2].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[3].addBox(4F, -7F, -3F, 1, 4, 1, f);
        strand[3].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[4].addBox(-5F, -7F, -2F, 1, 4, 1, f);
        strand[4].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[5].addBox(4F, -7F, -2F, 1, 4, 1, f);
        strand[5].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[6].addBox(-5F, -7F, -1F, 1, 5, 1, f);
        strand[6].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[7].addBox(4F, -7F, -1F, 1, 5, 1, f);
        strand[7].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[8].addBox(-5F, -7F, 0.0F, 1, 5, 1, f);
        strand[8].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[9].addBox(4F, -7F, 0.0F, 1, 5, 1, f);
        strand[9].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[10].addBox(-5F, -7F, 1.0F, 1, 6, 1, f);
        strand[10].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[11].addBox(4F, -7F, 1.0F, 1, 6, 1, f);
        strand[11].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[12].addBox(-5F, -7F, 2.0F, 1, 7, 1, f);
        strand[12].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[13].addBox(4F, -7F, 2.0F, 1, 7, 1, f);
        strand[13].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[14].addBox(-5F, -7F, 3F, 1, 8, 1, f);
        strand[14].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[15].addBox(4F, -7F, 3F, 1, 8, 1, f);
        strand[15].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[16].addBox(-4F, -7F, 4F, 1, 9, 1, f);
        strand[16].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[17].addBox(3F, -7F, 4F, 1, 9, 1, f);
        strand[17].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[18] = new ModelRenderer(42, 17);
        strand[18].addBox(-3F, -7F, 4F, 3, 10, 1, f);
        strand[18].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[19] = new ModelRenderer(43, 17);
        strand[19].addBox(0.0F, -7F, 4F, 3, 10, 1, f);
        strand[19].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[20].addBox(-1F, -7F, -5F, 1, 2, 1, f);
        strand[20].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        strand[21].addBox(0.0F, -7F, -5F, 1, 3, 1, f);
        strand[21].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        halo = new ModelRenderer[4];
        halo[0] = new ModelRenderer(43, 9);
        halo[0].addBox(-2.5F, -11F, -3.5F, 5, 1, 1, f);
        halo[0].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        halo[1] = new ModelRenderer(43, 9);
        halo[1].addBox(-2.5F, -11F, 2.5F, 5, 1, 1, f);
        halo[1].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        halo[2] = new ModelRenderer(42, 11);
        halo[2].addBox(-3.5F, -11F, -2.5F, 1, 1, 5, f);
        halo[2].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        halo[3] = new ModelRenderer(42, 11);
        halo[3].addBox(2.5F, -11F, -2.5F, 1, 1, 5, f);
        halo[3].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        bipedHead.render(f5);
        bipedBody.render(f5);
        bipedRightArm.render(f5);
        bipedLeftArm.render(f5);
        bipedRightLeg.render(f5);
        bipedLeftLeg.render(f5);
        bipedBody2.render(f5);
        bipedRightArm2.render(f5);
        bipedLeftArm2.render(f5);
        wingLeft.render(f5);
        wingRight.render(f5);
        for(int i = 0; i < 5; i++)
        {
            sword[i].render(f5);
        }

        for(int j = 0; j < 6; j++)
        {
            skirt[j].render(f5);
        }

        for(int k = 0; k < 22; k++)
        {
            strand[k].render(f5);
        }

        if(halow)
        {
            GL11.glEnable(2977 /*GL_NORMALIZE*/);
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
            GL11.glBlendFunc(770, 771);
            for(int l = 0; l < 4; l++)
            {
                halo[l].render(f5);
            }

            GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
        }
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        bipedHead.rotateAngleY = f3 / 57.29578F;
        bipedHead.rotateAngleX = f4 / 57.29578F;
        bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
        bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        bipedRightArm.rotateAngleZ = 0.05F;
        bipedLeftArm.rotateAngleZ = -0.05F;
        bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        bipedRightLeg.rotateAngleY = 0.0F;
        bipedLeftLeg.rotateAngleY = 0.0F;
        for(int i = 0; i < 22; i++)
        {
            strand[i].rotateAngleY = bipedHead.rotateAngleY;
            strand[i].rotateAngleX = bipedHead.rotateAngleX;
        }

        for(int j = 0; j < 4; j++)
        {
            halo[j].rotateAngleY = bipedHead.rotateAngleY;
            halo[j].rotateAngleX = bipedHead.rotateAngleX;
        }

        if(isRiding)
        {
            bipedRightArm.rotateAngleX += -0.6283185F;
            bipedLeftArm.rotateAngleX += -0.6283185F;
            bipedRightLeg.rotateAngleX = -1.256637F;
            bipedLeftLeg.rotateAngleX = -1.256637F;
            bipedRightLeg.rotateAngleY = 0.3141593F;
            bipedLeftLeg.rotateAngleY = -0.3141593F;
        }
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
            bipedBody2.rotateAngleY = bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
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
        for(int k = 0; k < 5; k++)
        {
            sword[k].rotateAngleZ = bipedRightArm.rotateAngleZ;
            sword[k].rotateAngleY = bipedRightArm.rotateAngleY;
            sword[k].rotateAngleX = bipedRightArm.rotateAngleX;
        }

        bipedRightArm2.rotateAngleZ = bipedRightArm.rotateAngleZ;
        bipedRightArm2.rotateAngleY = bipedRightArm.rotateAngleY;
        bipedRightArm2.rotateAngleX = bipedRightArm.rotateAngleX;
        bipedLeftArm2.rotateAngleZ = bipedLeftArm.rotateAngleZ;
        bipedLeftArm2.rotateAngleX = bipedLeftArm.rotateAngleX;
        wingLeft.rotateAngleY = -0.2F;
        wingRight.rotateAngleY = 0.2F;
        wingLeft.rotateAngleZ = -0.125F;
        wingRight.rotateAngleZ = 0.125F;
        wingLeft.rotateAngleY += Math.sin(sinage) / 6D;
        wingRight.rotateAngleY -= Math.sin(sinage) / 6D;
        wingLeft.rotateAngleZ += Math.cos(sinage) / (double)(gonRound ? 8F : 3F);
        wingRight.rotateAngleZ -= Math.cos(sinage) / (double)(gonRound ? 8F : 3F);
        skirt[0].rotateAngleX = -0.2F;
        skirt[1].rotateAngleX = -0.2F;
        skirt[2].rotateAngleX = 0.2F;
        skirt[3].rotateAngleX = 0.2F;
        skirt[4].rotateAngleZ = 0.2F;
        skirt[5].rotateAngleZ = -0.2F;
        if(bipedLeftLeg.rotateAngleX < -0.3F)
        {
            skirt[1].rotateAngleX += bipedLeftLeg.rotateAngleX + 0.3F;
            skirt[2].rotateAngleX -= bipedLeftLeg.rotateAngleX + 0.3F;
        }
        if(bipedLeftLeg.rotateAngleX > 0.3F)
        {
            skirt[3].rotateAngleX += bipedLeftLeg.rotateAngleX - 0.3F;
            skirt[0].rotateAngleX -= bipedLeftLeg.rotateAngleX - 0.3F;
        }
    }

    public ModelRenderer bipedBody2;
    public ModelRenderer bipedRightArm2;
    public ModelRenderer bipedLeftArm2;
    public ModelRenderer wingLeft;
    public ModelRenderer wingRight;
    public ModelRenderer skirt[];
    public ModelRenderer sword[];
    public ModelRenderer strand[];
    public ModelRenderer halo[];
    public static final int swordParts = 5;
    public static final int skirtParts = 6;
    public static final int strandParts = 22;
    public static final int haloParts = 4;
    public float sinage;
    public boolean gonRound;
    public boolean halow;
}
