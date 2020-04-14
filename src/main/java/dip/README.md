# Dependency Inversion Principle
This principle states that high level modules should depend on high level generalizations, and not on low level details. Meaning that classes if will there dependencies they should depend on a interface or abstract class rathar than concreate classes. If clients are dependent on higher-level generalizations then low level implementations can be changed or replaced with more ease later on. This is a form of looser coupling.

**Summary**
A. Higher-level modules should not depend on low-level modules. Both should depend on abstractions.
B. Abstractions should not depend on details. Details should depend on abstractions.

Also, dependency inversion helps in the generalization of the behavior of your concrete classes into abstract classes and interfaces.

![depending-on-abstraction-vs-depending-on-details](resources/depending-on-abstraction-vs-depending-on-details.png)

What are High Level Modules?
* Modules written to solve real problems and use cases
* they are more abstract and **map to the business domain** -> business logic
* These modules tell us "What the software should do"

What are Low Level Modules?
* Contain implementation details that are required to execute the business policies.
* They are considered the "plumbing" of an application
* These modules tell us "How the software should do various taks"

![Low-ISP-Adherence](resources/Low-ISP-Adherence.png)

![High Level Modules Work Together with Low Level Modules](resources/High-and-Low-Modules-Relation.png)

High level and low level modules are always relative to one another. For example, It we take "payment" as the high level model the low level model for this component is "notification system"; and for "notification system" the low level module is "email service". These relationships always depend on what is the referential

### Dependency Injection
Dependency Injection is the technique that allows the creation of dependent objects outside of a class and provides those objects to a class

### Inversion of Control (IoC)
**Inversion of control is a design principle in which the control of objects creation, configuration, and lifecycle is passed to a container or framework.**

IoC helps deal with a problem that can be seen by using the technique Dependency Injection. Creating dependencies manually in order to instanciate a component is not scalable. This is where the IoC comes in. It can handle the creation and the lifecycle of all objects in an application.

It is no longer necessary create new objects with "new", they are created by "something else" (IoC container). 

**Benefits**
* makes easy to switch between different implementations at runtime
* increased program modularity
* Manages the lifecycle of objects and their configuration
