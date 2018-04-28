package com.lucasmarciano.ceep

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.*
import com.lucasmarciano.ceep.adapter.PostListAdapter
import com.lucasmarciano.ceep.model.Post
import com.lucasmarciano.ceep.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_post_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        val call = RetrofitInitializer().postService().list()
        call.enqueue(object: Callback<List<Post>?> {
            override fun onResponse(call: Call<List<Post>?>?, response: Response<List<Post>?>?) {
                response?.body()?.let {
                    val notes: List<Post> = it
                    progress_bar.visibility = View.GONE
                    float_new_note.visibility = View.VISIBLE
                    setupRecicleView(notes)
                }
            }

            override fun onFailure(call: Call<List<Post>?>?, t: Throwable?) {
                Log.e("PostListActivity", t?.message)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun setupRecicleView(notes: List<Post>) {
        post_list_recyclerview.visibility = View.VISIBLE
        post_list_recyclerview.adapter = PostListAdapter(notes, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        post_list_recyclerview.layoutManager = layoutManager
    }

    fun newNote(view: View) {
        Snackbar.make(view, "Novo post!", Snackbar.LENGTH_SHORT).show()
    }
}
