package com.example.xmlformatassignment

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler{
    private val studentsArray = ArrayList<Student>()
    private var text: String? = null

    private var studentId = 0
    private var studentName = ""
    private var studentMarks = 0

    fun parse(inputStream: InputStream): List<Student>{
        try{
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while(eventType != XmlPullParser.END_DOCUMENT){
                val tagID = parser.name
                when(eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagID.equals("id", ignoreCase = true) -> {
                            studentId = text!!.toInt()
                        }
                        tagID.equals("name", ignoreCase = true) -> {
                            studentName = text.toString()
                        }
                        tagID.equals("marks", ignoreCase = true) -> {
                            studentMarks = text!!.toInt()
                        }
                        else -> studentsArray.add(Student(studentId, studentName, studentMarks))
                    }
                    else -> {
                    }
                }
                eventType = parser.next()
            }
        }catch (e: XmlPullParserException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return studentsArray
    }
}