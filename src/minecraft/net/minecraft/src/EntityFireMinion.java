// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, AxisAlignedBB, World

public class EntityFireMinion extends EntityMob
{

    public EntityFireMinion(World world)
    {
        super(world);
        texture = "/aether/mobs/firemonster.png";
        moveSpeed = 1.5F;
        attackStrength = 5;
        health = 40;
        isImmuneToFire = true;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(health > 0)
        {
            for(int i = 0; i < 4; i++)
            {
                double d = rand.nextFloat() - 0.5F;
                double d1 = rand.nextFloat();
                double d2 = rand.nextFloat() - 0.5F;
                double d3 = posX + d * d1;
                double d4 = (boundingBox.minY + d1) - 0.5D;
                double d5 = posZ + d2 * d1;
                worldObj.spawnParticle("flame", d3, d4, d5, 0.0D, -0.075000002980232239D, 0.0D);
            }

        }
    }
}
