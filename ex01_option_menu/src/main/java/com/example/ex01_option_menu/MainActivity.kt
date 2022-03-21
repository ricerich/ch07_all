package com.example.ex01_option_menu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity()
{
    //멤버 변수로 격상-> onCreateOptionsMenu에서 써야 하니까!
//    lateinit var baseLayout : LinearLayout
//    lateinit var btn1 : Button

    lateinit var edt1 : EditText
    lateinit var iv1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btn1 = findViewById<Button>(R.id.btn1)
//        baseLayout = findViewById<LinearLayout>(R.id.linearLayout1)

        edt1 = findViewById(R.id.edt1)
        iv1 = findViewById(R.id.iv1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
//        var mInflator = menuInflater
//        mInflator.inflate(R.menu.menu1,menu)

        //kotlin코드로만 메뉴만들기. ft)xml을 안쓰겠다. inflate를 안쓰겠다
        menu!!.add(0, 1 ,0, "그림회전" )


        menu!!.add(1, 2 ,0, "제주1" )
        menu!!.add(1, 3 ,0, "제주2" )
        menu!!.add(1, 4 ,0, "제주3" )

        menu!!.setGroupCheckable(1, true, true)



        return super.onCreateOptionsMenu(menu)
    }

    var fAngle : Float = 0f
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {

            1 -> {
                fAngle = fAngle + edt1.text.toString().toFloat()
                iv1.rotation = fAngle
            }
            2 -> {
                iv1.setImageResource(R.drawable.jeju12)
                item.setChecked(true)
            }
            3 -> {
                iv1.setImageResource(R.drawable.jeju14)
                item.setChecked(true)
            }
            4 ->{
                iv1.setImageResource(R.drawable.jeju4)
                item.setChecked(true)
            }

//            R.id.item1 -> baseLayout.setBackgroundColor(Color.RED)
//            R.id.item2 -> baseLayout.setBackgroundColor(Color.GREEN)
//            R.id.item3 -> baseLayout.setBackgroundColor(Color.BLUE)
//            R.id.item5 -> btn1.rotation = 45f
//            R.id.item6 -> btn1.scaleX = 2f
        }

        return super.onOptionsItemSelected(item)
    }
}