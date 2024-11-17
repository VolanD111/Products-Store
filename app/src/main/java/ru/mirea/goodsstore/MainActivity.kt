package ru.mirea.goodsstore

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import ru.mirea.goodsstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var answer = ""
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val naborCB = arrayListOf(binding.CB0, binding.CB1, binding.CB2, binding.CB3, binding.CB4, binding.CB5)
        setContentView(binding.root)
        var delivery = ""
        var master = ""
        var count = ""

        binding.Button.setOnClickListener{
            val answerCB = arrayListOf<CharSequence>()
            for (i in 0 .. 5){
                if ((naborCB[i]).isChecked && naborCB[i].text !in answerCB) {
                    answerCB.add(naborCB[i].text)
                }
            }
            answer = answerCB.joinToString()

            delivery = if ((binding.NaborRB[0] as RadioButton).isChecked){
                "Курьер"
            }else if ((binding.NaborRB[1] as RadioButton).isChecked){
                "Самовывоз"
            }else{
                "Дрон"
            }

            master = if (binding.Switch.isChecked == true)
            {
                "Да"
            }
            else{
                "Нет"
            }

            count = binding.EditText.text.toString()
            Snackbar.make(binding.root, "Способ доставки: $delivery " +
                    "\nБахилы: $master " +
                    "\nЧаевые: $count" +
                    "\nПродукты: $answer ", Snackbar.LENGTH_LONG).setTextMaxLines(10).show()
        }
    }
}