// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, IMob, DataWatcher, MathHelper, 
//            AxisAlignedBB, World, Vec3D, MovingObjectPosition, 
//            EnumMovingObjectType, AetherBlocks, Block, Entity

public class EntityAerwhale extends EntityFlying
    implements IMob
{

    public EntityAerwhale(World world)
    {
        super(world);
        checkTime = 0L;
        checkX = 0.0D;
        checkY = 0.0D;
        checkZ = 0.0D;
        isStuckWarning = false;
        courseChangeCooldown = 0;
        targetedEntity = null;
        isImmuneToFire = true;
        aggroCooldown = 0;
        prevAttackCounter = 0;
        attackCounter = 0;
        texture = "/aether/mobs/Mob_Aerwhale.png";
        setSize(4F, 4F);
        moveSpeed = 0.5F;
        health = 20;
        rotationYaw = 360F * rand.nextFloat();
        rotationPitch = 90F * rand.nextFloat() - 45F;
        //ignoreFrustumCheck = true;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    public void onLivingUpdate()
    {
    }

    public void onUpdate()
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        texture = byte0 == 1 ? "/aether/mobs/Mob_Aerwhale.png" : "/aether/mobs/Mob_Aerwhale.png";
        double ad[] = new double[5];
        ad[0] = openSpace(0.0F, 0.0F);
        ad[1] = openSpace(45F, 0.0F);
        ad[2] = openSpace(0.0F, 45F);
        ad[3] = openSpace(-45F, 0.0F);
        ad[4] = openSpace(0.0F, -45F);
        int i = 0;
        for(int j = 1; j < 5; j++)
        {
            if(ad[j] > ad[i])
            {
                i = j;
            }
        }

        switch(i)
        {
        default:
            break;

        case 0: // '\0'
            if(ad[0] == 50D)
            {
                motionYaw *= 0.89999997615814209D;
                motionPitch *= 0.89999997615814209D;
                if(posY > 100D)
                {
                    motionPitch -= 2D;
                }
                if(posY < 20D)
                {
                    motionPitch += 2D;
                }
            } else
            {
                rotationPitch = -rotationPitch;
                rotationYaw = -rotationYaw;
            }
            break;

        case 1: // '\001'
            motionYaw += 5D;
            break;

        case 2: // '\002'
            motionPitch -= 5D;
            break;

        case 3: // '\003'
            motionYaw -= 5D;
            break;

        case 4: // '\004'
            motionPitch += 5D;
            break;
        }
        motionYaw += 2.0F * rand.nextFloat() - 1.0F;
        motionPitch += 2.0F * rand.nextFloat() - 1.0F;
        rotationPitch += 0.10000000000000001D * motionPitch;
        rotationYaw += 0.10000000000000001D * motionYaw;
        if(rotationPitch < -60F)
        {
            rotationPitch = -60F;
        }
        if(rotationPitch > 60F)
        {
            rotationPitch = 60F;
        }
        rotationPitch *= 0.98999999999999999D;
        motionX += 0.0050000000000000001D * Math.cos(((double)rotationYaw / 180D) * 3.1415926535897931D) * Math.cos(((double)rotationPitch / 180D) * 3.1415926535897931D);
        motionY += 0.0050000000000000001D * Math.sin(((double)rotationPitch / 180D) * 3.1415926535897931D);
        motionZ += 0.0050000000000000001D * Math.sin(((double)rotationYaw / 180D) * 3.1415926535897931D) * Math.cos(((double)rotationPitch / 180D) * 3.1415926535897931D);
        motionX *= 0.97999999999999998D;
        motionY *= 0.97999999999999998D;
        motionZ *= 0.97999999999999998D;
        int k = MathHelper.floor_double(posX);
        int l = MathHelper.floor_double(boundingBox.minY);
        int i1 = MathHelper.floor_double(posZ);
        if(motionX > 0.0D && worldObj.getBlockId(k + 1, l, i1) != 0)
        {
            motionX = -motionX;
            motionYaw -= 10D;
        } else
        if(motionX < 0.0D && worldObj.getBlockId(k - 1, l, i1) != 0)
        {
            motionX = -motionX;
            motionYaw += 10D;
        }
        if(motionY > 0.0D && worldObj.getBlockId(k, l + 1, i1) != 0)
        {
            motionY = -motionY;
            motionPitch -= 10D;
        } else
        if(motionY < 0.0D && worldObj.getBlockId(k, l - 1, i1) != 0)
        {
            motionY = -motionY;
            motionPitch += 10D;
        }
        if(motionZ > 0.0D && worldObj.getBlockId(k, l, i1 + 1) != 0)
        {
            motionZ = -motionZ;
            motionYaw -= 10D;
        } else
        if(motionZ < 0.0D && worldObj.getBlockId(k, l, i1 - 1) != 0)
        {
            motionZ = -motionZ;
            motionYaw += 10D;
        }
        fire = 0;
        moveEntity(motionX, motionY, motionZ);
        checkForBeingStuck();
    }

    public double getSpeed()
    {
        return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
    }

    private double openSpace(float f, float f1)
    {
        float f2 = rotationYaw + f;
        float f3 = rotationYaw + f;
        Vec3D vec3d = Vec3D.createVector(posX, posY, posZ);
        float f4 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        float f5 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        float f6 = MathHelper.cos(-f3 * 0.01745329F);
        float f7 = MathHelper.sin(-f3 * 0.01745329F);
        float f8 = f5 * f6;
        float f9 = f7;
        float f10 = f4 * f6;
        double d = 50D;
        Vec3D vec3d1 = vec3d.addVector((double)f8 * d, (double)f9 * d, (double)f10 * d);
        MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks_do(vec3d, vec3d1, true);
        if(movingobjectposition == null)
        {
            return 50D;
        }
        if(movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            double d1 = (double)movingobjectposition.blockX - posX;
            double d2 = (double)movingobjectposition.blockY - posY;
            double d3 = (double)movingobjectposition.blockZ - posZ;
            return Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
        } else
        {
            return 50D;
        }
    }

    protected void updatePlayerActionState()
    {
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
        return "aether.sound.mobs.aerwhale.aerwhaleCall";
    }

    protected String getHurtSound()
    {
        return "aether.sound.mobs.aerwhale.aerwhaleDeath";
    }

    protected String getDeathSound()
    {
        return "aether.sound.mobs.aerwhale.aerwhaleDeath";
    }

    protected float getSoundVolume()
    {
        return 3F;
    }

    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    public boolean canDespawn()
    {
        return true;
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return rand.nextInt(65) == 0 && worldObj.checkIfAABBIsClear(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox) && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.DungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LightDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.Holystone.blockID;
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
    public double motionYaw;
    public double motionPitch;
}
