package de.simonsator.partyandfriends.clan.stats.buildbattle;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.Language;
import de.simonsator.partyandfriends.utilities.LanguageConfiguration;

import java.io.File;
import java.io.IOException;

public class SPMessages extends LanguageConfiguration {
	public SPMessages(Language pLanguage, File pFile, PAFExtension pPlugin) throws IOException {
		super(pLanguage, pFile, pPlugin, true);
		readFile();
		loadDefaultValues();
		saveFile();
		process();
	}

	private void loadDefaultValues() {
		set("ClanStats.StatName", "Build Battle");
		set("ClanStats.WinsLoseRatio", "&7The clan has win lose ratio of &a[WinsLosesRatio]&7.");
		set("ClanStats.Wins", "&7The people of the clan have won &a[WINS] &7games.");
		set("ClanStats.Loses", "&7The people of the clan have lost &a[LOSES]&7 games.");
	}
}