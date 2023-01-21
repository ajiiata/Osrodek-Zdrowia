import java.time.LocalDate;
import java.time.Period;

public class kalkulatorWieku {
    public int obliczWiek(LocalDate data) {
        LocalDate dzis = LocalDate.now();
        if (data != null) {
            return Period.between(data, dzis).getYears();
        } else {
            return 0;
        }
    }
}
