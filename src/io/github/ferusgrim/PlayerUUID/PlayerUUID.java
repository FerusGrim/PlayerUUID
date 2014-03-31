package io.github.ferusgrim.PlayerUUID;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerUUID extends JavaPlugin {
	
	@Override
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(), this);
		getCommand("uuid").setExecutor(new Executor());
	}
}
