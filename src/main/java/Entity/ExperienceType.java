package Entity;

import java.util.Arrays;

public enum ExperienceType {
    BEGGINER,
    INTERMEDIATE,
    ADVANCED,
    EXPERT;


    public static String printALLValues(){
        return  Arrays.toString(ExperienceType.values());
    }

}
