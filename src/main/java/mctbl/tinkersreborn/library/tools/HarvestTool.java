package mctbl.tinkersreborn.library.tools;

import mctbl.tinkersreborn.tools.Category;

public abstract class HarvestTool extends ToolCore {

    public HarvestTool(String toolTypeName, int partAmount) {
        super(toolTypeName, partAmount);
        this.categoryTags.add(Category.HARVEST);
        this.categoryTags.add(Category.TOOL);
    }

}
