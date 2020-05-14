package com.alexey.exercisestlph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailFragment=WorkoutDetailFragment()
        supportFragmentManager.findFragmentById(R.id.fr)
        //supportFragmentManager.findFragmentById(R.id.watcher)
        val workoutId:Long=intent.extras?.get("id") as Long
        this.setTitle(Workout.workout[workoutId.toInt()].name)
        //Log.i("buf1",workoutId.toString())
        detailFragment.set(workoutId)
        //this.replaceStopwatcher()
        //Log.i("flag","End of transaction")

    }
}
