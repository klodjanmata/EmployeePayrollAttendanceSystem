package Services;

import Entity.OvertimeRate;
import Util.Helper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashMap;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OvertimeRateServices {
        private HashMap<Long, OvertimeRate> overtimesMap;

        public void add(){
            System.out.println("Add the necessary overtime rate information");
            OvertimeRate overtimeRate = new OvertimeRate();
            overtimeRate.setDescription(Helper.getStringFromUser("Add the description"));
            overtimeRate.setRateForHour(Helper.getFloatFromUser("Add the overtime hours"));
        }

    }

