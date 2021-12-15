package com.example.basecolors_configureddialogex102;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Agam Toledano
 * @version 1.0
 * @since 27/11/2021
 * Short description - Practice (Configured Dialog) - Each button activates a different type of Configured Dialog.
 */

public class MainActivity extends AppCompatActivity{
    View background;
    int[] color = {0, 0, 0};
    final String[] colors = {"Red","Green","Blue"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (View) findViewById(R.id.background);
    }

    /**
     * Button:
     * Short description - Configured Dialog (Changes background to base color).
     * <p>
     *
     * @param view
     * @return none
     */
    public void forBaseColor(View view) {
        AlertDialog.Builder bColor;
        bColor = new AlertDialog.Builder(this);
        bColor.setCancelable(false);

        bColor.setTitle("Base Color");
        bColor.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                background.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                color[which] = 0;
            }
        });

        bColor.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = bColor.create();
        ad.show();
    }

    /**
     * Button:
     * Short description - Configured Dialog (Change background to mix base color).
     * <p>
     *
     * @param view
     * @return none
     */
    public void mixingColor(View view) {
        AlertDialog.Builder bColorC;
        bColorC = new AlertDialog.Builder(this);
        bColorC.setCancelable(false);

        bColorC.setTitle("Mixing Colors");

        bColorC.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    color[which] = 255;
                }
                else{
                    color[which] = 0;
                }
            }
        });

        bColorC.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(!((color[0] ==0)&&(color[1] ==0)&&(color[2] ==0))){
                    background.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                    for (int i=0;i<3;i++){
                        color[i] = 0;
                    }
                }
            }
        });

        bColorC.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = bColorC.create();
        ad.show();
    }

    /**
     * Button:
     * Short description - Configured Dialog (Change background to white).
     * <p>
     *
     * @param view
     * @return none
     */
    public void reset(View view) {
        AlertDialog.Builder forWhite;
        forWhite = new AlertDialog.Builder(this);
        forWhite.setCancelable(true);

        forWhite.setTitle("RESET");
        forWhite.setMessage("Change background to white");
        background.setBackgroundColor(Color.rgb(255, 255, 255));

        AlertDialog ad = forWhite.create();
        ad.show();
    }

    /**
     * Button:
     * Short description - Configured Dialog (Create a Toast).
     * <p>
     *
     * @param view
     * @return none
     */
    public void createToast(View view) {
        AlertDialog.Builder toToast;
        toToast = new AlertDialog.Builder(this);
        toToast.setCancelable(false);

        toToast.setTitle("Create a Toast");

        final EditText content = new EditText(this);
        toToast.setView(content);

        toToast.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String toast = content.getText().toString();
                Toast.makeText(MainActivity.this,toast,Toast.LENGTH_LONG).show();
            }
        });

        toToast.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = toToast.create();
        ad.show();
    }

    /**
     * OptionMenu:
     * Short description - Creation of OptionMenu.
     * @param menu
     * @return super.onCreateOptionsMenu(menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * OptionMenu:
     * Short description - Activating the OptionMenu.
     * @param item
     * @return super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent si = new Intent(this,CreditActivity.class);
        startActivity(si);
        return super.onOptionsItemSelected(item);
    }
}