// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            PlayerBase, InventoryAether, ContainerAether, EntityPlayerSP, 
//            World, InventoryPlayer, GuiMainMenu, Entity, 
//            ItemStack, AetherItems, Item, NBTTagCompound, 
//            NBTTagList, SaveHandler, CompressedStreamTools, Block

public class PlayerBaseAether extends PlayerBase
{

    public PlayerBaseAether(EntityPlayerSP entityplayersp)
    {
        super(entityplayersp);
        maxHealth = 20;
        inv = new InventoryAether(player);
      //  player.inventorySlots = new ContainerAether(player.inventory, inv, !player.worldObj.multiplayerWorld);
      //  player.craftingInventory = player.inventorySlots;
      //  readCustomData();
    }

    public void playerInit()
    {
    }

 

    public boolean heal(int i)
    {
        if(player.health <= 0)
        {
            return false;
        }
        player.health += i;
        if(player.health > maxHealth)
        {
            player.health = maxHealth;
        }
        player.heartsLife = player.heartsHalvesLife / 2;
        return true;
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(GuiMainMenu.mmactive)
        {
            if(entity != null)
            {
                entity.attackEntityFrom(entity, i);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onLivingUpdate()
    {
        if(GuiMainMenu.mmactive)
        {
            player.setPosition(player.lastTickPosX, player.lastTickPosY, player.lastTickPosZ);
        }
        if(player.ticksExisted % 400 == 0)
        {
            if(inv.slots[0] != null && inv.slots[0].itemID == AetherItems.ZanitePendant.shiftedIndex)
            {
                inv.slots[0].damageItem(1, player);
                if(inv.slots[0].stackSize < 1)
                {
                    inv.slots[0] = null;
                }
            }
            if(inv.slots[4] != null && inv.slots[4].itemID == AetherItems.ZaniteRing.shiftedIndex)
            {
                inv.slots[4].damageItem(1, player);
                if(inv.slots[4].stackSize < 1)
                {
                    inv.slots[4] = null;
                }
            }
            if(inv.slots[5] != null && inv.slots[5].itemID == AetherItems.ZaniteRing.shiftedIndex)
            {
                inv.slots[5].damageItem(1, player);
                if(inv.slots[5].stackSize < 1)
                {
                    inv.slots[5] = null;
                }
            }
            if(inv.slots[0] != null && inv.slots[0].itemID == AetherItems.IcePendant.shiftedIndex)
            {
                inv.slots[0].damageItem(1, player);
                if(inv.slots[0].stackSize < 1)
                {
                    inv.slots[0] = null;
                }
            }
            if(inv.slots[4] != null && inv.slots[4].itemID == AetherItems.IceRing.shiftedIndex)
            {
                inv.slots[4].damageItem(1, player);
                if(inv.slots[4].stackSize < 1)
                {
                    inv.slots[4] = null;
                }
            }
            if(inv.slots[5] != null && inv.slots[5].itemID == AetherItems.IceRing.shiftedIndex)
            {
                inv.slots[5].damageItem(1, player);
                if(inv.slots[5].stackSize < 1)
                {
                    inv.slots[5] = null;
                }
            }
        }
        if(player.worldObj.difficultySetting == 0 && player.health >= 20 && player.health < maxHealth && player.ticksExisted % 20 == 0)
        {
            player.heal(1);
        }
        return false;
    }

    public boolean invisible()
    {
        return !player.isSwinging && inv.slots[1] != null && inv.slots[1].itemID == AetherItems.InvisibilityCloak.shiftedIndex;
    }

    public boolean writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        if(!player.worldObj.multiplayerWorld)
        {
            writeCustomData(inv);
        }
        return false;
    }

    private void writeCustomData(InventoryAether inventoryaether)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setByte("MaxHealth", (byte)maxHealth);
        nbttagcompound.setTag("Inventory", inventoryaether.writeToNBT(new NBTTagList()));
        try
        {
            File file = new File(((SaveHandler)player.worldObj.saveHandler).getSaveDirectory(), "aether.dat");
            CompressedStreamTools.writeGzippedCompoundToOutputStream(nbttagcompound, new FileOutputStream(file));
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to create player data");
        }
    }

    public boolean readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        if(!player.worldObj.multiplayerWorld)
        {
          //  readCustomData();
        }
        return false;
    }

    private void readCustomData2()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        try
        {
            File file = new File(((SaveHandler)player.worldObj.saveHandler).getSaveDirectory(), "aether.dat");
            NBTTagCompound nbttagcompound1 = CompressedStreamTools.func_1138_a(new FileInputStream(file));
            maxHealth = nbttagcompound1.getByte("MaxHealth");
            if(maxHealth < 20)
            {
                maxHealth = 20;
            }
            NBTTagList nbttaglist = nbttagcompound1.getTagList("Inventory");
            inv.readFromNBT(nbttaglist);
        }
        catch(IOException ioexception)
        {
            System.out.println("Failed to read player data. Making new");
            maxHealth = 20;
        }
    }

    public boolean setEntityDead()
    {
        if(GuiMainMenu.mmactive)
        {
            return true;
        }
        if(!player.worldObj.multiplayerWorld)
        {
            writeCustomData(new InventoryAether(player));
        }
        return false;
    }

    public double getDistanceSq(double d, double d1, double d2, double d3)
    {
        return invisible() ? 1000D : d3;
    }

    public boolean isInWater(boolean flag)
    {
        return flag && (!wearingNeptuneArmor() || player.isJumping);
    }

    public float getCurrentPlayerStrVsBlock(Block block, float f)
    {
        if(inv.slots[0] != null && inv.slots[0].itemID == AetherItems.ZanitePendant.shiftedIndex)
        {
            f *= 1.0F + (float)inv.slots[0].getItemDamage() / ((float)inv.slots[0].getMaxDamage() * 3F);
        }
        if(inv.slots[4] != null && inv.slots[4].itemID == AetherItems.ZaniteRing.shiftedIndex)
        {
            f *= 1.0F + (float)inv.slots[4].getItemDamage() / ((float)inv.slots[4].getMaxDamage() * 3F);
        }
        if(inv.slots[5] != null && inv.slots[5].itemID == AetherItems.ZaniteRing.shiftedIndex)
        {
            f *= 1.0F + (float)inv.slots[5].getItemDamage() / ((float)inv.slots[5].getMaxDamage() * 3F);
        }
        return f;
    }

    private boolean wearingNeptuneArmor()
    {
        return player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].itemID == AetherItems.NeptuneHelmet.shiftedIndex && player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].itemID == AetherItems.NeptuneChestplate.shiftedIndex && player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].itemID == AetherItems.NeptuneLeggings.shiftedIndex && player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].itemID == AetherItems.NeptuneBoots.shiftedIndex && inv.slots[6] != null && inv.slots[6].itemID == AetherItems.NeptuneGlove.shiftedIndex;
    }

    public int maxHealth;
    public InventoryAether inv;
}
