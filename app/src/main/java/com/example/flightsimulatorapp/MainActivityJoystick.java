package com.example.flightsimulatorapp;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class MainActivityJoystick extends AppCompatActivity {
    private Joystick joyStick;
    private final String RudderPath = "set /controls/flight/rudder";
    private final String ThrottlePath = "set /controls/engines/current-engine/throttle";
    private final String AileronPath = "set /controls/flight/aileron";
    private final String ElevatorPath = "set /controls/flight/elevator";
    private static final String UP = "UP";
    private static final String RIGHT = "RIGHT";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private RelativeLayout layout_joystick;
    private SeekBar rudder;
    private SeekBar throttle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joystick);

        layout_joystick = (RelativeLayout) findViewById(R.id.layout_joystick);
        createJoyStick();
        setListner();
        rudder = (SeekBar) findViewById(R.id.rudder);
        setListSeekBarR();
        throttle = (SeekBar) findViewById(R.id.throttle);
        setListSeekBarT();

    }

    public void createJoyStick(){
        joyStick = new Joystick(getApplicationContext(), layout_joystick, R.drawable.image_button);
        joyStick.setOffset(110);
        joyStick.setMinimumDistance(50);
        joyStick.setLayoutAlpha(150);
        joyStick.setStickAlpha(100);
        joyStick.setStickSize(150, 150);
        joyStick.setLayoutSize(500, 500);
        joyStick.initJoyStickPosition();

    }

    public void setListner(){
        layout_joystick.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                joyStick.drawStick(arg1);
                float xPosition = joyStick.getX();
                float yPosition = joyStick.getY();
                String direction = joyStick.getDirection();
                sendData(xPosition, yPosition, direction);
                return true;
            }
        });
    }
    public void sendData(float x, float y, String direction) {
        if (direction.equals(UP) || direction.equals(DOWN)) {
            Model.Instance().sendMesssage(ElevatorPath + " " + String.valueOf(y));
        } else if (direction.equals(RIGHT) || direction.equals(LEFT)) {
            Model.Instance().sendMesssage(AileronPath + " " + String.valueOf(x));
        }
    }
    public void setListSeekBarR(){
        rudder.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                double x = (((double)progressChangedValue/100)-1);
                if (x>0.5)
                    x=1;
                else if(x<=-0.5)
                    x=-1;
                else x=0;
                Model.Instance().sendMesssage(RudderPath + " " + String.valueOf(x));
            }
        });
    }
    public void setListSeekBarT() {
        throttle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Model.Instance().sendMesssage(ThrottlePath + " " + String.valueOf((double)progressChangedValue/1000));
            }
        });
    }
}