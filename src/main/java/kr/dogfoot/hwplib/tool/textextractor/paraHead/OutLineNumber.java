package kr.dogfoot.hwplib.tool.textextractor.paraHead;

public class OutLineNumber {
    private final static int LevelCount = 10;
    private final static int DefaultValue = 0;

    int[] levelNumbers;
    int oldParaLevel = -1;

    public OutLineNumber() {
        levelNumbers = new int[LevelCount];
        for (int level = 0; level < LevelCount; level++) {
            levelNumbers[level] = DefaultValue;
        }
    }

    public String getText(int paraLevel) {
        int level;
        if (oldParaLevel + 1 < paraLevel) {
            for (level = oldParaLevel + 1; level <= paraLevel; level++) {
                levelNumbers[level] = levelNumbers[level] + 1;
            }
        } else {
            levelNumbers[paraLevel] = levelNumbers[paraLevel] + 1;
        }

        for (level = paraLevel + 1; level < LevelCount; level ++) {
            levelNumbers[level] = DefaultValue;
        }

        StringBuilder sb = new StringBuilder();
        for(level = 0; level <= paraLevel; level++) {
            sb.append(levelNumbers[level]).append(".");
        }

        oldParaLevel = paraLevel;

        return sb.toString();
    }
}
