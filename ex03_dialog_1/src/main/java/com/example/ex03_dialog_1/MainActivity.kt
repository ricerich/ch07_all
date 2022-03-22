package com.example.ex03_dialog_1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.button1)

        var checkArray = booleanArrayOf(false, false, false)
        btn1.setOnClickListener {

            var versionArray = arrayOf("오레오", "파이", "큐")
//            var checkArray = booleanArrayOf(false, false, false)

            var dlg1 = AlertDialog.Builder(this)
            dlg1.setTitle("제목입니다")
//            dlg1.setMessage("안녕~!")
//            dlg1.setItems(versionArray) { diaglog, position ->
//                btn1.text = versionArray[position]
//            }
//            dlg1.setSingleChoiceItems(versionArray,1) {diaglog, position ->
//                btn1.text = versionArray[position]
//            }

            dlg1.setMultiChoiceItems(versionArray,checkArray){diaglog, position, isChecked ->
                var str1 = ""
                var cnt = 0
                for(i in 0..versionArray.size-1)
                {
                    if(checkArray[i])
                    {
                        if(cnt == 0)
                            str1 = versionArray[i]
                        else
                            str1 = str1 + "," + versionArray[i]

                        cnt++;
                    }
                }
//                btn1.text = versionArray[position]
                btn1.text = str1
            }

            dlg1.setIcon(R.mipmap.ic_launcher)
            dlg1.setPositiveButton("OK", null)
            dlg1.setNegativeButton("취소", null)
            dlg1.show()
        }

    }
}