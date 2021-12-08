
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
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.field_78175_e, this.field_78176_b, this.field_78177_c, this.field_78174_d,
				this.field_78173_f, this.field_78178_a).forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
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
