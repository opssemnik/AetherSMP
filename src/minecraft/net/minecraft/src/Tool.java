// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package net.minecraft.src:
//            Item, SAPI, ItemStack, ToolBase, 
//            Block, Material, BlockHarvestPower, EntityLiving, 
//            Entity

public class Tool extends Item
{

    public Tool(boolean flag, ToolBase toolbase, int i, int j, float f, float f1, float f2)
    {
        this(flag, toolbase, i, j, f, f1, f2, 1.0F);
    }

    public Tool(boolean flag, ToolBase toolbase, int i, int j, float f, float f1, float f2, 
            float f3)
    {
        super(i);
        mineBlocks = new ArrayList();
        mineMaterials = new ArrayList();
        setMaxDamage(j);
        maxStackSize = 1;
        usingSAPI = flag;
        toolBase = toolbase;
        baseDamage = f;
        basePower = f1;
        toolSpeed = f2;
        defaultSpeed = f3;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return (int)Math.floor(baseDamage);
    }

    public float getPower()
    {
        return basePower;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return canHarvest(block) ? toolSpeed : defaultSpeed;
    }

    public boolean canHarvest(Block block)
    {
        if(toolBase != null && toolBase.canHarvest(block, getPower()))
        {
            return true;
        }
        for(Iterator iterator = mineMaterials.iterator(); iterator.hasNext();)
        {
            Material material = (Material)iterator.next();
            if(material == block.blockMaterial)
            {
                return true;
            }
        }

        for(Iterator iterator1 = mineBlocks.iterator(); iterator1.hasNext();)
        {
            BlockHarvestPower blockharvestpower = (BlockHarvestPower)iterator1.next();
            if(block.blockID == blockharvestpower.blockID || getPower() >= blockharvestpower.percentage)
            {
                return true;
            }
        }

        return false;
    }

    public final boolean usingSAPI;
    public ToolBase toolBase;
    public final float baseDamage;
    public final float basePower;
    public final float defaultSpeed;
    public final float toolSpeed;
    public ArrayList mineBlocks;
    public ArrayList mineMaterials;

    static 
    {
        //SAPI.showText();
    }
}
