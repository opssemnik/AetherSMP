// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityPlayerSP, PlayerBase, NBTTagCompound, Entity, 
//            Block

public class PlayerAPI
{

    public PlayerAPI()
    {
    }

    public static void RegisterPlayerBase(Class class1)
    {
        playerBaseClasses.add(class1);
    }

    public static PlayerBase getPlayerBase(EntityPlayerSP entityplayersp, Class class1)
    {
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(class1.isInstance(entityplayersp.playerBases.get(i)))
            {
                return (PlayerBase)entityplayersp.playerBases.get(i);
            }
        }

        return null;
    }

    public static List playerInit(EntityPlayerSP entityplayersp)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < playerBaseClasses.size(); i++)
        {
            try
            {
                arraylist.add((PlayerBase)((Class)playerBaseClasses.get(i)).getDeclaredConstructor(new Class[] {
                    net.minecraft.src.EntityPlayerSP.class
                }).newInstance(new Object[] {
                    entityplayersp
                }));
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }

        return arraylist;
    }

    public static boolean onLivingUpdate(EntityPlayerSP entityplayersp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).onLivingUpdate())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean respawn(EntityPlayerSP entityplayersp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).respawn())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean moveFlying(EntityPlayerSP entityplayersp, float f, float f1, float f2)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).moveFlying(f, f1, f2))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean updatePlayerActionState(EntityPlayerSP entityplayersp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).updatePlayerActionState())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean handleKeyPress(EntityPlayerSP entityplayersp, int i, boolean flag)
    {
        boolean flag1 = false;
        for(int j = 0; j < entityplayersp.playerBases.size(); j++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(j)).handleKeyPress(i, flag))
            {
                flag1 = true;
            }
        }

        return flag1;
    }

    public static boolean writeEntityToNBT(EntityPlayerSP entityplayersp, NBTTagCompound nbttagcompound)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).writeEntityToNBT(nbttagcompound))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean readEntityFromNBT(EntityPlayerSP entityplayersp, NBTTagCompound nbttagcompound)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).readEntityFromNBT(nbttagcompound))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean onExitGUI(EntityPlayerSP entityplayersp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).onExitGUI())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean setEntityDead(EntityPlayerSP entityplayersp)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).setEntityDead())
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean onDeath(EntityPlayerSP entityplayersp, Entity entity)
    {
        boolean flag = false;
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(i)).onDeath(entity))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean attackEntityFrom(EntityPlayerSP entityplayersp, Entity entity, int i)
    {
        boolean flag = false;
        for(int j = 0; j < entityplayersp.playerBases.size(); j++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(j)).attackEntityFrom(entity, i))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static double getDistanceSq(EntityPlayerSP entityplayersp, double d, double d1, double d2, double d3)
    {
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            d3 = ((PlayerBase)entityplayersp.playerBases.get(i)).getDistanceSq(d, d1, d2, d3);
        }

        return d3;
    }

    public static boolean isInWater(EntityPlayerSP entityplayersp, boolean flag)
    {
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayersp.playerBases.get(i)).isInWater(flag);
        }

        return flag;
    }

    public static boolean canTriggerWalking(EntityPlayerSP entityplayersp, boolean flag)
    {
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            flag = ((PlayerBase)entityplayersp.playerBases.get(i)).canTriggerWalking(flag);
        }

        return flag;
    }

    public static boolean heal(EntityPlayerSP entityplayersp, int i)
    {
        boolean flag = false;
        for(int j = 0; j < entityplayersp.playerBases.size(); j++)
        {
            if(((PlayerBase)entityplayersp.playerBases.get(j)).heal(i))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static int getPlayerArmorValue(EntityPlayerSP entityplayersp, int i)
    {
        for(int j = 0; j < entityplayersp.playerBases.size(); j++)
        {
            i = ((PlayerBase)entityplayersp.playerBases.get(j)).getPlayerArmorValue(i);
        }

        return i;
    }

    public static float getCurrentPlayerStrVsBlock(EntityPlayerSP entityplayersp, Block block, float f)
    {
        for(int i = 0; i < entityplayersp.playerBases.size(); i++)
        {
            f = ((PlayerBase)entityplayersp.playerBases.get(i)).getCurrentPlayerStrVsBlock(block, f);
        }

        return f;
    }

    public static List playerBaseClasses = new ArrayList();

}
