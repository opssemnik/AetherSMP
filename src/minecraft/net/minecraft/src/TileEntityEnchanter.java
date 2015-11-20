// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, Enchantment, AetherItems, Item, 
//            World, EntityPlayer, AetherBlocks

public class TileEntityEnchanter extends TileEntity
    implements IInventory
{

    public TileEntityEnchanter()
    {
        enchanterItemStacks = new ItemStack[3];
        enchantProgress = 0;
        enchantPowerRemaining = 0;
        enchantTimeForItem = 0;
    }

    public int getSizeInventory()
    {
        return enchanterItemStacks.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return enchanterItemStacks[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(enchanterItemStacks[i] != null)
        {
            if(enchanterItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = enchanterItemStacks[i];
                enchanterItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = enchanterItemStacks[i].splitStack(j);
            if(enchanterItemStacks[i].stackSize == 0)
            {
                enchanterItemStacks[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        enchanterItemStacks[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "Enchanter";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        enchanterItemStacks = new ItemStack[getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if(byte0 >= 0 && byte0 < enchanterItemStacks.length)
            {
                enchanterItemStacks[byte0] = new ItemStack(nbttagcompound1);
            }
        }

        enchantProgress = nbttagcompound.getShort("BurnTime");
        enchantTimeForItem = nbttagcompound.getShort("CookTime");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)enchantProgress);
        nbttagcompound.setShort("CookTime", (short)enchantTimeForItem);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < enchanterItemStacks.length; i++)
        {
            if(enchanterItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                enchanterItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
        if(enchantTimeForItem == 0)
        {
            return 0;
        } else
        {
            return (enchantProgress * i) / enchantTimeForItem;
        }
    }

    public int getBurnTimeRemainingScaled(int i)
    {
        return (enchantPowerRemaining * i) / 500;
    }

    public boolean isBurning()
    {
        return enchantPowerRemaining > 0;
    }

    public void updateEntity()
    {
        if(enchantPowerRemaining > 0)
        {
            enchantPowerRemaining--;
            if(currentEnchantment != null)
            {
                enchantProgress++;
            }
        }
        if(currentEnchantment != null && (enchanterItemStacks[0] == null || enchanterItemStacks[0].itemID != currentEnchantment.enchantFrom.itemID))
        {
            currentEnchantment = null;
            enchantProgress = 0;
        }
        if(currentEnchantment != null && enchantProgress >= currentEnchantment.enchantPowerNeeded)
        {
            if(enchanterItemStacks[2] == null)
            {
                setInventorySlotContents(2, new ItemStack(currentEnchantment.enchantTo.getItem(), 1, currentEnchantment.enchantTo.getItemDamage()));
            } else
            {
                setInventorySlotContents(2, new ItemStack(currentEnchantment.enchantTo.getItem(), getStackInSlot(2).stackSize + 1, currentEnchantment.enchantTo.getItemDamage()));
            }
            decrStackSize(0, 1);
            enchantProgress = 0;
            currentEnchantment = null;
            enchantTimeForItem = 0;
        }
        if(enchantPowerRemaining <= 0 && currentEnchantment != null && getStackInSlot(1) != null && getStackInSlot(1).itemID == AetherItems.AmbrosiumShard.shiftedIndex)
        {
            enchantPowerRemaining += 500;
            decrStackSize(1, 1);
        }
        if(currentEnchantment == null)
        {
            ItemStack itemstack = getStackInSlot(0);
            for(int i = 0; i < enchantments.size(); i++)
            {
                if(itemstack == null || enchantments.get(i) == null || itemstack.itemID != ((Enchantment)enchantments.get(i)).enchantFrom.itemID)
                {
                    continue;
                }
                if(enchanterItemStacks[2] == null)
                {
                    currentEnchantment = (Enchantment)enchantments.get(i);
                    enchantTimeForItem = currentEnchantment.enchantPowerNeeded;
                    continue;
                }
                if(enchanterItemStacks[2].itemID == ((Enchantment)enchantments.get(i)).enchantTo.itemID && ((Enchantment)enchantments.get(i)).enchantTo.getItem().getItemStackLimit() > enchanterItemStacks[2].stackSize)
                {
                    currentEnchantment = (Enchantment)enchantments.get(i);
                    enchantTimeForItem = currentEnchantment.enchantPowerNeeded;
                }
            }

        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        } else
        {
            return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
        }
    }

    public static void addEnchantment(ItemStack itemstack, ItemStack itemstack1, int i)
    {
        enchantments.add(new Enchantment(itemstack, itemstack1, i));
    }

    private static List enchantments = new ArrayList();
    private ItemStack enchanterItemStacks[];
    public int enchantProgress;
    public int enchantPowerRemaining;
    public int enchantTimeForItem;
    private Enchantment currentEnchantment;

    static 
    {
        addEnchantment(new ItemStack(AetherBlocks.GravititeOre, 1), new ItemStack(AetherBlocks.EnchantedGravitite, 1), 1000);
        addEnchantment(new ItemStack(AetherItems.PickSkyroot, 1), new ItemStack(AetherItems.PickSkyroot, 1), 250);
        addEnchantment(new ItemStack(AetherItems.SwordSkyroot, 1), new ItemStack(AetherItems.SwordSkyroot, 1), 250);
        addEnchantment(new ItemStack(AetherItems.ShovelSkyroot, 1), new ItemStack(AetherItems.ShovelSkyroot, 1), 200);
        addEnchantment(new ItemStack(AetherItems.AxeSkyroot, 1), new ItemStack(AetherItems.AxeSkyroot, 1), 200);
        addEnchantment(new ItemStack(AetherItems.PickHolystone, 1), new ItemStack(AetherItems.PickHolystone, 1), 600);
        addEnchantment(new ItemStack(AetherItems.SwordHolystone, 1), new ItemStack(AetherItems.SwordHolystone, 1), 600);
        addEnchantment(new ItemStack(AetherItems.ShovelHolystone, 1), new ItemStack(AetherItems.ShovelHolystone, 1), 500);
        addEnchantment(new ItemStack(AetherItems.AxeHolystone, 1), new ItemStack(AetherItems.AxeHolystone, 1), 500);
        addEnchantment(new ItemStack(AetherItems.PickZanite, 1), new ItemStack(AetherItems.PickZanite, 1), 2500);
        addEnchantment(new ItemStack(AetherItems.SwordZanite, 1), new ItemStack(AetherItems.SwordZanite, 1), 2500);
        addEnchantment(new ItemStack(AetherItems.ShovelZanite, 1), new ItemStack(AetherItems.ShovelZanite, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.AxeZanite, 1), new ItemStack(AetherItems.AxeZanite, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.PickGravitite, 1), new ItemStack(AetherItems.PickGravitite, 1), 6000);
        addEnchantment(new ItemStack(AetherItems.SwordGravitite, 1), new ItemStack(AetherItems.SwordGravitite, 1), 6000);
        addEnchantment(new ItemStack(AetherItems.ShovelGravitite, 1), new ItemStack(AetherItems.ShovelGravitite, 1), 5000);
        addEnchantment(new ItemStack(AetherItems.AxeGravitite, 1), new ItemStack(AetherItems.AxeGravitite, 1), 5000);
        addEnchantment(new ItemStack(AetherItems.Dart, 1, 0), new ItemStack(AetherItems.Dart, 1, 2), 250);
        addEnchantment(new ItemStack(AetherItems.Bucket, 1, 2), new ItemStack(AetherItems.Bucket, 1, 3), 1000);
        addEnchantment(new ItemStack(Item.record13, 1), new ItemStack(AetherItems.BlueMusicDisk, 1), 2500);
        addEnchantment(new ItemStack(Item.recordCat, 1), new ItemStack(AetherItems.BlueMusicDisk, 1), 2500);
        addEnchantment(new ItemStack(Item.helmetLeather, 1), new ItemStack(Item.helmetLeather, 1), 400);
        addEnchantment(new ItemStack(Item.plateLeather, 1), new ItemStack(Item.plateLeather, 1), 500);
        addEnchantment(new ItemStack(Item.legsLeather, 1), new ItemStack(Item.legsLeather, 1), 500);
        addEnchantment(new ItemStack(Item.bootsLeather, 1), new ItemStack(Item.bootsLeather, 1), 400);
        addEnchantment(new ItemStack(Item.pickaxeWood, 1), new ItemStack(Item.pickaxeWood, 1), 500);
        addEnchantment(new ItemStack(Item.shovelWood, 1), new ItemStack(Item.shovelWood, 1), 400);
        addEnchantment(new ItemStack(Item.swordWood, 1), new ItemStack(Item.swordWood, 1), 500);
        addEnchantment(new ItemStack(Item.axeWood, 1), new ItemStack(Item.axeWood, 1), 400);
        addEnchantment(new ItemStack(Item.hoeWood, 1), new ItemStack(Item.hoeWood, 1), 300);
        addEnchantment(new ItemStack(Item.pickaxeStone, 1), new ItemStack(Item.pickaxeStone, 1), 1000);
        addEnchantment(new ItemStack(Item.shovelStone, 1), new ItemStack(Item.shovelStone, 1), 750);
        addEnchantment(new ItemStack(Item.swordStone, 1), new ItemStack(Item.swordStone, 1), 1000);
        addEnchantment(new ItemStack(Item.axeStone, 1), new ItemStack(Item.axeStone, 1), 750);
        addEnchantment(new ItemStack(Item.hoeStone, 1), new ItemStack(Item.hoeStone, 1), 750);
        addEnchantment(new ItemStack(Item.helmetSteel, 1), new ItemStack(Item.helmetSteel, 1), 1500);
        addEnchantment(new ItemStack(Item.plateSteel, 1), new ItemStack(Item.plateSteel, 1), 2000);
        addEnchantment(new ItemStack(Item.legsSteel, 1), new ItemStack(Item.legsSteel, 1), 2000);
        addEnchantment(new ItemStack(Item.bootsSteel, 1), new ItemStack(Item.bootsSteel, 1), 1500);
        addEnchantment(new ItemStack(Item.pickaxeSteel, 1), new ItemStack(Item.pickaxeSteel, 1), 2500);
        addEnchantment(new ItemStack(Item.shovelSteel, 1), new ItemStack(Item.shovelSteel, 1), 2000);
        addEnchantment(new ItemStack(Item.swordSteel, 1), new ItemStack(Item.swordSteel, 1), 2500);
        addEnchantment(new ItemStack(Item.axeSteel, 1), new ItemStack(Item.axeSteel, 1), 1500);
        addEnchantment(new ItemStack(Item.hoeSteel, 1), new ItemStack(Item.hoeSteel, 1), 1500);
        addEnchantment(new ItemStack(Item.helmetGold, 1), new ItemStack(Item.helmetGold, 1), 1000);
        addEnchantment(new ItemStack(Item.plateGold, 1), new ItemStack(Item.plateGold, 1), 1200);
        addEnchantment(new ItemStack(Item.legsGold, 1), new ItemStack(Item.legsGold, 1), 1200);
        addEnchantment(new ItemStack(Item.bootsGold, 1), new ItemStack(Item.bootsGold, 1), 1000);
        addEnchantment(new ItemStack(Item.pickaxeGold, 1), new ItemStack(Item.pickaxeGold, 1), 1500);
        addEnchantment(new ItemStack(Item.shovelGold, 1), new ItemStack(Item.shovelGold, 1), 1000);
        addEnchantment(new ItemStack(Item.swordGold, 1), new ItemStack(Item.swordGold, 1), 1500);
        addEnchantment(new ItemStack(Item.axeGold, 1), new ItemStack(Item.axeGold, 1), 1000);
        addEnchantment(new ItemStack(Item.hoeGold, 1), new ItemStack(Item.hoeGold, 1), 1000);
        addEnchantment(new ItemStack(Item.helmetDiamond, 1), new ItemStack(Item.helmetDiamond, 1), 5000);
        addEnchantment(new ItemStack(Item.plateDiamond, 1), new ItemStack(Item.plateDiamond, 1), 6000);
        addEnchantment(new ItemStack(Item.legsDiamond, 1), new ItemStack(Item.legsDiamond, 1), 6000);
        addEnchantment(new ItemStack(Item.bootsDiamond, 1), new ItemStack(Item.bootsDiamond, 1), 5000);
        addEnchantment(new ItemStack(Item.pickaxeDiamond, 1), new ItemStack(Item.pickaxeDiamond, 1), 7000);
        addEnchantment(new ItemStack(Item.shovelDiamond, 1), new ItemStack(Item.shovelDiamond, 1), 6000);
        addEnchantment(new ItemStack(Item.swordDiamond, 1), new ItemStack(Item.swordDiamond, 1), 6500);
        addEnchantment(new ItemStack(Item.axeDiamond, 1), new ItemStack(Item.axeDiamond, 1), 6000);
        addEnchantment(new ItemStack(Item.hoeDiamond, 1), new ItemStack(Item.hoeDiamond, 1), 6000);
        addEnchantment(new ItemStack(Item.fishingRod, 1), new ItemStack(Item.fishingRod, 1), 500);
        addEnchantment(new ItemStack(AetherBlocks.Quicksoil, 1), new ItemStack(AetherBlocks.QuicksoilGlass, 1), 250);
        addEnchantment(new ItemStack(AetherBlocks.Holystone, 1), new ItemStack(AetherItems.HealingStone, 1), 750);
        addEnchantment(new ItemStack(AetherItems.GravititeHelmet, 1), new ItemStack(AetherItems.GravititeHelmet, 1), 12000);
        addEnchantment(new ItemStack(AetherItems.GravititeBodyplate, 1), new ItemStack(AetherItems.GravititeBodyplate, 1), 20000);
        addEnchantment(new ItemStack(AetherItems.GravititePlatelegs, 1), new ItemStack(AetherItems.GravititePlatelegs, 1), 15000);
        addEnchantment(new ItemStack(AetherItems.GravititeBoots, 1), new ItemStack(AetherItems.GravititeBoots, 1), 12000);
        addEnchantment(new ItemStack(AetherItems.GravititeGlove, 1), new ItemStack(AetherItems.GravititeGlove, 1), 10000);
        addEnchantment(new ItemStack(AetherItems.ZaniteHelmet, 1), new ItemStack(AetherItems.ZaniteHelmet, 1), 6000);
        addEnchantment(new ItemStack(AetherItems.ZaniteChestplate, 1), new ItemStack(AetherItems.ZaniteChestplate, 1), 10000);
        addEnchantment(new ItemStack(AetherItems.ZaniteLeggings, 1), new ItemStack(AetherItems.ZaniteLeggings, 1), 8000);
        addEnchantment(new ItemStack(AetherItems.ZaniteBoots, 1), new ItemStack(AetherItems.ZaniteBoots, 1), 5000);
        addEnchantment(new ItemStack(AetherItems.ZaniteGlove, 1), new ItemStack(AetherItems.ZaniteGlove, 1), 4000);
        addEnchantment(new ItemStack(AetherItems.ZaniteRing, 1), new ItemStack(AetherItems.ZaniteRing, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.ZanitePendant, 1), new ItemStack(AetherItems.ZanitePendant, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.LeatherGlove, 1), new ItemStack(AetherItems.LeatherGlove, 1), 300);
        addEnchantment(new ItemStack(AetherItems.IronGlove, 1), new ItemStack(AetherItems.IronGlove, 1), 1200);
        addEnchantment(new ItemStack(AetherItems.GoldGlove, 1), new ItemStack(AetherItems.GoldGlove, 1), 800);
        addEnchantment(new ItemStack(AetherItems.DiamondGlove, 1), new ItemStack(AetherItems.DiamondGlove, 1), 4000);
        addEnchantment(new ItemStack(AetherItems.DartShooter, 1, 0), new ItemStack(AetherItems.DartShooter, 1, 2), 2000);
    }
}
