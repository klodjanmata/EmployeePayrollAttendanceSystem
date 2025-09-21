package Services;

import Entity.Attendance;
import Entity.OvertimeRate;
import Util.Helper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class OvertimeRateServices {
        private HashMap<Long, OvertimeRate> overtimeRatesMap;

    public OvertimeRateServices(HashMap<Long, OvertimeRate> overtimeRates) {
        this.overtimeRatesMap = overtimeRatesMap;
    }

    public void add(){
            System.out.println("Add the necessary overtime rate information");
            OvertimeRate overtimeRate = new OvertimeRate();
            overtimeRate.setDescription(Helper.getStringFromUser("Add the description"));
            overtimeRate.setRateForHour(Helper.getFloatFromUser("Add the overtime hours"));
        }
    public void printAll() {
        HashMap<Long, OvertimeRate> overtimeRatesMap = getOvertimeRatesMap();
        for (OvertimeRate overtimeRate : overtimeRatesMap.values()){
            System.out.println(overtimeRate);
        }
    }

}

