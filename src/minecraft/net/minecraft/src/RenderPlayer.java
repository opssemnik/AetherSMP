// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelBiped, EntityPlayer, InventoryPlayer, 
//            ItemStack, ItemArmor, ModelRenderer, EntityPlayerSP, 
//            RenderManager, Tessellator, FontRenderer, Item, 
//            Block, RenderBlocks, ItemRenderer, MathHelper, 
//            EntityLiving, Entity

public class RenderPlayer extends RenderLiving
{

    public RenderPlayer()
    {
        super(new ModelBiped(0.0F), 0.5F);
        modelBipedMain = (ModelBiped)mainModel;
        modelArmorChestplate = new ModelBiped(1.0F);
        modelArmor = new ModelBiped(0.5F);
        modelEnergyShield = new ModelBiped(1.25F);
        modelCape = new ModelBiped(0.0F);
        modelMisc = new ModelBiped(0.6F);
    }
    protected void renderEquippedItems(EntityLiving entityliving, float f)
    {
        renderSpecials((EntityPlayer)entityliving, f);
        renderCape((EntityPlayer)entityliving, f);
    }

    public void renderCape(EntityPlayer entityplayer, float f)
    {
        InventoryAether inventoryaether = (entityplayer).inv;
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

    
    public boolean invisible(EntityPlayer entityplayer)
    {
        InventoryAether inventoryaether = (entityplayer).inv;
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
    
    protected boolean setEnergyShieldBrightness(EntityPlayer entityplayer, int i, float f)
    {
        if(i != 0)
        {
            return false;
        }
        InventoryAether inventoryaether = entityplayer.inv;
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
        if(entityplayer.isSneaking())
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
        if(entityplayer.isSneaking())
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
            InventoryAether inventoryaether = (entityplayer).inv;
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
    protected boolean setArmorModel(EntityPlayer entityplayer, int i, float f)
    {
        ItemStack itemstack = entityplayer.inventory.armorItemInSlot(3 - i);
        if(itemstack != null)
        {
            Item item = itemstack.getItem();
            if(item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                loadTexture((new StringBuilder()).append("/armor/").append(armorFilenamePrefix[itemarmor.renderIndex]).append("_").append(i != 2 ? 1 : 2).append(".png").toString());
                ModelBiped modelbiped = i != 2 ? modelArmorChestplate : modelArmor;
                modelbiped.bipedHead.showModel = i == 0;
                modelbiped.bipedHeadwear.showModel = i == 0;
                modelbiped.bipedBody.showModel = i == 1 || i == 2;
                modelbiped.bipedRightArm.showModel = i == 1;
                modelbiped.bipedLeftArm.showModel = i == 1;
                modelbiped.bipedRightLeg.showModel = i == 2 || i == 3;
                modelbiped.bipedLeftLeg.showModel = i == 2 || i == 3;
                setRenderPassModel(modelbiped);
                return true;
            }
        }
        return false;
    }

    public void renderPlayer(EntityPlayer entityplayer, double d, double d1, double d2, 
            float f, float f1)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        modelArmorChestplate.field_1278_i = modelArmor.field_1278_i = modelBipedMain.field_1278_i = itemstack != null;
        modelArmorChestplate.isSneak = modelArmor.isSneak = modelBipedMain.isSneak = entityplayer.isSneaking();
        double d3 = d1 - (double)entityplayer.yOffset;
        if(entityplayer.isSneaking())
        {
            d3 -= 0.125D;
        }
        super.doRenderLiving(entityplayer, d, d3, d2, f, f1);
        modelArmorChestplate.isSneak = modelArmor.isSneak = modelBipedMain.isSneak = false;
        modelArmorChestplate.field_1278_i = modelArmor.field_1278_i = modelBipedMain.field_1278_i = false;
    }

    protected void renderName(EntityPlayer entityplayer, double d, double d1, double d2)
    {
        if(Minecraft.isGuiEnabled() && entityplayer != renderManager.livingPlayer)
        {
            float f = 1.6F;
            float f1 = 0.01666667F * f;
            float f2 = entityplayer.getDistanceToEntity(renderManager.livingPlayer);
            float f3 = entityplayer.isSneaking() ? 32F : 64F;
            if(f2 < f3)
            {
                String s = entityplayer.username;
                if(!entityplayer.isSneaking())
                {
                    if(entityplayer.isPlayerSleeping())
                    {
                        renderLivingLabel(entityplayer, s, d, d1 - 1.5D, d2, 64);
                    } else
                    {
                        renderLivingLabel(entityplayer, s, d, d1, d2, 64);
                    }
                } else
                {
                    FontRenderer fontrenderer = getFontRendererFromRenderManager();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)d + 0.0F, (float)d1 + 2.3F, (float)d2);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                    GL11.glScalef(-f1, -f1, f1);
                    GL11.glDisable(2896 /*GL_LIGHTING*/);
                    GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042 /*GL_BLEND*/);
                    GL11.glBlendFunc(770, 771);
                    Tessellator tessellator = Tessellator.instance;
                    GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
                    tessellator.startDrawingQuads();
                    int i = fontrenderer.getStringWidth(s) / 2;
                    tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
                    tessellator.addVertex(-i - 1, -1D, 0.0D);
                    tessellator.addVertex(-i - 1, 8D, 0.0D);
                    tessellator.addVertex(i + 1, 8D, 0.0D);
                    tessellator.addVertex(i + 1, -1D, 0.0D);
                    tessellator.draw();
                    GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
                    GL11.glDepthMask(true);
                    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, 0, 0x20ffffff);
                    GL11.glEnable(2896 /*GL_LIGHTING*/);
                    GL11.glDisable(3042 /*GL_BLEND*/);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glPopMatrix();
                }
            }
        }
    }

    protected void renderSpecials(EntityPlayer entityplayer, float f)
    {
    	
        ItemStack itemstack = entityplayer.inventory.armorItemInSlot(3);
        if(itemstack != null && itemstack.getItem().shiftedIndex < 256)
        {
            GL11.glPushMatrix();
            modelBipedMain.bipedHead.postRender(0.0625F);
            if(RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
            {
                float f1 = 0.625F;
                GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            }
            renderManager.itemRenderer.renderItem(entityplayer, itemstack);
            GL11.glPopMatrix();
        }
        if(entityplayer.username.equals("deadmau5") && loadDownloadableImageTexture(entityplayer.skinUrl, null))
        {
            for(int i = 0; i < 2; i++)
            {
                float f2 = (entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f) - (entityplayer.prevRenderYawOffset + (entityplayer.renderYawOffset - entityplayer.prevRenderYawOffset) * f);
                float f6 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
                GL11.glPushMatrix();
                GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(f6, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.375F * (float)(i * 2 - 1), 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.375F, 0.0F);
                GL11.glRotatef(-f6, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
                float f7 = 1.333333F;
                GL11.glScalef(f7, f7, f7);
                modelBipedMain.renderEars(0.0625F);
                GL11.glPopMatrix();
            }

        }
        if(loadDownloadableImageTexture(entityplayer.playerCloakUrl, null))
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
            double d = (entityplayer.field_20066_r + (entityplayer.field_20063_u - entityplayer.field_20066_r) * (double)f) - (entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f);
            double d1 = (entityplayer.field_20065_s + (entityplayer.field_20062_v - entityplayer.field_20065_s) * (double)f) - (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f);
            double d2 = (entityplayer.field_20064_t + (entityplayer.field_20061_w - entityplayer.field_20064_t) * (double)f) - (entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f);
            float f8 = entityplayer.prevRenderYawOffset + (entityplayer.renderYawOffset - entityplayer.prevRenderYawOffset) * f;
            double d3 = MathHelper.sin((f8 * 3.141593F) / 180F);
            double d4 = -MathHelper.cos((f8 * 3.141593F) / 180F);
            float f9 = (float)d1 * 10F;
            if(f9 < -6F)
            {
                f9 = -6F;
            }
            if(f9 > 32F)
            {
                f9 = 32F;
            }
            float f10 = (float)(d * d3 + d2 * d4) * 100F;
            float f11 = (float)(d * d4 - d2 * d3) * 100F;
            if(f10 < 0.0F)
            {
                f10 = 0.0F;
            }
            float f12 = entityplayer.field_775_e + (entityplayer.field_774_f - entityplayer.field_775_e) * f;
            f9 += MathHelper.sin((entityplayer.prevDistanceWalkedModified + (entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified) * f) * 6F) * 32F * f12;
            if(entityplayer.isSneaking())
            {
                f9 += 25F;
            }
            GL11.glRotatef(6F + f10 / 2.0F + f9, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f11 / 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f11 / 2.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            modelBipedMain.renderCloak(0.0625F);
            GL11.glPopMatrix();
        }
        ItemStack itemstack1 = entityplayer.inventory.getCurrentItem();
        if(itemstack1 != null)
        {
            GL11.glPushMatrix();
            modelBipedMain.bipedRightArm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if(entityplayer.fishEntity != null)
            {
                itemstack1 = new ItemStack(Item.stick);
            }
            if(itemstack1.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack1.itemID].getRenderType()))
            {
                float f3 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f3 *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f3, -f3, f3);
            } else
            if(Item.itemsList[itemstack1.itemID].isFull3D())
            {
                float f4 = 0.625F;
                if(Item.itemsList[itemstack1.itemID].shouldRotateAroundWhenRendering())
                {
                    GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f4, -f4, f4);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f5 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f5, f5, f5);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            renderManager.itemRenderer.renderItem(entityplayer, itemstack1);
            GL11.glPopMatrix();
        }
    }

    protected void func_186_b(EntityPlayer entityplayer, float f)
    {
        float f1 = 0.9375F;
        GL11.glScalef(f1, f1, f1);
    }

    public void drawFirstPersonHand()
    {
        modelBipedMain.onGround = 0.0F;
        modelBipedMain.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        modelBipedMain.bipedRightArm.render(0.0625F);
        if(renderManager.renderEngine != null && renderManager.livingPlayer != null && renderManager.livingPlayer instanceof EntityPlayer && !invisible((EntityPlayer)renderManager.livingPlayer))
        {
            EntityPlayer entityplayersp = (EntityPlayer)renderManager.livingPlayer;
            InventoryAether inventoryaether = (entityplayersp).inv;
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

    protected void func_22016_b(EntityPlayer entityplayer, double d, double d1, double d2)
    {
        if(entityplayer.isEntityAlive() && entityplayer.isPlayerSleeping())
        {
            super.func_22012_b(entityplayer, d + (double)entityplayer.field_22063_x, d1 + (double)entityplayer.field_22062_y, d2 + (double)entityplayer.field_22061_z);
        } else
        {
            super.func_22012_b(entityplayer, d, d1, d2);
        }
    }

    protected void func_22017_a(EntityPlayer entityplayer, float f, float f1, float f2)
    {
        if(entityplayer.isEntityAlive() && entityplayer.isPlayerSleeping())
        {
            GL11.glRotatef(entityplayer.getBedOrientationInDegrees(), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(getDeathMaxRotation(entityplayer), 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
        } else
        {
            super.rotateCorpse(entityplayer, f, f1, f2);
        }
    }

    protected void passSpecialRender(EntityLiving entityliving, double d, double d1, double d2)
    {
    	
        renderName((EntityPlayer)entityliving, d, d1, d2);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        func_186_b((EntityPlayer)entityliving, f);
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return setArmorModel((EntityPlayer)entityliving, i, f);
    }

  

    protected void rotateCorpse(EntityLiving entityliving, float f, float f1, float f2)
    {
        func_22017_a((EntityPlayer)entityliving, f, f1, f2);
    }

    protected void func_22012_b(EntityLiving entityliving, double d, double d1, double d2)
    {
        func_22016_b((EntityPlayer)entityliving, d, d1, d2);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
    	if(!invisible((EntityPlayer)entityliving))
        {
            renderPlayer((EntityPlayer)entityliving, d, d1, d2, f, f1);
            renderEnergyShield((EntityPlayer)entityliving, d, d1, d2, f, f1);
            renderMisc((EntityPlayer)entityliving, d, d1, d2, f, f1);
        }
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        if(!invisible((EntityPlayer)entity))
        {
            renderPlayer((EntityPlayer)entity, d, d1, d2, f, f1);
            renderEnergyShield((EntityPlayer)entity, d, d1, d2, f, f1);
            renderMisc((EntityPlayer)entity, d, d1, d2, f, f1);
        }
    }

    private ModelBiped modelBipedMain;
    private ModelBiped modelArmorChestplate;
    private ModelBiped modelArmor;
    private ModelBiped modelEnergyShield;
    private ModelBiped modelCape;
    private ModelBiped modelMisc;
    private static final String armorFilenamePrefix[] = {
        "cloth", "chain", "iron", "diamond", "gold"
    };

}
