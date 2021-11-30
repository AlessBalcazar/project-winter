
package net.mcreator.projectwinter.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.projectwinter.ProjectwinterMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TeamSelectJoinTeamGuiWindow extends ContainerScreen<TeamSelectJoinTeamGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = TeamSelectJoinTeamGui.guistate;
	TextFieldWidget join_team;
	public TeamSelectJoinTeamGuiWindow(TeamSelectJoinTeamGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 174;
		this.ySize = 83;
	}
	private static final ResourceLocation texture = new ResourceLocation("projectwinter:textures/team_select_join_team.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		join_team.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (join_team.isFocused())
			return join_team.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		join_team.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Unirse a equipo", 41, 10, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		join_team = new TextFieldWidget(this.font, this.guiLeft + 23, this.guiTop + 28, 120, 20, new StringTextComponent("Nombre del equipo")) {
			{
				setSuggestion("Nombre del equipo");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Nombre del equipo");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Nombre del equipo");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:join_team", join_team);
		join_team.setMaxStringLength(32767);
		this.children.add(this.join_team);
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + 55, 35, 20, new StringTextComponent("OK"), e -> {
			if (true) {
				ProjectwinterMod.PACKET_HANDLER.sendToServer(new TeamSelectJoinTeamGui.ButtonPressedMessage(0, x, y, z));
				TeamSelectJoinTeamGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
