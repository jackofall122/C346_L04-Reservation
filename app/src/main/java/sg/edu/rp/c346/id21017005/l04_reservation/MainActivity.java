package sg.edu.rp.c346.id21017005.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etSize;
    EditText etContactno;
    RadioGroup rgSeatType;
    DatePicker date;
    TimePicker time;
    TextView tvDisplay;
    Button btnBook;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etSize = findViewById(R.id.etSize);
        etContactno = findViewById(R.id.etContact);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnBook = findViewById(R.id.btnBook);
        btnReset = findViewById(R.id.btnReset);
        time = findViewById(R.id.timePicker);
        date = findViewById(R.id.datePicker);
        rgSeatType = findViewById(R.id.seatType);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String size = etSize.getText().toString();
                String contact = etContactno.getText().toString();

                // Parse through textviews to find null values and print error
                if((name.isEmpty())||(size.isEmpty())||(contact.isEmpty())){
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                // Normal case (if no null values)
                else{
                    int day = date.getDayOfMonth();
                    int month = date.getMonth();
                    int year = date.getYear();
                    int hour = time.getCurrentHour();
                    int minute = time.getCurrentMinute();

                    int checkedRadioId = rgSeatType.getCheckedRadioButtonId();
                    String seatType = "";
                    if(checkedRadioId==R.id.smoking){
                        seatType ="Smoking Seat";
                    }
                    else{
                        seatType="Non-Smoking Seat";
                    }

                    String info = "Your booking details:\nName: " +name+"\nContact Number: " +contact+"\nSeat Type: "+seatType+"\nTime: " +hour+" : "+minute+"\nDate: " +day+" / "+month+" / "+year;
                    tvDisplay.setText(info);
                    Toast.makeText(MainActivity.this, "Booking Confirmed!\nCheck below for details", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,7,1);
                etName.setText("");
                etContactno.setText("");
                etSize.setText("");
                Toast.makeText(MainActivity.this, "Reset complete", Toast.LENGTH_SHORT).show();
            }
        });
    }

}