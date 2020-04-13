# Liskov Substitution Principle 

The Liskov Substitution Principle states that if objects of type T are replaced with objects of type S, when S is a subtype of T, in a program, the program’s characteristics should not change (e.g. correctness).

**Don't ask if some class "is a" other class, Instead prefer ask _Does the classA fully substitute the classB _**

## Liskov Substitution Requirements

**One Use Very Important of Liskov Substitution Principle**
This concept  is critical when developing libraries and frameworks because the classes are going to be used by other people whose code cannot directly be accessed and changed.

### Liskov Substitution Requirements
* **A subclass shouldn’t strengthen pre-conditions**
A subclass shouldn’t strengthen pre-conditions. A precondition of a class is a rule that must be in place before an action can be taken.
**Example:**  Before calling a method that reads from a database you may need to satisfy the precondition that the database connection is open. If the subclass add more conditions, there is a viollation of the principle

* **Postconditions cannot be weakened in subclasses.s**
Postconditions describe the state of objects after a process is completed. 
**Example:**  After calling a method that reads from a database it may be assumed that the database connection is closed after executing a SQL statement. If the subclass remove the condition of close the database conection by assuming that it will be closed by something else, there is a viollation of the principle.

* **Invariants of a superclass must be preserved**
Invariant conditions that exist in the base class, must also remain invariant in the subclass. Since invariant conditions are expected to be immutable, the subclass should not change them as it may cause a side effect in the behaviours of the base class or the program. Invariants can be described as:
	> "A condition of a process that is true before the process begins and remains true afterwards" [font](http://www.blackwasp.co.uk/lsp.aspx)

	**Example:** Consider a class that has a method to handle files. If the method handles the process to open and close a file, an invariant may be that the file is not open befor the call of this respective method.

* **Immutable characteristics of a base class must not be changed by the subclass**
An subclass inherits methods and properties of its superclasses. The **immutable characteristc** constraint says that new or modified members should not modify the state of an object in a manner that would not be permitted by the base class. For example, if the base class represents an object with a fixed size, the subclass should not permit this size to be modified.

* **The subclasses should not throw exceptions that are not thrown by the base class**
types of exceptions should match or be subtypes of the ones that the base method is already able to throw. 

**Contextualizingwith an Example - By Uncle Bob**
> In mathematics, a **Square** is a **Rectangle**. Indeed it is a specialization of a rectangle. The **"is a"** makes you want to model this with inheritance. However if in code you made **Square** derive from **Rectangle**, then a **Square** should be usable anywhere you expect a **Rectangle**. This makes for some strange behavior.

> Imagine you had **SetWidth** and **SetHeight** methods on your **Rectangle** base class; this seems perfectly logical. However if your **Rectangle** reference pointed to a **Square**, then **SetWidth** and **SetHeight** doesn't make sense because setting one would change the other to match it. In this case **Square** fails the Liskov Substitution Test with Rectangle and the abstraction of having Square inheriting from Rectangle is a bad one.

**Comments** - Requirements this example does not respect
	*  A subclass shouldn’t strengthen pre-conditions, because if you set a **Square**, immediatly you are saying that witdth and height must be the same, and it is not considered by the superclass, thus here we have a viollation.

### Exemplos of non-adherence of Liskov Substitution Principle

#### Verify for a specific type 
The below code snippet receives a set of taks and set the status of each of them to "in progress", except for bug fix that must first be initialized before assuming any status;

```java
for (Taks t: tasks){
	if(t instanceof BugFix){
		BugFix bf = (BugFix) t;
		bf.initializeBugDescription();
	}
    t.setInProgress();
}
```

This kind of approach where for most subtypes, one thing is done, but for particular subtypes something else must be performed. It indicates that the subtypes cannot be fully replace by its base class. In this situation inheritance are not been used properly 

**Solution:** Apply the principle "tell, don't ask"
```java
Class BugFix Extends Taks {
	
	@Override
	public void setInProgress()
    	this.initializeBugDescription();
	    super;setInProgress();

} 

// new for loop
for (Taks t: tasks){
    t.setInProgress();
}

```