// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            TextureFX

public abstract class AnimBase extends TextureFX
{
    public abstract class Mode
    {

        public abstract void draw(int i, int j, Color color);

        public Mode()
        {
        }
    }


    public AnimBase(int i, String s)
    {
        super(i);
        mdSet = new Mode() {

            public void draw(int l1, int i2, Color color)
            {
                setPixel(l1, i2, color);
            }

        }
;
        mdAdd = new Mode() {

            public void draw(int l1, int i2, Color color)
            {
                setPixel(l1, i2, AnimBase.add(new Color(frame[l1][i2]), color));
            }

        }
;
        mdSubtract = new Mode() {

            public void draw(int l1, int i2, Color color)
            {
                setPixel(l1, i2, AnimBase.subtract(new Color(frame[l1][i2]), color));
            }

        }
;
        mdBlend = new Mode() {

            public void draw(int l1, int i2, Color color)
            {
                setPixel(l1, i2, AnimBase.blend(new Color(frame[l1][i2]), color));
            }

        }
;
        size = (int)Math.sqrt(imageData.length / 4);
        fileBuf = new int[size][size];
        frame = new int[size][size];
        try
        {
            if(s.isEmpty())
            {
                BufferedImage bufferedimage = ImageIO.read((net.minecraft.client.Minecraft.class).getResource(tileImage != 0 ? "/gui/items.png" : "/terrain.png"));
                int j = (i % 16) * size;
                int l = (int)Math.floor(i / 16) * size;
                for(int j1 = 0; j1 < size; j1++)
                {
                    for(int k1 = 0; k1 < size; k1++)
                    {
                        fileBuf[k1][j1] = bufferedimage.getRGB(j + k1, l + j1);
                    }

                }

            } else
            {
                BufferedImage bufferedimage1 = ImageIO.read((net.minecraft.client.Minecraft.class).getResource(s));
                for(int k = 0; k < size; k++)
                {
                    for(int i1 = 0; i1 < size; i1++)
                    {
                        fileBuf[i1][k] = bufferedimage1.getRGB(i1, k);
                    }

                }

            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void onTick()
    {
        getCleanFrame();
        animFrame();
        copyFrameToArray();
    }

    public abstract void animFrame();

    protected void getCleanFrame()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                frame[j][i] = fileBuf[j][i];
            }

        }

    }

