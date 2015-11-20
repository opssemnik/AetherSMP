// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderPlayer, ModelBiped, mod_Aether, PlayerBaseAether, 
//            InventoryAether, ItemStack, AetherItems, Item, 
//            EntityPlayer, Entity, InventoryPlayer, EntityPlayerSP, 
//            ItemMoreArmor, ModelRenderer, RenderManager, ModLoader, 
//            MathHelper, GuiMainMenu, EntityLiving

public class RenderPlayerAether extends RenderPlayer
{

    public RenderPlayerAether()
    {
        modelEnergyShield = new ModelBiped(1.25F);
        modelCape = new ModelBiped(0.0F);
        modelMisc = new ModelBiped(0.6F);
    }

    protected boolean setEnergyShieldBrightness(EntityPlayer entityplayer, int i, float f)
    {
        if(i != 0)
        {
            return false;
        }
        InventoryAether inventoryaether = mod_Aether.getPlayer().inv;
        boolean flag = inventoryaether != null && inventoryaether.slots[2] != null && inventoryaether.slots[2].itemID == AetherItems.RepShield.shiftedIndex;
        if(flag)
        {
            if((entityplayer.onGround || entityplayer.ridingEntity != null && entityplayer.ridingEntity.onGround) && entityplayer.moveForward == 0.0F && entityplayer.moveStrafing == 0.0F)
            {
                loadTexture("/aether/mobs/energyGlow.png");
                GL11.glEnable(2977 /*GL_NORMALIZE*/);
                GL11.glEnable(3042 /*GL_BLEND*/);
                GL11.glBlendFunc(770, 771);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            } else
            {
                GL11.glEnable(2977 /*GL_NORMALIZE*/);
                GL11.glEnable(3042 /*GL_BLEND*/);
                GL11.glBlendFunc(770, 771);
                loadTexture("/aether/mobs/energyNotGlow.png");
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void renderEnergyShield(EntityPlayer entityplayer, double d, double d1, double d2, 
            float f, float f1)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        modelEnergyShield.field_1278_i = itemstack != null;
        modelEnergyShield.isSneak = entityplayer.isSneaking();
        double d3 = d1 - (double)entityplayer.yOffset;
        if(entityplayer.isSneaking() && !(entityplayer instanceof EntityPlayerSP))
        {
            d3 -= 0.125D;
        }
        doRenderEnergyShield(entityplayer, d, d3, d2, f, f1);
        modelEnergyShield.isSneak = false;
        modelEnergyShield.field_1278_i = false;
    }

    public void renderMisc(EntityPlayer entityplayer, double d, double d1, double d2, 
            float f, float f1)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        modelMisc.field_1278_i = itemstack != null;
        modelMisc.isSneak = entityplayer.isSneaking();
        double d3 = d1 - (double)entityplayer.yOffset;
        if(entityplayer.isSneaking() && !(entityplayer instanceof EntityPlayerSP))
        {
            d3 -= 0.125D;
        }
        doRenderMisc(entityplayer, d, d3, d2, f, f1);
        modelMisc.isSneak = false;
        modelMisc.field_1278_i = false;
    }

    public void doRenderMisc(EntityPlayer entityplayer, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glEnable(2884 /*GL_CULL_FACE*/);
        modelMisc.onGround = func_167_c(entityplayer, f1);
        modelMisc.isRiding = entityplayer.isRiding();
        try
        {
            float f2 = entityplayer.prevRenderYawOffset + (entityplayer.renderYawOffset - entityplayer.prevRenderYawOffset) * f1;
            float f3 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f1;
            float f4 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f1;
            func_22012_b(entityplayer, d, d1, d2);
            float f5 = func_170_d(entityplayer, f1);
            rotateCorpse(entityplayer, f5, f2, f1);
            float f6 = 0.0625F;
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            GL11.glScalef(-1F, -1F, 1.0F);
            preRenderCallback(entityplayer, f1);
            GL11.glTranslatef(0.0F, -24F * f6 - 0.0078125F, 0.0F);
            float f7 = entityplayer.field_705_Q + (entityplayer.field_704_R - entityplayer.field_705_Q) * f1;
            float f8 = entityplayer.field_703_S - entityplayer.field_704_R * (1.0F - f1);
            if(f7 > 1.0F)
            {
                f7 = 1.0F;
            }
            GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
            modelMisc.setRotationAngles(f8, f7, f5, f3 - f2, f4, f6);
            float f9 = entityplayer.getEntityBrightness(f);
            InventoryAether inventoryaether = mod_Aether.getPlayer(entityplayer).inv;
            if(inventoryaether.slots[0] != null)
            {
                ItemMoreArmor itemmorearmor = (ItemMoreArmor)inventoryaether.slots[0].getItem();
                loadTexture(itemmorearmor.texture);
                int i = itemmorearmor.getColorFromDamage(0);
                float f10 = (float)(i >> 16 & 0xff) / 255F;
                float f12 = (float)(i >> 8 & 0xff) / 255F;
                float f14 = (float)(i & 0xff) / 255F;
                if(itemmorearmor.colouriseRender)
                {
                    GL11.glColor3f(f10 * f9, f12 * f9, f14 * f9);
                } else
                {
                    GL11.glColor3f(f9, f9, f9);
                }
                modelMisc.bipedBody.render(f6);
            }
            if(inventoryaether.slots[6] != null)
            {
                ItemMoreArmor itemmorearmor1 = (ItemMoreArmor)inventoryaether.slots[6].getItem();
                loadTexture(itemmorearmor1.texture);
                int j = itemmorearmor1.getColorFromDamage(0);
                float f11 = (float)(j >> 16 & 0xff) / 255F;
                float f13 = (float)(j >> 8 & 0xff) / 255F;
                float f15 = (float)(j & 0xff) / 255F;
                if(itemmorearmor1.colouriseRender)
                {
                    GL11.glColor3f(f11 * f9, f13 * f9, f15 * f9);
                } else
                {
                    GL11.glColor3f(f9, f9, f9);
                }
                modelMisc.bipedLeftArm.render(f6);
                modelMisc.bipedRightArm.render(f6);
            }
            GL11.glDisable(3042 /*GL_BLEND*/);
            GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        GL11.glPopMatrix();
    }

    public void drawFirstPersonHand()
    {
        if(renderManager.renderEngine != null && !invisible(ModLoader.getMinecraftInstance().thePlayer))
        {
            super.drawFirstPersonHand();
            EntityPlayerSP entityplayersp = ModLoader.getMinecraftInstance().thePlayer;
            InventoryAether inventoryaether = mod_Aether.getPlayer(entityplayersp).inv;
            if(inventoryaether.slots[6] != null)
            {
                float f = entityplayersp.getEntityBrightness(1.0F);
                modelMisc.onGround = 0.0F;
                modelMisc.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                modelMisc.bipedRightArm.render(0.0625F);
                ItemMoreArmor itemmorearmor = (ItemMoreArmor)inventoryaether.slots[6].getItem();
                loadTexture(itemmorearmor.texture);
                int i = itemmorearmor.getColorFromDamage(0);
                float f1 = (float)(i >> 16 & 0xff) / 255F;
                float f2 = (float)(i >> 8 & 0xff) / 255F;
                float f3 = (float)(i & 0xff) / 255F;
                if(itemmorearmor.colouriseRender)
                {
                    GL11.glColor3f(f1 * f, f2 * f, f3 * f);
                } else
                {
                    GL11.glColor3f(f, f, f);
                }
                modelMisc.bipedRightArm.render(0.0625F);
            }
        }
    }

    protected void renderEquippedItems(EntityLiving entityliving, float f)
    {
        renderSpecials((EntityPlayer)entityliving, f);
        renderCape((EntityPlayer)entityliving, f);
    }

    public void renderCape(EntityPlayer entityplayer, float f)
    {
        InventoryAether inventoryaether = mod_Aether.getPlayer(entityplayer).inv;
        if(inventoryaether.slots[1] != null)
        {
            ItemStack itemstack = inventoryaether.slots[1];
            if(itemstack.itemID == AetherItems.RepShield.shiftedIndex)
            {
                return;
            }
            loadTexture(((ItemMoreArmor)itemstack.getItem()).texture);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
            double d = (entityplayer.field_20066_r + (entityplayer.field_20063_u - entityplayer.field_20066_r) * (double)f) - (entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f);
            double d1 = (entityplayer.field_20065_s + (entityplayer.field_20062_v - entityplayer.field_20065_s) * (double)f) - (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f);
            double d2 = (entityplayer.field_20064_t + (entityplayer.field_20061_w - entityplayer.field_20064_t) * (double)f) - (entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f);
            float f1 = entityplayer.prevRenderYawOffset + (entityplayer.renderYawOffset - entityplayer.prevRenderYawOffset) * f;
            double d3 = MathHelper.sin((f1 * 3.141593F) / 180F);
            double d4 = -MathHelper.cos((f1 * 3.141593F) / 180F);
            float f2 = (float)d1 * 10F;
            if(f2 < -6F)
            {
                f2 = -6F;
            }
            if(f2 > 32F)
            {
                f2 = 32F;
            }
            float f3 = (float)(d * d3 + d2 * d4) * 100F;
            float f4 = (float)(d * d4 - d2 * d3) * 100F;
            if(f3 < 0.0F)
            {
                f3 = 0.0F;
            }
            float f5 = entityplayer.field_775_e + (entityplayer.field_774_f - entityplayer.field_775_e) * f;
            f2 += MathHelper.sin((entityplayer.prevDistanceWalkedModified + (entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified) * f) * 6F) * 32F * f5;
            if(entityplayer.isSneaking())
            {
                f2 += 25F;
            }
            GL11.glRotatef(6F + f3 / 2.0F + f2, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f4 / 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f4 / 2.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            modelCape.renderCloak(0.0625F);
            GL11.glPopMatrix();
        }
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        if(!invisible((EntityPlayer)entityliving))
        {
            super.doRenderLiving(entityliving, d, d1, d2, f, f1);
            renderEnergyShield((EntityPlayer)entityliving, d, d1, d2, f, f1);
            renderMisc((EntityPlayer)entityliving, d, d1, d2, f, f1);
        }
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        if(!invisible((EntityPlayer)entity))
        {
            super.doRender(entity, d, d1, d2, f, f1);
            renderEnergyShield((EntityPlayer)entity, d, d1, d2, f, f1);
            renderMisc((EntityPlayer)entity, d, d1, d2, f, f1);
        }
    }

    public boolean invisible(EntityPlayer entityplayer)
    {
        InventoryAether inventoryaether = mod_Aether.getPlayer(entityplayer).inv;
        if(!entityplayer.isSwinging && inventoryaether.slots[1] != null && inventoryaether.slots[1].itemID == AetherItems.InvisibilityCloak.shiftedIndex)
        {
            return true;
        }
        return GuiMainMenu.mmactive;
    }

    public void doRenderEnergyShield(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glEnable(2884 /*GL_CULL_FACE*/);
        modelEnergyShield.onGround = func_167_c(entityliving, f1);
        modelEnergyShield.isRiding = entityliving.isRiding();
        try
        {
            float f2 = entityliving.prevRenderYawOffset + (entityliving.renderYawOffset - entityliving.prevRenderYawOffset) * f1;
            float f3 = entityliving.prevRotationYaw + (entityliving.rotationYaw - entityliving.prevRotationYaw) * f1;
            float f4 = entityliving.prevRotationPitch + (entityliving.rotationPitch - entityliving.prevRotationPitch) * f1;
            func_22012_b(entityliving, d, d1, d2);
            float f5 = func_170_d(entityliving, f1);
            rotateCorpse(entityliving, f5, f2, f1);
            float f6 = 0.0625F;
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            GL11.glScalef(-1F, -1F, 1.0F);
            preRenderCallback(entityliving, f1);
            GL11.glTranslatef(0.0F, -24F * f6 - 0.0078125F, 0.0F);
            float f7 = entityliving.field_705_Q + (entityliving.field_704_R - entityliving.field_705_Q) * f1;
            float f8 = entityliving.field_703_S - entityliving.field_704_R * (1.0F - f1);
            if(f7 > 1.0F)
            {
                f7 = 1.0F;
            }
            GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
            if(setEnergyShieldBrightness((EntityPlayer)entityliving, 0, f1))
            {
                modelEnergyShield.render(f8, f7, f5, f3 - f2, f4, f6);
                GL11.glDisable(3042 /*GL_BLEND*/);
                GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
            }
            GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        GL11.glEnable(2884 /*GL_CULL_FACE*/);
        GL11.glPopMatrix();
    }

    private ModelBiped modelEnergyShield;
    private ModelBiped modelCape;
    private ModelBiped modelMisc;
}
