package com.brst_pc81.kotlinsample

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = findViewById(R.id.toolbar)as Toolbar
        toolbar.setTitle("Login")

        var email=findViewById(R.id.email) as TextInputEditText
        var pass=findViewById(R.id.pass) as TextInputEditText
        var main_layout=findViewById(R.id.mainLayout) as LinearLayout

        var login=findViewById(R.id.login) as Button


        login.setOnClickListener(View.OnClickListener {
            if (email.getText().toString().equals("")||pass.getText().toString().equals("")){
                Snackbar.make(main_layout,"Please fill all Fields...", Snackbar.LENGTH_LONG)
                        .show()
            }else{
                if(email.getText().toString().equals("admin")&&pass.getText().toString().equals("123456")){
                    val intent=Intent(applicationContext,DashboardActivity::class.java)
                    startActivity(intent)

                }else{
                    Snackbar.make(main_layout,"Invalid username and password...", Snackbar.LENGTH_LONG)
                            .show()
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
