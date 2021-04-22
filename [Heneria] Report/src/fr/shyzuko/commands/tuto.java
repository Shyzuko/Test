package fr.shyzuko.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tuto implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("tuto")){
            Player p = (Player)sender;
            p.sendMessage("                     §3§lHene§b§lria                       ");
            p.sendMessage(" ");
            p.sendMessage("§71) §6Vous devez aller faire votre carte d'identités");
            p.sendMessage("§72) §6Une fois faite allait acheter un téléphone");
            p.sendMessage("§73) §6puis acheter à manger ");
            p.sendMessage("§74) §6Regarder votre Gps pour aller faire votre carte bancaire etc.");
            p.sendMessage("§75) §6Je vous laisse vous amuser");
            p.sendMessage(" ");
            p.sendMessage(" ");
        }
        return false;
    }
}
