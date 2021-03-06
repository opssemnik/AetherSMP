// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityFlyingCow

public class ModelFlyingCow2 extends ModelBase
{

    public ModelFlyingCow2()
    {
        leftWingInner = new ModelRenderer(0, 0);
        leftWingOuter = new ModelRenderer(20, 0);
        rightWingInner = new ModelRenderer(0, 0);
        rightWingOuter = new ModelRenderer(40, 0);
        leftWingInner.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        leftWingOuter.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        rightWingInner.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        rightWingOuter.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        rightWingOuter.rotateAngleY = 3.141593F;
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = -(float)Math.acos(flyingcow.wingFold);
        float f7 = (32F * flyingcow.wingFold) / 4F;
        float f8 = (-32F * (float)Math.sqrt(1.0F - flyingcow.wingFold * flyingcow.wingFold)) / 4F;
        float f9 = 0.0F;
        float f10 = f7 * (float)Math.cos(flyingcow.wingAngle) - f8 * (float)Math.sin(flyingcow.wingAngle);
        float f11 = f7 * (float)Math.sin(flyingcow.wingAngle) + f8 * (float)Math.cos(flyingcow.wingAngle);
        leftWingInner.setRotationPoint(4F + f10, f11 + 6F, f9);
        rightWingInner.setRotationPoint(-4F - f10, f11 + 6F, f9);
        f7 *= 3F;
        f10 = f7 * (float)Math.cos(flyingcow.wingAngle) - f8 * (float)Math.sin(flyingcow.wingAngle);
        f11 = f7 * (float)Math.sin(flyingcow.wingAngle) + f8 * (float)Math.cos(flyingcow.wingAngle);
        leftWingOuter.setRotationPoint(4F + f10, f11 + 6F, f9);
        rightWingOuter.setRotationPoint(-4F - f10, f11 + 6F, f9);
        leftWingInner.rotateAngleZ = flyingcow.wingAngle + f6 + 1.570796F;
        leftWingOuter.rotateAngleZ = (flyingcow.wingAngle - f6) + 1.570796F;
        rightWingInner.rotateAngleZ = -((flyingcow.wingAngle + f6) - 1.570796F);
        rightWingOuter.rotateAngleZ = -((flyingcow.wingAngle - f6) + 1.570796F);
        leftWingOuter.render(f5);
        leftWingInner.render(f5);
        rightWingOuter.render(f5);
        rightWingInner.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    private ModelRenderer leftWingInner;
    private ModelRenderer leftWingOuter;
    private ModelRenderer rightWingInner;
    private ModelRenderer rightWingOuter;
    public static EntityFlyingCow flyingcow;
}
