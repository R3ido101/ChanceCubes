package chanceCubes.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ProfileGui extends GuiScreen
{
	private GuiScreen parentScreen;
	private ProfilesList profileList;

	private String hoverText;

	public ProfileGui(GuiScreen screen)
	{
		parentScreen = screen;
	}

	@Override
	public void initGui()
	{
		this.profileList = new ProfilesList(this, this.mc, this.width, this.height, 64, this.height - 32, 20);
		this.addButton(new GuiButton(0, this.width / 2 - 36, this.height - 28, 72, 20, "Save"));
	}

	/**
	 * Handles mouse input.
	 */
	public void handleMouseInput() throws IOException
	{
		super.handleMouseInput();
		this.profileList.handleMouseInput();
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		hoverText = "";
		this.profileList.drawScreen(mouseX, mouseY, partialTicks);
		this.drawCenteredString(this.fontRenderer, "Disclaimer: In developement", this.width / 2, 6, 0xFF0000);
		this.drawCenteredString(this.fontRenderer, "Profiles", this.width / 2, 20, 16777215);
		this.drawCenteredString(this.fontRenderer, "Hover over the profile name to see a description", this.width / 2, 34, 16777215);
		this.drawCenteredString(this.fontRenderer, "https://github.com/Turkey2349/ChanceCubes/wiki/Chance-Cubes-Rewards-Evolution", this.width / 2, 48, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
		if(!hoverText.isEmpty())
			this.drawHoveringText(hoverText, mouseX, mouseY);
	}

	/**
	 * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
	 */
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.profileList.mouseClicked(mouseX, mouseY, mouseButton);
	}

	/**
	 * Called when a mouse button is released.
	 */
	protected void mouseReleased(int mouseX, int mouseY, int state)
	{
		super.mouseReleased(mouseX, mouseY, state);
		this.profileList.mouseReleased(mouseX, mouseY, state);
	}

	public void setHoverText(String text)
	{
		this.hoverText = text;
	}

	protected void actionPerformed(GuiButton button) throws IOException
	{
		if(button.enabled)
		{
			if(button.id == 0)
				this.mc.displayGuiScreen(this.parentScreen);
		}
	}
}
