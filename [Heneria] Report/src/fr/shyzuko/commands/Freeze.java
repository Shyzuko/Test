package fr.shyzuko.commands;

import fr.shyzuko.ReportManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Freeze implements CommandExecutor, Listener {
    public ArrayList<Player> frozen = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("freeze")) {
            Player p = (Player) sender;
            if (p.hasPermission("staff")) {
                if (args.length == 0) {
                    p.sendMessage(ReportManager.getInstance().getPrefix() + " §cVous devez mettre un argument !");
                    return false;
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == p) {
                        p.sendMessage(ReportManager.getInstance().getPrefix() + " §cVous ne pouvez pas vous freeze vous même ");
                        return false;
                    } else if (target == null) {
                        p.sendMessage(ReportManager.getInstance().getPrefix() + " §cLe joueur que vous avez siter n'est pas connécté ou n'éxiste pas");
                        return false;
                    } else {
                        if (frozen.contains(target)) {
                            frozen.remove(target);
                            target.sendMessage(ReportManager.getInstance().getPrefix() + " §eVous avez été unfreeze par §a§l" + p.getName());
                            p.sendMessage(ReportManager.getInstance().getPrefix() + " §eVous avez bien unfreeze par §a§l" + target.getName());
                        } else {
                            target.sendMessage(ReportManager.getInstance().getPrefix() + " §3§lVous avez été freeze par §a§l" + p.getName());
                            frozen.add(target);
                            p.sendMessage(ReportManager.getInstance().getPrefix() + " §e§lVous avez bien freeze §a§l" + target.getName());
                        }
                    }

                }
            }
        }

        return false;
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if(frozen.contains(player)) {
            e.setCancelled(true);
            player.sendMessage(ReportManager.getInstance().getPrefix() + "§cVous êtes actuellement freeze");
        }
    }
}
