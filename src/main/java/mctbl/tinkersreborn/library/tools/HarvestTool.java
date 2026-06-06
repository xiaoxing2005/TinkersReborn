package mctbl.tinkersreborn.library.tools;

public abstract class HarvestTool extends ToolCore {

    public HarvestTool(String toolTypeName, int partAmount) {
        super(toolTypeName, partAmount);
        this.categoryTags.add("harvest");
    }

}
