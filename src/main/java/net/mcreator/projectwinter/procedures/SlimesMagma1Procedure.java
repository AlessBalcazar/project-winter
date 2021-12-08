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
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;
import java.util.HashMap;

public class SlimesMagma1Procedure {
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
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure SlimesMagma1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (ProjectwinterModVariables.MapVariables.get(world).prog_slime_1_flag) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[tag=mddt] run tag @e[type=magma_cube,distance=..15] add modmagma");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[tag=modmagma,nbt=!{Size:0}] run execute unless entity @e[tag=mddt,distance=..3] run summon minecraft:armor_stand ~ ~ ~ {NoGravity:1b,Marker:1b,Invisible:1b,Tags:[\"mddt\",\"nonticked\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=magma_cube] unless entity @e[tag=mddt,distance=..10] run data merge entity @e[type=magma_cube,limit=1,sort=nearest,tag=!modmagma] {Size:16,Tags:[\"modmagma\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[tag=sddt] run tag @e[type=slime,distance=..10] add gigaslime");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[tag=gigaslime,nbt=!{Size:0}] run execute unless entity @e[tag=sddt,distance=..3] run summon minecraft:armor_stand ~ ~ ~ {NoGravity:1b,Marker:1b,Invisible:1b,Tags:[\"sddt\",\"nonticked\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=slime] unless entity @e[tag=sddt,distance=..10] run data merge entity @e[type=slime,limit=1,sort=nearest,tag=!gigaslime] {Health:225f,Size:15,Tags:[\"gigaslime\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=mddt,tag=nonticked] run execute at @s unless entity @e[tag=modmagma,distance=..2] run scoreboard players set @s mddt 40");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=sddt,tag=nonticked] run execute at @s unless entity @e[tag=gigaslime,distance=..2] run scoreboard players set @s mddt 40");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tag @e[tag=mddt,scores={mddt=40..40}] remove nonticked");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tag @e[tag=sddt,scores={mddt=40..40}] remove nonticked");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"scoreboard players remove @e[type=armor_stand,tag=mddt,tag=!nonticked] mddt 1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"scoreboard players remove @e[type=armor_stand,tag=sddt,tag=!nonticked] mddt 1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"kill @e[tag=mddt,tag=!nonticked,scores={mddt=..0}]");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"kill @e[tag=sddt,tag=!nonticked,scores={mddt=..0}]");
			}
		}
	}
}
