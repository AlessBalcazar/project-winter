package net.mcreator.projectwinter.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;

public class DeathAnnounceControlProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure DeathAnnounceControl!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (ProjectwinterModVariables.MapVariables.get(world).death_announce_f == 1);
	}
}
