package Services;

import Entity.OvertimeRate;

public class Test {
    public static void main(String[] args) {
        OvertimeRate overtimeRate = new OvertimeRate();
        System.out.println("Entity found! " + overtimeRate.getClass().getSimpleName());
    }
}
