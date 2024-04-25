# constraint-validation-with-springboot-3

# JAVA 21 and Spring Boot 3.1.4
1. Constraint validation

    StudentController: Handled by Spring global exception handler
    ```
    @PostMapping("add")
    public ResponseEntity<Void> addStudent(@Valid @RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
    
    ```
    EmployeeController: Handled by us manually
    ```
    @PostMapping("add")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        Set<ConstraintViolation<Employee>> v = Validation
                .buildDefaultValidatorFactory().getValidator().validate(employee);

        v.forEach(violation -> System.out.println(violation.getMessage()));
        employeeList.add(employee);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
    ```

2. Global Exception Handler: Using ProblemDetail class
```
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail getErrors(Exception ee) throws URISyntaxException {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ee.getLocalizedMessage());

        problemDetail.setTitle("BAD Request");
        problemDetail.setType(new URI("test"));
        return problemDetail;
    }
}
```

Spring boot 3:

3. Custom Annotation
```
@Constraint(validatedBy = NameSizeGreaterThan5AndStartWithSValidationRule.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NameSizeGreaterThan5AndStartWithS {

    String message() default "Attribute can't be null, cant be less than 5 and always starts with S";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

```
Type of RetentionPolicy:
1. ```RetentionPolicy.SOURCE```: Discard during the compile. These annotations don't make any sense after the compilation has been completed, so they aren't written to the bytecode. Example: ```@Override```, ```@SuppressWarnings```

2. ```RetentionPolicy.CLASS```: Discard during class load. Useful when doing bytecode-level post-processing. Somewhat surprisingly, this is the default.

3. ```RetentionPolicy.RUNTIME```: Do not discard. The annotation should be available for reflection at runtime. Example: ```@Deprecated```

```
public class NameSizeGreaterThan5AndStartWithSValidationRule
        implements ConstraintValidator<NameSizeGreaterThan5AndStartWithS, String> {
}
```
In custom validator, we uses ```Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};``` as it will give all the details where which field which class

Dependencies:


```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

```

# We want to check on which field the particular annotation is present, if yes, then update the value of the field.

```
public static void main(String[] args) throws IllegalAccessException {
        Employee emp = new Employee();
        emp.setName("SidharthDas - ");
        processAnnotation(emp);

        System.out.println(emp);

    }

    public static void processAnnotation(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(NameSizeGreaterThan5AndStartWithS.class)) {
                f.setAccessible(true);
                String originalValue = (String) f.get(obj);
                String newVal = originalValue + "Sid";
                f.set(obj, newVal);
            }
        }
    }
```

# @Retryable and @Recover

-> Below Dependency needs to be added.
```
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
    <version>2.0.3</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>6.0.11</version>
</dependency>
```
-> Need to add ```@EnableRetry``` in the config class or MainApplication class
-> Need to add ```@Retryable and @Recover ``` like below
```
@Retryable(retryFor = RuntimeException.class, maxAttempts = 5)
    public String getMessage();

    @Recover
    public String getRecoverMessage();
```

-> For reference:
```
Check class: src/main/java/com/constraintvalidation/service/EmployeeService.java
Run application and hit API: localhost:8080/api/employee/test-retry
```
