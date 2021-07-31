package com.example.contacts.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.adapter.ContactListAdapterClass
import com.example.contacts.datas.ListOfDataInDataClass
import com.example.contacts.inteface.OnItemClick



class MainActivity : AppCompatActivity(), OnItemClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawer)
        val showDrawer = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val bar = ActionBarDrawerToggle(this,drawerLayout,
            showDrawer, R.string.openDrawer, R.string.closeDrawer
        )
        drawerLayout.addDrawerListener(bar)
        bar.syncState()
        ListOfDataInDataClass.dataList.sortBy { it.name }
        val rvAdapter = ContactListAdapterClass(ListOfDataInDataClass.dataList,this)
        val layoutRv = findViewById<RecyclerView>(R.id.recycle)
        layoutRv.adapter = rvAdapter
        layoutRv.layoutManager = LinearLayoutManager(this)
    }

    override fun itemClickes(position: Int) {
        val intent = Intent(this, ContactProfile::class.java)
        intent.apply {
            putExtra("picture", ListOfDataInDataClass.dataList[position].image)
            putExtra("text", ListOfDataInDataClass.dataList[position].name)
            putExtra("phoneNumber", ListOfDataInDataClass.dataList[position].phone)
            putExtra("emailCode", ListOfDataInDataClass.dataList[position].email)
        }
            startActivity(intent)
        }
    }
