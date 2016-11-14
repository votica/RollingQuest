package me.ranol.rollingquest.quest.commands;

import java.util.List;

import me.ranol.rollingquest.management.QuestManager;
import me.ranol.rollingquest.quest.QuestMenu;

public class CmdGiveQuest implements RollingCommand {
	String questName;

	@Override
	public void apply(List<String> args) {
		questName = args.get(0);
	}

	@Override
	public void activate(QuestMenu menu) {
		if (QuestManager.availableQuest(questName)) {
			QuestManager.giveQuest(menu.getPlayer(), questName);
		}
	}

}
