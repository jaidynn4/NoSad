package com.csci448.jaidynnfohr.alpha_release.viewmodels

class PreviewNoSadViewModel private constructor() : INoSadViewModel() {

    companion object{
        private var viewModelInstance: PreviewNoSadViewModel? = PreviewNoSadViewModel()

        fun getInstance(): PreviewNoSadViewModel{
            var temp = viewModelInstance
            if (temp == null){
                temp = PreviewNoSadViewModel()
                viewModelInstance = temp
            }
            return temp
        }
    }

}