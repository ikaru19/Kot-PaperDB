package com.ikaru19.kot_paperdb.adapters

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ikaru19.kot_paperdb.R
import com.ikaru19.kot_paperdb.models.Animal

class AnimalAdapter(layoutResId: Int, data: List<Animal>) :
    BaseQuickAdapter<Animal, BaseViewHolder>(layoutResId, data) {

    // Place data from Object(item) to the View(helper)
    override fun convert(helper: BaseViewHolder, item: Animal) {
        helper.setText(R.id.tv_animal , item.name)
    }
}