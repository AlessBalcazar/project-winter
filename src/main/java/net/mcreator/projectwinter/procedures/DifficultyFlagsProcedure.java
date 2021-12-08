package net.mcreator.projectwinter.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;
import java.util.HashMap;

public class DifficultyFlagsProcedure {
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
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure DifficultyFlags!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.isRemote()
				? Minecraft.getInstance().getConnection().getPlayerInfoMap().size()
				: ServerLifecycleHooks.getCurrentServer().getCurrentPlayerCount()) >= 1)) {
			if (((ProjectwinterModVariables.MapVariables.get(world).tick_counter > ProjectwinterModVariables.MapVariables.get(world).const_ticks_day)
					&& (!ProjectwinterModVariables.MapVariables.get(world).prog_zombie_1_flag))) {
				ProjectwinterModVariables.MapVariables.get(world).prog_zombie_1_flag = (boolean) (true);
				ProjectwinterModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tellraw @a [\"\",{\"text\":\"NUEVA DIFICULTAD!!! -  \",\"bold\":true,\"color\":\"dark_red\"},{\"text\":\"LOS ZOMBIES AHORA TIENEN \",\"color\":\"blue\"},{\"text\":\"VELOCIDAD II\",\"bold\":true,\"color\":\"blue\"}]");
				}
			}
			if (((ProjectwinterModVariables.MapVariables.get(world).tick_counter > (ProjectwinterModVariables.MapVariables.get(world).const_ticks_day
					* 2)) && (!ProjectwinterModVariables.MapVariables.get(world).prog_skeleton_1_flag))) {
				ProjectwinterModVariables.MapVariables.get(world).prog_skeleton_1_flag = (boolean) (true);
				ProjectwinterModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tellraw @a [\"\",{\"text\":\"NUEVA DIFICULTAD!!! -  \",\"bold\":true,\"color\":\"dark_red\"},{\"text\":\"LOS ESQUELETOS AHORA TIENEN \",\"color\":\"blue\"},{\"text\":\"ARMADURAS\",\"bold\":true,\"color\":\"blue\"}]");
				}
			}
			if (((ProjectwinterModVariables.MapVariables.get(world).tick_counter > (ProjectwinterModVariables.MapVariables.get(world).const_ticks_day
					* 3)) && (!ProjectwinterModVariables.MapVariables.get(world).prog_spider_1_flag))) {
				ProjectwinterModVariables.MapVariables.get(world).prog_spider_1_flag = (boolean) (true);
				ProjectwinterModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tellraw @a [\"\",{\"text\":\"NUEVA DIFICULTAD!!! -  \",\"bold\":true,\"color\":\"dark_red\"},{\"text\":\"LAS ARANAS AHORA TIENEN \",\"color\":\"blue\"},{\"text\":\"FUERZA III\",\"bold\":true,\"color\":\"blue\"}]");
				}
			}
			if (((ProjectwinterModVariables.MapVariables.get(world).tick_counter > (ProjectwinterModVariables.MapVariables.get(world).const_ticks_day
					* 4)) && (!ProjectwinterModVariables.MapVariables.get(world).prog_slime_1_flag))) {
				ProjectwinterModVariables.MapVariables.get(world).prog_slime_1_flag = (boolean) (true);
				ProjectwinterModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tellraw @a [\"\",{\"text\":\"NUEVA DIFICULTAD!!! -  \",\"bold\":true,\"color\":\"dark_red\"},{\"text\":\"LOS SLIMES Y MAGMA CUBES AHORA SON\",\"color\":\"blue\"},{\"text\":\"MEGA\",\"bold\":true,\"color\":\"blue\"}]");
				}
			}
		}
	}
}
