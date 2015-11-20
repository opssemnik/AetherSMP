// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.lang.reflect.Method;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            DimensionOverworld, DimensionNether, WorldProvider, Teleporter, 
//            SAPI, World, EntityPlayerSP, EntityPlayer, 
//            ChunkCoordinates, WorldGenDeadBush, ChunkProviderLoadOrGenerate, IChunkProvider, 
//            PlayerController, MovementInputFromOptions, GuiGameOver, Loc

public class DimensionBase
{

    public static DimensionBase getDimByNumber(int i)
    {
        for(int j = 0; j < list.size(); j++)
        {
            DimensionBase dimensionbase = (DimensionBase)list.get(j);
            if(dimensionbase.number == i)
            {
                return dimensionbase;
            }
        }

        return null;
    }

    public static DimensionBase getDimByProvider(Class class1)
    {
        for(int i = 0; i < list.size(); i++)
        {
            DimensionBase dimensionbase = (DimensionBase)list.get(i);
            if(dimensionbase.worldProvider.getName().equals(class1.getName()))
            {
                return dimensionbase;
            }
        }

        return null;
    }

    public WorldProvider getWorldProvider()
    {
        try
        {
            return (WorldProvider)worldProvider.newInstance();
        }
        catch(InstantiationException instantiationexception) { }
        catch(IllegalAccessException illegalaccessexception) { }
        return null;
    }

    public Teleporter getTeleporter()
    {
        try
        {
            if(teleporter != null)
            {
                return (Teleporter)teleporter.newInstance();
            }
        }
        catch(InstantiationException instantiationexception) { }
        catch(IllegalAccessException illegalaccessexception) { }
        return null;
    }

    public static void respawn(boolean flag, int i)
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        if(!minecraft.theWorld.multiplayerWorld && !minecraft.theWorld.worldProvider.canRespawnHere())
        {
            usePortal(0, true);
        }
        ChunkCoordinates chunkcoordinates = null;
        ChunkCoordinates chunkcoordinates1 = null;
        boolean flag1 = true;
        if(minecraft.thePlayer != null && !flag)
        {
            chunkcoordinates = minecraft.thePlayer.getPlayerSpawnCoordinate();
            if(chunkcoordinates != null)
            {
                chunkcoordinates1 = EntityPlayer.func_25060_a(minecraft.theWorld, chunkcoordinates);
                if(chunkcoordinates1 == null)
                {
                    minecraft.thePlayer.addChatMessage("tile.bed.notValid");
                }
            }
        }
        if(chunkcoordinates1 == null)
        {
            chunkcoordinates1 = minecraft.theWorld.getSpawnPoint();
            flag1 = false;
        }
        IChunkProvider ichunkprovider = minecraft.theWorld.getIChunkProvider();
        if(ichunkprovider instanceof WorldGenDeadBush)
        {
            ChunkProviderLoadOrGenerate chunkproviderloadorgenerate = (ChunkProviderLoadOrGenerate)ichunkprovider;
            chunkproviderloadorgenerate.setCurrentChunkOver(chunkcoordinates1.x >> 4, chunkcoordinates1.z >> 4);
        }
        minecraft.theWorld.setSpawnLocation();
        minecraft.theWorld.updateEntityList();
        int j = 0;
        if(minecraft.thePlayer != null)
        {
            j = minecraft.thePlayer.entityId;
            minecraft.theWorld.setEntityDead(minecraft.thePlayer);
        }
        minecraft.renderViewEntity = null;
        minecraft.thePlayer = (EntityPlayerSP)minecraft.playerController.createPlayer(minecraft.theWorld);
        minecraft.thePlayer.dimension = i;
        minecraft.renderViewEntity = minecraft.thePlayer;
        minecraft.thePlayer.preparePlayerToSpawn();
        if(flag1)
        {
            minecraft.thePlayer.setPlayerSpawnCoordinate(chunkcoordinates);
            minecraft.thePlayer.setLocationAndAngles((float)chunkcoordinates1.x + 0.5F, (float)chunkcoordinates1.y + 0.1F, (float)chunkcoordinates1.z + 0.5F, 0.0F, 0.0F);
        }
        minecraft.playerController.flipPlayer(minecraft.thePlayer);
        minecraft.theWorld.spawnPlayerWithLoadedChunks(minecraft.thePlayer);
        minecraft.thePlayer.movementInput = new MovementInputFromOptions(minecraft.gameSettings);
        minecraft.thePlayer.entityId = j;
        minecraft.thePlayer.func_6420_o();
        minecraft.playerController.func_6473_b(minecraft.thePlayer);
        try
        {
            Method method = (net.minecraft.client.Minecraft.class).getDeclaredMethod("d", new Class[] {
                java.lang.String.class
            });
            method.setAccessible(true);
            method.invoke(minecraft, new Object[] {
                "Respawning"
            });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(minecraft.currentScreen instanceof GuiGameOver)
        {
            minecraft.displayGuiScreen(null);
        }
    }

