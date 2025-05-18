package edu.luqsiyana.forumfgdapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.luqsiyana.forumfgdapps.databinding.ActivityDetailBinding
import edu.luqsiyana.forumfgdapps.model.Participant

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val participant = intent.getParcelableExtra<Participant>("participant")

        participant.let {
            binding.txtNamaResult.text = it?.nama
            binding.txtTelefonResult.text = it?.telefon
            binding.txtEmailResult.text = it?.email
            binding.txtGenderResult.text = it?.gender
            binding.txtSkillsetResult.text = it?.skillset?.joinToString(", ")
            binding.txtKategoriResult.text = it?.category
        }

        binding.btnInfoDeveloper.setOnClickListener {
            val bottonSheet = InfoDeveloper()
            bottonSheet.show(supportFragmentManager, "InfoDeveloper")

        }

    }
}