// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityPlayerMP, PlayerBase, EnumStatus, NBTTagCompound, 
//            Entity, Block, Material, ItemStack, 
//            IInventory, TileEntityFurnace, TileEntityDispenser

public class PlayerAPI
{

    public PlayerAPI()
    {
    }

    public static void RegisterPlayerBase(Class class1)
    {
        playerBaseClasses.add(class1);
    }

    public static PlayerBase getPlayerBase(EntityPlayerMP entityplayermp, Class class1)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(class1.isInstance(entityplayermp.playerBases.get(i)))
            {
                return (PlayerBase)entityplayermp.playerBases.get(i);
            }
        }

        return null;
    }

    public static List playerInit(EntityPlayerMP entityplayermp)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < playerBaseClasses.size(); i++)
        {
            try
            {
                arraylist.add((PlayerBase)((Class)playerBaseClasses.get(i)).getDeclaredConstructor(new Class[] {
                    net.minecraft.src.EntityPlayerMP.class
                }).newInstance(new Object[] {
                    entityplayermp
                }));
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }

        return arraylist;
    }

    public static boolean onLivingUpdate(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).onLivingUpdate())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean updatePlayerActionState(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).updatePlayerActionState())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean handleKeyPress(EntityPlayerMP entityplayermp, int i, boolean flag)
    {
        boolean flag1 = false;
        for(int j = 0; j < entityplayermp.playerBases.size(); j++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(j)).handleKeyPress(i, flag))
            {
                flag1 = true;
            }
        }

        return flag1;
    }

    public static boolean writeEntityToNBT(EntityPlayerMP entityplayermp, NBTTagCompound nbttagcompound)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).writeEntityToNBT(nbttagcompound))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean readEntityFromNBT(EntityPlayerMP entityplayermp, NBTTagCompound nbttagcompound)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).readEntityFromNBT(nbttagcompound))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean onExitGUI(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).onExitGUI())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean setEntityDead(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).setEntityDead())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean onDeath(EntityPlayerMP entityplayermp, Entity entity)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).onDeath(entity))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean attackEntityFrom(EntityPlayerMP entityplayermp, Entity entity, int i)
    {
        boolean flag = false;
        for(int j = 0; j < entityplayermp.playerBases.size(); j++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(j)).attackEntityFrom(entity, i))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean canTriggerWalking(EntityPlayerMP entityplayermp, boolean flag)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayermp.playerBases.get(i)).canTriggerWalking(flag);
        }

        return flag;
    }

    public static boolean moveFlying(EntityPlayerMP entityplayermp, float f, float f1, float f2)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).moveFlying(f, f1, f2))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean respawn(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).respawn())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static double getDistanceSq(EntityPlayerMP entityplayermp, double d, double d1, double d2, double d3)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            d3 = ((PlayerBase)entityplayermp.playerBases.get(i)).getDistanceSq(d, d1, d2, d3);
        }

        return d3;
    }

    public static boolean isInWater(EntityPlayerMP entityplayermp, boolean flag)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayermp.playerBases.get(i)).isInWater(flag);
        }

        return flag;
    }

    public static boolean heal(EntityPlayerMP entityplayermp, int i)
    {
        boolean flag = false;
        for(int j = 0; j < entityplayermp.playerBases.size(); j++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(j)).heal(i))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static int getPlayerArmorValue(EntityPlayerMP entityplayermp, int i)
    {
        for(int j = 0; j < entityplayermp.playerBases.size(); j++)
        {
            i = ((PlayerBase)entityplayermp.playerBases.get(j)).getPlayerArmorValue(i);
        }

        return i;
    }

    public static float getCurrentPlayerStrVsBlock(EntityPlayerMP entityplayermp, Block block, float f)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            f = ((PlayerBase)entityplayermp.playerBases.get(i)).getCurrentPlayerStrVsBlock(block, f);
        }

        return f;
    }

    public static boolean moveEntity(EntityPlayerMP entityplayermp, double d, double d1, double d2)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).moveEntity(d, d1, d2))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static EnumStatus sleepInBedAt(EntityPlayerMP entityplayermp, int i, int j, int k)
    {
        EnumStatus enumstatus = null;
        for(int l = 0; l < entityplayermp.playerBases.size(); l++)
        {
            enumstatus = ((PlayerBase)entityplayermp.playerBases.get(l)).sleepInBedAt(i, j, k, enumstatus);
        }

        return enumstatus;
    }

    public static float getEntityBrightness(EntityPlayerMP entityplayermp, float f, float f1)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            f = ((PlayerBase)entityplayermp.playerBases.get(i)).getEntityBrightness(f, f1);
        }

        return f;
    }

    public static boolean pushOutOfBlocks(EntityPlayerMP entityplayermp, double d, double d1, double d2)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).pushOutOfBlocks(d, d1, d2))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean onUpdate(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).onUpdate())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static void afterUpdate(EntityPlayerMP entityplayermp)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            ((PlayerBase)entityplayermp.playerBases.get(i)).afterUpdate();
        }

    }

    public static boolean moveEntityWithHeading(EntityPlayerMP entityplayermp, float f, float f1)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).moveEntityWithHeading(f, f1))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean isOnLadder(EntityPlayerMP entityplayermp, boolean flag)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayermp.playerBases.get(i)).isOnLadder(flag);
        }

        return flag;
    }

    public static boolean isInsideOfMaterial(EntityPlayerMP entityplayermp, Material material, boolean flag)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayermp.playerBases.get(i)).isInsideOfMaterial(material, flag);
        }

        return flag;
    }

    public static boolean isSneaking(EntityPlayerMP entityplayermp, boolean flag)
    {
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayermp.playerBases.get(i)).isSneaking(flag);
        }

        return flag;
    }

    public static boolean dropCurrentItem(EntityPlayerMP entityplayermp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).dropCurrentItem())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean dropPlayerItem(EntityPlayerMP entityplayermp, ItemStack itemstack)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).dropPlayerItem(itemstack))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean onUpdateEntity(EntityPlayerMP entityplayermp, boolean flag)
    {
        boolean flag1 = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).onUpdateEntity(flag))
            {
                flag1 = true;
            }
        }

        return flag1;
    }

    public static boolean displayGUIChest(EntityPlayerMP entityplayermp, IInventory iinventory)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).displayGUIChest(iinventory))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean displayWorkbenchGUI(EntityPlayerMP entityplayermp, int i, int j, int k)
    {
        boolean flag = false;
        for(int l = 0; l < entityplayermp.playerBases.size(); l++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(l)).displayWorkbenchGUI(i, j, k))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean displayGUIFurnace(EntityPlayerMP entityplayermp, TileEntityFurnace tileentityfurnace)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).displayGUIFurnace(tileentityfurnace))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean displayGUIDispenser(EntityPlayerMP entityplayermp, TileEntityDispenser tileentitydispenser)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayermp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayermp.playerBases.get(i)).displayGUIDispenser(tileentitydispenser))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static List playerBaseClasses = new ArrayList();

}
