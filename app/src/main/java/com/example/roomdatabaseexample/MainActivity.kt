package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.colornotes.db.INoteRepository
import com.example.colornotes.db.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val TAG = "001"
    lateinit var noteRepository: INoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn: Button = findViewById(R.id.btn_insert)
        val insertGet: Button = findViewById(R.id.btn_get)
        noteRepository = NoteRepository.getInstance(this)

        val arrString = ArrayList<String>()
        arrString.add("one")
        arrString.add("tow")

        val color = MyColor("green")

        val objectJson = JSONObject()
        objectJson.put("color", color.color)
        val objectJsonStr = objectJson.toString()

        val listJson = JSONArray()
        for (item in arrString) {
            listJson.put(item)
        }

        val listJsonStr = listJson.toString()

        val note = Note(1, "orange", listJsonStr, objectJsonStr)

        insertBtn.setOnClickListener(View.OnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                noteRepository.insert(note)
            }
        })

        insertGet.setOnClickListener(View.OnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val arrNote: ArrayList<Note> = noteRepository.getAll() as ArrayList<Note>
                for (item in arrNote) {
                    val listJson = JSONArray(item.list)
                    val objectJson = JSONObject(item.color)

                    Log.d(TAG, "arrNote: id: " + item.id + " title: " + item.title + " list1: " + listJson.get(0) + " list2: " + listJson.get(1) + " object: " + objectJson.get("color"))
                }
            }
        })
    }
}