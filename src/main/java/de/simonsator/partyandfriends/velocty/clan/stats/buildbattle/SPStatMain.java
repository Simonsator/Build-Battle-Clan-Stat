package de.simonsator.partyandfriends.velocty.clan.stats.buildbattle;

import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.clan.commands.ClanCommands;
import de.simonsator.partyandfriends.velocity.clan.commands.subcommands.Stats;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;
import de.simonsator.partyandfriends.velocity.utilities.Language;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class SPStatMain extends PAFExtension {
	private ConfigurationCreator config;

	public SPStatMain(Path folder) {
		super(folder);
	}

	public void onEnable() {
		ConfigurationCreator messagesConfig = null;
		try {
			this.config = new SPConfig(new File(getDataFolder(), "config.yml"), this);
			messagesConfig = new SPMessages(Language.OWN, new File(getDataFolder(), "messages.yml"), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SPConnection connection = new SPConnection(this.config.getString("database.db"), "jdbc:mysql://" + this.config.getString("database.host") + ":" + this.config.getInt("database.port"), this.config.getString("database.user"), this.config.getString("database.password"), config.getBoolean("database.ssl"));
		((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new SPStat(connection, messagesConfig), this);
		registerAsExtension();
	}

	@Override
	public String getName() {
		return "BuildBattleStats";
	}
}