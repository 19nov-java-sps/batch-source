# AOP -> Aspect Oriented Program
- breaking down program logic into distinct cross cutting concerns
- Aspect Oriented Programming - aspect is our unit of modularity
- aspect handles a cross cutting concerns
    - logging, security, validation, etc.
- annotate our class with @Aspect and @Component
    - @Aspect is an annotation we get from Aspect J which is a full AOP framework; we just use the AspectJ annotations rather than xml config

### Join Point 
- point in application where code will be injected
- JP is represented by a method execution 

### Point Cut
- predicate specifies which methods will be affected
- a collection of JP's matching a particular criteria

### Advice 
- code to be injected at a join point
- types of advice:
    - @Before - execute before JP
    - @After - executes after JP, regardless of JP's success
        - @AfterReturning - executes after JP executes successfully
        - @AfterThrowing - executes after JP throws an exception
    - @Around
        - allows for advice to be injected before and after the JP execution
        - most powerful type of advice and should not be used if Before or After could achieve what's needed

- advice is associated with point cuts and run at matching join points
- JoinPoint object can be passed into any aspect method
    - gives access to the target object (the object being advised; this is a Spring AOP proxy object )
    - allows us to get the JP method signature, arguments, etc.
- ProceedingJoinPoint is an object (subinterface of JoinPoint) that can be passed into a method which handles Around advice only
    - allows you to control if/when the join point is actually executed relative to the surrounding advice

### Types of Point Cut Expressions
- execution: most common, method execution 
    - ```"execution([type] [methodSignature](..))```
    - ```"execution(* doSomething())"```
    - ```"execution(* set*(..))```
- within: limits to method execution within certain classes
    - ```"within(com.revature.beans.*)"```
- this: limits matching to jp's where the AOP proxy being advised
- target: limits matching to jp's where the target object is being proxied 
- args: limits matching to jp's where arguments are instances of the given types
