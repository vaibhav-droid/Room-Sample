package com.sample.sampledbapplication.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.sample.libraryapplication.database.entity.AccountEntity
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.libraryapplication.database.entity.ExtensionEntity

data class ContactData (

    @Embedded
    var accountEntity: AccountEntity,

   @Embedded
   var contactEntity: ContactEntity
){
}