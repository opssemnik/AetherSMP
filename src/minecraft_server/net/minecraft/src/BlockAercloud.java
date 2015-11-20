// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, ModLoader, Material, Entity, 
//            World, EntityPlayer, AetherAchievements, mod_Aether, 
//            IBlockAccess, AxisAlignedBB

public class BlockAercloud extends Block
{

    protected BlockAercloud(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/Aercloud.png"), Material.ice);
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.fallDistance = 0.0F;
        if(world.getBlockMetadata(i, j, k) == 1)
        {
            entity.motionY = 2D;
            if(entity instanceof EntityPlayer)
            {
               ((EntityPlayer)entity).func_27017_a(AetherAchievements.blueCloud);
            }
        } else
        if(entity.motionY < 0.0D)
        {
            entity.motionY *= 0.0050000000000000001D;
        }
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public int getRenderColor(int i)
    {
        if(i == 1)
        {
            return 0x38acec;
        }
        return i != 2 ? 0xffffff : 0xffff80;
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        if(world.getBlockMetadata(i, j, k) == 1)
        {
            return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i, j, k);
        } else
        {
            return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, j, k + 1);
        }
    }

    public static final int bouncingMeta = 1;
}
