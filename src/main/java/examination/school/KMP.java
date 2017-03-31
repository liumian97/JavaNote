package examination.school;

/**
 * Created by liumian on 2017/3/31.
 */
public class KMP {


    public boolean kmpPattern(String src, String pattern) {

        int srcIndex = 0, patternIndex = 0;

        while (srcIndex < src.length() && patternIndex < pattern.length()) {

            if (src.indexOf(src) == pattern.indexOf(patternIndex)) {
                srcIndex++;
                patternIndex++;
            } else {
                int commonLength = commonLength(pattern, patternIndex);
                patternIndex += commonLength;
            }
        }

        if(srcIndex == patternIndex){

        }
        return false;
    }


    private int commonLength(String pattern, int rightIndex) {
        for (int i = 0; i < rightIndex; i++) {
            if (pattern.indexOf(i) != pattern.indexOf(rightIndex - i)) {
                return i;
            }
        }
        return rightIndex;

    }

}
