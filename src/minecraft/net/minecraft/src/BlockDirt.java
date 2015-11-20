// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockDirt extends Block
{

    protected BlockDirt(int i, int j)
    {
        super(i, j, Material.ground);
    }
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entity)
    {
        if(entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayer)
        {
           ((EntityPlayer)entity).setInPortal(3);
           return true;
        }
        return false;
    }
}
