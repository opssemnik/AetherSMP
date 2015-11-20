// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, AetherBlocks, BlockTrap, 
//            ModLoader

public class BlockDungeon extends Block
{

    protected BlockDungeon(int i)
    {
        super(i, Material.rock);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 2)
        {
            return isLit() ? sprGoldLit : sprGold;
        }
        if(j == 1)
        {
            return isLit() ? sprSilverLit : sprSilver;
        } else
        {
            return isLit() ? sprBronzeLit : sprBronze;
        }
    }

    private boolean isLit()
    {
        return blockID == AetherBlocks.LightDungeonStone.blockID || blockID == AetherBlocks.LockedLightDungeonStone.blockID;
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int func_21034_c(int i)
    {
        return ~i & 0xf;
    }

    public static int func_21035_d(int i)
    {
        return ~i & 0xf;
    }

    public static int sprBronze;
    public static int sprSilver;
    public static int sprGold;
    public static int sprBronzeLit = ModLoader.addOverride("/terrain.png", "/aether/blocks/LightCarvedStone.png");
    public static int sprSilverLit = ModLoader.addOverride("/terrain.png", "/aether/blocks/LightAngelicStone.png");
    public static int sprGoldLit = ModLoader.addOverride("/terrain.png", "/aether/blocks/LightHellfireStone.png");

    static 
    {
        sprBronze = BlockTrap.sprBronze;
        sprSilver = BlockTrap.sprSilver;
        sprGold = BlockTrap.sprGold;
    }
}
