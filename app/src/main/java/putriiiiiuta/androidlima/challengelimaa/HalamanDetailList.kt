package putriiiiiuta.androidlima.challengelimaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_halaman_detail_list.*
import putriiiiiuta.androidlima.challengelimaa.model.remote.FilmResponse

class HalamanDetailList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_detail_list)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val datafilm = intent.getParcelableExtra<FilmResponse>("DetailFilm")
        title = datafilm?.title
        detail_judulfilm.text = datafilm?.title
        detail_tglfilm.text = datafilm?.releaseDate
        detail_sutradarafilm.text = datafilm?.director
        detail_filmsinopsis.text = datafilm?.synopsis

        Glide.with(applicationContext)
            .load(datafilm?.image)
            .into(detailimg_film)

        fab_favorite.setOnClickListener{

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                startActivity(Intent(this, HalamanHome::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}