    protected void copyFrameToArray()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                int k = getXYIndex(j, i);
                imageData[k * 4 + 0] = (byte)(frame[j][i] >> 16 & 0xff);
                imageData[k * 4 + 1] = (byte)(frame[j][i] >> 8 & 0xff);
                imageData[k * 4 + 2] = (byte)(frame[j][i] & 0xff);
                imageData[k * 4 + 3] = (byte)(frame[j][i] >> 24 & 0xff);
            }

        }

    }

    private void setPixel(int i, int j, Color color)
    {
        if(!inImage(i, j))
        {
            return;
        } else
        {
            frame[i][j] = color.getRGB();
            return;
        }
    }

    protected int getXYIndex(int i, int j)
    {
        return j * size + i;
    }

    protected boolean inImage(int i, int j)
    {
        return i >= 0 && j >= 0 && i < size && j < size;
    }

    protected void drawPoint(int i, int j, Color color)
    {
        drawPoint(i, j, color, mdSet);
    }

    protected void drawPoint(int i, int j, Color color, Mode mode)
    {
        mode.draw(i, j, color);
    }

    protected void drawRect(int i, int j, int k, int l, Color color)
    {
        drawRect(i, j, k, l, color, mdSet);
    }

    protected void drawRect(int i, int j, int k, int l, Color color, Mode mode)
    {
        int i1 = Math.min(i, k);
        int j1 = Math.min(j, l);
        int k1 = Math.max(i, k);
        int l1 = Math.max(j, l);
        for(int i2 = j1; i2 < l1; i2++)
        {
            for(int j2 = i1; j2 < k1; j2++)
            {
                drawPoint(j2, i2, color, mode);
            }

        }

    }

    protected void shiftFrame(int i, int j, boolean flag, boolean flag1)
    {
        int ai[] = new int[size];
        if(flag)
        {
            for(; i < 0; i += size) { }
            i %= size;
        }
        if(flag1)
        {
            for(; j < 0; j += size) { }
            j %= size;
        }
        if(i != 0)
        {
            if(flag)
            {
                for(int k = 0; k < size; k++)
                {
                    for(int k1 = 0; k1 < size; k1++)
                    {
                        ai[k1] = frame[k1][k];
                    }

                    for(int l1 = 0; l1 < size; l1++)
                    {
                        frame[l1][k] = ai[(l1 + i) % size];
                    }

                }

            } else
            {
                for(int l = 0; l < size; l++)
                {
                    for(int i2 = 0; i2 < size; i2++)
                    {
                        ai[i2] = frame[i2][l];
                        frame[i2][l] = 0;
                    }

                    for(int j2 = 0; j2 < size; j2++)
                    {
                        if(inImage(j2 + i, l))
                        {
                            frame[j2 + i][l] = ai[j2];
                        }
                    }

                }

            }
        }
        if(j != 0)
        {
            if(flag1)
            {
                for(int i1 = 0; i1 < size; i1++)
                {
                    for(int k2 = 0; k2 < size; k2++)
                    {
                        ai[k2] = frame[i1][k2];
                    }

                    for(int l2 = 0; l2 < size; l2++)
                    {
                        frame[i1][l2] = ai[(l2 + j) % size];
                    }

                }

            } else
            {
                for(int j1 = 0; j1 < size; j1++)
                {
                    for(int i3 = 0; i3 < size; i3++)
                    {
                        ai[i3] = frame[j1][i3];
                        frame[j1][i3] = 0;
                    }

                    for(int j3 = 0; j3 < size; j3++)
                    {
                        if(inImage(j1, j3 + j))
                        {
                            frame[j1][j3 + j] = ai[j3];
                        }
                    }

                }

            }
        }
    }

    protected void flipFrame(boolean flag, boolean flag1)
    {
        if(flag)
        {
            for(int k = 0; k < size / 2; k++)
            {
                for(int i1 = 0; i1 < size; i1++)
                {
                    int i = frame[k][i1];
                    frame[k][i1] = frame[size - 1 - k][i1];
                    frame[size - 1 - k][i1] = i;
                }

            }

        }
        if(flag1)
        {
            for(int l = 0; l < size / 2; l++)
            {
                for(int j1 = 0; j1 < size; j1++)
                {
                    int j = frame[j1][l];
                    frame[j1][l] = frame[j1][size - 1 - l];
                    frame[j1][size - 1 - l] = j;
                }

            }

        }
    }

    public static Color add(Color color, Color color1)
    {
        float f = (float)color1.getAlpha() / 255F;
        int i = color.getRed();
        i = (int)((float)i + (float)color1.getRed() * f);
        i = Math.min(i, 255);
        int j = color.getGreen();
        j = (int)((float)j + (float)color1.getGreen() * f);
        j = Math.min(j, 255);
        int k = color.getBlue();
        k = (int)((float)k + (float)color1.getBlue() * f);
        k = Math.min(k, 255);
        int l = color.getAlpha();
        return new Color(i, j, k, l);
    }

    public static Color subtract(Color color, Color color1)
    {
        float f = (float)color1.getAlpha() / 255F;
        int i = color.getRed();
        i = (int)((float)i - (float)color1.getRed() * f);
        i = Math.max(i, 0);
        int j = color.getGreen();
        j = (int)((float)j - (float)color1.getGreen() * f);
        j = Math.max(j, 0);
        int k = color.getBlue();
        k = (int)((float)k - (float)color1.getBlue() * f);
        k = Math.max(k, 0);
        int l = color.getAlpha();
        return new Color(i, j, k, l);
    }

    public static Color merge(Color color, Color color1, float f)
    {
        f = Math.min(Math.max(f, 0.0F), 1.0F);
        float f1 = (float)color.getRed() - ((float)color.getRed() - (float)color1.getRed()) * f;
        float f2 = (float)color.getGreen() - ((float)color.getGreen() - (float)color1.getGreen()) * f;
        float f3 = (float)color.getBlue() - ((float)color.getBlue() - (float)color1.getBlue()) * f;
        float f4 = (float)color.getAlpha() - ((float)color.getAlpha() - (float)color1.getAlpha()) * f;
        return new Color(f1 / 255F, f2 / 255F, f3 / 255F, f4 / 255F);
    }

    public static Color blend(Color color, Color color1)
    {
        float f = ((float)color.getRed() / 255F) * ((float)color1.getRed() / 255F);
        float f1 = ((float)color.getGreen() / 255F) * ((float)color1.getGreen() / 255F);
        float f2 = ((float)color.getBlue() / 255F) * ((float)color1.getBlue() / 255F);
        float f3 = ((float)color.getAlpha() / 255F) * ((float)color1.getAlpha() / 255F);
        return new Color(f, f1, f2, f3);
    }

    protected int fileBuf[][];
    protected int frame[][];
    protected int size;
    public Mode mdSet;
    public Mode mdAdd;
    public Mode mdSubtract;
    public Mode mdBlend;

}
