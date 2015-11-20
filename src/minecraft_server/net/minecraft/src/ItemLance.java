// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, IReach, EnumToolMaterial, SAPI, 
//            Block, ItemStack, AetherItems, EntityLiving, 
//            Entity

public class ItemLance extends Item
  //  implements IReach
{

    public ItemLance(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
        weaponDamage = 4 + enumtoolmaterial.getDamageVsEntity() * 2;
    //    SAPI.reachAdd(this);
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return block.blockID == Block.web.blockID ? 15F : 1.5F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public boolean canHarvestBlock(Block block)
    {
        return block.blockID == Block.web.blockID;
    }

    public boolean reachItemMatches(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return false;
        } else
        {
            return itemstack.itemID == AetherItems.Lance.shiftedIndex;
        }
    }

    public float getReach(ItemStack itemstack)
    {
        return 10F;
    }

    private int weaponDamage;
}
