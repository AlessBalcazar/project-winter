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
import net.minecraft.scoreboard.ScoreCriteria;
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
			{
				Entity _ent = entity;
				if (_ent instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective("ban_seconds");
					if (_so == null) {
						_so = _sc.addObjective("ban_seconds", ScoreCriteria.DUMMY, new StringTextComponent("ban_seconds"),
								ScoreCriteria.RenderType.INTEGER);
					}
					Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
					_scr.setScorePoints((int) Math.ceil((((entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ProjectwinterModVariables.PlayerVariables())).ban_time) / 20)));
				}
			}
			ProjectwinterModVariables.MapVariables
					.get(world).death_players = (double) (ProjectwinterModVariables.MapVariables.get(world).death_players + 1);
			ProjectwinterModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"scoreboard objectives setdisplay sidebar ban_seconds");
			}
			{
				Entity _ent = entity;
				if (_ent instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective("death_status");
					if (_so == null) {
						_so = _sc.addObjective("death_status", ScoreCriteria.DUMMY, new StringTextComponent("death_status"),
								ScoreCriteria.RenderType.INTEGER);
					}
					Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
					_scr.setScorePoints((int) 2);
				}
			}
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
			{
				double _setval = (double) (((entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ProjectwinterModVariables.PlayerVariables())).ban_time) - 1);
				entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ban_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Entity _ent = entity;
				if (_ent instanceof PlayerEntity) {
					Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective("ban_seconds");
					if (_so == null) {
						_so = _sc.addObjective("ban_seconds", ScoreCriteria.DUMMY, new StringTextComponent("ban_seconds"),
								ScoreCriteria.RenderType.INTEGER);
					}
					Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
					_scr.setScorePoints((int) Math.ceil((((entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ProjectwinterModVariables.PlayerVariables())).ban_time) / 20)));
				}
			}
			if ((((entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ProjectwinterModVariables.PlayerVariables())).ban_time) <= 0)) {
				ProjectwinterModVariables.MapVariables
						.get(world).death_players = (double) (ProjectwinterModVariables.MapVariables.get(world).death_players - 1);
				ProjectwinterModVariables.MapVariables.get(world).syncData(world);
				if ((ProjectwinterModVariables.MapVariables.get(world).death_players <= 0)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"scoreboard objectives setdisplay sidebar");
						}
					}
					ProjectwinterModVariables.MapVariables.get(world).death_players = (double) 0;
					ProjectwinterModVariables.MapVariables.get(world).syncData(world);
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"tellraw @a [{\"selector\":\"@s\",\"bold\":true,\"color\":\"blue\"},{\"text\":\" ha sido desbaneado!\",\"color\":\"dark_purple\"}]");
					}
				}
				{
					Entity _ent = entity;
					if (_ent instanceof PlayerEntity) {
						Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
						ScoreObjective _so = _sc.getObjective("death_status");
						if (_so == null) {
							_so = _sc.addObjective("death_status", ScoreCriteria.DUMMY, new StringTextComponent("death_status"),
									ScoreCriteria.RenderType.INTEGER);
						}
						Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
						_scr.setScorePoints((int) 0);
					}
				}
			}
		}
	}
}
