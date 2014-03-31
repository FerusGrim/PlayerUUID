package io.github.ferusgrim.PlayerUUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Executor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { 
		Player player = null;
		boolean hasPerm = false;
		if(!(sender instanceof Player)) hasPerm = true; else{
			player = (Player) sender;
			if(player.hasPermission("playeruuid")) hasPerm = true; else hasPerm = false;
		}
		if(!hasPerm){
			sender.sendMessage("No permissions!");
			return true;
		}
		String username;
		if(args.length < 1){
			username = sender.getName().toLowerCase();
			return UUIDManager.getOwnUUID(username, sender);
		}
		username = args[0].toLowerCase();
		if(username.equals(sender.getName().toLowerCase())){
			return UUIDManager.getOwnUUID(username, sender);
		}
		return UUIDManager.getUUID(args, sender);
	}

}
