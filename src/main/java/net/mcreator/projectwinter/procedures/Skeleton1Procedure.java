package net.mcreator.projectwinter.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.projectwinter.ProjectwinterModVariables;
import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.Map;
import java.util.HashMap;

public class Skeleton1Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntitySpawned(EntityJoinWorldEvent event) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = event.getWorld();
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
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency entity for procedure Skeleton1!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ProjectwinterMod.LOGGER.warn("Failed to load dependency world for procedure Skeleton1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double armor_probability = 0;
		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("minecraft:skeleton_effects").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			if (ProjectwinterModVariables.MapVariables.get(world).prog_skeleton_1_flag) {
				armor_probability = (double) Math.random();
				if (((armor_probability >= 0) && (armor_probability <= 0.8))) {
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.IRON_HELMET));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.IRON_HELMET));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.IRON_CHESTPLATE));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.IRON_CHESTPLATE));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.IRON_LEGGINGS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.IRON_LEGGINGS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.IRON_BOOTS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.IRON_BOOTS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (ProjectwinterModVariables.MapVariables.get(world).prog_skeleton_2_flag) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) Double.POSITIVE_INFINITY, (int) 1));
					}
				} else if (((armor_probability > 0.8) && (armor_probability <= 0.98))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) Double.POSITIVE_INFINITY, (int) 1));
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.DIAMOND_HELMET));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.DIAMOND_HELMET));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.DIAMOND_CHESTPLATE));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.DIAMOND_CHESTPLATE));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.DIAMOND_LEGGINGS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.DIAMOND_LEGGINGS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.DIAMOND_BOOTS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.DIAMOND_BOOTS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (ProjectwinterModVariables.MapVariables.get(world).prog_skeleton_2_flag) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) Double.POSITIVE_INFINITY, (int) 3));
					}
				} else if (((armor_probability > 0.98) && (armor_probability < 1))) {
					entity.setCustomName(new StringTextComponent("Rey esqueleto"));
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.NETHERITE_HELMET));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.NETHERITE_HELMET));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.NETHERITE_CHESTPLATE));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.NETHERITE_CHESTPLATE));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.NETHERITE_LEGGINGS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.NETHERITE_LEGGINGS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.NETHERITE_BOOTS));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.NETHERITE_BOOTS));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (ProjectwinterModVariables.MapVariables.get(world).prog_skeleton_2_flag) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) Double.POSITIVE_INFINITY, (int) 5));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) Double.POSITIVE_INFINITY, (int) 3));
					}
				}
			}
		}
	}
}
