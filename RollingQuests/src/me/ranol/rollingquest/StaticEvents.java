package me.ranol.rollingquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;

import me.ranol.rollingquest.menu.MenuClickEvent;

public class StaticEvents {

	static final HashMap<Class<?>, List<BindedEvent>> binds = new HashMap<>();

	public static <T extends Event> BindedEvent<T> bind(Class<T> clazz, EventFilter<T> filter, Runnable doRun) {
		if (!binds.containsKey(clazz))
			binds.put(clazz, new ArrayList<>());
		BindedEvent<T> bind = new BindedEvent<>(filter, doRun);
		binds.get(clazz).add(bind);
		return bind;
	}

	public static <T extends Event> void unbind(Class<T> clazz, BindedEvent<T> bind) {
		if (!binds.containsKey(clazz))
			binds.put(clazz, new ArrayList<>());
		binds.get(clazz).remove(bind);
	}

	public List<BindedEvent> getRunnables(Class<? extends Event> clazz) {
		return binds.get(clazz);
	}

	@EventHandler
	public void onMenuClick(MenuClickEvent e) {
		getRunnables(MenuClickEvent.class).stream().forEach(r -> r.matchedRun(e));
	}
}