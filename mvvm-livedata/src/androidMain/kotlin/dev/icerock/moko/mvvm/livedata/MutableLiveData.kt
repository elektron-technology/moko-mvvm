/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.mvvm.livedata

actual open class MutableLiveData<T> : LiveData<T> {

    actual constructor(initialValue: T) : super(
        androidx.lifecycle.MutableLiveData<T>().apply { value = initialValue }
    )

    constructor(mutableLiveData: androidx.lifecycle.MutableLiveData<T>) : super(mutableLiveData)

    @Suppress("UNCHECKED_CAST")
    actual override var value: T
        get() = archLiveData.value as T
        set(newValue) {
            changeValue(newValue)
        }

    actual fun postValue(value: T) {
        archLiveData.postValue(value)
    }

    override fun ld(): androidx.lifecycle.MutableLiveData<T> = archLiveData
}
