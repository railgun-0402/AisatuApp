package jp.techacademy.sugawara.aisatuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v:View){
        showTimePickerDialog()
    }

    private fun showTimePickerDialog(){

        /*
        //TimePickerDialogの表示
        this:Activityを与える
        OnTimeSetListener:時刻を設定した時にonTimeSetメソッドが呼ばれる
        */
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")

                //時刻によってTextViewの記述を変える
                if (2 <= hour && hour <= 9){
                    textView.text = "おはよう"
                } else if (10 <= hour && hour <=17){
                    textView.text = "こんにちは"
                } else if (18 <= hour || hour == 1){
                    textView.text = "こんばんは"
                }

            },
            //初期値の時間、分、trueは24時間表記、falseは午前午後表記
            13,0,true)

        //showメソッドでTimePickerDialogを表示させる
        timePickerDialog.show()
    }

}
