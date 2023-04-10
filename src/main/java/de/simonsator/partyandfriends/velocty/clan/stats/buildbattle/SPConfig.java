package de.simonsator.partyandfriends.velocty.clan.stats.buildbattle;

import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class SPConfig extends ConfigurationCreator {

	protected SPConfig(File file, PAFExtension pPlugin) throws IOException {
		super(file, pPlugin);
		readFile();
		loadDefaultValues();
		saveFile();
	}

	private void loadDefaultValues() {
		set("database.host", "localhost");
		set("database.port", 3306);
		set("database.db", "buildbattle");
		set("database.user", "root");
		set("database.password", "Password");
		set("database.ssl", false);
	}
}