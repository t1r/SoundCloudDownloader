package com.t1r.scd.core.utils.type

sealed class Failure {
    object NetworkConnectionMissing : Failure()
    class SimpleFailure(val throwable: Throwable) : Failure()
}
