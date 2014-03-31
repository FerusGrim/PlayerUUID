package io.github.ferusgrim.PlayerUUID;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mojang.api.profiles.HttpProfileRepository;
import com.mojang.api.profiles.Profile;
import com.mojang.api.profiles.ProfileCriteria;

public class UUIDManager {

	public static boolean getUUID(String[] usernames, CommandSender sender) {
		String uuid;
		String username;
		final HttpProfileRepository repository = new HttpProfileRepository();
		int i=0;
		while(usernames.length > i){
			username = usernames[i];
			Profile[] profiles = repository.findProfilesByCriteria(new ProfileCriteria(username, "minecraft"));
			if(!(profiles.length >= 1)){
				sender.sendMessage("Username doesn't exist!");
				profiles = null;
				return true;
			}
			uuid = profiles[0].getId();
			profiles = null;
			sender.sendMessage("UUID for " + username + ":");
			sender.sendMessage("(" + uuid + ")");
			i++;
		}
		return true;
	}
	
	public static boolean getOwnUUID(String username, CommandSender sender){
		String uuid;
		Player player = (Player) sender;
		uuid = player.getUniqueId().toString().replace("-", "");
		sender.sendMessage("UUID for " + username + ":");
		sender.sendMessage("(" + uuid + ")");
		return true;
	}
}
