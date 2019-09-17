package com.t1r.scd.core.utils

sealed class Failure {
    object NetworkConnectionMissing : Failure()
    class PairsLoadingError(val throwable: Throwable) : Failure()
    class PairsManagerFailure(val throwable: Throwable) : Failure()
}
