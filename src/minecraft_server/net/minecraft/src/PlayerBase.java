// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityPlayerMP, NBTTagCompound, Entity, Block, 
//            EnumStatus, Material, ItemStack, IInventory, 
//            TileEntityFurnace, TileEntityDispenser

public abstract class PlayerBase
{

    public PlayerBase(EntityPlayerMP entityplayermp)
    {
        player = entityplayermp;
    }
    
    public void playerInit()
    {
    }

    public boolean onLivingUpdate()
    {
        return false;
    }

    public boolean updatePlayerActionState()
    {
        return false;
    }

    public boolean handleKeyPress(int i, boolean flag)
    {
        return false;
    }

    public boolean writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        return false;
    }

    public boolean readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        return false;
    }

    public boolean setEntityDead()
    {
        return false;
    }

    public boolean onDeath(Entity entity)
    {
        return false;
    }

    public boolean respawn()
    {
        return false;
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        return false;
    }

    public double getDistanceSq(double d, double d1, double d2, double d3)
    {
        return d3;
    }

    public boolean isInWater(boolean flag)
    {
        return flag;
    }

    public boolean onExitGUI()
    {
        return false;
    }

    public boolean heal(int i)
    {
        return false;
    }

    public boolean canTriggerWalking(boolean flag)
    {
        return flag;
    }

    public boolean moveFlying(float f, float f1, float f2)
    {
        return false;
    }

    public int getPlayerArmorValue(int i)
    {
        return i;
    }

    public float getCurrentPlayerStrVsBlock(Block block, float f)
    {
        return f;
    }

    public boolean moveEntity(double d, double d1, double d2)
    {
        return false;
    }

    public EnumStatus sleepInBedAt(int i, int j, int k, EnumStatus enumstatus)
    {
        return enumstatus;
    }

    public float getEntityBrightness(float f, float f1)
    {
        return f1;
    }

    public boolean pushOutOfBlocks(double d, double d1, double d2)
    {
        return false;
    }

    public boolean onUpdate()
    {
        return false;
    }

    public void afterUpdate()
    {
    }

    public boolean moveEntityWithHeading(float f, float f1)
    {
        return false;
    }

    public boolean isOnLadder(boolean flag)
    {
        return flag;
    }

    public boolean isInsideOfMaterial(Material material, boolean flag)
    {
        return flag;
    }

    public boolean isSneaking(boolean flag)
    {
        return flag;
    }

    public boolean dropCurrentItem()
    {
        return false;
    }

    public boolean dropPlayerItem(ItemStack itemstack)
    {
        return false;
    }

    public boolean onUpdateEntity(boolean flag)
    {
        return false;
    }

    public boolean displayGUIChest(IInventory iinventory)
    {
        return false;
    }

    public boolean displayWorkbenchGUI(int i, int j, int k)
    {
        return false;
    }

    public boolean displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        return false;
    }

    public boolean displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        return false;
    }

    public EntityPlayerMP player;
}
