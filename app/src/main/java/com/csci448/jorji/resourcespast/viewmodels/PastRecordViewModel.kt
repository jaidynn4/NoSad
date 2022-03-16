package com.csci448.jorji.resourcespast.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.csci448.jorji.resourcespast.data.PastRecord
import com.csci448.jorji.resourcespast.util.RecordGenerator
import java.util.*

class PastRecordViewModel : GenericViewModel() {
    private val _pastRecordListLiveData = MutableLiveData<MutableList<PastRecord>>(mutableListOf())
    private val _pastRecordIDLiveData = MutableLiveData<UUID>()

    init{
        _pastRecordListLiveData.value?.let{
            recordList -> for(i in 1..5) {
                recordList.add(RecordGenerator.generateRandomRecord())
            }
            _pastRecordListLiveData.value = recordList
        }
    }

    companion object{
        private var singleton : PastRecordViewModel? = null
        fun getInstance() : PastRecordViewModel{
            var temp = singleton
            if(temp == null){
                temp = PastRecordViewModel()
                singleton = temp
            }
            return temp
        }
    }

    override val DataLiveList: LiveData<List<Any>> = Transformations.map(_pastRecordListLiveData){
            recordList -> recordList
    }

    override val IDLiveList: LiveData<Any?> = Transformations.map(_pastRecordIDLiveData){
        recordID -> var foundRecord: PastRecord? = null
        _pastRecordListLiveData.value?.let{
                recordList ->
            for (record in recordList){
                if(record.getID() == recordID){
                    foundRecord = record
                    break
                }
            }
        }
        foundRecord
    }

    override fun addData(data: Any) {
        _pastRecordListLiveData.value?.let {
                recordList -> recordList.add(data as PastRecord)
            _pastRecordListLiveData.value = recordList
        }
    }

    override fun loadData(id: UUID) {
        _pastRecordIDLiveData.value = id
    }
}