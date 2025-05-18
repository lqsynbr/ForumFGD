package edu.luqsiyana.forumfgdapps

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.luqsiyana.forumfgdapps.databinding.ActivityMainBinding
import edu.luqsiyana.forumfgdapps.model.Participant

/*
     NIM : 10122328
     Nama : Luqsiyana Bariq Raihan
     Kelas : IF-ANDRO4
     Hari/Tgl : Minggu, 18 Mei 2025
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val categories = listOf("Akademisi", "Bisnis", "Komunitas", "Pemerintah", "Media", "Organisasi", "NGO")

    private val skillMap by lazy {
        listOf(
            Pair(binding.chkAlgo, "Algoritma"),
            Pair(binding.chkProblemSolving, "Problem Solving"),
            Pair(binding.chkCriticalthinking, "Critical Thinking"),
            Pair(binding.chkProgramming, "Programming"),
            Pair(binding.chkDesignthinking, "Design Thinking")
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adapter Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spCategory.adapter = adapter

        binding.btnSubmit.setOnClickListener {
            val name = binding.edtNama.text.toString()
            val phone = binding.edtTelefon.text.toString()
            val email = binding.edtEmail.text.toString()
            val gender = when {
                binding.radLakilaki.isChecked -> "Laki-laki"
                binding.radPerempuan.isChecked -> "Perempuan"
                else -> ""
            }
            val skillset = skillMap.filter { it.first.isChecked }.map { it.second }
            if (skillset.isEmpty()) {
                Toast.makeText(this, "Pilih minimal satu skill", Toast.LENGTH_SHORT).show()
            }

            val category = binding.spCategory.selectedItem.toString()
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || category.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val participant = Participant(name, phone, email, gender, skillset, category)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("participant", participant)
            startActivity(intent)

        }

    }
}