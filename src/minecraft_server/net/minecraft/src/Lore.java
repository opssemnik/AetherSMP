// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, Block, Item

public class Lore
{

    public Lore(ItemStack itemstack, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, int i)
    {
        stack = itemstack;
        name = s;
        line1 = s1;
        line2 = s2;
        line3 = s3;
        line4 = s4;
        line5 = s5;
        line6 = s6;
        type = i;
    }

    public Lore(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, int j)
    {
        this(new ItemStack(i, 1, -1), s, s1, s2, s3, s4, s5, s6, j);
    }

    public Lore(Block block, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, int i)
    {
        this(new ItemStack(block, 1, -1), s, s1, s2, s3, s4, s5, s6, i);
    }

    public Lore(Item item, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, int i)
    {
        this(new ItemStack(item, 1, -1), s, s1, s2, s3, s4, s5, s6, i);
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return stack == null;
        }
        if(obj instanceof Lore)
        {
            return ((Lore)obj).stack.itemID == stack.itemID && (((Lore)obj).stack.getItemDamage() == stack.getItemDamage() || stack.getItemDamage() == -1);
        }
        if(obj instanceof ItemStack)
        {
            return ((ItemStack)obj).itemID == stack.itemID && (((ItemStack)obj).getItemDamage() == stack.getItemDamage() || stack.getItemDamage() == -1);
        } else
        {
            return false;
        }
    }

    public ItemStack stack;
    public String name;
    public String line1;
    public String line2;
    public String line3;
    public String line4;
    public String line5;
    public String line6;
    public int type;
}
