package com.youssif.youssifcodebase.utils


/**
 * Created by Youssif Hamdy on 1/11/2023.
 */

// sealed classes can be termed as Enum classes on steroids. Sealed classes allow us to create instances with different types
// sealed is kind of abstract class but we can define which classes are allowed to inherit from this resource class
// sealed class cannot be instantiated.
// Constructors of a sealed class are private by default. All subclasses of a sealed class must be declared within the same file.
// sealed classes are important in ensuring type safety by restricting the set of types at compile-time only.
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    class Loading<T> : Resource<T>()

}