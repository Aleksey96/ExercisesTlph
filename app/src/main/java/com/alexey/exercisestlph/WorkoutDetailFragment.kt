package com.alexey.exercisestlph

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class WorkoutDetailFragment: Fragment() {
    companion object {
        private var workoutId: Long = 0
       // private var titleActivity:String?=null
    }


    fun set(value:Long){
        workoutId=value
    }
    fun get():Long{
        return workoutId
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("workoutId",get())
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //Log.i("kabanga",savedInstanceState?.getLong("workoutId").toString())
        if(savedInstanceState!=null) {
            workoutId = savedInstanceState.getLong("workoutId")

        }
        else {
            val fragmenentTransaction: FragmentTransaction = childFragmentManager.beginTransaction()
            val stopwatch = Stopwatch()
            fragmenentTransaction.replace(R.id.waatcher, stopwatch)
            fragmenentTransaction.addToBackStack(null)
            fragmenentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmenentTransaction.commit()
        }
        val view=inflater.inflate(R.layout.fragment_workout_detail,container,false)

        return view
    }

    override fun onStart() {
        super.onStart()
        val view=getView()
        if(view!=null){
            var id:Int=get().toInt()
           // Log.i("huyamba",get().toString())
            view?.findViewById<TextView>(R.id.textDescription)?.text = Workout.workout[id].discription
        }

    }

}