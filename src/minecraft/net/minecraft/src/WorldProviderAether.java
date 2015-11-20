// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            WorldProvider, WorldChunkManagerAether, ChunkProviderAether, World, 
//            ModLoader, AetherAchievements, StatFileWriter, MathHelper, 
//            Vec3D, Block, Material, IChunkProvider

public class WorldProviderAether extends WorldProvider
{

    public WorldProviderAether()
    {
        colorsSunriseSunset = new float[4];
    }

    public void registerWorldChunkManager()
    {
        worldChunkMgr = new WorldChunkManagerAether(1.0D);
        worldType = 1;
    }

    public IChunkProvider getChunkProvider()
    {
        return new ChunkProviderAether(worldObj, worldObj.getRandomSeed());
    }

    public float calculateCelestialAngle(long l, float f)
    {
        boolean flag = ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(AetherAchievements.defeatGold);
        if(flag)
        {
            int i = (int)(l % 0x13880L);
            float f1 = ((float)i + f) / 120000F - 0.25F;
            if(i > 60000)
            {
                i -= 40000;
                f1 = ((float)i + f) / 20000F - 0.25F;
            }
            if(f1 < 0.0F)
            {
                f1++;
            }
            if(f1 > 1.0F)
            {
                f1--;
            }
            float f2 = f1;
            f1 = 1.0F - (float)((Math.cos((double)f1 * 3.1415926535897931D) + 1.0D) / 2D);
            f1 = f2 + (f1 - f2) / 3F;
            return f1;
        } else
        {
            return 0.0F;
        }
    }

    public float[] calcSunriseSunsetColors(float f, float f1)
    {
        float f2 = 0.4F;
        float f3 = MathHelper.cos(f * 3.141593F * 2.0F) - 0.0F;
        float f4 = -0F;
        if(f3 >= f4 - f2 && f3 <= f4 + f2)
        {
            float f5 = ((f3 - f4) / f2) * 0.5F + 0.5F;
            float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * 3.141593F)) * 0.99F;
            f6 *= f6;
            colorsSunriseSunset[0] = f5 * 0.3F + 0.1F;
            colorsSunriseSunset[1] = f5 * f5 * 0.7F + 0.2F;
            colorsSunriseSunset[2] = f5 * f5 * 0.7F + 0.2F;
            colorsSunriseSunset[3] = f6;
            return colorsSunriseSunset;
        } else
        {
            return null;
        }
    }

    public Vec3D func_4096_a(float f, float f1)
    {
        int i = 0x8080a0;
        float f2 = MathHelper.cos(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = (float)(i >> 16 & 0xff) / 255F;
        float f4 = (float)(i >> 8 & 0xff) / 255F;
        float f5 = (float)(i & 0xff) / 255F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return Vec3D.createVector(f3, f4, f5);
    }

    public boolean func_28112_c()
    {
        return false;
    }

    public float getCloudHeight()
    {
        return 8F;
    }

    public boolean canCoordinateBeSpawn(int i, int j)
    {
        int k = worldObj.getFirstUncoveredBlock(i, j);
        if(k == 0)
        {
            return false;
        } else
        {
            return Block.blocksList[k].blockMaterial.getIsSolid();
        }
    }

    public boolean canRespawnHere()
    {
        return false;
    }

    private float colorsSunriseSunset[];
}
