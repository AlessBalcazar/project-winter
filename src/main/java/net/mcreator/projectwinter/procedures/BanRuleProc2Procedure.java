package net.mcreator.projectwinter.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class BanRuleProc2Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency entity for procedure BanRuleProc2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency x for procedure BanRuleProc2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency y for procedure BanRuleProc2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency z for procedure BanRuleProc2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure BanRuleProc2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public int getScore(String score) {
				if (entity instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) entity).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective(score);
					if (_so != null) {
						Score _scr = _sc.getOrCreateScore(((PlayerEntity) entity).getScoreboardName(), _so);
						return _scr.getScorePoints();
					}
				}
				return 0;
			}
		}.getScore("death_status")) == 1)) {
			{
				double _setval = (double) 12000;
				entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ban_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			ProjectwinterModVariables.MapVariables.get(world).display_flag = (double) 1;
			ProjectwinterModVariables.MapVariables.get(world).syncData(world);
		} else if (((new Object() {
			public int getScore(String score) {
				if (entity instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) entity).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective(score);
					if (_so != null) {
						Score _scr = _sc.getOrCreateScore(((PlayerEntity) entity).getScoreboardName(), _so);
						return _scr.getScorePoints();
					}
				}
				return 0;
			}
		}.getScore("death_status")) == 3)) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(x, y, z);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		}
		if ((ProjectwinterModVariables.MapVariables.get(world).display_flag == 1)) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								((null) + "" + (null)));
			}
			ProjectwinterModVariables.MapVariables.get(world).display_flag = (double) 0;
			ProjectwinterModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
