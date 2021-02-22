package ua.kpi.comsys.io8212.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ua.kpi.comsys.io8212.lab1_2.TimeBM;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        String error = "";
        try{
            TimeBM lastTest = new TimeBM(25, 60, 60);
        }catch (IllegalArgumentException e){
            error = e.getMessage();
        }

        TimeBM test1 = new TimeBM(7, 32, 5);
        TimeBM test2 = new TimeBM(14, 59, 59);
        TimeBM test2_1 = new TimeBM(15, 59, 59);
        mText = new MutableLiveData<>();
        Calendar calendar = new GregorianCalendar(2000, 12, 23);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 23);
        calendar.set(Calendar.SECOND, 23);


        mText.setValue(test1.getTime() +
                "\n" + test2.getTime() + "+" + test2_1.getTime() + "=" + test2.plus2Time(test2_1).getTime() +
                "\n" + test2.getTime() + "-" + test2_1.getTime() + "=" + test2.minus2Time(test2_1).getTime() +
                "\n" + TimeBM.minus2Time(new TimeBM(), new TimeBM(2, 15, 50)).getTime() +
                "\n" + TimeBM.plus2Time(new TimeBM(17, 32, 0), new TimeBM(calendar)).getTime()+
                "\n" + error);

    }
    public LiveData<String> getText() {
        return mText;
    }

}