package com.vanniktech.rxriddles

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object Riddle101 {
    /**
     * Create an Observable that acts as a countdown. Counting down from [seconds] to 0s and emitting each second how much seconds are remaining.
     *
     * Use case: You have some countdown functionality and want to display how many seconds are left.
     */
    fun solve(seconds: Long): Observable<Long> {
        return Observable
                .interval(1, TimeUnit.SECONDS)
                .map { seconds - it - 1 }
                .takeUntil { it <= 0 }
                .startWith(seconds)
    }
}
