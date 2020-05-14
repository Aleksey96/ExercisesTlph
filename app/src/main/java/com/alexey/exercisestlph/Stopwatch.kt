package com.alexey.exercisestlph

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.fragment_stopwatch.*


class Stopwatch : Fragment() {

    private var time: Int = 0
    private var running: Boolean = false
    private var exist:Boolean=false
    private var handler:Handler?=null
    private var buttonStop:Button?=null
    private var buttonStart:Button?=null
    private var buttonReset:Button?=null


    //var runnable:Runnable=Runnable{
      //  if(running){
        //    time++
        //}
        //handler?.postDelayed(runnable(),1000)
    //}
    //private fun runnable()=runnable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // handler=Handler()
        //handler?.post(runnable)

        if(exist)
            running=true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("time",time)
        outState.putBoolean("stop",running)
        outState.putBoolean("exist",exist)
        //DetailActivity.saveData.time=time
        //DetailActivity.saveData.running=running
        //DetailActivity.saveData.wasRunning=exist
    }

    override fun onResume() {
        super.onResume()
        if(exist)
            running=true

    }

    override fun onPause() {
        super.onPause()
        exist=running
        running= false
    }



   private fun startTime(view: View){
       val textView = view.findViewById<TextView>(R.id.textView)
       handler= Handler()
       handler?.post(object :Runnable{
        override fun run(){
            var hours = time / 3600
            var minutes = (time % 3600) / 60
            var seconds = time % 60
            val stringTime = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            textView.setText(stringTime)
            if(running){
                time++
            }
            handler?.postDelayed(this,1000)
        }
    })
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        Log.i("time",time.toString())
        /*
        * можно запилить отдельнай класс который сохраняет время
        * и потом возвращает его обратно при смене ориентации экрана.
        * Это правильно?
        * */
        if(savedInstanceState!=null){
            Log.i("flag","saveInstance равен нулл")
           time=savedInstanceState.getInt("time")
            Log.i("flag",time.toString())
           running=savedInstanceState.getBoolean("running")
            Log.i("flag",running.toString())
            exist=savedInstanceState.getBoolean("exist")
            Log.i("flag",exist.toString())
        }
         val myView=inflater.inflate(R.layout.fragment_stopwatch, container, false)
        startTime(myView)

        buttonStart=myView.findViewById(R.id.start1)
        buttonStop=myView.findViewById(R.id.stop1)
        buttonReset=myView.findViewById(R.id.reset1)

        Log.i("flag",buttonReset.toString())
        Log.i("flag",buttonStop.toString())
        Log.i("flag",buttonStart.toString())

        buttonStart?.setOnClickListener {
            running=true
            exist=true
            Log.i("flag","start")
        }

        buttonReset?.setOnClickListener {
            running=false
                time=0
                exist=false

                Log.i("flag","reset")
        }

        buttonStop?.setOnClickListener{
            running=false
            exist=true
            Log.i("flag","stop")
        }

        return myView
    }


}
