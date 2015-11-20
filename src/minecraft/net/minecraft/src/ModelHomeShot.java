// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelHomeShot extends ModelBase
{

    public ModelHomeShot()
    {
        this(0.0F);
    }

    public ModelHomeShot(float f)
    {
        this(f, 0.0F);
    }

    public ModelHomeShot(float f, float f1)
    {
        sinage = new float[3];
        head = new ModelRenderer[3];
        head[0] = new ModelRenderer(0, 0);
        head[1] = new ModelRenderer(32, 0);
        head[2] = new ModelRenderer(0, 16);
        for(int i = 0; i < 3; i++)
        {
            head[i].addBox(-4F, -4F, -4F, 8, 8, 8, f);
            head[i].setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        }

    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        GL11.glTranslatef(0.0F, 0.75F, 0.0F);
        GL11.glEnable(2977 /*GL_NORMALIZE*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glRotatef(sinage[0] * 57.29577F, 1.0F, 0.0F, 0.0F);
        head[0].render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glRotatef(sinage[1] * 57.29577F, 0.0F, 1.0F, 0.0F);
        head[1].render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glRotatef(sinage[2] * 57.29577F, 0.0F, 0.0F, 1.0F);
        head[2].render(f5);
        GL11.glPopMatrix();
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        for(int i = 0; i < 3; i++)
        {
            head[i].rotateAngleY = f3 / 57.29578F;
            head[i].rotateAngleX = f4 / 57.29578F;
        }

    }

    public ModelRenderer head[];
    public float sinage[];
    private static final float sponge = 57.29577F;
}
