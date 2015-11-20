// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityMimic

public class ModelMimic extends ModelBase
{

    public ModelMimic()
    {
        box = new ModelRenderer(0, 0);
        box.addBox(-8F, 0.0F, -8F, 16, 10, 16);
        box.setRotationPoint(0.0F, -24F, 0.0F);
        boxLid = new ModelRenderer(16, 10);
        boxLid.addBox(0.0F, 0.0F, 0.0F, 16, 6, 16);
        boxLid.setRotationPoint(-8F, -24F, 8F);
        leftLeg = new ModelRenderer(0, 0);
        leftLeg.addBox(-3F, 0.0F, -3F, 6, 15, 6);
        leftLeg.setRotationPoint(-4F, -15F, 0.0F);
        rightLeg = new ModelRenderer(0, 0);
        rightLeg.addBox(-3F, 0.0F, -3F, 6, 15, 6);
        rightLeg.setRotationPoint(4F, -15F, 0.0F);
    }

    public void render1(float f, float f1, float f2, float f3, float f4, float f5, EntityMimic entitymimic)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        boxLid.rotateAngleX = 3.141593F - entitymimic.mouth;
        rightLeg.rotateAngleX = entitymimic.legs;
        leftLeg.rotateAngleX = -entitymimic.legs;
        box.render(f5);
    }

    public void render2(float f, float f1, float f2, float f3, float f4, float f5, EntityMimic entitymimic)
    {
        boxLid.render(f5);
        leftLeg.render(f5);
        rightLeg.render(f5);
    }

    ModelRenderer box;
    ModelRenderer boxLid;
    ModelRenderer leftLeg;
    ModelRenderer rightLeg;
}
