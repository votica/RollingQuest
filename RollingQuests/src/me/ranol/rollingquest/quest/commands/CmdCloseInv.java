package me.ranol.rollingquest.quest.commands;

import java.util.List;

import me.ranol.rollingquest.quest.QuestMenu;

public class CmdCloseInv implements QuestCommand {

	@Override
	public void apply(List<String> args) {
	}

	@Override
	public void activate(QuestMenu menu) {
		menu.getPlayer().closeInventory();
	}

}