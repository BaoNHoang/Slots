package com.example.slots;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton reset;
    ImageButton go;
    ImageView f1, f2, f3;
    TextView value;
    int amountStart = CONSTANTS.STARTUP_CASH;
    private final int[] images = {R.drawable.f1, R.drawable.f2, R.drawable.f3};
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.reset);
        go = findViewById(R.id.go);
        value = findViewById(R.id.value);

        f1 = findViewById(R.id.imageLeft);
        f2 = findViewById(R.id.imageMiddle);
        f3 = findViewById(R.id.imageRight);

        value.setText(String.valueOf(amountStart));

        reset.setVisibility(View.INVISIBLE);
        reset.setEnabled(false);
        checkAmount();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAmount();
                reset.setVisibility(View.VISIBLE);
                reset.setEnabled(true);
                amountStart -= CONSTANTS.COST_PER_ROLL;
                value.setText(String.valueOf(amountStart));
                go.setEnabled(false);
                startSpinAnimation();
            }
        });
    }

    private void startSpinAnimation() {
        Animation spinAnimation = AnimationUtils.loadAnimation(this, R.anim.flower_spin);

        spinAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changeImages();
                value.setText(String.valueOf(amountStart));
                go.setEnabled(true);
                checkAmount();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        f1.startAnimation(spinAnimation);
        f2.startAnimation(spinAnimation);
        f3.startAnimation(spinAnimation);
    }

    private void changeImages() {
        int img1 = images[random.nextInt(images.length)];
        int img2 = images[random.nextInt(images.length)];
        int img3 = images[random.nextInt(images.length)];

        f1.setImageResource(img1);
        f2.setImageResource(img2);
        f3.setImageResource(img3);

        int fullMatch = img1 + img2 + img3;
        System.out.println(fullMatch);
        if (fullMatch == CONSTANTS.NUMB_FLOWERS) {
            amountStart += CONSTANTS.MATCH_3;
        } else if (img1 == img2 || img2 == img3 || img1 == img3) {
            amountStart += CONSTANTS.MATCH_2;
        } else {
            amountStart -= CONSTANTS.COST_PER_ROLL;
        }
    }

    private void checkAmount() {
        if (amountStart <= CONSTANTS.YOUR_BROKE) {
            go.setVisibility(View.INVISIBLE);
            go.setEnabled(false);
            reset.setVisibility(View.VISIBLE);
            reset.setEnabled(true);
        }
    }

    private void resetGame() {
        go.setVisibility(View.VISIBLE);
        go.setEnabled(true);
        reset.setVisibility(View.INVISIBLE);
        reset.setEnabled(false);
        amountStart = CONSTANTS.STARTUP_CASH;
        value.setText(String.valueOf(amountStart));
    }
}
