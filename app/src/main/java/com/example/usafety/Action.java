package com.example.usafety;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.FragmentManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Action extends Fragment {
    Boolean cardViewPressed;
    CardView cardViewTemp1, cardViewTemp2, cardViewSymptoms1, cardViewSymptoms2,
            cardViewSymptoms3, cardViewSymptoms4, cardViewSymptoms5, cardViewSymptoms6,
            cardViewSymptoms7,cardViewSymptoms8,cardViewSymptoms9, cardViewActionSubmit;
    Integer tempSelectBelow, tempSelectAbove, symp1,symp2,symp3,symp4,symp5,symp6,symp7,symp8,symp9;
    Dialog dialog;
    Vibrator vib;
    LocationManager locationManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_action, container, false);

        cardViewTemp1 = root.findViewById(R.id.tempBelow);
        cardViewTemp2 = root.findViewById(R.id.tempAbove);

        vib = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        cardViewSymptoms1 = root.findViewById(R.id.sympCard1);
        cardViewSymptoms2 = root.findViewById(R.id.sympCard2);
        cardViewSymptoms3  = root.findViewById(R.id.sympCard3);
        cardViewSymptoms4  = root.findViewById(R.id.sympCard4);
        cardViewSymptoms5  = root.findViewById(R.id.sympCard5);
        cardViewSymptoms6  = root.findViewById(R.id.sympCard6);
        cardViewSymptoms7  = root.findViewById(R.id.sympCard7);
        cardViewSymptoms8  = root.findViewById(R.id.sympCard8);
        cardViewSymptoms9  = root.findViewById(R.id.sympCard9);

        cardViewActionSubmit = root.findViewById(R.id.actionSubmit);

        dialog = new Dialog(getContext());
        tempSelectBelow=0; tempSelectAbove=0;

        symp1 = 0; symp2=0; symp3=0; symp4=0; symp5=0; symp6=0; symp7=0; symp8=0; symp9=0;

        cardViewPressed = false;






        //temp
        cardViewTemp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewTemp1.isPressed()==true&&cardViewPressed==false&&tempSelectBelow==0&&tempSelectAbove==0){
                    cardViewTemp1.setCardBackgroundColor(Color.GREEN);
                    tempSelectBelow=1;
                    cardViewPressed=true;
                }
                else if(cardViewPressed==true&&cardViewTemp1.isPressed()==true&&tempSelectBelow==1){
                    cardViewTemp1.setCardBackgroundColor(Color.WHITE);
                    cardViewPressed=false;
                    tempSelectBelow=0;
                }
            }
        });

        cardViewTemp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewTemp2.isPressed()==true&&cardViewPressed==false&&tempSelectBelow==0&&tempSelectAbove==0){
                    cardViewTemp2.setCardBackgroundColor(Color.parseColor("#B22222"));
                    cardViewPressed=true;
                    tempSelectAbove=1;
                }
                else if(cardViewPressed==true&&cardViewTemp2.isPressed()==true&&tempSelectAbove==1){
                    cardViewTemp2.setCardBackgroundColor(Color.WHITE);
                    cardViewPressed=false;
                    tempSelectAbove=0;
                }
            }
        });
        cardViewSymptoms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms1.isPressed()&&symp1==0){
                    cardViewSymptoms1.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp1 = 1;
                }
                else if(cardViewSymptoms1.isPressed()&&symp1==1){
                    cardViewSymptoms1.setCardBackgroundColor(Color.WHITE);
                    symp1 = 0;
                }
            }
        });
        cardViewSymptoms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms2.isPressed()&&symp2==0){
                    cardViewSymptoms2.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp2 = 1;
                }
                else if(cardViewSymptoms2.isPressed()&&symp2==1){
                    cardViewSymptoms2.setCardBackgroundColor(Color.WHITE);
                    symp2= 0;
                }
            }
        });
        cardViewSymptoms3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms3.isPressed()&&symp3==0){
                    cardViewSymptoms3.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp3 = 1;
                }
                else if(cardViewSymptoms3.isPressed()&&symp3==1){
                    cardViewSymptoms3.setCardBackgroundColor(Color.WHITE);
                    symp3 = 0;
                }
            }
        });
        cardViewSymptoms4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms4.isPressed()&&symp4==0){
                    cardViewSymptoms4.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp4 = 1;
                }
                else if(cardViewSymptoms4.isPressed()&&symp4==1){
                    cardViewSymptoms4.setCardBackgroundColor(Color.WHITE);
                    symp4 = 0;
                }
            }
        });
        cardViewSymptoms5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms5.isPressed()&&symp5==0){
                    cardViewSymptoms5.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp5 = 1;
                }
                else if(cardViewSymptoms5.isPressed()&&symp5==1){
                    cardViewSymptoms5.setCardBackgroundColor(Color.WHITE);
                    symp5 = 0;
                }
            }
        });
        cardViewSymptoms6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms6.isPressed()&&symp6==0){
                    cardViewSymptoms6.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp6 = 1;
                }
                else if(cardViewSymptoms6.isPressed()&&symp6==1){
                    cardViewSymptoms6.setCardBackgroundColor(Color.WHITE);
                    symp6 = 0;
                }
            }
        });
        cardViewSymptoms7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms7.isPressed()&&symp7==0){
                    cardViewSymptoms7.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp7 = 1;
                }
                else if(cardViewSymptoms7.isPressed()&&symp7==1){
                    cardViewSymptoms7.setCardBackgroundColor(Color.WHITE);
                    symp7 = 0;
                }
            }
        });
        cardViewSymptoms8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms8.isPressed()&&symp8==0){
                    cardViewSymptoms8.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp8 = 1;
                }
                else if(cardViewSymptoms8.isPressed()&&symp8==1){
                    cardViewSymptoms8.setCardBackgroundColor(Color.WHITE);
                    symp8 = 0;
                }
            }
        });
        cardViewSymptoms9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardViewSymptoms9.isPressed()&&symp9==0){
                    cardViewSymptoms9.setCardBackgroundColor(Color.parseColor("#B22222"));
                    symp9 = 1;
                }
                else if(cardViewSymptoms9.isPressed()&&symp9==1){
                    cardViewSymptoms9.setCardBackgroundColor(Color.WHITE);
                    symp9 = 0;
                }
            }
        });

        cardViewActionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempSelectBelow==1&&(symp1  == 0&&symp2 == 0&&symp3 == 0&&
                        symp4  == 0&&symp5 == 0&&symp6 == 0&&symp7  == 0&&symp8 == 0&&symp9 == 0)){
                    belowDialog();

                }
                else if(tempSelectAbove==1&&(symp1  == 0&&symp2 == 0&&symp3 == 0&&
                        symp4  == 0&&symp5 == 0&&symp6 == 0&&symp7  == 0&&symp8 == 0&&symp9 == 0)){
                    aboveDialog();
                }
                else if(((symp4 == 1) &&
                        (symp1 == 0 && symp5 == 0 && symp6 == 0 && symp7 == 0 && symp8 == 0 && symp9 == 0 && symp2 == 0 && symp3 == 0))){
                    feverDialog();
                } else if(((symp6 == 1) &&
                        (symp1 == 0 && symp5 == 0 && symp4 == 0 && symp7 == 0 && symp8 == 0 && symp9 == 0 && symp2 == 0 && symp3 == 0))){
                    coughDialog();
                }else if(((symp9 == 1) &&
                        (symp1 == 0 && symp5 == 0 && symp4 == 0 && symp7 == 0 && symp8 == 0 && symp6 == 0 && symp2 == 0 && symp3 == 0))){
                    chestDialog();
                }
                else if(((symp4 == 1 || symp5 == 1 || symp6 == 1) &&
                        (symp7 == 0 && symp8 == 0 && symp9 == 0))){
                    commonDialog();
                }
                else if(symp7  == 1||symp8 == 1||symp9 == 1){
                    seriousDialog();
                }
                else if(tempSelectBelow==0&&tempSelectBelow==0&&symp1  == 0&&symp2 == 0&&
                        symp3 == 0&&symp4  == 0&&symp5 == 0&&symp6 == 0&&symp7  == 0&&symp8 == 0&&symp9 == 0){
                    Toast toast=Toast.makeText(getActivity(),"Please choose any symptoms",Toast. LENGTH_SHORT);
                    toast.show();
                    long[] pattern = { 0, 100, 100,100};
                    vib.vibrate(pattern, -1);
                }

            }
        });
        

        return root;
    }



    private void belowDialog() {
        dialog.setContentView(R.layout.temp_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        reset();

        Button btnOk=dialog.findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void aboveDialog() {
        dialog.setContentView(R.layout.abovetemp_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnOk=dialog.findViewById(R.id.btnOk);

        reset();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void feverDialog() {
        dialog.setContentView(R.layout.fever);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk=dialog.findViewById(R.id.btnOk);
        reset();
        long[] pattern = { 0, 1000, 1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        vib.vibrate(pattern, -1);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                vib.cancel();
            }
        });
        dialog.show();
    }

    private void chestDialog() {
        dialog.setContentView(R.layout.chest);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk=dialog.findViewById(R.id.btnOk);
        reset();
        long[] pattern = { 0, 1000, 1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        vib.vibrate(pattern, -1);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                vib.cancel();
            }
        });
        dialog.show();
    }
    private void coughDialog() {
        dialog.setContentView(R.layout.cough);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk=dialog.findViewById(R.id.btnOk);
        reset();
        long[] pattern = { 0, 1000, 1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        vib.vibrate(pattern, -1);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                vib.cancel();
            }
        });
        dialog.show();
    }
    private void lessDialog() {
        dialog.setContentView(R.layout.less_symp_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk=dialog.findViewById(R.id.btnOk);
        reset();
        long[] pattern = { 0, 1000, 1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        vib.vibrate(pattern, -1);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                vib.cancel();
            }
        });
        dialog.show();
    }

    private void commonDialog() {

        dialog.setContentView(R.layout.common_symp_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk=dialog.findViewById(R.id.btnOk);
        long[] pattern = { 0, 1000, 1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        vib.vibrate(pattern, -1);
        reset();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                vib.cancel();
            }
        });
        dialog.show();
    }
    private void reset(){

        cardViewPressed=false;

        cardViewTemp1.setCardBackgroundColor(Color.WHITE);
        cardViewTemp2.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms1.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms2.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms3.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms4.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms5.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms6.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms7.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms8.setCardBackgroundColor(Color.WHITE);
        cardViewSymptoms9.setCardBackgroundColor(Color.WHITE);

        tempSelectBelow=0; tempSelectAbove=0;
        symp1 = 0; symp2=0; symp3=0; symp4=0; symp5=0; symp6=0; symp7=0; symp8=0; symp9=0;
    }

    private void seriousDialog() {
        dialog.setContentView(R.layout.seious_symp_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk=dialog.findViewById(R.id.btnOk);
        Button btnNear=dialog.findViewById(R.id.btnNear);
        long[] pattern = { 0, 1000, 1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        vib.vibrate(pattern, -1);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0289426843"));
                startActivity(intent);
                vib.cancel();
            }
        });

        btnNear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospital");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });
        dialog.show();
    }




}