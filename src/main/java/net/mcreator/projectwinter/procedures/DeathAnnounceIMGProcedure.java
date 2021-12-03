package net.mcreator.projectwinter.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;
import java.util.HashMap;

public class DeathAnnounceIMGProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure DeathAnnounceIMG!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((ProjectwinterModVariables.MapVariables.get(world).death_img == 76)) {
			ProjectwinterModVariables.MapVariables.get(world).death_img = (double) 0;
			ProjectwinterModVariables.MapVariables.get(world).syncData(world);
			ProjectwinterModVariables.MapVariables.get(world).death_announce_f = (double) 0;
			ProjectwinterModVariables.MapVariables.get(world).syncData(world);
		}
		if ((ProjectwinterModVariables.MapVariables.get(world).death_announce_f == 1)) {
			if (((ProjectwinterModVariables.MapVariables.get(world).tick_counter % 3) == 2)) {
				ProjectwinterModVariables.MapVariables
						.get(world).death_img = (double) (ProjectwinterModVariables.MapVariables.get(world).death_img + 1);
				ProjectwinterModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
