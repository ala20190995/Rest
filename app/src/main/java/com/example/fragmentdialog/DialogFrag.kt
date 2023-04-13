package com.example.fragmentdialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogFrag: DialogFragment(R.layout.dialog_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancel : Button = view.findViewById(R.id.cancel_button)
        val submit : Button = view.findViewById(R.id.submit_button)
        val radioGroup = view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
        cancel.setOnClickListener{
            dismiss()
        }
        submit.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context,radioButton.text,Toast.LENGTH_SHORT).show()
            val m1:MainActivity = activity as MainActivity
            m1.receiveFeedback(radioButton.text.toString())
            dismiss()
        }
    }
}