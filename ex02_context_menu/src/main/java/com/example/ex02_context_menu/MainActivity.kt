package com.example.ex02_context_menu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity()
{
    //멤버 변수로 격상-> onCreateOptionsMenu에서 써야 하니까!
    lateinit var baseLayout : LinearLayout
    lateinit var btn1 : Button
    lateinit var btn2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        baseLayout = findViewById<LinearLayout>(R.id.linearLayout1)

        btn1 = findViewById<Button>(R.id.btn1)
        registerForContextMenu(btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        registerForContextMenu(btn2)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflator = menuInflater
        if(v == btn1) {
            menu!!.setHeaderTitle("배경색변경")
            mInflator.inflate(R.menu.menu1, menu)
        }
        else if(v == btn2)
            mInflator.inflate(R.menu.menu2,menu)

    }

    //메뉴 이벤트 처리
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item1 -> baseLayout.setBackgroundColor(Color.RED)
            R.id.item2 -> baseLayout.setBackgroundColor(Color.GREEN)
            R.id.item3 -> baseLayout.setBackgroundColor(Color.BLUE)
            R.id.item5 -> btn1.rotation = 45f
            R.id.item6 -> btn1.scaleX = 2f
        }

        return super.onContextItemSelected(item)
    }
}