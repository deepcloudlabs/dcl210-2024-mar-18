package com.example;

public class Exercise01 {

	public static void main(String[] args) {
		// OS -> Application -> Process
		// java -jar app.jar -> Java Process
		// RAM -> Virtual Memory (Text+Data+Heap+Stack) + CPU
        // Task -> i) Child Process 
		//            Process API (Java SE 9)
     	//	      ii) Thread (Stack)(-Xss4m) -> Process (Text+Data+Heap)
		//            Runnable Thread -> Callable Thread -> Kernel Thread 
		// Project Loom (https://openjdk.org/projects/loom/)
		// Thread:  i) Platform Thread (Kernel-level Thread) > 10k
		//         ii) Virtual Thread (= fiber) (User-level Thread) 100_000
		
		// Multi-Thread
		// 1. Thread Safety
		// 2. Starvation Free
		// 3. Thread Liveness
		// 4. Dead-Lock Free
		
		// 1. Executors (Thread Pool)
		// 2. Synchronizers (Cyclic Barrier, Count-Down Latch, ...)
		// 3. Re-entrant ReadWrite Lock, Spin Lock, Stamp Lock, Atomic(Integer/Long/Reference,...) variables
		//    synchronized, volatile, ...
		//     
	}

}
