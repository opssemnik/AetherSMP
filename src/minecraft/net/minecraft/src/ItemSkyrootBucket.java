// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Item, Block, ItemStack, EntityPlayer, 
//            Vec3D, MathHelper, World, ModLoader, 
//            MovingObjectPosition, EntityAechorPlant, AetherPoison, EnumMovingObjectType, 
//            Material, AetherItems, WorldProvider, EntityCow, 
//            EntityFlyingCow

public class ItemSkyrootBucket extends Item
{

    public ItemSkyrootBucket(int i)
    {
        super(i);
        setHasSubtypes(true);
        maxStackSize = 1;
    }

    public int getIconFromDamage(int i)
    {
        if(i == 3)
        {
            return sprRemedy;
        }
        if(i == 2)
        {
            return sprPoison;
        }
        if(i == 1)
        {
            return sprMilk;
        }
        if(i == Block.waterMoving.blockID)
        {
            return sprWater;
        } else
        {
            return sprEmpty;
        }
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 3 && i != Block.waterMoving.blockID)
        {
            i = 0;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        float f = 1.0F;
        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
        float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
        double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
        double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
        double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
        Vec3D vec3d = Vec3D.createVector(d, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        float f6 = MathHelper.sin(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5D;
        Vec3D vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do(vec3d, vec3d1, itemstack.getItemDamage() == 0);
        if(itemstack.getItemDamage() == 2 && (ModLoader.getMinecraftInstance().objectMouseOver == null || ModLoader.getMinecraftInstance().objectMouseOver.entityHit == null || !(ModLoader.getMinecraftInstance().objectMouseOver.entityHit instanceof EntityAechorPlant)))
        {
            if(AetherPoison.afflictPoison())
            {
                itemstack.setItemDamage(0);
                return itemstack;
            }
        } else
        if(itemstack.getItemDamage() == 3 && AetherPoison.curePoison())
        {
            itemstack.setItemDamage(0);
            return itemstack;
        }
        if(movingobjectposition != null && movingobjectposition.typeOfHit == EnumMovingObjectType.TILE && (itemstack.getItemDamage() == 0 || itemstack.getItemDamage() == Block.waterMoving.blockID))
        {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            if(!world.func_6466_a(entityplayer, i, j, k))
            {
                return itemstack;
            }
            if(itemstack.getItemDamage() == 0)
            {
                if(world.getBlockMaterial(i, j, k) == Material.water && world.getBlockMetadata(i, j, k) == 0)
                {
                    world.setBlockWithNotify(i, j, k, 0);
                    itemstack.setItemDamage(Block.waterMoving.blockID);
                    return itemstack;
                }
            } else
            {
                if(itemstack.getItemDamage() <= 3 && itemstack.getItemDamage() != 0)
                {
                    return new ItemStack(AetherItems.Bucket);
                }
                if(movingobjectposition.sideHit == 0)
                {
                    j--;
                }
                if(movingobjectposition.sideHit == 1)
                {
                    j++;
                }
                if(movingobjectposition.sideHit == 2)
                {
                    k--;
                }
                if(movingobjectposition.sideHit == 3)
                {
                    k++;
                }
                if(movingobjectposition.sideHit == 4)
                {
                    i--;
                }
                if(movingobjectposition.sideHit == 5)
                {
                    i++;
                }
                if(world.isAirBlock(i, j, k) || !world.getBlockMaterial(i, j, k).isSolid())
                {
                    if(world.worldProvider.isHellWorld && itemstack.getItemDamage() == Block.waterMoving.blockID)
                    {
                        world.playSoundEffect(d + 0.5D, d1 + 0.5D, d2 + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
                        for(int l = 0; l < 8; l++)
                        {
                            world.spawnParticle("largesmoke", (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
                        }

                    } else
                    {
                        world.setBlockAndMetadataWithNotify(i, j, k, itemstack.getItemDamage(), 0);
                    }
                    return new ItemStack(AetherItems.Bucket);
                }
            }
        } else
        if(itemstack.getItemDamage() == 0 && ModLoader.getMinecraftInstance().objectMouseOver != null && ModLoader.getMinecraftInstance().objectMouseOver.entityHit != null && ((ModLoader.getMinecraftInstance().objectMouseOver.entityHit instanceof EntityCow) || (ModLoader.getMinecraftInstance().objectMouseOver.entityHit instanceof EntityFlyingCow)))
        {
            itemstack.setItemDamage(1);
            return itemstack;
        }
        return itemstack;
    }

    public static int sprEmpty = ModLoader.addOverride("/gui/items.png", "/aether/items/Bucket.png");
    public static int sprWater = ModLoader.addOverride("/gui/items.png", "/aether/items/BucketWater.png");
    public static int sprMilk = ModLoader.addOverride("/gui/items.png", "/aether/items/BucketMilk.png");
    public static int sprPoison = ModLoader.addOverride("/gui/items.png", "/aether/items/BucketPoison.png");
    public static int sprRemedy = ModLoader.addOverride("/gui/items.png", "/aether/items/BucketRemedy.png");

}
