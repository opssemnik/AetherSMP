// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelAerwhale extends ModelBase
{

    public ModelAerwhale()
    {
        body2 = new ModelRenderer(0, 0);
        body2.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5);
        body3 = new ModelRenderer(0, 10);
        body3.addBox(-1.5F, -1.5F, 2.5F, 3, 3, 4);
        fin1 = new ModelRenderer(0, 17);
        fin1.addBox(-7.5F, -0.5F, 2.5F, 8, 1, 4);
        fin2 = new ModelRenderer(0, 17);
        fin2.addBox(-0.5F, -0.5F, 2.5F, 8, 1, 4);
        fin3 = new ModelRenderer(0, 22);
        fin3.addBox(-7.5F, 1.5F, -6.5F, 4, 1, 2);
        fin4 = new ModelRenderer(0, 22);
        fin4.addBox(3.5F, 1.5F, -6.5F, 4, 1, 2);
        body = new ModelRenderer(20, 0);
        body.addBox(-3.5F, -3.5F, -12.5F, 7, 6, 10);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        body.render(f5);
        body2.render(f5);
        body3.render(f5);
        fin1.render(f5);
        fin2.render(f5);
        fin3.render(f5);
        fin4.render(f5);
    }

    ModelRenderer body;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer fin1;
    ModelRenderer fin2;
    ModelRenderer fin3;
    ModelRenderer fin4;
}
