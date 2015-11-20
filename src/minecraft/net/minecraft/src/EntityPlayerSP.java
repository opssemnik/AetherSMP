// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MouseFilter, Session, World, 
//            PlayerAPI, MovementInput, AchievementList, StatFileWriter, 
//            GuiAchievement, SoundManager, AxisAlignedBB, NBTTagCompound, 
//            GuiEditSign, GuiChest, GuiCrafting, GuiFurnace, 
//            GuiDispenser, EntityPickupFX, EffectRenderer, InventoryPlayer, 
//            Material, GuiIngame, StatBase, Achievement, 
//            MathHelper, EnumStatus, Entity, TileEntitySign, 
//            IInventory, TileEntityFurnace, TileEntityDispenser, Block, 
//            ItemStack

public class EntityPlayerSP extends EntityPlayer
{

    public EntityPlayerSP(Minecraft minecraft, World world, Session session, int i)
    {
        super(world);
        field_21903_bJ = new MouseFilter();
        field_21904_bK = new MouseFilter();
        field_21902_bL = new MouseFilter();
        mc = minecraft;
        dimension = i;
        if(session != null && session.username != null && session.username.length() > 0)
        {
            skinUrl = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftSkins/").append(session.username).append(".png").toString();
        }
        username = session.username;
        this.inventorySlots = new ContainerAether(inventory, inv, !worldObj.multiplayerWorld);
        this.craftingInventory = this.inventorySlots;
 
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        
            return super.attackEntityFrom(entity, i);
        
    }

    public void onDeath(Entity entity)
    {
       
            super.onDeath(entity);
            return;
        
    }

    public void updatePlayerActionState()
    {
       
            super.updatePlayerActionState();
            moveStrafing = movementInput.moveStrafe;
            moveForward = movementInput.moveForward;
            isJumping = movementInput.jump;
            return;
        
    }

    public void superUpdatePlayerActionState()
    {
        super.updatePlayerActionState();
    }

