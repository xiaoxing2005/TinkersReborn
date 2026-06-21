package mctbl.tinkersreborn.library.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

public class GuiToolNameField extends GuiTextField {

    public GuiToolNameField(FontRenderer p_i1032_1_, int p_i1032_2_, int p_i1032_3_, int p_i1032_4_, int p_i1032_5_) {
        super(p_i1032_1_, p_i1032_2_, p_i1032_3_, p_i1032_4_, p_i1032_5_);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        boolean isClick = mouseX >= this.xPosition && mouseX < this.xPosition + this.width
            && mouseY >= this.yPosition
            && mouseY < this.yPosition + this.height;
        if (isClick && mouseButton == 1) {
            // right click clear
            this.setText("");
        } else {
            super.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

}
