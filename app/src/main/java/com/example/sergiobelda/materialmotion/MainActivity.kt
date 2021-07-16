/*
 * Copyright 2021 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sergiobelda.materialmotion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sergiobelda.materialmotion.databinding.MainActivityBinding
import com.example.sergiobelda.materialmotion.sample.SampleItem
import com.example.sergiobelda.materialmotion.sample.SamplesAdapter
import com.example.sergiobelda.materialmotion.sample.samples

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val samplesAdapter = SamplesAdapter(samples).apply {
            listener = object : SamplesAdapter.OnSampleClickListener {
                override fun onSampleClick(sampleItem: SampleItem) {
                    startActivity(Intent(this@MainActivity, sampleItem.activity))
                }
            }
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = samplesAdapter
        }
    }
}
