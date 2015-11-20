// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityDungeonMob, IAetherBoss, NameGen, World, 
//            Entity, Block, EntityPlayer, ItemStack, 
//            AetherItems, Item, ModLoader, GuiIngame, 
//            EntityHomeShot, EntityLiving, mod_Aether, MathHelper, 
//            AxisAlignedBB, NBTTagCompound, NBTTagList, NBTTagDouble, 
//            AetherBlocks, AetherAchievements

public class EntityValkyrie extends EntityDungeonMob
    implements IAetherBoss
{

    public EntityValkyrie(World world)
    {
        super(world);
        setSize(0.8F, 1.6F);
        texture = "/aether/mobs/valkyrie.png";
        teleTimer = rand.nextInt(250);
        health = 50;
        moveSpeed = 0.5F;
        timeLeft = 1200;
        attackStrength = 7;
        safeX = posX;
        safeY = posY;
        safeZ = posZ;
    }

    public EntityValkyrie(World world, double d, double d1, double d2, 
            boolean flag)
    {
        super(world);
        setSize(0.8F, 1.6F);
        bossName = NameGen.gen();
        texture = "/aether/mobs/valkyrie.png";
        if(flag)
        {
            texture = "/aether/mobs/valkyrie2.png";
            health = 500;
            boss = true;
        } else
        {
            health = 50;
        }
        teleTimer = rand.nextInt(250);
        moveSpeed = 0.5F;
        timeLeft = 1200;
        attackStrength = 7;
        safeX = posX = d;
        safeY = posY = d1;
        safeZ = posZ = d2;
        hasDungeon = false;
    }

    public void fall(float f)
    {
    }

    public void onUpdate()
    {
        lastMotionY = motionY;
        super.onUpdate();
        if(!onGround && playerToAttack != null && lastMotionY >= 0.0D && motionY < 0.0D && getDistanceToEntity(playerToAttack) <= 16F && canEntityBeSeen(playerToAttack))
        {
            double d = playerToAttack.posX - posX;
            double d1 = playerToAttack.posZ - posZ;
            double d2 = Math.atan2(d, d1);
            motionX = Math.sin(d2) * 0.25D;
            motionZ = Math.cos(d2) * 0.25D;
        }
        if(!onGround && !isOnLadder() && Math.abs(motionY - lastMotionY) > 0.070000000000000007D && Math.abs(motionY - lastMotionY) < 0.089999999999999997D)
        {
            motionY += 0.054999999701976776D;
            if(motionY < -0.27500000596046448D)
            {
                motionY = -0.27500000596046448D;
            }
        }
        moveSpeed = playerToAttack != null ? 1.0F : 0.5F;
        if(worldObj.difficultySetting <= 0 && (playerToAttack != null || angerLevel > 0))
        {
            angerLevel = 0;
            playerToAttack = null;
        }
        if(isSwinging)
        {
            prevSwingProgress += 0.15F;
            swingProgress += 0.15F;
            if(prevSwingProgress > 1.0F || swingProgress > 1.0F)
            {
                isSwinging = false;
                prevSwingProgress = 0.0F;
                swingProgress = 0.0F;
            }
        }
        if(!onGround)
        {
            sinage += 0.75F;
        } else
        {
            sinage += 0.15F;
        }
        if(sinage > 6.283186F)
        {
            sinage -= 6.283186F;
        }
        if(!otherDimension())
        {
            timeLeft--;
            if(timeLeft <= 0)
            {
                isDead = true;
                spawnExplosionParticle();
            }
        }
    }

    public boolean otherDimension()
    {
        return true;
    }

    public void teleport(double d, double d1, double d2, int i)
    {
        int j = rand.nextInt(i + 1);
        int k = rand.nextInt(i / 2);
        int l = i - j;
        j *= rand.nextInt(2) * 2 - 1;
        k *= rand.nextInt(2) * 2 - 1;
        l *= rand.nextInt(2) * 2 - 1;
        d += j;
        d1 += k;
        d2 += l;
        int i1 = (int)Math.floor(d - 0.5D);
        int j1 = (int)Math.floor(d1 - 0.5D);
        int k1 = (int)Math.floor(d2 - 0.5D);
        boolean flag = false;
        for(int l1 = 0; l1 < 32 && !flag; l1++)
        {
            int i2 = i1 + (rand.nextInt(i / 2) - rand.nextInt(i / 2));
            int j2 = j1 + (rand.nextInt(i / 2) - rand.nextInt(i / 2));
            int k2 = k1 + (rand.nextInt(i / 2) - rand.nextInt(i / 2));
            if(j2 <= 124 && j2 >= 5 && isAirySpace(i2, j2, k2) && isAirySpace(i2, j2 + 1, k2) && !isAirySpace(i2, j2 - 1, k2) && (!hasDungeon || i2 > dungeonX && i2 < dungeonX + 20 && j2 > dungeonY && j2 < dungeonY + 12 && k2 > dungeonZ && k2 < dungeonZ + 20))
            {
                i1 = i2;
                j1 = j2;
                k1 = k2;
                flag = true;
            }
        }

        if(!flag)
        {
            teleFail();
        } else
        {
            spawnExplosionParticle();
            setPosition((double)i1 + 0.5D, (double)j1 + 0.5D, (double)k1 + 0.5D);
            motionX = 0.0D;
            motionY = 0.0D;
            motionZ = 0.0D;
            moveForward = 0.0F;
            moveStrafing = 0.0F;
            isJumping = false;
            rotationPitch = 0.0F;
            rotationYaw = 0.0F;
            setPathToEntity(null);
            renderYawOffset = rand.nextFloat() * 360F;
            spawnExplosionParticle();
            teleTimer = rand.nextInt(40);
        }
    }

    public boolean isAirySpace(int i, int j, int k)
    {
        int l = worldObj.getBlockId(i, j, k);
        return l == 0 || Block.blocksList[l].getCollisionBoundingBoxFromPool(worldObj, i, j, k) == null;
    }

    public boolean canDespawn()
    {
        return !boss;
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        faceEntity(entityplayer, 180F, 180F);
        if(!boss)
        {
            if(timeLeft >= 1200)
            {
                ItemStack itemstack = entityplayer.getCurrentEquippedItem();
                if(itemstack != null && itemstack.itemID == AetherItems.VictoryMedal.shiftedIndex && itemstack.stackSize >= 0)
                {
                    if(itemstack.stackSize >= 10)
                    {
                        chatItUp("Umm... that's a nice pile of medallions you have there...");
                    } else
                    if(itemstack.stackSize >= 5)
                    {
                        chatItUp("That's pretty impressive, but you won't defeat me.");
                    } else
                    {
                        chatItUp("You think you're a tough guy, eh? Well, bring it on!");
                    }
                } else
                {
                    int i = rand.nextInt(3);
                    if(i == 2)
                    {
                        chatItUp("What's that? You want to fight? Aww, what a cute little human.");
                    } else
                    if(i == 1)
                    {
                        chatItUp("You're not thinking of fighting a big, strong Valkyrie are you?");
                    } else
                    {
                        chatItUp("I don't think you should bother me, you could get really hurt.");
                    }
                }
            }
        } else
        if(duel)
        {
            chatItUp("If you wish to challenge me, strike at any time.");
        } else
        if(!duel)
        {
            ItemStack itemstack1 = entityplayer.getCurrentEquippedItem();
            if(itemstack1 != null && itemstack1.itemID == AetherItems.VictoryMedal.shiftedIndex && itemstack1.stackSize >= 10)
            {
                itemstack1.stackSize -= 10;
                if(itemstack1.stackSize <= 0)
                {
                    itemstack1.func_1097_a(entityplayer);
                    entityplayer.destroyCurrentEquippedItem();
                    chatTime = 0;
                    chatItUp("Very well, attack me when you wish to begin.");
                    duel = true;
                }
            } else
            {
                chatItUp("Show me 10 victory medals, and I will fight you.");
            }
        }
        return true;
    }

    private void chatItUp(String s)
    {
        if(chatTime <= 0 && otherDimension())
        {
            ModLoader.getMinecraftInstance().ingameGUI.addChatMessage(s);
            chatTime = 60;
        }
    }

    public void makeHomeShot(int i, EntityLiving entityliving)
    {
        for(int j = 0; j < i; j++)
        {
            EntityHomeShot entityhomeshot = new EntityHomeShot(worldObj, posX - motionX / 2D, posY, posZ - motionZ / 2D, entityliving);
            worldObj.entityJoinedWorld(entityhomeshot);
        }

    }

    protected void dropFewItems()
    {
        if(boss)
        {
            entityDropItem(new ItemStack(AetherItems.Key, 1, 1), 0.0F);
            dropItem(Item.swordGold.shiftedIndex, 1);
        } else
        {
            dropItem(AetherItems.VictoryMedal.shiftedIndex, 1);
        }
    }

    public void updatePlayerActionState()
    {
        super.updatePlayerActionState();
        teleTimer++;
        if(teleTimer >= 450)
        {
            if(playerToAttack != null)
            {
                if(boss && onGround && rand.nextInt(2) == 0 && playerToAttack != null && (playerToAttack instanceof EntityLiving))
                {
                    makeHomeShot(1, (EntityLiving)playerToAttack);
                    teleTimer = -100;
                } else
                {
                    teleport(playerToAttack.posX, playerToAttack.posY, playerToAttack.posZ, 7);
                }
            } else
            if(!onGround || boss)
            {
                teleport(safeX, safeY, safeZ, 6);
            } else
            {
                teleport(posX, posY, posZ, 12 + rand.nextInt(12));
            }
        } else
        if(teleTimer < 446 && (posY <= 0.0D || posY <= safeY - 16D))
        {
            teleTimer = 446;
        } else
        if(teleTimer % 5 == 0 && playerToAttack != null && !canEntityBeSeen(playerToAttack))
        {
            teleTimer += 100;
        }
        if(onGround && teleTimer % 10 == 0 && !boss)
        {
            safeX = posX;
            safeY = posY;
            safeZ = posZ;
        }
        if(playerToAttack != null && playerToAttack.isDead)
        {
            playerToAttack = null;
            if(boss)
            {
                unlockDoor();
                mod_Aether.currentBoss = null;
            }
            angerLevel = 0;
        }
        if(chatTime > 0)
        {
            chatTime--;
        }
    }

    public void swingArm()
    {
        if(!isSwinging)
        {
            isSwinging = true;
            prevSwingProgress = 0.0F;
            swingProgress = 0.0F;
        }
    }

    public void teleFail()
    {
        teleTimer -= rand.nextInt(40) + 40;
        if(posY <= 0.0D)
        {
            teleTimer = 446;
        }
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.getFullBlockLightValue(i, j, k) > 8 && worldObj.checkIfAABBIsClear(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Anger", (short)angerLevel);
        nbttagcompound.setShort("TeleTimer", (short)teleTimer);
        nbttagcompound.setShort("TimeLeft", (short)timeLeft);
        nbttagcompound.setBoolean("Boss", boss);
        nbttagcompound.setBoolean("Duel", duel);
        nbttagcompound.setInteger("DungeonX", dungeonX);
        nbttagcompound.setInteger("DungeonY", dungeonY);
        nbttagcompound.setInteger("DungeonZ", dungeonZ);
        nbttagcompound.setInteger("DungeonEntranceZ", dungeonEntranceZ);
        nbttagcompound.setTag("SafePos", newDoubleNBTList(new double[] {
            safeX, safeY, safeZ
        }));
        nbttagcompound.setBoolean("IsCurrentBoss", isCurrentBoss());
        nbttagcompound.setString("BossName", bossName);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        angerLevel = nbttagcompound.getShort("Anger");
        teleTimer = nbttagcompound.getShort("TeleTimer");
        timeLeft = nbttagcompound.getShort("TimeLeft");
        duel = nbttagcompound.getBoolean("Duel");
        boss = nbttagcompound.getBoolean("Boss");
        dungeonX = nbttagcompound.getInteger("DungeonX");
        dungeonY = nbttagcompound.getInteger("DungeonY");
        dungeonZ = nbttagcompound.getInteger("DungeonZ");
        dungeonEntranceZ = nbttagcompound.getInteger("DungeonEntranceZ");
        if(boss)
        {
            texture = "/aether/mobs/valkyrie2.png";
        }
        NBTTagList nbttaglist = nbttagcompound.getTagList("SafePos");
        safeX = ((NBTTagDouble)nbttaglist.tagAt(0)).doubleValue;
        safeY = ((NBTTagDouble)nbttaglist.tagAt(1)).doubleValue;
        safeZ = ((NBTTagDouble)nbttaglist.tagAt(2)).doubleValue;
        if(nbttagcompound.getBoolean("IsCurrentBoss"))
        {
            mod_Aether.currentBoss = this;
        }
        bossName = nbttagcompound.getString("BossName");
    }

    protected Entity findPlayerToAttack()
    {
        if(otherDimension() && (worldObj.difficultySetting <= 0 || boss && !duel || angerLevel <= 0))
        {
            return null;
        } else
        {
            return super.findPlayerToAttack();
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if((entity instanceof EntityPlayer) && worldObj.difficultySetting > 0)
        {
            if(boss && (!duel || worldObj.difficultySetting <= 0))
            {
                spawnExplosionParticle();
                int j = rand.nextInt(2);
                if(j == 2)
                {
                    chatItUp("Sorry, I don't fight with weaklings.");
                } else
                {
                    chatItUp("Try defeating some weaker valkyries first.");
                }
                return false;
            }
            if(boss)
            {
                if(playerToAttack == null)
                {
                    mod_Aether.currentBoss = this;
                    chatTime = 0;
                    chatItUp("This will be your final battle!");
                } else
                {
                    teleTimer += 60;
                }
            } else
            if(playerToAttack == null)
            {
                chatTime = 0;
                int k = rand.nextInt(3);
                if(k == 2)
                {
                    chatItUp("I'm not going easy on you!");
                } else
                if(k == 1)
                {
                    chatItUp("You're gonna regret that!");
                } else
                {
                    chatItUp("Now you're in for it!");
                }
            } else
            {
                teleTimer -= 10;
            }
            becomeAngryAt(entity);
        } else
        {
            teleport(posX, posY, posZ, 8);
            fire = 0;
            return false;
        }
        boolean flag = super.attackEntityFrom(entity, i);
        if(flag && health <= 0)
        {
            int l = rand.nextInt(3);
            isDead = true;
            if(boss)
            {
                isDead = false;
                unlockDoor();
                unlockTreasure();
                chatItUp("You are truly... a mighty warrior...");
                mod_Aether.currentBoss = null;
            } else
            if(l == 2)
            {
                chatItUp("Alright, alright! You win!");
            } else
            if(l == 1)
            {
                chatItUp("Okay, I give up! Geez!");
            } else
            {
                chatItUp("Oww! Fine, here's your medal...");
            }
            spawnExplosionParticle();
        }
        return flag;
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(attackTime <= 0 && f < 2.75F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            swingArm();
            entity.attackEntityFrom(this, attackStrength);
            if(entity != null && playerToAttack != null && entity == playerToAttack && (entity instanceof EntityLiving))
            {
                EntityLiving entityliving = (EntityLiving)entity;
                if(entityliving.health <= 0)
                {
                    playerToAttack = null;
                    angerLevel = 0;
                    int i = rand.nextInt(3);
                    chatTime = 0;
                    if(boss)
                    {
                        chatItUp("As expected of a human.");
                        unlockDoor();
                        mod_Aether.currentBoss = null;
                    } else
                    if(i == 2)
                    {
                        chatItUp("You want a medallion? Try being less pathetic.");
                    } else
                    if(i == 1 && (entityliving instanceof EntityPlayer))
                    {
                        EntityPlayer entityplayer = (EntityPlayer)entityliving;
                        String s = entityplayer.username;
                        chatItUp((new StringBuilder()).append("Maybe some day, ").append(s).append("... maybe some day.").toString());
                    } else
                    {
                        chatItUp("Humans aren't nearly as cute when they're dead.");
                    }
                }
            }
        }
    }

    private void becomeAngryAt(Entity entity)
    {
        playerToAttack = entity;
        angerLevel = 200 + rand.nextInt(200);
        if(boss)
        {
            for(int i = dungeonZ + 2; i < dungeonZ + 23; i += 7)
            {
                if(worldObj.getBlockId(dungeonX - 1, dungeonY, i) == 0)
                {
                    dungeonEntranceZ = i;
                    worldObj.setBlockAndMetadata(dungeonX - 1, dungeonY, i, AetherBlocks.LockedDungeonStone.blockID, 1);
                    worldObj.setBlockAndMetadata(dungeonX - 1, dungeonY, i + 1, AetherBlocks.LockedDungeonStone.blockID, 1);
                    worldObj.setBlockAndMetadata(dungeonX - 1, dungeonY + 1, i + 1, AetherBlocks.LockedDungeonStone.blockID, 1);
                    worldObj.setBlockAndMetadata(dungeonX - 1, dungeonY + 1, i, AetherBlocks.LockedDungeonStone.blockID, 1);
                    return;
                }
            }

        }
    }

    private void unlockDoor()
    {
        worldObj.setBlock(dungeonX - 1, dungeonY, dungeonEntranceZ, 0);
        worldObj.setBlock(dungeonX - 1, dungeonY, dungeonEntranceZ + 1, 0);
        worldObj.setBlock(dungeonX - 1, dungeonY + 1, dungeonEntranceZ + 1, 0);
        worldObj.setBlock(dungeonX - 1, dungeonY + 1, dungeonEntranceZ, 0);
    }

    private void unlockTreasure()
    {
        worldObj.setBlockAndMetadata(dungeonX + 16, dungeonY + 1, dungeonZ + 9, Block.trapdoor.blockID, 3);
        worldObj.setBlockAndMetadata(dungeonX + 17, dungeonY + 1, dungeonZ + 9, Block.trapdoor.blockID, 2);
        worldObj.setBlockAndMetadata(dungeonX + 16, dungeonY + 1, dungeonZ + 10, Block.trapdoor.blockID, 3);
        worldObj.setBlockAndMetadata(dungeonX + 17, dungeonY + 1, dungeonZ + 10, Block.trapdoor.blockID, 2);
        mod_Aether.giveAchievement(AetherAchievements.defeatSilver);
        for(int i = dungeonX - 26; i < dungeonX + 29; i++)
        {
            for(int j = dungeonY - 1; j < dungeonY + 22; j++)
            {
                for(int k = dungeonZ - 5; k < dungeonZ + 25; k++)
                {
                    int l = worldObj.getBlockId(i, j, k);
                    if(l == AetherBlocks.LockedDungeonStone.blockID)
                    {
                        worldObj.setBlockAndMetadata(i, j, k, AetherBlocks.DungeonStone.blockID, worldObj.getBlockMetadata(i, j, k));
                    }
                    if(l == AetherBlocks.Trap.blockID)
                    {
                        worldObj.setBlockAndMetadata(i, j, k, AetherBlocks.DungeonStone.blockID, worldObj.getBlockMetadata(i, j, k));
                    }
                    if(l == AetherBlocks.LockedLightDungeonStone.blockID)
                    {
                        worldObj.setBlockAndMetadata(i, j, k, AetherBlocks.LightDungeonStone.blockID, worldObj.getBlockMetadata(i, j, k));
                    }
                }

            }

        }

    }

    public void setDungeon(int i, int j, int k)
    {
        hasDungeon = true;
        dungeonX = i;
        dungeonY = j;
        dungeonZ = k;
    }

    public int getBossHP()
    {
        return health;
    }

    public int getBossMaxHP()
    {
        return 500;
    }

    public boolean isCurrentBoss()
    {
        if(mod_Aether.currentBoss == null)
        {
            return false;
        } else
        {
            return equals(mod_Aether.currentBoss);
        }
    }

    public int getBossEntityID()
    {
        return entityId;
    }

    public String getBossTitle()
    {
        return (new StringBuilder()).append(bossName).append(", the Valkyrie Queen").toString();
    }

    public boolean isSwinging;
    public boolean boss;
    public boolean duel;
    public boolean hasDungeon;
    public int teleTimer;
    public int angerLevel;
    public int timeLeft;
    public int chatTime;
    public int dungeonX;
    public int dungeonY;
    public int dungeonZ;
    public int dungeonEntranceZ;
    public double safeX;
    public double safeY;
    public double safeZ;
    public float sinage;
    public double lastMotionY;
    public String bossName;
}
