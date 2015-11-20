// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, IAetherBoss, MathHelper, AxisAlignedBB, 
//            NameGen, World, EntityPlayer, EntityLiving, 
//            Entity, mod_Aether, Material, EntityFiroBall, 
//            AetherBlocks, Block, BlockFire, NBTTagCompound, 
//            ModLoader, GuiIngame, EntityFireMinion, ItemStack, 
//            AetherItems, AetherAchievements

public class EntityFireMonster extends EntityFlying
    implements IAetherBoss
{

    public EntityFireMonster(World world)
    {
        super(world);
        texture = "/aether/mobs/firemonster.png";
        setSize(2.25F, 2.5F);
        noClip = true;
        orgX = MathHelper.floor_double(posX);
        orgY = MathHelper.floor_double(boundingBox.minY) + 1;
        orgZ = MathHelper.floor_double(posZ);
        wideness = 10;
        health = 50;
        speedness = 0.5D - ((double)health / 70D) * 0.20000000000000001D;
        direction = 0;
        entCount = rand.nextInt(6);
        bossName = NameGen.gen();
    }

    public EntityFireMonster(World world, int i, int j, int k, int l, int i1)
    {
        super(world);
        texture = "/aether/mobs/firemonster.png";
        setSize(2.25F, 2.5F);
        setPosition((double)i + 0.5D, j, (double)k + 0.5D);
        wideness = l - 2;
        orgX = i;
        orgY = j;
        orgZ = k;
        noClip = true;
        rotary = (double)rand.nextFloat() * 360D;
        health = 50;
        speedness = 0.5D - ((double)health / 70D) * 0.20000000000000001D;
        direction = i1;
        entCount = rand.nextInt(6);
        bossName = NameGen.gen();
    }

    public boolean canDespawn()
    {
        return false;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(health > 0)
        {
            double d = rand.nextFloat() - 0.5F;
            double d1 = rand.nextFloat();
            double d2 = rand.nextFloat() - 0.5F;
            double d3 = posX + d * d1;
            double d4 = (boundingBox.minY + d1) - 0.5D;
            double d5 = posZ + d2 * d1;
            worldObj.spawnParticle("flame", d3, d4, d5, 0.0D, -0.075000002980232239D, 0.0D);
            entCount++;
            if(entCount >= 3)
            {
                burnEntities();
                evapWater();
                entCount = 0;
            }
            if(hurtness > 0)
            {
                hurtness--;
                if(hurtness == 0)
                {
                    texture = "/aether/mobs/firemonster.png";
                }
            }
        }
        if(chatCount > 0)
        {
            chatCount--;
        }
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 32D);
        if(entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public void updatePlayerActionState()
    {
        super.updatePlayerActionState();
        if(gotTarget && target == null)
        {
            target = findPlayerToAttack();
            gotTarget = false;
        }
        if(target == null)
        {
            setPosition((double)orgX + 0.5D, orgY, (double)orgZ + 0.5D);
            setDoor(0);
            return;
        }
        renderYawOffset = rotationYaw;
        setPosition(posX, orgY, posZ);
        motionY = 0.0D;
        boolean flag = false;
        if(motionX > 0.0D && (int)Math.floor(posX) > orgX + wideness)
        {
            rotary = 360D - rotary;
            flag = true;
        } else
        if(motionX < 0.0D && (int)Math.floor(posX) < orgX - wideness)
        {
            rotary = 360D - rotary;
            flag = true;
        }
        if(motionZ > 0.0D && (int)Math.floor(posZ) > orgZ + wideness)
        {
            rotary = 180D - rotary;
            flag = true;
        } else
        if(motionZ < 0.0D && (int)Math.floor(posZ) < orgZ - wideness)
        {
            rotary = 180D - rotary;
            flag = true;
        }
        if(rotary > 360D)
        {
            rotary -= 360D;
        } else
        if(rotary < 0.0D)
        {
            rotary += 360D;
        }
        if(target != null)
        {
            faceEntity(target, 20F, 20F);
        }
        double d = rotary / 57.295772552490234D;
        motionX = Math.sin(d) * speedness;
        motionZ = Math.cos(d) * speedness;
        motionTimer++;
        if(motionTimer >= 20 || flag)
        {
            motionTimer = 0;
            if(rand.nextInt(3) == 0)
            {
                rotary += (double)(rand.nextFloat() - rand.nextFloat()) * 60D;
            }
        }
        flameCount++;
        if(flameCount == 40 && rand.nextInt(2) == 0)
        {
            poopFire();
        } else
        if(flameCount >= 55 + health / 2 && target != null && (target instanceof EntityLiving))
        {
            makeFireBall(1);
            flameCount = 0;
        }
        if(target != null && target.isDead)
        {
            setPosition((double)orgX + 0.5D, orgY, (double)orgZ + 0.5D);
            motionX = 0.0D;
            motionY = 0.0D;
            motionZ = 0.0D;
            target = null;
            chatLine("\247cSuch is the fate of a being who opposes the might of the sun.");
            setDoor(0);
            mod_Aether.currentBoss = null;
            gotTarget = false;
        }
    }

    public void burnEntities()
    {
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(0.0D, 4D, 0.0D));
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);
            if((entity instanceof EntityLiving) && !entity.isImmuneToFire)
            {
                entity.attackEntityFrom(this, 10);
                entity.fire = 300;
            }
        }

    }

    public void evapWater()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posZ);
        for(int k = 0; k < 8; k++)
        {
            int l = (orgY - 2) + k;
            if(worldObj.getBlockMaterial(i, l, j) != Material.water)
            {
                continue;
            }
            worldObj.setBlockWithNotify(i, l, j, 0);
            worldObj.playSoundEffect((float)i + 0.5F, (float)l + 0.5F, (float)j + 0.5F, "random.fizz", 0.5F, 2.6F + (rand.nextFloat() - rand.nextFloat()) * 0.8F);
            for(int i1 = 0; i1 < 8; i1++)
            {
                worldObj.spawnParticle("largesmoke", (double)i + Math.random(), (double)l + 0.75D, (double)j + Math.random(), 0.0D, 0.0D, 0.0D);
            }

        }

    }

    public void makeFireBall(int i)
    {
        worldObj.playSoundAtEntity(this, "mob.ghast.fireball", 5F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        boolean flag = false;
        ballCount++;
        if(ballCount >= 3 + rand.nextInt(3))
        {
            flag = true;
            ballCount = 0;
        }
        for(int j = 0; j < i; j++)
        {
            EntityFiroBall entityfiroball = new EntityFiroBall(worldObj, posX - motionX / 2D, posY, posZ - motionZ / 2D, flag);
            worldObj.entityJoinedWorld(entityfiroball);
        }

    }

    public void poopFire()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posZ);
        int k = orgY - 2;
        if(AetherBlocks.isGood(worldObj.getBlockId(i, k, j), worldObj.getBlockMetadata(i, k, j)))
        {
            worldObj.setBlockWithNotify(i, k, j, Block.fire.blockID);
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("OriginX", (short)orgX);
        nbttagcompound.setShort("OriginY", (short)orgY);
        nbttagcompound.setShort("OriginZ", (short)orgZ);
        nbttagcompound.setShort("Wideness", (short)wideness);
        nbttagcompound.setShort("FlameCount", (short)flameCount);
        nbttagcompound.setShort("BallCount", (short)ballCount);
        nbttagcompound.setShort("ChatLog", (short)chatLog);
        nbttagcompound.setFloat("Rotary", (float)rotary);
        gotTarget = target != null;
        nbttagcompound.setBoolean("GotTarget", gotTarget);
        nbttagcompound.setBoolean("IsCurrentBoss", isCurrentBoss());
        nbttagcompound.setString("BossName", bossName);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        orgX = nbttagcompound.getShort("OriginX");
        orgY = nbttagcompound.getShort("OriginY");
        orgZ = nbttagcompound.getShort("OriginZ");
        wideness = nbttagcompound.getShort("Wideness");
        flameCount = nbttagcompound.getShort("FlameCount");
        ballCount = nbttagcompound.getShort("BallCount");
        chatLog = nbttagcompound.getShort("ChatLog");
        rotary = nbttagcompound.getFloat("Rotary");
        gotTarget = nbttagcompound.getBoolean("GotTarget");
        speedness = 0.5D - ((double)health / 70D) * 0.20000000000000001D;
        if(nbttagcompound.getBoolean("IsCurrentBoss"))
        {
            mod_Aether.currentBoss = this;
        }
        bossName = nbttagcompound.getString("BossName");
    }

    public void chatLine(String s)
    {
       ModLoader.getMinecraftServerInstance().configManager.sendChatMessageToAllOps(s);
    }

    public boolean chatWithMe()
    {
        if(chatCount <= 0)
        {
            if(chatLog == 0)
            {
                chatLine("\247cYou are certainly a brave soul to have entered this chamber.");
                chatLog = 1;
                chatCount = 100;
            } else
            if(chatLog == 1)
            {
                chatLine("\247cBegone human, you serve no purpose here.");
                chatLog = 2;
                chatCount = 100;
            } else
            if(chatLog == 2)
            {
                chatLine("\247cYour presence annoys me. Do you not fear my burning aura?");
                chatLog = 3;
                chatCount = 100;
            } else
            if(chatLog == 3)
            {
                chatLine("\247cI have nothing to offer you, fool. Leave me at peace.");
                chatLog = 4;
                chatCount = 100;
            } else
            if(chatLog == 4)
            {
                chatLine("\247cPerhaps you are ignorant. Do you wish to know who I am?");
                chatLog = 5;
                chatCount = 100;
            } else
            if(chatLog == 5)
            {
                chatLine("\247cI am a sun spirit, embodiment of Aether's eternal daylight.");
                chatLine("\247cAs long as I am alive, the sun will never set on this world.");
                chatLog = 6;
                chatCount = 100;
            } else
            if(chatLog == 6)
            {
                chatLine("\247cMy body burns with the anger of a thousand beasts.");
                chatLine("\247cNo man, hero, or villain can harm me. You are no exception.");
                chatLog = 7;
                chatCount = 100;
            } else
            if(chatLog == 7)
            {
                chatLine("\247cYou wish to challenge the might of the sun? You are mad.");
                chatLine("\247cDo not further insult me or you will feel my wrath.");
                chatLog = 8;
                chatCount = 100;
            } else
            if(chatLog == 8)
            {
                chatLine("\247cThis is your final warning. Leave now, or prepare to burn.");
                chatLog = 9;
                chatCount = 100;
            } else
            {
                if(chatLog == 9)
                {
                    chatLine("\2476As you wish, your death will be slow and agonizing.");
                    chatLog = 10;
                    mod_Aether.currentBoss = this;
                    return true;
                }
                if(chatLog == 10 && target == null)
                {
                    chatLine("\247cDid your previous death not satisfy your curiosity, human?");
                    chatLog = 9;
                    chatCount = 100;
                }
            }
        }
        return false;
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        if(chatWithMe())
        {
            rotary = 57.295772552490234D * Math.atan2(posX - entityplayer.posX, posZ - entityplayer.posZ);
            target = entityplayer;
            setDoor(AetherBlocks.LockedDungeonStone.blockID);
            return true;
        } else
        {
            return false;
        }
    }

    public void addVelocity(double d, double d1, double d2)
    {
    }

    public void knockBack(Entity entity, int i, double d, double d1)
    {
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(entity == null || !(entity instanceof EntityFiroBall))
        {
            return false;
        }
        speedness = 0.5D - ((double)health / 70D) * 0.20000000000000001D;
        boolean flag = super.attackEntityFrom(entity, i);
        if(flag)
        {
            hurtness = 15;
            texture = "/aether/mobs/firemonsterHurt.png";
            EntityFireMinion entityfireminion = new EntityFireMinion(worldObj);
            entityfireminion.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
            worldObj.entityJoinedWorld(entityfireminion);
            worldObj.entityJoinedWorld(entityfireminion);
            worldObj.entityJoinedWorld(entityfireminion);
            if(health <= 0)
            {
                mod_Aether.currentBoss = null;
                chatLine("\247bSuch bitter cold... is this the feeling... of pain?");
                setDoor(0);
                unlockTreasure();
            }
        }
        return flag;
    }

    protected void dropFewItems()
    {
        entityDropItem(new ItemStack(AetherItems.Key, 1, 2), 0.0F);
    }

    private void setDoor(int i)
    {
        if(direction / 2 == 0)
        {
            for(int j = orgY - 1; j < orgY + 2; j++)
            {
                for(int l = orgZ - 1; l < orgZ + 2; l++)
                {
                    worldObj.setBlockAndMetadata(orgX + (direction != 0 ? 11 : -11), j, l, i, 2);
                }

            }

        } else
        {
            for(int k = orgY - 1; k < orgY + 2; k++)
            {
                for(int i1 = orgX - 1; i1 < orgX + 2; i1++)
                {
                    worldObj.setBlockAndMetadata(i1, k, orgZ + (direction != 3 ? -11 : 11), i, 2);
                }

            }

        }
    }

    private void unlockTreasure()
    {
        if(direction / 2 == 0)
        {
            for(int i = orgY - 1; i < orgY + 2; i++)
            {
                for(int l = orgZ - 1; l < orgZ + 2; l++)
                {
                    worldObj.setBlock(orgX + (direction != 0 ? -11 : 11), i, l, 0);
                }

            }

        } else
        {
            for(int j = orgY - 1; j < orgY + 2; j++)
            {
                for(int i1 = orgX - 1; i1 < orgX + 2; i1++)
                {
                    worldObj.setBlock(i1, j, orgZ + (direction != 3 ? 11 : -11), 0);
                }

            }

        }
       // this.playerToAttack(AetherAchievements.defeatGold);
        for(int k = orgX - 20; k < orgX + 20; k++)
        {
            for(int j1 = orgY - 3; j1 < orgY + 6; j1++)
            {
                for(int k1 = orgZ - 20; k1 < orgZ + 20; k1++)
                {
                    int l1 = worldObj.getBlockId(k, j1, k1);
                    if(l1 == AetherBlocks.LockedDungeonStone.blockID)
                    {
                        worldObj.setBlockAndMetadata(k, j1, k1, AetherBlocks.DungeonStone.blockID, worldObj.getBlockMetadata(k, j1, k1));
                    }
                    if(l1 == AetherBlocks.LockedLightDungeonStone.blockID)
                    {
                        worldObj.setBlockAndMetadata(k, j1, k1, AetherBlocks.LightDungeonStone.blockID, worldObj.getBlockMetadata(k, j1, k1));
                    }
                }

            }

        }

    }

    public int getBossHP()
    {
        return health;
    }

    public int getBossMaxHP()
    {
        return 50;
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
        return (new StringBuilder()).append(bossName).append(", the Sun Spirit").toString();
    }

    public int wideness;
    public int orgX;
    public int orgY;
    public int orgZ;
    public int motionTimer;
    public int entCount;
    public int flameCount;
    public int ballCount;
    public int chatLog;
    public int chatCount;
    public int hurtness;
    public int direction;
    public double rotary;
    public double speedness;
    public Entity target;
    public boolean gotTarget;
    public String bossName;
    public static final float jimz = 57.29577F;
}
