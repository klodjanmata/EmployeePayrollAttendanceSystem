package Services;

import Entity.Attendance;
import Entity.OvertimeRate;
import Repository.OvertimeRateRepository;
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
    private HashMap<Long, OvertimeRate> overtimeRatesMap = new HashMap<>();

    public OvertimeRateServices(HashMap<Long, OvertimeRate> overtimeRates) {
        this.overtimeRatesMap = overtimeRates;
    }

    public OvertimeRate create() {
        System.out.println("Add the necessary overtime rate information");
        OvertimeRate overtimeRate = new OvertimeRate();
        overtimeRate.setDescription(Helper.getStringFromUser("Put the description"));
        overtimeRate.setRateForHour(Helper.getFloatFromUser("Put the overtime rate"));
        OvertimeRateRepository repository = new OvertimeRateRepository();
        overtimeRate = repository.create(overtimeRate);
        overtimeRatesMap.put(overtimeRate.getId(), overtimeRate);
        System.out.println("Overtime rate created: " + overtimeRate);
        return overtimeRate;
    }

    public void printAll() {
        System.out.println("All overtime rates");
       HashMap<Long, OvertimeRate> overtimeRatesMap = getOvertimeRatesMap();
        for (OvertimeRate overtimeRate : overtimeRatesMap.values()) {
            System.out.println(overtimeRate);
        }
    }
}


