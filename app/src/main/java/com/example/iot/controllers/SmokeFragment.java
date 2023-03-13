package com.example.iot.controllers;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.iot.R;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.Slider.OnSliderTouchListener;

public class SmokeFragment extends Fragment {
    Slider slider ;
    private float valueSlider ;
    SwitchCompat switchCompat ;
    boolean send_data ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smoke, container, false);
        slider = (Slider) view.findViewById(R.id.smoke_slider);
        slider.addOnSliderTouchListener(new OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {
            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                setValueSlider(slider.getValue());
                Toast.makeText(getActivity(),"Value is:  "+getValueSlider(),Toast.LENGTH_SHORT).show();
                MainActivity mainActivitySlider = (MainActivity) getActivity();
                mainActivitySlider.getSmokeSlider(getValueSlider());
            }
        });
        switchCompat = (SwitchCompat) view.findViewById(R.id.smokeSwitch) ;
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchCompat.isChecked()) {
                    setValueData(true);
                }
                else {
                    setValueData(false);
                }
                MainActivity mainActivitySendData = (MainActivity) getActivity();
                mainActivitySendData.getSmokeSendData(getValueData());
            }
        });
        return view ;
    }

    public float getValueSlider(){return valueSlider; }

    public void setValueSlider(float value){this.valueSlider = value ;}

    public boolean getValueData() {return  send_data ;}

    public void setValueData(boolean flag) {this.send_data=flag;}

}