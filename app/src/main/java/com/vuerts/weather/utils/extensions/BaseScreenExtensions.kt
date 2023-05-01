package com.vuerts.weather.utils.extensions

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.view.base.BaseActivity
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

/**
 * Inflates ViewBinding of [VB] generic type for an activity using reflection
 */
fun <VB : ViewBinding> BaseActivity<VB, *>.inflateBinding(inflater: LayoutInflater): VB {
    val clazz = this::class.java.findGenericClass<ViewBinding>()
        ?: error("Cannot find view binding generic parameter for $this")

    val method = clazz.findMethod { it.parameterTypes[0] == LayoutInflater::class.java }

    return method.invoke(null, inflater) as VB
}

/**
 * Creates ViewModel of [VM] generic type using reflection
 */
fun <VM : BaseViewModel> ViewModelStoreOwner.createViewModel(
    viewModelFactory: ViewModelProvider.Factory,
): VM {
    val clazz = this::class.java.findGenericClass<BaseViewModel>() as? Class<VM>
        ?: error("Cannot find view model generic parameter for $this")

    return ViewModelProvider(this, viewModelFactory)[clazz]
}

private inline fun <T> Class<T>.findMethod(predicate: (Method) -> Boolean): Method =
    declaredMethods.first(predicate)

/**
 * Tries to find class in class hierarchy with [T] generic type
 */
private inline fun <reified T> Class<*>.findGenericClass(): Class<T>? {
    var clazz: Class<*>? = this

    do {
        val superClass = clazz?.genericSuperclass

        if (superClass is ParameterizedType) {
            superClass.actualTypeArguments.firstOrNull {
                T::class.java.isAssignableFrom((it as Class<*>))
            }?.let {
                return it as Class<T>
            }
        }

        clazz = superClass as Class<*>?

    } while (clazz != null)

    return null
}
