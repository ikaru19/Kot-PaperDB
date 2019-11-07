package com.ikaru19.kot_paperdb.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ikaru19.kot_paperdb.R
import com.ikaru19.kot_paperdb.adapters.AnimalAdapter
import com.ikaru19.kot_paperdb.models.Animal
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var animals : ArrayList<Animal> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPaperDB()
        var adapter : AnimalAdapter = AnimalAdapter(R.layout.item_animal,animals)
        rv_animal.layoutManager = LinearLayoutManager(this)
        rv_animal.adapter = adapter
        btnAdd.setOnClickListener {

            if (et_name.text.isNotEmpty()){
                animals.add(Animal(et_name.text.toString()))
                adapter.notifyDataSetChanged()
                save()
                et_name.text = null
            }else{
                Toast.makeText(this@MainActivity,"Name Can't be Empty",Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun getPaperDB(){
        Paper.init(this)
        animals = Paper.book().read("animals", ArrayList())
    }

    fun save(){
        Paper.book().write("animals",animals)
    }
}
