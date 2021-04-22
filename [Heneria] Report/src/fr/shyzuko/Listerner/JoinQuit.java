package fr.shyzuko.Listerner;

import fr.shyzuko.ReportManager;
import fr.shyzuko.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JoinQuit implements Listener {
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // message de join
        e.setJoinMessage("§e[§2+§e] §6" + p.getName() + " §eest de retour en ville");

        // téleportation au hub
        Location aéroports = new Location(p.getWorld(), 444.119, 104.00000, 459.907, 91.2f, 1.7f);
        p.teleport(aéroports);

        if (!(p.hasPlayedBefore())) {
            Inventory tuto = Bukkit.createInventory(null, 8, "§3Heneria &8» &bTuto");

            tuto.setItem(4, new ItemBuilder(Material.PAPER).setName("Est que vous voulaient un tuto ??").toItemStack());

            p.openInventory(tuto);

        }
    }
    @EventHandler
    public void invclick(InventoryClickEvent e) {
        if (e.getCurrentItem() != null) {
            Player p = (Player)e.getWhoClicked();
            switch(e.getCurrentItem().getType()) {
                case PAPER:
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3Heneria &8» &bTuto")) {
                        Inventory Tuto = Bukkit.createInventory(null, 8, "§a§lValidation");

                        Tuto.setItem(3, new ItemBuilder(Material.SLIME_BALL).setName("§a§lOui !").toItemStack());
                        Tuto.setItem(5, new ItemBuilder(Material.RED_SANDSTONE).setName("§4§lNon !").toItemStack());

                        p.openInventory(Tuto);
                        break;
                }
                case SLIME_BALL:
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lOui !")) {
                        p.closeInventory();
                        p.sendMessage("                     §3§lHene§b§lria                       ");
                        p.sendMessage(" ");
                        p.sendMessage("§71) §6§lVous devez aller faire votre carte d'identités");
                        p.sendMessage("§72) §6§lUne fois faite allait acheter un téléphone");
                        p.sendMessage("§73) §6§lpuis acheter à manger ");
                        p.sendMessage("§74) §6§lRegarder votre Gps pour aller faire votre carte bancaire etc.");
                        p.sendMessage("§75) &6§lJe vous laisse vous amuser");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        break;
                    }
                case RED_SANDSTONE:
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4§lNon !")) {
                        p.sendMessage(ReportManager.getInstance().getPrefix() + "§cVous avez refusé si vous changez d'avis §7/tuto ");
                        break;
                    }
                default: break;

            }
        }
    }
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        // message de Quit
        e.setQuitMessage("§e[§4-§e] §6" + p.getName() + "§eà quitter la ville");
    }
}
