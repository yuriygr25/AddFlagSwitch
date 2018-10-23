package com.example.yura.addflagswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int IDM_COLOR_GROUP = 400;
    public static final int IDM_COLOR_RED = 401;
    public static final int IDM_COLOR_GREEN = 402;
    public static final int IDM_COLOR_BLUE = 403;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenuColor = menu.addSubMenu("Цвет");
        subMenuColor.add(IDM_COLOR_GROUP, IDM_COLOR_RED, Menu.NONE, "Красный");
        subMenuColor.add(IDM_COLOR_GROUP, IDM_COLOR_GREEN, Menu.NONE, "Зеленый");
        subMenuColor.add(IDM_COLOR_GROUP, IDM_COLOR_BLUE, Menu.NONE, "Синий");
        subMenuColor.setGroupCheckable(IDM_COLOR_GROUP, true, false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;

        switch (item.getItemId()) {
            case IDM_COLOR_RED:
                // инвертируем состояние флажка
                item.setChecked(!item.isChecked());
                message = "Красный цвет";
                Intent intent = new Intent(MainActivity.this, MyOtherActivity.class);
                startActivity(intent);
                break;
            case IDM_COLOR_GREEN:
                // инвертируем состояние флажка
                item.setChecked(!item.isChecked());
                message = "Зелёный цвет";
                break;
            case IDM_COLOR_BLUE:
                // инвертируем состояние флажка
                item.setChecked(!item.isChecked());
                message = "Синий цвет";
                break;

            default:
                return false;
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);

        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;

    }
}