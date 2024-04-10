package com.jaycodes.signuppage

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.jaycodes.signuppage.adapter.CountryAdapter


class SignUp : AppCompatActivity() {

    private val countryName: List<Countries> = listOf(
        Countries(1, "India", "India is diverse country"),
        Countries(2, "Dubai", "Dubai is diverse country"),
        Countries(3, "China", "China is diverse country"),
        Countries(4, "Hong Kong", "Hong Kong is diverse country"),
        Countries(5, "USA", "USA is diverse country")
    )
val a = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val enterName = findViewById<EditText>(R.id.etName)
        val enterEmail = findViewById<EditText>(R.id.etEmail)
        val enterPassword = findViewById<EditText>(R.id.etPassword)
        val enterAboutMe = findViewById<EditText>(R.id.etAboutMe)
        val female = findViewById<RadioButton>(R.id.radioButton)
        val male = findViewById<RadioButton>(R.id.radioButton2)
        val java = findViewById<CheckBox>(R.id.java)
        val android = findViewById<CheckBox>(R.id.android)
        val cpp = findViewById<CheckBox>(R.id.cpp)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val datePicker = findViewById<EditText>(R.id.datePickerBtn)
        val nameSpinner = findViewById<Spinner>(R.id.countryNames)

        submitBtn.setOnClickListener {

            val name: String = enterName.text.toString()
            val email: String = enterEmail.text.toString()
            val password: String = enterPassword.text.toString()
            val about: String = enterAboutMe.text.toString()


            val gender: String = if (female.isChecked) {
                "female"
            } else if (male.isChecked) {
                "male"
            } else {
                "other"
            }

            var course = ""
            if (java.isChecked) {
                course += "Java"
            }
            if (cpp.isChecked) {
                course += ", C++"
            }
            if (android.isChecked) {
                course += ", Android"
            }

            Log.w("Name", name)
            Log.w("Email", email)
            Log.w("About Me", about)
            Log.w("Gender", gender)
            Log.w("Course", course)
        }

        datePicker.setOnClickListener {
            showDataPickerDialog()

        }


//        val countryAdapter = ArrayAdapter(
//            this,
//            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//            countryName
//        )

        val countryAdapter = CountryAdapter(countryName, this)
        nameSpinner.adapter = countryAdapter
        nameSpinner.setSelection(4)

        nameSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

//    Date Picker

    fun showDataPickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
            }, year, month, dayOfMonth
        )

        datePickerDialog.show()
    }


}