// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerBase, EntityPlayerSP, AchievementList, StatFileWriter, 
//            GuiAchievement, DimensionBase, World, SoundManager, 
//            MovementInput, AxisAlignedBB

public class PlayerBaseSAPI extends PlayerBase
{

    public PlayerBaseSAPI(EntityPlayerSP entityplayersp)
    {
        super(entityplayersp);
    }

    public boolean onLivingUpdate()
    {
        Minecraft minecraft = player.mc;
        if(!minecraft.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory))
        {
            minecraft.guiAchievement.queueAchievementInformation(AchievementList.openInventory);
        }
        player.prevTimeInPortal = player.timeInPortal;
        if(portal != 0)
        {
            DimensionBase dimensionbase = DimensionBase.getDimByNumber(portal);
            if(player.inPortal)
            {
                if(!player.worldObj.multiplayerWorld && player.ridingEntity != null)
                {
                    player.mountEntity(null);
                }
                if(minecraft.currentScreen != null)
                {
                    minecraft.displayGuiScreen(null);
                }
                if(player.timeInPortal == 0.0F)
                {
                    minecraft.sndManager.playSoundFX(dimensionbase.soundTrigger, 1.0F, player.rand.nextFloat() * 0.4F + 0.8F);
                }
                player.timeInPortal += 0.0125F;
                if(player.timeInPortal >= 1.0F)
                {
                    player.timeInPortal = 1.0F;
                    if(!player.worldObj.multiplayerWorld)
                    {
                        player.timeUntilPortal = 10;
                        minecraft.sndManager.playSoundFX(dimensionbase.soundTravel, 1.0F, player.rand.nextFloat() * 0.4F + 0.8F);
                        DimensionBase.usePortal(portal);
                    }
                }
                player.inPortal = false;
            } else
            {
                if(player.timeInPortal > 0.0F)
                {
                    player.timeInPortal -= 0.05F;
                }
                if(player.timeInPortal < 0.0F)
                {
                    player.timeInPortal = 0.0F;
                }
            }
        }
        if(player.timeUntilPortal > 0)
        {
            player.timeUntilPortal--;
        }
        player.movementInput.updatePlayerMoveState(player);
        if(player.movementInput.sneak && player.ySize < 0.2F)
        {
            player.ySize = 0.2F;
        }
        player.pushOutOfBlocks(player.posX - (double)player.width * 0.34999999999999998D, player.boundingBox.minY + 0.5D, player.posZ + (double)player.width * 0.34999999999999998D);
        player.pushOutOfBlocks(player.posX - (double)player.width * 0.34999999999999998D, player.boundingBox.minY + 0.5D, player.posZ - (double)player.width * 0.34999999999999998D);
        player.pushOutOfBlocks(player.posX + (double)player.width * 0.34999999999999998D, player.boundingBox.minY + 0.5D, player.posZ - (double)player.width * 0.34999999999999998D);
        player.pushOutOfBlocks(player.posX + (double)player.width * 0.34999999999999998D, player.boundingBox.minY + 0.5D, player.posZ + (double)player.width * 0.34999999999999998D);
        player.superOnLivingUpdate();
        return true;
    }

    public boolean respawn()
    {
        DimensionBase.respawn(false, 0);
        return true;
    }

    public int portal;
}
