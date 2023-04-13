package com.example.fragmentdialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val spinner: Spinner = findViewById(R.id.spinner)
        val textview1: TextView = findViewById(R.id.textview1)
        var flag = "Burger"
        val options = arrayOf("Burger", "Pizza")
        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener {
            if (flag == "Burger")
                Toast.makeText(this, "Burger, nice choice", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Pizza, nice choice", Toast.LENGTH_SHORT).show()
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



            textview1.setOnClickListener{
            val dialog = DialogFrag()
           dialog.show(supportFragmentManager,"Custom Dialog")
        }
    }
    fun receiveFeedback(feedback: String){
        val textview1 : TextView = findViewById(R.id.textview1)
        textview1.text = feedback

    }

   override fun onCreateOptionsMenu(menu: Menu): Boolean {

       val inflater : MenuInflater = menuInflater
    inflater.inflate(R.menu.rest_menu, menu)
    return super.onCreateOptionsMenu(menu)
}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 ->Toast.makeText(this, "Our locations selected", Toast.LENGTH_SHORT).show()
            R.id.item3 ->Toast.makeText(this, "About us selected", Toast.LENGTH_SHORT).show()
            R.id.sub_item1 -> Toast.makeText(this, "Main Courses selected", Toast.LENGTH_SHORT).show()
            R.id.sub_item2 ->Toast.makeText(this, "Side dishes selected", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}

