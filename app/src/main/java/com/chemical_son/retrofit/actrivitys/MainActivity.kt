package com.chemical_son.retrofit.actrivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chemical_son.retrofit.R
import com.chemical_son.retrofit.adapter.PostsAdapter
import com.chemical_son.retrofit.dataModel.TopHeadlinesResponse
import com.chemical_son.retrofit.handelRequists.ApiInterface
import com.chemical_son.retrofit.handelRequists.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var postsAdapter: PostsAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycle_view)

        getData()
    }

    private fun getData() {
        var getData = Service.getInstance().create(ApiInterface::class.java)
        getData.getNews("eg", "8e58f324a063461598c2535e52d14002")
            .enqueue(object : Callback<TopHeadlinesResponse?> {
                override fun onResponse(
                    call: Call<TopHeadlinesResponse?>,
                    response: Response<TopHeadlinesResponse?>
                ) {
                    val responseBody = response.body()!!
                    if (response.code() == 200) {
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        postsAdapter = PostsAdapter(this@MainActivity, responseBody.articles)
                        recyclerView.adapter = postsAdapter
                    }

                }

                override fun onFailure(call: Call<TopHeadlinesResponse?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}