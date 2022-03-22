package com.example.ex04_dialog_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var tv1 = findViewById<TextView>(R.id.tvName)
//        var tv2 = findViewById<TextView>(R.id.tvEmail)

        var edt1 = findViewById<EditText>(R.id.edtName)
        var edt2 = findViewById<EditText>(R.id.edtEmail)

        var btn1 = findViewById<Button>(R.id.button1)

        btn1.setOnClickListener {

            //xml로 만든 뷰를, 인플레이터해서, kotlin뷰로 만든다.
            var view1 = View.inflate(this,R.layout.dialog1,null)

            var dlg1 = AlertDialog.Builder(this)
            dlg1.setTitle("사용자 정보 입력")
            dlg1.setIcon(R.drawable.ic_menu_allfriends)

            dlg1.setView(view1)//kotlin뷰를 꽂는다. 사용한다. 미리만들어진

            //여기쯤
            //위로 격상 시킴
            var dlgEdt1 = view1.findViewById<EditText>(R.id.dlgEdt1)
            var dlgEdt2 = view1.findViewById<EditText>(R.id.dlgEdt2)
            dlgEdt1.text = edt1.text
            dlgEdt2.text = edt2.text


            dlg1.setPositiveButton("확인") { dialog, position ->
                //
//                var dlgEdt1 = view1.findViewById<EditText>(R.id.dlgEdt1)
//                var dlgEdt2 = view1.findViewById<EditText>(R.id.dlgEdt2)
                var str1 = dlgEdt1.text
                var str2 = dlgEdt2.text
//                tv1.text = str1
//                tv2.text = str2
                edt1.text = str1
                edt2.text = str2
            }

            dlg1.setNegativeButton("취소"){ digalog, position ->
                var view1 = View.inflate(this,R.layout.toast1,null)

                var toast1 = Toast(this)

                var toastTV = view1.findViewById<TextView>(R.id.toastText1)
                toastTV.text = "취소~!"

                toast1.view = view1

                toast1.show()


            }

            dlg1.show()

        }


    }
}