    public void onLivingUpdate()
    {
     
        if(!mc.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory))
        {
            mc.guiAchievement.queueAchievementInformation(AchievementList.openInventory);
        }
        prevTimeInPortal = timeInPortal;
        if(inPortal)
        {
            if(!worldObj.multiplayerWorld && ridingEntity != null)
            {
                mountEntity(null);
            }
            if(mc.currentScreen != null)
            {
                mc.displayGuiScreen(null);
            }
            if(timeInPortal == 0.0F)
            {
                mc.sndManager.playSoundFX("portal.trigger", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
            }
            timeInPortal += 0.0125F;
            if(timeInPortal >= 1.0F)
            {
                timeInPortal = 1.0F;
                if(!worldObj.multiplayerWorld)
                {
                    timeUntilPortal = 10;
                    mc.sndManager.playSoundFX("portal.travel", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
                    mc.usePortal(mc.nextDim);
                }
            }
            inPortal = false;
        } else
        {
            if(timeInPortal > 0.0F)
            {
                timeInPortal -= 0.05F;
            }
            if(timeInPortal < 0.0F)
            {
                timeInPortal = 0.0F;
            }
        }
        if(timeUntilPortal > 0)
        {
            timeUntilPortal--;
        }
        movementInput.updatePlayerMoveState(this);
        if(movementInput.sneak && ySize < 0.2F)
        {
            ySize = 0.2F;
        }
        pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ + (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ - (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ - (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ + (double)width * 0.34999999999999998D);
        super.onLivingUpdate();
    }

    public void superOnLivingUpdate()
    {
        super.onLivingUpdate();
    }

    public void superOnUpdate()
    {
        super.onUpdate();
    }

    public void moveFlying(float f, float f1, float f2)
    {
       
            super.moveFlying(f, f1, f2);
            return;
        
    }

    protected boolean canTriggerWalking()
    {
        return true;
        
    }

    public void resetPlayerKeyState()
    {
        movementInput.resetKeyState();
    }

    public void handleKeyPress(int i, boolean flag)
    {
        
            movementInput.checkKeyForMovementInput(i, flag);
            return;
        
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
      
            super.writeEntityToNBT(nbttagcompound);
            nbttagcompound.setInteger("Score", score);
            return;
        
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
       
            super.readEntityFromNBT(nbttagcompound);
            score = nbttagcompound.getInteger("Score");
            return;
        
    }

    public void closeScreen()
    {
      
            super.closeScreen();
            mc.displayGuiScreen(null);
            return;
        
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign)
    {
      
            mc.displayGuiScreen(new GuiEditSign(tileentitysign));
            return;
        
    }
    

    public void displayGUIChest(IInventory iinventory)
    {
      
            mc.displayGuiScreen(new GuiChest(inventory, iinventory));
            return;
        
    }

    public void displayWorkbenchGUI(int i, int j, int k)
    {
        
            mc.displayGuiScreen(new GuiCrafting(inventory, worldObj, i, j, k));
            return;
        
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
            mc.displayGuiScreen(new GuiFurnace(inventory, tileentityfurnace));
            return;
        
    }

    public void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
      
            mc.displayGuiScreen(new GuiDispenser(inventory, tileentitydispenser));
            return;
        
    }

    public void onItemPickup(Entity entity, int i)
    {
        mc.effectRenderer.addEffect(new EntityPickupFX(mc.theWorld, entity, this, -0.5F));
    }

    public int getPlayerArmorValue()
    {
        return inventory.getTotalArmorValue();
    }

    public void setEntityDead()
    {
       
            super.setEntityDead();
            return;
        
    }

    public double getDistanceSq(double d, double d1, double d2)
    {
        return  super.getDistanceSq(d, d1, d2);
    }

    public boolean isInWater()
    {
        return inWater;
    }

    public boolean isSneaking()
    {
        return  movementInput.sneak && !sleeping;
    }

    public float getCurrentPlayerStrVsBlock(Block block)
    {
        float f = inventory.getStrVsBlock(block);
        if(isInsideOfMaterial(Material.water))
        {
            f /= 5F;
        }
        if(!onGround)
        {
            f /= 5F;
        }
        return f;
    }

    public void heal(int i)
    {
        
            super.heal(i);
            return;
        
    }

    public void setHealth(int i)
    {
        int j = health - i;
        if(j <= 0)
        {
            health = i;
            if(j < 0)
            {
                heartsLife = heartsHalvesLife / 2;
            }
        } else
        {
            field_9346_af = j;
            prevHealth = health;
            heartsLife = heartsHalvesLife;
            damageEntity(j);
            hurtTime = maxHurtTime = 10;
        }
    }

    public void respawnPlayer()
    {
      
            mc.respawn(false, 0);
            return;
        
    }

    public void func_6420_o()
    {
    }

    public void addChatMessage(String s)
    {
        mc.ingameGUI.addChatMessageTranslate(s);
    }

    public void addStat(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.func_25067_a())
        {
            Achievement achievement = (Achievement)statbase;
            if(achievement.parentAchievement == null || mc.statFileWriter.hasAchievementUnlocked(achievement.parentAchievement))
            {
                if(!mc.statFileWriter.hasAchievementUnlocked(achievement))
                {
                    mc.guiAchievement.queueTakenAchievement(achievement);
                }
                mc.statFileWriter.readStat(statbase, i);
            }
        } else
        {
            mc.statFileWriter.readStat(statbase, i);
        }
    }

    private boolean isBlockTranslucent(int i, int j, int k)
    {
        return worldObj.isBlockNormalCube(i, j, k);
    }

    protected boolean pushOutOfBlocks(double d, double d1, double d2)
    {
       
        int i = MathHelper.floor_double(d);
        int j = MathHelper.floor_double(d1);
        int k = MathHelper.floor_double(d2);
        double d3 = d - (double)i;
        double d4 = d2 - (double)k;
        if(isBlockTranslucent(i, j, k) || isBlockTranslucent(i, j + 1, k))
        {
            boolean flag = !isBlockTranslucent(i - 1, j, k) && !isBlockTranslucent(i - 1, j + 1, k);
            boolean flag1 = !isBlockTranslucent(i + 1, j, k) && !isBlockTranslucent(i + 1, j + 1, k);
            boolean flag2 = !isBlockTranslucent(i, j, k - 1) && !isBlockTranslucent(i, j + 1, k - 1);
            boolean flag3 = !isBlockTranslucent(i, j, k + 1) && !isBlockTranslucent(i, j + 1, k + 1);
            byte byte0 = -1;
            double d5 = 9999D;
            if(flag && d3 < d5)
            {
                d5 = d3;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d3 < d5)
            {
                d5 = 1.0D - d3;
                byte0 = 1;
            }
            if(flag2 && d4 < d5)
            {
                d5 = d4;
                byte0 = 4;
            }
            if(flag3 && 1.0D - d4 < d5)
            {
                double d6 = 1.0D - d4;
                byte0 = 5;
            }
            float f = 0.1F;
            if(byte0 == 0)
            {
                motionX = -f;
            }
            if(byte0 == 1)
            {
                motionX = f;
            }
            if(byte0 == 4)
            {
                motionZ = -f;
            }
            if(byte0 == 5)
            {
                motionZ = f;
            }
        }
        return false;
    }

    public EnumStatus superSleepInBedAt(int i, int j, int k)
    {
        return super.sleepInBedAt(i, j, k);
    }

    public Minecraft getMc()
    {
        return mc;
    }

    public void superMoveEntity(double d, double d1, double d2)
    {
        super.moveEntity(d, d1, d2);
    }

    public void setMoveForward(float f)
    {
        moveForward = f;
    }

    public void setMoveStrafing(float f)
    {
        moveStrafing = f;
    }

    public void setIsJumping(boolean flag)
    {
        isJumping = flag;
    }

    public float getEntityBrightness(float f)
    {
        return super.getEntityBrightness(f);
    }

    public void onUpdate()
    {
                 super.onUpdate();
  
    }

    public void superMoveFlying(float f, float f1, float f2)
    {
        super.moveFlying(f, f1, f2);
    }

    public void moveEntity(double d, double d1, double d2)
    {
            super.moveEntity(d, d1, d2);
        

    }

    public EnumStatus sleepInBedAt(int i, int j, int k)
    {
     
            return super.sleepInBedAt(i, j, k);
       
    }

    public void doFall(float f)
    {
        super.fall(f);
    }

    public float getFallDistance()
    {
        return fallDistance;
    }

    public boolean getSleeping()
    {
        return sleeping;
    }

    public boolean getJumping()
    {
        return isJumping;
    }

    public void doJump()
    {
        jump();
    }

    public Random getRandom()
    {
        return rand;
    }

    public void setFallDistance(float f)
    {
        fallDistance = f;
    }

    public void setYSize(float f)
    {
        ySize = f;
    }

    public void moveEntityWithHeading(float f, float f1)
    {
        
            super.moveEntityWithHeading(f, f1);
            return;
        
    }

    public boolean isOnLadder()
    {
        return super.isOnLadder();
    }

    public void setActionState(float f, float f1, boolean flag)
    {
        moveStrafing = f;
        moveForward = f1;
        isJumping = flag;
    }

    public boolean isInsideOfMaterial(Material material)
    {
        return super.isInsideOfMaterial(material);
    }

    public void dropCurrentItem()
    {
       
            super.dropCurrentItem();
            return;
        
    }

    public void dropPlayerItem(ItemStack itemstack)
    {
       
            super.dropPlayerItem(itemstack);
            return;
        
    }

    public boolean superIsInsideOfMaterial(Material material)
    {
        return super.isInsideOfMaterial(material);
    }

    public float superGetEntityBrightness(float f)
    {
        return super.getEntityBrightness(f);
    }

    public void sendChatMessage(String s)
    {
      super.addChatMessage(s);
    }

    protected String getHurtSound()
    {
      
            return super.getHurtSound();
        
    }

    public String superGetHurtSound()
    {
        return super.getHurtSound();
    }

    public float superGetCurrentPlayerStrVsBlock(Block block)
    {
        return super.getCurrentPlayerStrVsBlock(block);
    }

    public boolean canHarvestBlock(Block block)
    {
     
            return super.canHarvestBlock(block);
        
    }

    public boolean superCanHarvestBlock(Block block)
    {
        return super.canHarvestBlock(block);
    }

    protected void fall(float f)
    {
       
            super.fall(f);
        
    }

    public void superFall(float f)
    {
        super.fall(f);
    }

    protected void jump()
    {
       
            super.jump();
        
    }

    public void superJump()
    {
        super.jump();
    }

    protected void damageEntity(int i)
    {
       
            super.damageEntity(i);
        
    }

    protected void superDamageEntity(int i)
    {
        super.damageEntity(i);
    }

    public double getDistanceSqToEntity(Entity entity)
    {
      
            return super.getDistanceSqToEntity(entity);
        
    }

    public double superGetDistanceSqToEntity(Entity entity)
    {
        return super.getDistanceSqToEntity(entity);
    }

    public void attackTargetEntityWithCurrentItem(Entity entity)
    {
           super.attackTargetEntityWithCurrentItem(entity);
        
    }

    public void superAttackTargetEntityWithCurrentItem(Entity entity)
    {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    public boolean handleWaterMovement()
    {
     
            return super.handleWaterMovement();
        
    }

    public boolean superHandleWaterMovement()
    {
        return super.handleWaterMovement();
    }

    public boolean handleLavaMovement()
    {
       
            return super.handleLavaMovement();
        
    }

    public boolean superHandleLavaMovement()
    {
        return super.handleLavaMovement();
    }

    public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
       
            super.dropPlayerItemWithRandomChoice(itemstack, flag);
        
    }

    public void superDropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        super.dropPlayerItemWithRandomChoice(itemstack, flag);
    }

    public MovementInput movementInput;
    protected Minecraft mc;
    private MouseFilter field_21903_bJ;
    private MouseFilter field_21904_bK;
    private MouseFilter field_21902_bL;
    public List playerBases;
}
