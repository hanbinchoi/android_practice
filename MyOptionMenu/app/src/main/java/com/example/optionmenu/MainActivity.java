package com.example.optionmenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar aBar = getSupportActionBar();
        //aBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int curID = item.getItemId();

        switch (curID){
            case R.id.menu_refresh:
                Toast.makeText(this,"새로고침 메뉴 클릭됨",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this,"검색 메뉴 클릭됨",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this,"설정 메뉴 클릭됨",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
