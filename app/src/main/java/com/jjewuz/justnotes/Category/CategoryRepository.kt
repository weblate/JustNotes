package com.jjewuz.justnotes.Category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jjewuz.justnotes.Category.CategoryDao
import com.jjewuz.justnotes.Category.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepo(private val categoryDao: CategoryDao) {

    fun getAllCategories(): LiveData<List<Category>> {
        return categoryDao.getAllCategories()
    }

    suspend fun insert(category: Category) {
        withContext(Dispatchers.IO) {
            categoryDao.insert(category)
        }
    }

    suspend fun delete(category: Category){
        withContext(Dispatchers.IO){
            categoryDao.delete(category.id)
        }
    }
}