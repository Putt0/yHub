package free.git.hub.yh.tabmanager;

import org.bukkit.entity.*;

import free.git.hub.yh.HubMain;

import org.bukkit.*;
import java.lang.reflect.*;

public class TabList {
	
    public static Class<?> getNmsClass(final String nmsClassName) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);
    }
    
    public static String getServerVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().substring(23);
    }
    
    public static void sendTablist(final Player p, String msg, String msg2, final HubMain plugin, final boolean colors) {
        if (colors) {
        	msg = "";
        	msg2 = "";
        }
        try {
            if (getServerVersion().equalsIgnoreCase("v1_12_R1")) {
                final Object header = getNmsClass("ChatComponentText").getConstructor(String.class).newInstance(ChatColor.translateAlternateColorCodes('&', msg));
                final Object footer = getNmsClass("ChatComponentText").getConstructor(String.class).newInstance(ChatColor.translateAlternateColorCodes('&', msg2));
                final Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
                final Field fa = ppoplhf.getClass().getDeclaredField("a");
                fa.setAccessible(true);
                fa.set(ppoplhf, header);
                final Field fb = ppoplhf.getClass().getDeclaredField("b");
                fb.setAccessible(true);
                fb.set(ppoplhf, footer);
                final Object nmsp = p.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(p, new Object[0]);
                final Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);
                pcon.getClass().getMethod("sendPacket", getNmsClass("Packet")).invoke(pcon, ppoplhf);
            }
            else if (getServerVersion().equalsIgnoreCase("v1_9_R1") || getServerVersion().equalsIgnoreCase("v1_9_R2") || getServerVersion().equalsIgnoreCase("v1_10_R1") || getServerVersion().equalsIgnoreCase("v1_11_R1") || getServerVersion().equalsIgnoreCase("v1_12_R1")) {
                final Object header = getNmsClass("ChatComponentText").getConstructor(String.class).newInstance(ChatColor.translateAlternateColorCodes('&', msg));
                final Object footer = getNmsClass("ChatComponentText").getConstructor(String.class).newInstance(ChatColor.translateAlternateColorCodes('&', msg2));
                final Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(getNmsClass("IChatBaseComponent")).newInstance(header);
                final Field f = ppoplhf.getClass().getDeclaredField("b");
                f.setAccessible(true);
                f.set(ppoplhf, footer);
                final Object nmsp2 = p.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(p, new Object[0]);
                final Object pcon2 = nmsp2.getClass().getField("playerConnection").get(nmsp2);
                pcon2.getClass().getMethod("sendPacket", getNmsClass("Packet")).invoke(pcon2, ppoplhf);
            }
            else if (getServerVersion().equalsIgnoreCase("v1_8_R2") || getServerVersion().equalsIgnoreCase("v1_8_R3")) {
                final Object header = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", String.class).invoke(null, "{'text': '" + msg + "'}");
                final Object footer = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", String.class).invoke(null, "{'text': '" + msg2 + "'}");
                final Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(getNmsClass("IChatBaseComponent")).newInstance(header);
                final Field f = ppoplhf.getClass().getDeclaredField("b");
                f.setAccessible(true);
                f.set(ppoplhf, footer);
                final Object nmsp2 = p.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(p, new Object[0]);
                final Object pcon2 = nmsp2.getClass().getField("playerConnection").get(nmsp2);
                pcon2.getClass().getMethod("sendPacket", getNmsClass("Packet")).invoke(pcon2, ppoplhf);
            }
            else {
                final Object header = getNmsClass("ChatSerializer").getMethod("a", String.class).invoke(null, "{'text': '" + msg + "'}");
                final Object footer = getNmsClass("ChatSerializer").getMethod("a", String.class).invoke(null, "{'text': '" + msg2 + "'}");
                final Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(getNmsClass("IChatBaseComponent")).newInstance(header);
                final Field f = ppoplhf.getClass().getDeclaredField("b");
                f.setAccessible(true);
                f.set(ppoplhf, footer);
                final Object nmsp2 = p.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(p, new Object[0]);
                final Object pcon2 = nmsp2.getClass().getField("playerConnection").get(nmsp2);
                pcon2.getClass().getMethod("sendPacket", getNmsClass("Packet")).invoke(pcon2, ppoplhf);
            }
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException ex2) {
            final Exception ex = null;
            System.out.println(ex);
        }
    }
}

