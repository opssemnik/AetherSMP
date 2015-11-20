// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityPortalFX, World

public class EntityAetherPortalFX extends EntityPortalFX
{

    public EntityAetherPortalFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        float f = rand.nextFloat() * 0.6F + 0.4F;
        particleRed = particleGreen = particleBlue = 1.0F * f;
        particleRed *= 0.2F;
        particleGreen *= 0.2F;
    }
}
