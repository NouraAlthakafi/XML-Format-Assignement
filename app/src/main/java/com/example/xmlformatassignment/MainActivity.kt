package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var rvStudents: RecyclerView
    lateinit var studentsArray: ArrayList<String>

    private lateinit var students: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStudents = findViewById(R.id.rvStudents)
        studentsArray = ArrayList()

        rvStudents.adapter = RVstudents(studentsArray)
        rvStudents.layoutManager = LinearLayoutManager(this)

        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("students.xml")
            students = parser.parse(iStream)

            var text = ""
            for(aStudent in students){
                text += "\n${aStudent.name} - ${aStudent.marks}\n"
            }
            studentsArray.add(text)
            rvStudents.adapter?.notifyDataSetChanged()
            rvStudents.scrollToPosition(studentsArray.size-1)

        }catch (e: IOException){
            println("ISSUE: $e")
        }
    }
}