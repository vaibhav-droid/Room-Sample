package com.sample.sampledbapplication.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sample.libraryapplication.dagger.factory.ContactViewModelFactory
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.sampledbapplication.R
import com.sample.sampledbapplication.SampleApplication
import com.sample.sampledbapplication.databinding.ActivityMainBinding
import com.sample.sampledbapplication.viewmodel.ContactViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var contactViewModelFactory: ContactViewModelFactory

    private lateinit var contactViewModel: ContactViewModel
    private var contactArrayAdapter: ArrayAdapter<ContactEntity>? = null

    private val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this,
        R.layout.activity_main
    ) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDagger()

        createViewModel()

        observeViewModel()

        binding.viewModel = contactViewModel
        binding.clickHandlers = ContactListClickHandlers()
    }

    private fun injectDagger() {
        SampleApplication.instance.appComponent.inject(this)
    }

    private fun createViewModel() {
        contactViewModel = ViewModelProviders.of(this, contactViewModelFactory)[ContactViewModel::class.java]
    }

    private fun observeViewModel() {
        contactViewModel.allContactEntity.observe(this, Observer { list ->
            if (!isDestroyed) {
                setDataToSpinner(list)
            }
        })
    }

    private fun setDataToSpinner(categoryList: List<ContactEntity>?) {
        categoryList?.let { list ->
            if (list.isNotEmpty()) {
                if (contactArrayAdapter == null) {
                    contactArrayAdapter = ArrayAdapter(this, R.layout.list_item_contact, list)
                    contactArrayAdapter?.setDropDownViewResource(R.layout.list_item_contact)
                    binding.spinnerAdapter = contactArrayAdapter
                } else {
                    contactArrayAdapter?.clear()
                    contactArrayAdapter?.addAll(list)
                    contactArrayAdapter?.notifyDataSetChanged()
                }
            }
        }
    }

    inner class ContactListClickHandlers {
        fun onContactSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
           val selectedContact = parent?.getItemAtPosition(position) as? ContactEntity
            updateContact(selectedContact?.contactId)
        }
    }

   private fun updateContact(id: String?) {
        id?.let {
            contactViewModel.getContactData(id).observe(this, Observer { data ->
                if (!isDestroyed) {
                    binding.tv.setText("Id: "+data?.contactEntity?.id+"\n"
                            +"Staging Id: "+data?.contactEntity?.stagingId+"\n"
                            +"Contact Id: "+data?.contactEntity?.contactId+"\n"
                            +"Status: "+data?.accountEntity?.status+"\n"
                            +"User Id: "+data?.accountEntity?.userId+"\n"
                            +"Context Id: "+data?.accountEntity?.contextId)
                }
            })
        }
    }
}