    public static void usePortal(int i)
    {
        usePortal(i, false);
    }

    private static void usePortal(int i, boolean flag)
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        int j = minecraft.thePlayer.dimension;
        int k = i;
        if(j == k)
        {
            k = 0;
        }
        minecraft.theWorld.setEntityDead(minecraft.thePlayer);
        minecraft.thePlayer.isDead = false;
        Loc loc = new Loc(minecraft.thePlayer.posX, minecraft.thePlayer.posZ);
        if(k != 0)
        {
            order.push(Integer.valueOf(k));
        }
        if(k == 0 && !order.isEmpty())
        {
            k = ((Integer)order.pop()).intValue();
        }
        if(j == k)
        {
            k = 0;
        }
        String s = "";
        for(Iterator iterator = order.iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            if(!s.isEmpty())
            {
                s = (new StringBuilder(String.valueOf(s))).append(",").toString();
            }
            s = (new StringBuilder(String.valueOf(s))).append(integer).toString();
        }

        World world = null;
        DimensionBase dimensionbase = getDimByNumber(j);
        DimensionBase dimensionbase1 = getDimByNumber(k);
        loc = dimensionbase.getDistanceScale(loc, true);
        loc = dimensionbase1.getDistanceScale(loc, false);
        minecraft.thePlayer.dimension = k;
        minecraft.thePlayer.setLocationAndAngles(loc.x, minecraft.thePlayer.posY, loc.z, minecraft.thePlayer.rotationYaw, minecraft.thePlayer.rotationPitch);
        minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
        world = new World(minecraft.theWorld, dimensionbase1.getWorldProvider());
        minecraft.changeWorld(world, (new StringBuilder(String.valueOf(k != 0 ? "Entering" : "Leaving"))).append(" the ").append(k != 0 ? dimensionbase1.name : dimensionbase.name).toString(), minecraft.thePlayer);
        minecraft.thePlayer.worldObj = minecraft.theWorld;
        minecraft.thePlayer.setLocationAndAngles(loc.x, minecraft.thePlayer.posY, loc.z, minecraft.thePlayer.rotationYaw, minecraft.thePlayer.rotationPitch);
        minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
        Teleporter teleporter1 = dimensionbase1.getTeleporter();
        if(teleporter1 == null)
        {
            teleporter1 = dimensionbase.getTeleporter();
        }
        teleporter1.func_4107_a(minecraft.theWorld, minecraft.thePlayer);
    }

    public DimensionBase(int i, Class class1, Class class2)
    {
        name = "Dimension";
        soundTrigger = "portal.trigger";
        soundTravel = "portal.travel";
        number = i;
        worldProvider = class1;
        teleporter = class2;
        list.add(this);
    }

    public Loc getDistanceScale(Loc loc, boolean flag)
    {
        return loc;
    }

    public static ArrayList list = new ArrayList();
    public static LinkedList order = new LinkedList();
    public final int number;
    public final Class worldProvider;
    public final Class teleporter;
    public String name;
    public String soundTrigger;
    public String soundTravel;

    static 
    {
        new DimensionOverworld();
        new DimensionNether();
        new DimensionAether();
    }
}
