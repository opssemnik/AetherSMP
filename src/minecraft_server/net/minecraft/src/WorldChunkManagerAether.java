// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Arrays;

// Referenced classes of package net.minecraft.src:
//            WorldChunkManager, BiomeGenAether, BiomeGenBase, ChunkCoordIntPair

public class WorldChunkManagerAether extends WorldChunkManager
{

    public WorldChunkManagerAether(double d)
    {
        field_4201_e = BiomeGenAether.me;
        field_4200_f = d;
    }

    public BiomeGenBase getBiomeGenAtChunkCoord(ChunkCoordIntPair chunkcoordintpair)
    {
        return field_4201_e;
    }

    public BiomeGenBase getBiomeGenAt(int i, int j)
    {
        return field_4201_e;
    }

    public double getTemperature(int i, int j)
    {
        return field_4200_f;
    }

    public double[] getTemperatures(double ad[], int i, int j, int k, int l)
    {
        if(ad == null || ad.length < k * l)
        {
            ad = new double[k * l];
        }
        Arrays.fill(ad, 0, k * l, field_4200_f);
        return ad;
    }

    public BiomeGenBase[] func_4069_a(int i, int j, int k, int l)
    {
    	field_4256_d = loadBlockGeneratorData(field_4256_d, i, j, k, l);
        return field_4256_d;
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase abiomegenbase[], int i, int j, int k, int l)
    {
        if(abiomegenbase == null || abiomegenbase.length < k * l)
        {
            abiomegenbase = new BiomeGenBase[k * l];
        }
        if(temperature == null || temperature.length < k * l)
        {
            temperature = new double[k * l];
            humidity = new double[k * l];
        }
        Arrays.fill(abiomegenbase, 0, k * l, field_4201_e);
        return abiomegenbase;
    }

    private BiomeGenBase field_4201_e;
    private double field_4200_f;
}
