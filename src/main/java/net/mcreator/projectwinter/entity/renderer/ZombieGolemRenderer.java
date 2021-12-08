package net.mcreator.projectwinter.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.projectwinter.entity.ZombieGolemEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableList;

@OnlyIn(Dist.CLIENT)
public class ZombieGolemRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ZombieGolemEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelIronGolemModel(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("projectwinter:textures/iron_golem.png");
					}
				};
			});
		}
	}

	/**
	 * IronGolemModel - Either Mojang or a mod author (Taken From Memory) Created
	 * using Tabula 8.0.0
	 */
	@OnlyIn(Dist.CLIENT)
	public static class ModelIronGolemModel<T extends Entity> extends EntityModel<T> {
		public ModelRenderer field_78176_b;
		public ModelRenderer field_78174_d;
		public ModelRenderer field_78177_c;
		public ModelRenderer field_78175_e;
		public ModelRenderer field_78178_a;
		public ModelRenderer field_78173_f;
		public ModelIronGolemModel() {
			this.textureWidth = 128;
			this.textureHeight = 128;
			this.field_78175_e = new ModelRenderer(this, 37, 0);
			this.field_78175_e.setRotationPoint(-4.0F, 11.0F, 0.0F);
			this.field_78175_e.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, 0.0F, 0.0F);
			this.field_78176_b = new ModelRenderer(this, 0, 40);
			this.field_78176_b.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78176_b.addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F, 0.0F, 0.0F);
			this.field_78176_b.setTextureOffset(0, 30).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F, 0.5F, 0.5F);
			this.field_78177_c = new ModelRenderer(this, 60, 21);
			this.field_78177_c.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78177_c.addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F, 0.0F, 0.0F);
			this.field_78174_d = new ModelRenderer(this, 60, 58);
			this.field_78174_d.setRotationPoint(0.0F, -7.0F, 0.0F);
			this.field_78174_d.addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F, 0.0F, 0.0F);
			this.field_78173_f = new ModelRenderer(this, 60, 0);
			this.field_78173_f.mirror = true;
			this.field_78173_f.setRotationPoint(5.0F, 11.0F, 0.0F);
			this.field_78173_f.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, 0.0F, 0.0F);
			this.field_78178_a = new ModelRenderer(this, 0, 0);
			this.field_78178_a.setRotationPoint(0.0F, -7.0F, -2.0F);
			this.field_78178_a.addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
			this.field_78178_a.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		}

		@Override
		public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green,
				float blue, float alpha) {
			ImmutableList.of(this.field_78175_e, this.field_78176_b, this.field_78177_c, this.field_78174_d, this.field_78173_f, this.field_78178_a)
					.forEach((modelRenderer) -> {
						modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
					});
		}

		@Override
		public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		}

		/**
		 * This is a helper function from Tabula to set the rotation of model parts
		 */
		public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
