package com.twiceyuan.android.component.inject

import org.koin.core.definition.BeanDefinition
import org.koin.core.definition.IndexKey
import org.koin.core.definition.Kind
import org.koin.core.definition.indexKey
import org.koin.core.instance.InstanceFactory
import org.koin.core.instance.SingleInstanceFactory
import org.koin.core.scope.Scope

fun Scope.append(appendActionContext: AppendInstanceContext.() -> Unit) {
    AppendInstanceContext(this).appendActionContext()
}

class AppendInstanceContext(val scope: Scope) {

    inline fun <reified T> scoped(crossinline instance: () -> T): Scope = scope.apply {
        val definition = BeanDefinition(
            scopeDefinition = this._scopeDefinition,
            primaryType = T::class,
            kind = Kind.Single,
            definition = { instance() }
        )

        val factory = SingleInstanceFactory(this._koin, definition)
        (this._instanceRegistry.instances as HashMap<IndexKey, InstanceFactory<*>>)[indexKey(
            T::class, null
        )] = factory
        return this
    }
}