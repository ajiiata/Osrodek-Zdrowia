import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dzisData {
    final String dzisiejszaData;

    dzisData() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String month = monthFormat.format(cal.getTime());
        String day = dayFormat.format(cal.getTime());
        String year = yearFormat.format(cal.getTime());

        this.dzisiejszaData = day + "-" + month + "-" + year;
    }

    void jakaData() {
        System.out.println(dzisiejszaData);
    }

}
