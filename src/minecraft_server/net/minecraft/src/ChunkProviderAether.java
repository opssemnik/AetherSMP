// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenCaves, NoiseGeneratorOctaves, AetherBlocks, 
//            Block, BiomeGenAether, BiomeGenBase, Chunk, 
//            World, WorldChunkManager, MapGenBase, BlockSand, 
//            AetherGenGumdrop, WorldGenLakes, AetherGenMinable, AetherGenFlowers, 
//            AetherGenClouds, AetherGenDungeonBronze, AetherGenDungeonSilver, AetherGenQuicksoil, 
//            WorldGenerator, AetherGenLiquids, IProgressUpdate

public class ChunkProviderAether
    implements IChunkProvider
{

    public ChunkProviderAether(World world, long l)
    {
        field_28079_r = new double[256];
        field_28078_s = new double[256];
        field_28077_t = new double[256];
        mapGenCaves = new MapGenCaves();
        field_28088_i = new int[32][32];
        worldObj = world;
        random = new Random(l);
        noiseGenerator1 = new NoiseGeneratorOctaves(random, 16);
        noiseGenerator2 = new NoiseGeneratorOctaves(random, 16);
        noiseGenerator3 = new NoiseGeneratorOctaves(random, 8);
        noiseGenerator4 = new NoiseGeneratorOctaves(random, 4);
        noiseGenerator5 = new NoiseGeneratorOctaves(random, 4);
        noiseGenerator6 = new NoiseGeneratorOctaves(random, 10);
        noiseGenerator7 = new NoiseGeneratorOctaves(random, 16);
        noiseGenerator8 = new NoiseGeneratorOctaves(random, 8);
    }

    public void generateTerrain(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[], double ad[])
    {
        byte byte0 = 2;
        int k = byte0 + 1;
        byte byte1 = 33;
        int l = byte0 + 1;
        field_28080_q = func_28073_a(field_28080_q, i * byte0, 0, j * byte0, k, byte1, l);
        for(int i1 = 0; i1 < byte0; i1++)
        {
            for(int j1 = 0; j1 < byte0; j1++)
            {
                for(int k1 = 0; k1 < 32; k1++)
                {
                    double d = 0.25D;
                    double d1 = field_28080_q[((i1 + 0) * l + (j1 + 0)) * byte1 + (k1 + 0)];
                    double d2 = field_28080_q[((i1 + 0) * l + (j1 + 1)) * byte1 + (k1 + 0)];
                    double d3 = field_28080_q[((i1 + 1) * l + (j1 + 0)) * byte1 + (k1 + 0)];
                    double d4 = field_28080_q[((i1 + 1) * l + (j1 + 1)) * byte1 + (k1 + 0)];
                    double d5 = (field_28080_q[((i1 + 0) * l + (j1 + 0)) * byte1 + (k1 + 1)] - d1) * d;
                    double d6 = (field_28080_q[((i1 + 0) * l + (j1 + 1)) * byte1 + (k1 + 1)] - d2) * d;
                    double d7 = (field_28080_q[((i1 + 1) * l + (j1 + 0)) * byte1 + (k1 + 1)] - d3) * d;
                    double d8 = (field_28080_q[((i1 + 1) * l + (j1 + 1)) * byte1 + (k1 + 1)] - d4) * d;
                    for(int l1 = 0; l1 < 4; l1++)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            int j2 = i2 + i1 * 8 << 11 | 0 + j1 * 8 << 7 | k1 * 4 + l1;
                            char c = '\200';
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for(int k2 = 0; k2 < 8; k2++)
                            {
                                int l2 = 0;
                                if(d15 > 0.0D)
                                {
                                    l2 = AetherBlocks.Holystone.blockID;
                                }
                                abyte0[j2] = (byte)l2;
                                j2 += c;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }

                }

            }

        }

    }

    public void replaceBlocksForBiome(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[])
    {
        double d = 0.03125D;
        field_28079_r = noiseGenerator4.generateNoiseOctaves(field_28079_r, i * 16, j * 16, 0.0D, 16, 16, 1, d, d, 1.0D);
        field_28078_s = noiseGenerator4.generateNoiseOctaves(field_28078_s, i * 16, 109.0134D, j * 16, 16, 1, 16, d, 1.0D, d);
        field_28077_t = noiseGenerator5.generateNoiseOctaves(field_28077_t, i * 16, j * 16, 0.0D, 16, 16, 1, d * 2D, d * 2D, d * 2D);
        for(int k = 0; k < 16; k++)
        {
            for(int l = 0; l < 16; l++)
            {
                BiomeGenAether biomegenaether = BiomeGenAether.me;
                int i1 = (int)(field_28077_t[k + l * 16] / 3D + 3D + random.nextDouble() * 0.25D);
                int j1 = -1;
                topAetherBlock = (byte)AetherBlocks.Grass.blockID;
                fillerAetherBlock = (byte)AetherBlocks.Dirt.blockID;
                byte byte0 = topAetherBlock;
                byte byte1 = fillerAetherBlock;
                byte byte2 = (byte)AetherBlocks.Holystone.blockID;
                if(byte0 < 0)
                {
                    byte0 += 0;
                }
                if(byte1 < 0)
                {
                    byte1 += 0;
                }
                if(byte2 < 0)
                {
                    byte2 += 0;
                }
                for(int k1 = 127; k1 >= 0; k1--)
                {
                    int l1 = (l * 16 + k) * 128 + k1;
                    byte byte3 = abyte0[l1];
                    if(byte3 == 0)
                    {
                        j1 = -1;
                        continue;
                    }
                    if(byte3 != byte2)
                    {
                        continue;
                    }
                    if(j1 == -1)
                    {
                        if(i1 <= 0)
                        {
                            byte0 = 0;
                            byte1 = byte2;
                        }
                        j1 = i1;
                        if(k1 >= 0)
                        {
                            abyte0[l1] = byte0;
                        } else
                        {
                            abyte0[l1] = byte1;
                        }
                        continue;
                    }
                    if(j1 > 0)
                    {
                        j1--;
                        abyte0[l1] = byte1;
                    }
                }

            }

        }

    }

    public Chunk loadChunk(int i, int j)
    {
        return provideChunk(i, j);
    }

    public Chunk provideChunk(int i, int j)
    {
        random.setSeed((long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        Chunk chunk = new Chunk(worldObj, abyte0, i, j);
        field_28075_v = worldObj.getWorldChunkManager().loadBlockGeneratorData(field_28075_v, i * 16, j * 16, 16, 16);
        double ad[] = worldObj.getWorldChunkManager().temperature;
        generateTerrain(i, j, abyte0, field_28075_v, ad);
        replaceBlocksForBiome(i, j, abyte0, field_28075_v);
        mapGenCaves.func_667_a(this, worldObj, i, j, abyte0);
        chunk.func_353_b();
        return chunk;
    }

    private double[] func_28073_a(double ad[], int i, int j, int k, int l, int i1, int j1)
    {
        if(ad == null)
        {
            ad = new double[l * i1 * j1];
        }
        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        double ad1[] = worldObj.getWorldChunkManager().temperature;
        double ad2[] = worldObj.getWorldChunkManager().humidity;
        field_28090_g = noiseGenerator6.func_4103_a(field_28090_g, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        field_28089_h = noiseGenerator7.func_4103_a(field_28089_h, i, k, l, j1, 200D, 200D, 0.5D);
        d *= 2D;
        field_28093_d = noiseGenerator3.generateNoiseOctaves(field_28093_d, i, j, k, l, i1, j1, d / 80D, d1 / 160D, d / 80D);
        field_28092_e = noiseGenerator1.generateNoiseOctaves(field_28092_e, i, j, k, l, i1, j1, d, d1, d);
        field_28091_f = noiseGenerator2.generateNoiseOctaves(field_28091_f, i, j, k, l, i1, j1, d, d1, d);
        int k1 = 0;
        int l1 = 0;
        int i2 = 16 / l;
        for(int j2 = 0; j2 < l; j2++)
        {
            int k2 = j2 * i2 + i2 / 2;
            for(int l2 = 0; l2 < j1; l2++)
            {
                int i3 = l2 * i2 + i2 / 2;
                double d2 = ad1[k2 * 16 + i3];
                double d3 = ad2[k2 * 16 + i3] * d2;
                double d4 = 1.0D - d3;
                d4 *= d4;
                d4 *= d4;
                d4 = 1.0D - d4;
                double d5 = (field_28090_g[l1] + 256D) / 512D;
                d5 *= d4;
                if(d5 > 1.0D)
                {
                    d5 = 1.0D;
                }
                double d6 = field_28089_h[l1] / 8000D;
                if(d6 < 0.0D)
                {
                    d6 = -d6 * 0.29999999999999999D;
                }
                d6 = d6 * 3D - 2D;
                if(d6 > 1.0D)
                {
                    d6 = 1.0D;
                }
                d6 /= 8D;
                d6 = 0.0D;
                if(d5 < 0.0D)
                {
                    d5 = 0.0D;
                }
                d5 += 0.5D;
                d6 = (d6 * (double)i1) / 16D;
                l1++;
                double d7 = (double)i1 / 2D;
                for(int j3 = 0; j3 < i1; j3++)
                {
                    double d8 = 0.0D;
                    double d9 = (((double)j3 - d7) * 8D) / d5;
                    if(d9 < 0.0D)
                    {
                        d9 *= -1D;
                    }
                    double d10 = field_28092_e[k1] / 512D;
                    double d11 = field_28091_f[k1] / 512D;
                    double d12 = (field_28093_d[k1] / 10D + 1.0D) / 2D;
                    if(d12 < 0.0D)
                    {
                        d8 = d10;
                    } else
                    if(d12 > 1.0D)
                    {
                        d8 = d11;
                    } else
                    {
                        d8 = d10 + (d11 - d10) * d12;
                    }
                    d8 -= 8D;
                    int k3 = 32;
                    if(j3 > i1 - k3)
                    {
                        double d13 = (float)(j3 - (i1 - k3)) / ((float)k3 - 1.0F);
                        d8 = d8 * (1.0D - d13) + -30D * d13;
                    }
                    k3 = 8;
                    if(j3 < k3)
                    {
                        double d14 = (float)(k3 - j3) / ((float)k3 - 1.0F);
                        d8 = d8 * (1.0D - d14) + -30D * d14;
                    }
                    ad[k1] = d8;
                    k1++;
                }

            }

        }

        return ad;
    }

    public boolean chunkExists(int i, int j)
    {
        return true;
    }

    public void populate(IChunkProvider ichunkprovider, int i, int j)
    {
        BlockSand.fallInstantly = true;
        int k = i * 16;
        int l = j * 16;
        BiomeGenBase biomegenbase = worldObj.getWorldChunkManager().getBiomeGenAt(k + 16, l + 16);
        random.setSeed(worldObj.getRandomSeed());
        long l1 = (random.nextLong() / 2L) * 2L + 1L;
        long l2 = (random.nextLong() / 2L) * 2L + 1L;
        random.setSeed((long)i * l1 + (long)j * l2 ^ worldObj.getRandomSeed());
        double d = 0.25D;
        if(gumCount < 800)
        {
            gumCount++;
        } else
        if(random.nextInt(32) == 0)
        {
            boolean flag = false;
            int k5 = k + random.nextInt(16) + 8;
            int l9 = random.nextInt(64) + 32;
            int j14 = l + random.nextInt(16) + 8;
            flag = (new AetherGenGumdrop()).generate(worldObj, random, k5, l9, j14);
            if(flag)
            {
                gumCount = 0;
            }
        }
        if(random.nextInt(3) == 0)
        {
            int i1 = k + random.nextInt(16) + 8;
            int l5 = random.nextInt(128);
            int i10 = l + random.nextInt(16) + 8;
            (new WorldGenLakes(Block.waterStill.blockID)).generate(worldObj, random, i1, l5, i10);
        }
        for(int j1 = 0; j1 < 20; j1++)
        {
            int i6 = k + random.nextInt(16);
            int j10 = random.nextInt(128);
            int k14 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.Dirt.blockID, 32)).generate(worldObj, random, i6, j10, k14);
        }

        for(int k1 = 0; k1 < 2; k1++)
        {
            int j6 = k + random.nextInt(16) + 8;
            int k10 = random.nextInt(128);
            int l14 = l + random.nextInt(16) + 8;
            (new AetherGenFlowers(AetherBlocks.WhiteFlower.blockID)).generate(worldObj, random, j6, k10, l14);
        }

        for(int i2 = 0; i2 < 2; i2++)
        {
            if(random.nextInt(2) == 0)
            {
                int k6 = k + random.nextInt(16) + 8;
                int l10 = random.nextInt(128);
                int i15 = l + random.nextInt(16) + 8;
                (new AetherGenFlowers(AetherBlocks.PurpleFlower.blockID)).generate(worldObj, random, k6, l10, i15);
            }
        }

        for(int j2 = 0; j2 < 10; j2++)
        {
            int l6 = k + random.nextInt(16);
            int i11 = random.nextInt(128);
            int j15 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.Icestone.blockID, 32)).generate(worldObj, random, l6, i11, j15);
        }

        for(int k2 = 0; k2 < 20; k2++)
        {
            int i7 = k + random.nextInt(16);
            int j11 = random.nextInt(128);
            int k15 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.AmbrosiumOre.blockID, 16)).generate(worldObj, random, i7, j11, k15);
        }

        for(int i3 = 0; i3 < 15; i3++)
        {
            int j7 = k + random.nextInt(16);
            int k11 = random.nextInt(64);
            int l15 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.ZaniteOre.blockID, 8)).generate(worldObj, random, j7, k11, l15);
        }

        for(int j3 = 0; j3 < 8; j3++)
        {
            int k7 = k + random.nextInt(16);
            int l11 = random.nextInt(32);
            int i16 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.GravititeOre.blockID, 7)).generate(worldObj, random, k7, l11, i16);
        }

        if(random.nextInt(50) == 0)
        {
            int k3 = k + random.nextInt(16);
            int l7 = random.nextInt(32) + 96;
            int i12 = l + random.nextInt(16);
            (new AetherGenClouds(AetherBlocks.Aercloud.blockID, 2, 4, false)).generate(worldObj, random, k3, l7, i12);
        }
        if(random.nextInt(13) == 0)
        {
            int l3 = k + random.nextInt(16);
            int i8 = random.nextInt(64) + 32;
            int j12 = l + random.nextInt(16);
            (new AetherGenClouds(AetherBlocks.Aercloud.blockID, 1, 8, false)).generate(worldObj, random, l3, i8, j12);
        }
        if(random.nextInt(7) == 0)
        {
            int i4 = k + random.nextInt(16);
            int j8 = random.nextInt(64) + 32;
            int k12 = l + random.nextInt(16);
            (new AetherGenClouds(AetherBlocks.Aercloud.blockID, 0, 16, false)).generate(worldObj, random, i4, j8, k12);
        }
        if(random.nextInt(50) == 0)
        {
            int j4 = k + random.nextInt(16);
            int k8 = random.nextInt(32);
            int l12 = l + random.nextInt(16);
            (new AetherGenClouds(AetherBlocks.Aercloud.blockID, 0, 64, true)).generate(worldObj, random, j4, k8, l12);
        }
        for(int k4 = 0; k4 < 2; k4++)
        {
            int l8 = k + random.nextInt(16);
            int i13 = 32 + random.nextInt(64);
            int j16 = l + random.nextInt(16);
          //  (new AetherGenDungeonBronze(AetherBlocks.LockedDungeonStone.blockID, AetherBlocks.LockedLightDungeonStone.blockID, AetherBlocks.DungeonStone.blockID, AetherBlocks.LightDungeonStone.blockID, AetherBlocks.Holystone.blockID, 2, AetherBlocks.Holystone.blockID, 0, 16, true)).generate(worldObj, random, l8, i13, j16);
        }

        if(random.nextInt(500) == 0)
        {
            int l4 = k + random.nextInt(16);
            int i9 = random.nextInt(32) + 64;
            int j13 = l + random.nextInt(16);
            (new AetherGenDungeonSilver(AetherBlocks.LockedDungeonStone.blockID, AetherBlocks.LockedLightDungeonStone.blockID, AetherBlocks.DungeonStone.blockID, AetherBlocks.LightDungeonStone.blockID, AetherBlocks.Holystone.blockID, 2, AetherBlocks.Holystone.blockID, 0, AetherBlocks.Pillar.blockID)).generate(worldObj, random, l4, i9, j13);
        }
        if(random.nextInt(5) == 0)
        {
            for(int i5 = k; i5 < k + 16; i5++)
            {
                for(int j9 = l; j9 < l + 16; j9++)
                {
                    for(int k13 = 0; k13 < 48; k13++)
                    {
                        if(worldObj.getBlockId(i5, k13, j9) == 0 && worldObj.getBlockId(i5, k13 + 1, j9) == AetherBlocks.Grass.blockID && worldObj.getBlockId(i5, k13 + 2, j9) == 0)
                        {
                            (new AetherGenQuicksoil(AetherBlocks.Quicksoil.blockID)).generate(worldObj, random, i5, k13, j9);
                            k13 = 128;
                        }
                    }

                }

            }

        }
        d = 0.5D;
        int j5 = (int)((noiseGenerator8.func_647_a((double)k * d, (double)l * d) / 8D + random.nextDouble() * 4D + 4D) / 3D);
        int k9 = 0;
        if(random.nextInt(10) == 0)
        {
            k9++;
        }
      
        k9 += j5;
        for(int l13 = 0; l13 < k9; l13++)
        {
            int k16 = k + random.nextInt(16) + 8;
            int i17 = l + random.nextInt(16) + 8;
            WorldGenerator worldgenerator = biomegenbase.getRandomWorldGenForTrees(random);
            worldgenerator.func_420_a(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(worldObj, random, k16, worldObj.getHeightValue(k16, i17), i17);
        }

        for(int i14 = 0; i14 < 50; i14++)
        {
            int l16 = k + random.nextInt(16) + 8;
            int j17 = random.nextInt(random.nextInt(120) + 8);
            int k17 = l + random.nextInt(16) + 8;
            (new AetherGenLiquids(Block.waterMoving.blockID)).generate(worldObj, random, l16, j17, k17);
        }

        BlockSand.fallInstantly = false;
    }

    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate)
    {
        return true;
    }

    public boolean unload100OldestChunks()
    {
        return false;
    }

    public boolean canSave()
    {
        return true;
    }

    public String makeString()
    {
        return "RandomLevelSource";
    }

   
    public static int gumCount;
    private Random random;
    private NoiseGeneratorOctaves noiseGenerator1;
    private NoiseGeneratorOctaves noiseGenerator2;
    private NoiseGeneratorOctaves noiseGenerator3;
    private NoiseGeneratorOctaves noiseGenerator4;
    private NoiseGeneratorOctaves noiseGenerator5;
    public NoiseGeneratorOctaves noiseGenerator6;
    public NoiseGeneratorOctaves noiseGenerator7;
    public NoiseGeneratorOctaves noiseGenerator8;
    private World worldObj;
    private double field_28080_q[];
    private double field_28079_r[];
    private double field_28078_s[];
    private double field_28077_t[];
    private MapGenBase mapGenCaves;
    private BiomeGenBase field_28075_v[];
    double field_28093_d[];
    double field_28092_e[];
    double field_28091_f[];
    double field_28090_g[];
    double field_28089_h[];
    int field_28088_i[][];
    private double field_28074_w[];
    public byte topAetherBlock;
    public byte fillerAetherBlock;
	

	public boolean func_361_a() {
		return false;
	}

	public boolean func_364_b() {
		return false;
	}
}
