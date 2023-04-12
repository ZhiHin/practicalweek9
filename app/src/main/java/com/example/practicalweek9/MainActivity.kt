package com.example.practicalweek9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //#1 create object for spinner
        val spinner : Spinner = findViewById(R.id.CourseSelection)
        spinner.onItemSelectedListener = this
        //#2 Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.course_selection,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            //specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long){
        //An item was selected. You can retrieve the selection
        //parent.getItemAtPosition(pso)
        val selectionTv : TextView = findViewById(R.id.SelectionResults)
        selectionTv.text = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>){
        //Another interface callback
        val selectionTy : TextView = findViewById(R.id.SelectionResults)
        selectionTy.text = "You have not make a course selection"
    }
}