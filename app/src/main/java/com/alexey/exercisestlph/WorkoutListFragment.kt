package com.alexey.exercisestlph

import android.content.Context
import android.os.Bundle
//import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

/**
 * A simple [Fragment] subclass.
 */
class WorkoutListFragment : ListFragment() {

    private var listLister:WorkoutListListener?=null

    interface WorkoutListListener{
        fun onListItem(id:Long)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        if(listLister!=null)
            listLister?.onListItem(id)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listLister=context as? WorkoutListListener?

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val arrExec= arrayOf(Workout.workout[0].name,Workout.workout[1].name,Workout.workout[2].name,Workout.workout[3].name)
        val listadapter=ArrayAdapter<String>(inflater.context,android.R.layout.simple_list_item_1,arrExec)
        listAdapter=listadapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}