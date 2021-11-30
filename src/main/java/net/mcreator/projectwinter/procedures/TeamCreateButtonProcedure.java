package net.mcreator.projectwinter.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;
import java.util.HashMap;

public class TeamCreateButtonProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency entity for procedure TeamCreateButton!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency guistate for procedure TeamCreateButton!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency x for procedure TeamCreateButton!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency y for procedure TeamCreateButton!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency z for procedure TeamCreateButton!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure TeamCreateButton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					(("team add ") + "" + ((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:new_team");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) + "" + (" {\"text\":\"") + "" + ((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:new_team");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) + "" + ("\"}")));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					(("team join ") + "" + ((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:new_team");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) + "" + (" ") + "" + ((entity.getDisplayName().getString()))));
		}
		{
			String _setval = (String) (new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:new_team");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText());
			entity.getCapability(ProjectwinterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.team_name = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
