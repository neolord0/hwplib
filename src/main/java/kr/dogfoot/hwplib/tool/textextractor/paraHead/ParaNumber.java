package kr.dogfoot.hwplib.tool.textextractor.paraHead;

public class ParaNumber {
    private final static int LevelCount = 10;

    int[] levelNumbers;
    int currentHeadID;

    public ParaNumber() {
        levelNumbers = new int[LevelCount];
        currentHeadID = -1;
    }

    public boolean changedParaHead(int headID) {
        return currentHeadID != headID;
    }

    public void reset(int headID, int level, int valueForLevel1) {
        levelNumbers[0] = valueForLevel1;
        for (int level2 = 1; level2 < LevelCount; level2++) {
            if (level >= level2) {
                levelNumbers[level2] = 1;
            } else {
                levelNumbers[level2] = 0;
            }
        }
        currentHeadID = headID;
    }

    public int value(int level) {
        return levelNumbers[level];
    }

    public void increase(int level) {
        for (int level2 = 0; level2 < LevelCount; level2++) {
            if (level2 < level) {
                if (levelNumbers[level2] == 0) {
                    levelNumbers[level2] = 1;
                }
            } else if (level2 > level) {
                levelNumbers[level2] = 0;
            } else {
                levelNumbers[level2]++;
            }
        }
    }
}
