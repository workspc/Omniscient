# Java Memory Model #
----------
## 1. Java Virtual Machine (JVM) ##

#### What is Java virtual machine ? ####

JVM (Java virtual machine) is the component responsible for the Java's hardware and O.S. independence. JVM knows nothing of the java programming language but only a particular binary format, the ***class*** file format. A class file contains JVM instructions *(or bytecode)*, a symbol table, as well as other ancillary information.

For the sake of security, JVM imposes strong syntactic and structural constraint on the code in class file, although JVM implementations are free to perform the actions specified by the instructions in any way it chooses. Either it can interpret the instructions or translate them into native code.

#### Why is Java virtual machine good ? ####

1. Operating System independent ***(Compile once, run anywhere)***
2. Automatic garbage collection
3. Security

#### JVM consists of three things ####

1. A set of instructions and meaning of those instructions ***(bytecode)***
2. A binary format called the ***class file format***, which is used to convey bytecode and related class infrastructure in platform independent manner.
3. An ***algorithm*** for identifying programs that can't compromise the integrity of JVM. *Algorithm is called the ***verification*** algorithm*.

## JVM Structure ##

It is divided into ***"four"*** conceptual data areas. These runtime data areas are used during program execution. Some data areas are created and destroyed when JVM starts and stops respectively while other data areas are thread dependent. These areas are as follows:

1. **JVM Stacks**
2. **Method Area**
3. **Heap**
4. **Native method stacks**

	![JVM Architecture Diagram](https://shyamalmadura.files.wordpress.com/2012/11/jvm_architecture3.png)

	### JVM Stacks ###
	Each JVM thread has a private stack, created at the same time as the thread. JVM stack stored ***"frames"***. It's only being used to push and pop frames. Memory of JVM stack doesn't need to be contigeous.

	    public int add(int a, int b){
      		return a + b;
    	}
    
    	public void functionA(){
      		int result = add(2,3);
    	}

	![JVM Stacks](http://coding-geek.com/wp-content/uploads/2015/04/state_of_jvm_method_stack.jpg)

	**Working of the JVM stacks is governed by following components.**

	1. **Program Counter Register:** JVM can support many threads of execution at once. Each JVM thread has its own program counter***(PC)*** register. When a thread is executing a method, ***PC register contains the address of the JVM instruction currently being executed***. in case of native method it's undefined.

	2. **Frames:** A frame is used to store data and partial results, as well as to perform dynamic linking, return values for methods and dispatch exceptions. ***A new frame is created each time a new method is invoked and destroyed when execution completes***. Each frame has its own *array of local variables*, its own *operand stack* and reference to the *runtime constant pool* of class of the current method.

		1. ***Local Variables:*** Each frame contains an array of variables known as local variables. A single local variable can hold the value of type boolean, byte, char, short, int, float, reference or return address. A pair of local variables can hold a value of type long, double. These are addressed by indexing. Index of first local variable is zero. JVM uses local variables to pass parameters on method invocation. 

		2. ***Operand Stack:*** Each frame contains a LIFO stack known as it's operand stack. It holds the operand used by operators to perform operations. It's also used to prepare parameters used to be passed to methods and to receive method results. In other words it's used to store arguments and return values of many of the virtual machine instructions.

	### JVM Heap ###
	JVM has a heap that is shared amoung all JVM threads. Heap is a run-time data area from which memory for all classes, instances and arrays is allocated. It's created on JVM statup. Heap storage for objects is reclaimed by an automatic storage management system (known as Garbage collector). Heap is further divided into number of sections or generations.

	1. **New generation:** Most objects are short loved in any application, analyzing all objects in an app during a garbage collection would be slow and time consuming, so as a result all the new objects are placed into new generation. New generation is further split up into:

		1. ***Eden Space:*** All new objects are placed here, when it becomes full a minor GC occurs. All objects that are still referenced are then promoted to survivor.

		2. ***Survivor Space:*** Each GC inside this increments the age of object in this space. When an object has survived a sufficient number of minor GC (normally 15) it will be promoted to the old generation. Survivor space has two segments "from" and "to".