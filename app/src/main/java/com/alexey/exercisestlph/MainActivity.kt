package com.alexey.exercisestlph

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction

//import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity(),WorkoutListFragment.WorkoutListListener {

    var workoutId: Long = 0

     fun get():Long{
        return workoutId
    }

    fun set(value:Long){
        workoutId=value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   override fun onListItem(id: Long){
        val intent=Intent(this,DetailActivity::class.java)
       //var id=get()
       //Log.i("buf", id.toString())
       //Log.i("buff",get().toString())
       intent.putExtra("id",id)
       startActivity(intent)
    }
}
