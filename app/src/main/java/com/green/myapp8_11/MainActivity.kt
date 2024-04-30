package com.green.myapp8_11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRead : Button = findViewById<Button>(R.id.btnRead)
        var btnWrite : Button = findViewById<Button>(R.id.btnWrite)

        btnWrite.setOnClickListener {

            var outFs : FileOutputStream =openFileOutput("testFile1.txt", Context.MODE_PRIVATE)
            var str="안녕"
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "testFile1.txt에 내용을 씀", Toast.LENGTH_LONG).show()
        }


        btnRead.setOnClickListener{

            try {
                var inFs : FileInputStream = openFileInput("testFile1.txt")
                var txt = ByteArray(30)
                inFs.read(txt)

                var str = txt.toString(Charsets.UTF_8)

                Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                inFs.close()
            }catch (e:Exception){
                Toast.makeText(applicationContext, "testFile1.txt 읽는 도중 예외 발생", Toast.LENGTH_LONG).show()
            }

        }

    }
}
