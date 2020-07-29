package me.TheJokerDev.XTroll.utils;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.events.PlayerEvents;
import me.TheJokerDev.XTroll.inventories.AllInOne;
import me.TheJokerDev.XTroll.inventories.Morphs;
import me.TheJokerDev.XTroll.inventories.Selector;
import me.TheJokerDev.XTroll.inventories.categories.Categories;
import me.TheJokerDev.XTroll.language.LBase;
import org.bukkit.*;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import xyz.theprogramsrc.supercoreapi.global.utils.Utils;
import xyz.theprogramsrc.supercoreapi.spigot.dialog.Dialog;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("all")
public class TrollItems {
    public static GUIButton BedrockCageItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.BEDROCK)
                .setDisplayName("&aBedrock Cage")
                .setLore("&cWARNING: Destroys block in protected locations!");
        Player t = Main.target.get(p);
        boolean b = SettingsManager.getRegeneratonBoolean();
        int delay = Main.i.getSettingsStorage().getConfig().getInt("regenerationblocks.delay");
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            List<IBlock> bedrockRegen = new ArrayList<>();
            Location loc = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ());
            bedrockRegen.add(new IBlock(loc.getBlock()));
            Location te = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ());
            bedrockRegen.add(new IBlock(te.getBlock()));
            Location t2 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(t2.getBlock()));
            Location blocksloc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(blocksloc.getBlock()));
            Location unten = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(unten.getBlock()));
            Location t5 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(t5.getBlock()));
            Location tl6 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl6.getBlock()));
            Location tl7 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY(), t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl7.getBlock()));
            Location tl8 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl8.getBlock()));
            Location tl19 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl19.getBlock()));
            Location tl20 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl20.getBlock()));
            Location tl21 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl21.getBlock()));
            Location tl22 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl22.getBlock()));
            Location tl23 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl23.getBlock()));
            Location tl24 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl24.getBlock()));
            Location tl25 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl25.getBlock()));
            Location tl26 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl26.getBlock()));
            Location tl27 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 2.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl27.getBlock()));
            Location tl28 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl28.getBlock()));
            Location tl29 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl29.getBlock()));
            Location tl30 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 3.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl30.getBlock()));
            Location tl31 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() - 1.0);
            bedrockRegen.add(new IBlock(tl31.getBlock()));
            Location tl32 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ() + 1.0);
            bedrockRegen.add(new IBlock(tl32.getBlock()));
            Location tl33 = new Location(t.getWorld(), t.getLocation().getX() - 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl33.getBlock()));
            Location tl34 = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY() + 1.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl34.getBlock()));
            Location tl35 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl35.getBlock()));
            Location tl36 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 1.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl36.getBlock()));
            Location tl37 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() + 2.0, t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl37.getBlock()));
            Location tl38 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ());
            bedrockRegen.add(new IBlock(tl38.getBlock()));
            p.closeInventory();
            Material bedrock = XMaterial.BEDROCK.parseMaterial();
            Material ironfence = XMaterial.IRON_BARS.parseMaterial();
            t.getWorld().getBlockAt(loc).setType(bedrock);
            t.getWorld().getBlockAt(te).setType(bedrock);
            t.getWorld().getBlockAt(t2).setType(bedrock);
            t.getWorld().getBlockAt(blocksloc).setType(bedrock);
            t.getWorld().getBlockAt(unten).setType(bedrock);
            t.getWorld().getBlockAt(t5).setType(bedrock);
            t.getWorld().getBlockAt(tl6).setType(bedrock);
            t.getWorld().getBlockAt(tl7).setType(bedrock);
            t.getWorld().getBlockAt(tl8).setType(bedrock);
            t.getWorld().getBlockAt(tl19).setType(bedrock);
            t.getWorld().getBlockAt(tl20).setType(bedrock);
            t.getWorld().getBlockAt(tl21).setType(bedrock);
            t.getWorld().getBlockAt(tl22).setType(bedrock);
            t.getWorld().getBlockAt(tl23).setType(bedrock);
            t.getWorld().getBlockAt(tl24).setType(bedrock);
            t.getWorld().getBlockAt(tl25).setType(bedrock);
            t.getWorld().getBlockAt(tl26).setType(bedrock);
            t.getWorld().getBlockAt(tl27).setType(bedrock);
            t.getWorld().getBlockAt(tl28).setType(bedrock);
            t.getWorld().getBlockAt(tl29).setType(bedrock);
            t.getWorld().getBlockAt(tl30).setType(bedrock);
            t.getWorld().getBlockAt(tl31).setType(ironfence);
            t.getWorld().getBlockAt(tl32).setType(ironfence);
            t.getWorld().getBlockAt(tl33).setType(ironfence);
            t.getWorld().getBlockAt(tl34).setType(ironfence);
            t.getWorld().getBlockAt(tl35).setType(bedrock);
            t.getWorld().getBlockAt(tl36).setType(Material.AIR);
            t.getWorld().getBlockAt(tl37).setType(Material.AIR);
            t.getWorld().getBlockAt(tl38).setType(Material.AIR);
            t.setGameMode(GameMode.SURVIVAL);
            if (b) {
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.i, () -> {
                    for (IBlock b1 : bedrockRegen)
                        t.getWorld().getBlockAt(b1.getLoc()).setType(b1.getType());
                }, 20L * delay);
            } else {
                bedrockRegen.clear();
            }
        });
    }

    public static GUIButton BurnPlayerItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.FLINT_AND_STEEL)
                .setDisplayName("&aBurn Player")
                .setLore("");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            t.setFireTicks(5000);
            p.closeInventory();
        });
    }

    public static GUIButton chargedCreepersItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.CREEPER_HEAD)
                .setDisplayName("&aCharged Creepers")
                .setLore("&cWARNING: Destroys block in protected locations!");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            Location te = new Location(t.getWorld(), t.getLocation().getX() + 1.0, t.getLocation().getY(), t.getLocation().getZ());
            Location t2 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ());
            Location blocksloc = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
            Location unten = new Location(t.getWorld(), t.getLocation().getX() + 2.0, t.getLocation().getY(), t.getLocation().getZ() - 1.0);
            Location t5 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ() + 1.0);
            CCreeper(te.add(0.5, 1.0, 0.5));
            CCreeper(t2.add(0.5, 1.0, 0.5));
            CCreeper(blocksloc.add(0.5, 1.0, 0.5));
            CCreeper(unten.add(0.5, 1.0, 0.5));
            CCreeper(t5.add(0.5, 1.0, 0.5));
        });
    }

    public static GUIButton controlPlayerItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromMojang("Troll"))
                .setDisplayName("&aControl Player")
                .setLore("&7Status: %control-status%");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            if (t == p) {
                p.sendMessage(Main.prefix + LBase.Messages_anotherPlayer.toString());
                return;
            }
            if (!TrollArrays.controlPlayerTroll.contains(t.getName())) {
                TrollArrays.controlPlayerTroll.add(t.getName());
                Main.i.startControlling(t, p);
                p.sendMessage(Main.prefix + Utils.ct(LBase.Messages_controlPlayerActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                TrollArrays.controlPlayerTroll.remove(t.getName());
                Main.i.stopControlling(t, p);
                p.sendMessage(Main.prefix + Utils.ct(LBase.Messages_controlPlayerDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }

    public static GUIButton demostrationItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.NAME_TAG)
                .setDisplayName("&aDemostration Troll")
                .setLore("");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            Player enviar = t;
            String path = Bukkit.getServer().getClass().getPackage().getName();
            String version = path.substring(path.lastIndexOf(".") + 1);
            try {
                Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(Integer.TYPE, Float.TYPE);
                Object packet = playOutConstructor.newInstance(5, 0);
                Object craftPlayerObject = craftPlayer.cast(enviar);
                Method getHandleMethod = craftPlayer.getMethod("getHandle");
                Object handle = getHandleMethod.invoke(craftPlayerObject);
                Object pc = handle.getClass().getField("playerConnection").get(handle);
                Method sendPacketMethod = pc.getClass().getMethod("sendPacket", Packet);
                sendPacketMethod.invoke(pc, packet);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static GUIButton dropInventoryItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.FISHING_ROD)
                .setDisplayName("&aDrop Player Inventory")
                .setLore("");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            for (ItemStack emerald1 : t.getInventory().getContents()) {
                if (emerald1 == null) continue;
                t.getWorld().dropItemNaturally(t.getLocation(), emerald1);
                t.getInventory().remove(emerald1);
            }
            for (ItemStack emerald3 : t.getInventory().getArmorContents()) {
                if (emerald3 == null) continue;
                t.getWorld().dropItemNaturally(t.getLocation(), emerald3);
                t.getInventory().setArmorContents(null);
            }
        });
    }

    public static GUIButton extremeTrollItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.BEACON)
                .setDisplayName("&aExtremeTroll")
                .setLore("");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            for (int x = 0; x <= 1000; ++x) {
                String message = Utils.ct("&a&kAISDIQOIWJDOAISJDOIAJSDOIAJOSDI9823U10283U109J");
                t.sendMessage(message);
                t.sendMessage(message);
                t.sendMessage(message);
                t.sendMessage(message);
                t.sendMessage(message);
            }
            t.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3000, 1000));
            t.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3000, 1000));
            t.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 3000, 1000));
            t.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3000, 1000));
        });
    }

    public static GUIButton explosiveWandItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.STICK)
                .setDisplayName("&aExplosiveWand")
                .setLore("");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            t.getInventory().addItem(getExplosiveWand());
        });
    }

    public static GUIButton facepalmItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setDisplayName("&aFacePalm")
                .setLore("&7Status: %facepalm-status%");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            if (!TrollArrays.FacepalmTroll.contains(t.getName())) {
                TrollArrays.FacepalmTroll.add(t.getName());
                t.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 100));
                p.sendMessage(Main.prefix + Utils.ct(LBase.Messages_FacepalmActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                TrollArrays.FacepalmTroll.remove(t.getName());
                if (t.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    t.removePotionEffect(PotionEffectType.BLINDNESS);
                }
                p.sendMessage(Main.prefix + Utils.ct(LBase.Messages_FacepalmDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }

    public static GUIButton fakeBanItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.BARRIER)
                .setDisplayName("&aFake ban");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            t.kickPlayer(Utils.ct(SettingsManager.getSettings().getString("Trolls.KickMessage")));
        });
    }

    public static GUIButton fakeOPItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.WOODEN_AXE)
                .setDisplayName("&aFake OP");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            t.sendMessage(Utils.ct(SettingsManager.getSettings().getString("Trolls.FakeOPMessage").replaceAll("%target%", t.getName())));
        });
    }

    public static GUIButton fillInventoryItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.DIRT)
                .setDisplayName("&aFill Inventory");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            new Dialog(Main.i, a.getPlayer()) {

                @Override
                public String getTitle() {
                    return "&3Fill Inventory";
                }

                @Override
                public String getSubtitle() {
                    return "&7Write the item below";
                }

                @Override
                public String getActionbar() {
                    return null;
                }

                @Override
                public boolean onResult(String playerInput) {
                    ItemStack fillInv = new ItemStack(Material.valueOf(playerInput.toUpperCase()), 2304);
                    t.getInventory().addItem(fillInv);
                    return true;
                }
            };
        });
    }

    public static GUIButton flyCarpetItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.WHITE_CARPET)
                .setDisplayName("&aFly carpet");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            FallingBlock b;
            FallingBlock b8;
            FallingBlock b7;
            FallingBlock b6;
            FallingBlock b5;
            FallingBlock b3;
            FallingBlock b2;
            FallingBlock b4;
            FallingBlock b1;
            Location l = t.getLocation().add(0, +5, 0);
            t.teleport(l);
            if (!Bukkit.getVersion().contains("1.13") && !Bukkit.getVersion().contains("1.13.1")) {
                b = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b1 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b2 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b3 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b4 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b5 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b6 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b7 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b8 = t.getWorld().spawnFallingBlock(t.getLocation(), XMaterial.WHITE_CARPET.parseMaterial(), (byte) 0);
                b.setPassenger(t);
                new BukkitRunnable() {

                    public void run() {
                        Location l = t.getLocation();
                        Vector pv = l.getDirection();
                        b1.teleport(b.getLocation().add(0.0, 0.0, -1.0));
                        b2.teleport(b.getLocation().add(0.0, 0.0, 1.0));
                        b3.teleport(b.getLocation().add(-1.0, 0.0, 0.0));
                        b4.teleport(b.getLocation().add(-1.0, 0.0, -1.0));
                        b5.teleport(b.getLocation().add(-1.0, 0.0, 1.0));
                        b6.teleport(b.getLocation().add(-2.0, 0.0, 0.0));
                        b7.teleport(b.getLocation().add(-2.0, 0.0, -1.0));
                        b8.teleport(b.getLocation().add(-2.0, 0.0, 1.0));
                        b1.setVelocity(pv);
                        b2.setVelocity(pv);
                        b3.setVelocity(pv);
                        b4.setVelocity(pv);
                        b5.setVelocity(pv);
                        b6.setVelocity(pv);
                        b7.setVelocity(pv);
                        b8.setVelocity(pv);
                        b.setVelocity(pv);
                        if (b.getPassenger() == null) {
                            b.remove();
                            b1.remove();
                            b2.remove();
                            b3.remove();
                            b4.remove();
                            b5.remove();
                            b6.remove();
                            b7.remove();
                            b8.remove();
                            this.cancel();
                        } else if (!b.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) || !b1.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) ||
                                !b2.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) || !b3.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) ||
                                !b4.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) || !b5.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) ||
                                !b6.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) || !b7.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR) ||
                                !b8.getLocation().add(0, -2, 0).getBlock().getType().equals(Material.AIR)) {

                            b.remove();
                            b1.remove();
                            b2.remove();
                            b3.remove();
                            b4.remove();
                            b5.remove();
                            b6.remove();
                            b7.remove();
                            b8.remove();
                            this.cancel();
                        } else if (t.isOnline()) {
                            b.remove();
                            b1.remove();
                            b2.remove();
                            b3.remove();
                            b4.remove();
                            b5.remove();
                            b6.remove();
                            b7.remove();
                            b8.remove();
                            this.cancel();
                        } else {
                            if (b.getPassenger() == null) {
                                this.cancel();
                            }
                        }
                    }
                }.runTaskTimer(Main.i, 0L, 1L);
            }
        });
    }
    public static GUIButton FreezePlayerItem(Integer i, Player p){
        SimpleItem item = new SimpleItem(XMaterial.ICE)
                .setDisplayName("&aFreeze Player")
                .setLore("&7Status: %freeze-status%");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a-> {
            if(!TrollArrays.FreezeTroll.contains(t.getName())){
                TrollArrays.FreezeTroll.add(t.getName());
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_FreezeActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                TrollArrays.FreezeTroll.remove(t.getName());
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_FreezeDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }
    public static GUIButton FreezeAllPlayerItem(Integer i, Player p){
        SimpleItem item = new SimpleItem(XMaterial.ICE)
                .setDisplayName("&aFreeze All Players")
                .setAmount(10)
                .setLore("&7Status: %freezeall-status%");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a-> {
            if (GeneralUtils.getOnlinePlayers(p).size() == 0){
                p.sendMessage(LBase.Messages_anotherAllPlayer.toString());
                return;
            }
            if(!TrollArrays.FreezeAllTroll.contains(t.getName())){
                for (Player all : GeneralUtils.getOnlinePlayers(p)){
                    TrollArrays.FreezeAllTroll.add(all.getName());
                }
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_FreezeAllActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                for (Player all : GeneralUtils.getOnlinePlayers(p)){
                    TrollArrays.FreezeAllTroll.remove(all.getName());
                }
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_FreezeAllDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }
    public static GUIButton HidePlayerItem(Integer i, Player p){
        SimpleItem item = new SimpleItem(XMaterial.REDSTONE_TORCH)
                .setDisplayName("&aHide Player")
                .setLore("&7Status: %hideplayer-status%");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a-> {
            if(!TrollArrays.HidePlayer.contains(t.getName())){
                TrollArrays.HidePlayer.add(t.getName());
                Bukkit.getOnlinePlayers().forEach(t::hidePlayer);
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_hidePlayerActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                TrollArrays.HidePlayer.remove(t.getName());
                Bukkit.getOnlinePlayers().forEach(t::showPlayer);
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_hidePlayerDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }
    public static GUIButton InfiniteInventoryItem(Integer i, Player p){
        SimpleItem item = new SimpleItem(XMaterial.LEVER)
                .setDisplayName("&aInfinite Inventory")
                .setLore("&7Status: %infiniteinv-status%");
        Player t = Main.target.get(p);
        int infiniteinv;
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a-> {
            if(!TrollArrays.infiniteInventoryTroll.contains(t.getName())) {
                TrollArrays.infiniteInventoryTroll.add(t.getName());
                Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.i, () -> {
                    ArrayList<InventoryType> invList = new ArrayList<>();
                    invList.add(InventoryType.ANVIL);
                    invList.add(InventoryType.BEACON);
                    invList.add(InventoryType.BREWING);
                    invList.add(InventoryType.CHEST);
                    invList.add(InventoryType.DISPENSER);
                    invList.add(InventoryType.DROPPER);
                    invList.add(InventoryType.ENCHANTING);
                    invList.add(InventoryType.ENDER_CHEST);
                    invList.add(InventoryType.FURNACE);
                    invList.add(InventoryType.HOPPER);
                    invList.add(InventoryType.MERCHANT);
                    invList.add(InventoryType.WORKBENCH);
                    int index = ThreadLocalRandom.current().nextInt(invList.size());
                    InventoryType desiredInv = invList.get(index);
                    t.openInventory(Bukkit.createInventory(t, desiredInv, org.bukkit.ChatColor.translateAlternateColorCodes('&', "&4&l&n<Error>")));
                }, 0L, 5L);
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_infiniteInvActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                TrollArrays.infiniteInventoryTroll.remove(t.getName());
                Bukkit.getScheduler().cancelTask(1);
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_infiniteInvDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }
    public static GUIButton fakeLagItem(Integer i, Player p){
        SimpleItem item = new SimpleItem(XMaterial.COAL)
                .setDisplayName("&aFake Lag")
                .setLore("&7Status: %fakelag-status%");
        Player t = Main.target.get(p);
        int infiniteinv;
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a-> {
            if(!TrollArrays.fakeLagTroll.contains(t.getName())) {
                TrollArrays.fakeLagTroll.add(t.getName());
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_fakeLagActivated.options().placeholder("{target}", t.getName()).toString()));
            } else {
                TrollArrays.fakeLagTroll.remove(t.getName());
                p.sendMessage(Main.prefix+ Utils.ct(LBase.Messages_fakeLagDeactivated.options().placeholder("{target}", t.getName()).toString()));
            }
        });
    }
    public static GUIButton launchPlayerItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.ARROW)
                .setDisplayName("&aLaunch Player");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            Vector launch = new Vector(0, 20, 0);
            t.setVelocity(launch);
        });
    }
    public static GUIButton launchPlayerInvertedItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.ARROW)
                .setAmount(2)
                .setDisplayName("&aLaunch Player (Inverted)");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            t.setGameMode(GameMode.SPECTATOR);
            Vector v = new Vector(0, -20, 0);
            for (int x = 0; x < 20; ++x) {
                t.setVelocity(v);
            }
            PlayerEvents plls= new PlayerEvents();
            plls.runSync(new Runnable() {
                public void run() {
                    t.setGameMode(GameMode.SURVIVAL);
                }
            }, 10);
        });
    }
    public static GUIButton lavaCageItem(Integer i, Player p) {
        SimpleItem item = new SimpleItem(XMaterial.LAVA_BUCKET)
                .setDisplayName("&aLava Cage");
        Player t = Main.target.get(p);
        boolean b = SettingsManager.getRegeneratonBoolean();
        int delay = Main.i.getSettingsStorage().getConfig().getInt("regenerationblocks.delay");
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            List<IBlock> littlelava = new ArrayList<>();
            Location tl = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0D, t.getLocation().getZ());
            Location tl1 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 1.0D);
            Location tl2 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 1.0D);
            Location tl3 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 1.0D);
            Location tl4 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 1.0D);
            Location tl5 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 1.0D);
            Location tl6 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 1.0D);
            Location tl7 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ());
            Location tl8 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ());
            Location tl19 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 2.0D, t.getLocation().getZ());
            Location tl20 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 2.0D, t.getLocation().getZ() + 1.0D);
            Location tl21 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 2.0D, t.getLocation().getZ() - 1.0D);
            Location tl13 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 2.0D, t.getLocation().getZ() + 1.0D);
            Location tl23 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 2.0D, t.getLocation().getZ() - 1.0D);
            Location tl24 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 2.0D, t.getLocation().getZ() + 1.0D);
            Location tl25 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 2.0D, t.getLocation().getZ() - 1.0D);
            Location tl26 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 2.0D, t.getLocation().getZ());
            Location tl27 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 2.0D, t.getLocation().getZ());
            Location tl28 = new Location(t.getWorld(), t.getLocation().getX() + 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 2.0D);
            Location tl29 = new Location(t.getWorld(), t.getLocation().getX() - 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 2.0D);
            Location tl30 = new Location(t.getWorld(), t.getLocation().getX() + 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 2.0D);
            Location tl31 = new Location(t.getWorld(), t.getLocation().getX() - 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 2.0D);
            Location tl32 = new Location(t.getWorld(), t.getLocation().getX() + 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ());
            Location tl33 = new Location(t.getWorld(), t.getLocation().getX() - 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ());
            Location tl34 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 2.0D);
            Location tl35 = new Location(t.getWorld(), t.getLocation().getX(), t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 2.0D);
            Location tl36 = new Location(t.getWorld(), t.getLocation().getX() + 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 1.0D);
            Location tl37 = new Location(t.getWorld(), t.getLocation().getX() - 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 1.0D);
            Location tl38 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 2.0D);
            Location tl39 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 2.0D);
            Location tl40 = new Location(t.getWorld(), t.getLocation().getX() + 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 2.0D);
            Location tl41 = new Location(t.getWorld(), t.getLocation().getX() - 1.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 2.0D);
            Location tl42 = new Location(t.getWorld(), t.getLocation().getX() - 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() + 1.0D);
            Location tl43 = new Location(t.getWorld(), t.getLocation().getX() + 2.0D, t.getLocation().getY() - 1.0D, t.getLocation().getZ() - 1.0D);
            littlelava.add(new IBlock(tl.getBlock()));
            littlelava.add(new IBlock(tl1.getBlock()));
            littlelava.add(new IBlock(tl2.getBlock()));
            littlelava.add(new IBlock(tl2.getBlock()));
            littlelava.add(new IBlock(tl3.getBlock()));
            littlelava.add(new IBlock(tl4.getBlock()));
            littlelava.add(new IBlock(tl5.getBlock()));
            littlelava.add(new IBlock(tl6.getBlock()));
            littlelava.add(new IBlock(tl7.getBlock()));
            littlelava.add(new IBlock(tl8.getBlock()));
            littlelava.add(new IBlock(tl19.getBlock()));
            littlelava.add(new IBlock(tl20.getBlock()));
            littlelava.add(new IBlock(tl21.getBlock()));
            littlelava.add(new IBlock(tl13.getBlock()));
            littlelava.add(new IBlock(tl23.getBlock()));
            littlelava.add(new IBlock(tl24.getBlock()));
            littlelava.add(new IBlock(tl25.getBlock()));
            littlelava.add(new IBlock(tl26.getBlock()));
            littlelava.add(new IBlock(tl27.getBlock()));
            littlelava.add(new IBlock(tl28.getBlock()));
            littlelava.add(new IBlock(tl29.getBlock()));
            littlelava.add(new IBlock(tl30.getBlock()));
            littlelava.add(new IBlock(tl31.getBlock()));
            littlelava.add(new IBlock(tl32.getBlock()));
            littlelava.add(new IBlock(tl33.getBlock()));
            littlelava.add(new IBlock(tl34.getBlock()));
            littlelava.add(new IBlock(tl35.getBlock()));
            littlelava.add(new IBlock(tl36.getBlock()));
            littlelava.add(new IBlock(tl37.getBlock()));
            littlelava.add(new IBlock(tl38.getBlock()));
            littlelava.add(new IBlock(tl39.getBlock()));
            littlelava.add(new IBlock(tl40.getBlock()));
            littlelava.add(new IBlock(tl41.getBlock()));
            littlelava.add(new IBlock(tl42.getBlock()));
            littlelava.add(new IBlock(tl43.getBlock()));
            World w = t.getWorld();
            Material lava = XMaterial.LAVA.parseMaterial();
            Material stone = XMaterial.STONE.parseMaterial();
            Material fence = XMaterial.STONE_BRICK_WALL.parseMaterial();
            t.getWorld().getBlockAt(tl).setType(lava);
            t.getWorld().getBlockAt(tl1).setType(lava);
            t.getWorld().getBlockAt(tl2).setType(lava);
            t.getWorld().getBlockAt(tl3).setType(lava);
            t.getWorld().getBlockAt(tl4).setType(lava);
            t.getWorld().getBlockAt(tl5).setType(lava);
            t.getWorld().getBlockAt(tl6).setType(lava);
            t.getWorld().getBlockAt(tl7).setType(lava);
            t.getWorld().getBlockAt(tl8).setType(lava);
            t.getWorld().getBlockAt(tl19).setType(stone);
            t.getWorld().getBlockAt(tl20).setType(stone);
            t.getWorld().getBlockAt(tl21).setType(stone);
            t.getWorld().getBlockAt(tl13).setType(stone);
            t.getWorld().getBlockAt(tl23).setType(stone);
            t.getWorld().getBlockAt(tl24).setType(stone);
            t.getWorld().getBlockAt(tl25).setType(stone);
            t.getWorld().getBlockAt(tl26).setType(stone);
            t.getWorld().getBlockAt(tl27).setType(stone);
            t.getWorld().getBlockAt(tl28).setType(fence);
            t.getWorld().getBlockAt(tl29).setType(fence);
            t.getWorld().getBlockAt(tl30).setType(fence);
            t.getWorld().getBlockAt(tl31).setType(fence);
            t.getWorld().getBlockAt(tl32).setType(fence);
            t.getWorld().getBlockAt(tl33).setType(fence);
            t.getWorld().getBlockAt(tl34).setType(fence);
            t.getWorld().getBlockAt(tl35).setType(fence);
            t.getWorld().getBlockAt(tl36).setType(fence);
            t.getWorld().getBlockAt(tl37).setType(fence);
            t.getWorld().getBlockAt(tl38).setType(fence);
            t.getWorld().getBlockAt(tl39).setType(fence);
            t.getWorld().getBlockAt(tl40).setType(fence);
            t.getWorld().getBlockAt(tl41).setType(fence);
            t.getWorld().getBlockAt(tl42).setType(fence);
            t.getWorld().getBlockAt(tl43).setType(fence);
            if (b){
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.i, () -> {
                    for (IBlock b1 : littlelava)
                        t.getWorld().getBlockAt(b1.getLoc()).setType(b1.getType());
                }, 20L * delay);
            } else {
                littlelava.clear();
            }
            t.setGameMode(GameMode.SURVIVAL);
        });
    }
    public static GUIButton getLevitationItem(Integer slot, Player p) {
        SimpleItem item = null;
        if (GeneralUtils.checkIfNewVersions()) {
            item = new SimpleItem(XMaterial.ELYTRA)
                    .setDisplayName("&aLevitation (7s)")
                    .setLore();
        } else {
            item = new SimpleItem(XMaterial.BARRIER)
                    .setDisplayName("&aLevitation (7s) &7| &cNEED 1.9+ VERSIONS!")
                    .setLore("&4This feature need more than 1.9 versions!")
                    .setGlowing(true);
        }
        Player t = Main.target.get(p);
        return new GUIButton(slot, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            if (!GeneralUtils.checkIfNewVersions()){
                p.sendMessage(LBase.Messages_VersionOutdated.options().placeholder("{version}", "1.9").toString());
                return;
            }
            t.addPotionEffect(new PotionEffect(PotionEffectType.getByName("LEVITATION"), 140, 2));
        });
    }
    public static GUIButton getLevitationAllItem(Integer slot, Player p) {
        SimpleItem item = null;
        if (GeneralUtils.checkIfNewVersions()) {
            item = new SimpleItem(XMaterial.ELYTRA)
                    .setDisplayName("&aLevitation for All (7s)")
                    .setLore();
        } else {
            item = new SimpleItem(XMaterial.BARRIER)
                    .setDisplayName("&aLevitation for All (7s) &7| &cNEED 1.9+ VERSIONS!")
                    .setLore("&4This feature need more than 1.9 versions!")
                    .setGlowing(true);
        }
        Player t = Main.target.get(p);
        return new GUIButton(slot, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            if (!GeneralUtils.checkIfNewVersions()){
                p.sendMessage(LBase.Messages_VersionOutdated.options().placeholder("{version}", "1.9").toString());
                return;
            }
            if (GeneralUtils.getOnlinePlayers(p).size() == 0){
                p.sendMessage(LBase.Messages_anotherAllPlayer.toString());
                return;
            }
            for (Player t2 : GeneralUtils.getOnlinePlayers(p)) {
                t2.addPotionEffect(new PotionEffect(PotionEffectType.getByName("LEVITATION"), 140, 2));
            }
        });
    }
    public static GUIButton getMatrixItem(Integer slot, Player p) {
        SimpleItem item = item = new SimpleItem(XMaterial.END_PORTAL_FRAME)
                    .setDisplayName("&aMatrix Troll")
                    .setLore();
        Player t = Main.target.get(p);
        return new GUIButton(slot, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            t.kickPlayer("§a§kFAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_FAKE_");
        });
    }
    public static GUIButton getMorphsItem(Integer slot, Player p) {
        SimpleItem item = item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setDisplayName("&aMorphs Menu")
                .setLore();
        Player t = Main.target.get(p);
        return new GUIButton(slot, PlaceHolders.setPlaceHolders(item, t), a -> {
            p.closeInventory();
            new Morphs(p);
        });
    }
    public static GUIButton getBackItem(Integer slot, Integer i2){
        GUIButton returnitem = null;
        if (i2 == 0){
            returnitem =new GUIButton(slot, Main.i.getPreloadedItems().getBackItem(), a-> {
                new Selector(a.getPlayer());
            });
        }
        if (i2 == 1){
            returnitem =new GUIButton(slot, Main.i.getPreloadedItems().getBackItem(), a-> {
                if (SettingsManager.checkUserSettings(a.getPlayer())){
                    if (SettingsManager.getGUIMode(a.getPlayer()).equals("categories")){
                        new Categories(Main.i, a.getPlayer());
                        return;
                    }
                    if (SettingsManager.getGUIMode(a.getPlayer()).equals("allinone")){
                        new AllInOne(Main.i, a.getPlayer());
                    }
                }
            });
        }
        return returnitem;
    }
    private static void CCreeper(Location loc) {
        Creeper creeper = loc.getWorld().spawn(loc, Creeper.class);
        creeper.setPowered(true);
    }
    public static ItemStack getExplosiveWand(){
        SimpleItem item = new SimpleItem(XMaterial.STICK)
                .setDisplayName("&aExplosive Wand")
                .setLore("&7To use, only right click and",
                        "&7thats all!");
        return item.build();
    }
}
