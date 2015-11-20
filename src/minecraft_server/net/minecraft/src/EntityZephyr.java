// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, IMob, MathHelper, Entity, 
//            World, AxisAlignedBB, EntityZephyrSnowball, Vec3D, 
//            AetherBlocks, Block

public class EntityZephyr extends EntityFlying
    implements IMob
{

    public EntityZephyr(World world)
    {
        super(world);
        checkTime = 0L;
        checkX = 0.0D;
        checkY = 0.0D;
        checkZ = 0.0D;
        isStuckWarning = false;
        courseChangeCooldown = 0;
        targetedEntity = null;
        aggroCooldown = 0;
        prevAttackCounter = 0;
        attackCounter = 0;
        texture = "/aether/mobs/Zephyr.png";
        setSize(4F, 4F);
    }

    protected void updatePlayerActionState()
    {
        if(posY < -2D || posY > 130D)
        {
            func_27008_Y();
        }
        prevAttackCounter = attackCounter;
        double d = waypointX - posX;
        double d1 = waypointY - posY;
        double d2 = waypointZ - posZ;
        double d3 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
        if(d3 < 1.0D || d3 > 60D)
        {
            waypointX = posX + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
            waypointY = posY + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
            waypointZ = posZ + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
        }
        if(courseChangeCooldown-- <= 0)
        {
            courseChangeCooldown += rand.nextInt(5) + 2;
            if(isCourseTraversable(waypointX, waypointY, waypointZ, d3))
            {
                motionX += (d / d3) * 0.10000000000000001D;
                motionY += (d1 / d3) * 0.10000000000000001D;
                motionZ += (d2 / d3) * 0.10000000000000001D;
            } else
            {
                waypointX = posX;
                waypointY = posY;
                waypointZ = posZ;
            }
        }
        if(targetedEntity != null && targetedEntity.isDead)
        {
            targetedEntity = null;
        }
        if(targetedEntity == null || aggroCooldown-- <= 0)
        {
            targetedEntity = worldObj.getClosestPlayerToEntity(this, 100D);
            if(targetedEntity != null)
            {
                aggroCooldown = 20;
            }
        }
        double d4 = 64D;
        if(targetedEntity != null && targetedEntity.getDistanceSqToEntity(this) < d4 * d4)
        {
            double d5 = targetedEntity.posX - posX;
            double d6 = (targetedEntity.boundingBox.minY + (double)(targetedEntity.height / 2.0F)) - (posY + (double)(height / 2.0F));
            double d7 = targetedEntity.posZ - posZ;
            renderYawOffset = rotationYaw = (-(float)Math.atan2(d5, d7) * 180F) / 3.141593F;
            if(canEntityBeSeen(targetedEntity))
            {
                if(attackCounter == 10)
                {
                    worldObj.playSoundAtEntity(this, "aether.sound.mobs.zephyr.zephyrCall", getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                }
                attackCounter++;
                if(attackCounter == 20)
                {
                    worldObj.playSoundAtEntity(this, "aether.sound.mobs.zephyr.zephyrShoot", getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                    EntityZephyrSnowball entityzephyrsnowball = new EntityZephyrSnowball(worldObj, this, d5, d6, d7);
                    double d8 = 4D;
                    Vec3D vec3d = getLook(1.0F);
                    entityzephyrsnowball.posX = posX + vec3d.xCoord * d8;
                    entityzephyrsnowball.posY = posY + (double)(height / 2.0F) + 0.5D;
                    entityzephyrsnowball.posZ = posZ + vec3d.zCoord * d8;
                    worldObj.entityJoinedWorld(entityzephyrsnowball);
                    attackCounter = -40;
                }
            } else
            if(attackCounter > 0)
            {
                attackCounter--;
            }
        } else
        {
            renderYawOffset = rotationYaw = (-(float)Math.atan2(motionX, motionZ) * 180F) / 3.141593F;
            if(attackCounter > 0)
            {
                attackCounter--;
            }
        }
        texture = attackCounter > 10 ? "/aether/mobs/Zephyr.png" : "/aether/mobs/Zephyr.png";
        if(!worldObj.singleplayerWorld && worldObj.difficultySetting == 0)
        {
            setEntityDead();
        }
        checkForBeingStuck();
    }

    private boolean isCourseTraversable(double d, double d1, double d2, double d3)
    {
        double d4 = (waypointX - posX) / d3;
        double d5 = (waypointY - posY) / d3;
        double d6 = (waypointZ - posZ) / d3;
        AxisAlignedBB axisalignedbb = boundingBox.copy();
        for(int i = 1; (double)i < d3; i++)
        {
            axisalignedbb.offset(d4, d5, d6);
            if(worldObj.getCollidingBoundingBoxes(this, axisalignedbb).size() > 0)
            {
                return false;
            }
        }

        return true;
    }

    protected String getLivingSound()
    {
        return "aether.sound.mobs.zephyr.zephyrCall";
    }

    protected String getHurtSound()
    {
        return "aether.sound.mobs.zephyr.zephyrCall";
    }

    protected String getDeathSound()
    {
        return "aether.sound.mobs.zephyr.zephyrCall";
    }

    protected int getDropItemId()
    {
        return AetherBlocks.Aercloud.blockID;
    }

    public boolean canDespawn()
    {
        return true;
    }

    protected float getSoundVolume()
    {
        return 3F;
    }

    private void checkForBeingStuck()
    {
        long l = System.currentTimeMillis();
        if(l > checkTime + 3000L)
        {
            double d = posX - checkX;
            double d1 = posY - checkY;
            double d2 = posZ - checkZ;
            double d3 = Math.sqrt(d * d + d1 * d1 + d2 * d2);
            if(d3 < 3D)
            {
                if(!isStuckWarning)
                {
                    isStuckWarning = true;
                } else
                {
                    setEntityDead();
                }
            }
            checkX = posX;
            checkY = posY;
            checkZ = posZ;
            checkTime = l;
        }
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return rand.nextInt(85) == 0 && worldObj.checkIfAABBIsClear(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox) && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.DungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LightDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.Holystone.blockID && worldObj.difficultySetting > 0;
    }

    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    private long checkTime;
    private final long checkTimeInterval = 3000L;
    private double checkX;
    private double checkY;
    private double checkZ;
    private final double minTraversalDist = 3D;
    private boolean isStuckWarning;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
}
