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

```
```
3. Custom Annotation
```
@Constraint(validatedBy = NameSizeGreaterThan5AndStartWithSValidationRule.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NameSizeGreaterThan5AndStartWithS {

    String message() default "Attribute cant be null, cant be less than 5 and always starts with S";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

public class NameSizeGreaterThan5AndStartWithSValidationRule
        implements ConstraintValidator<NameSizeGreaterThan5AndStartWithS, String> {

}
```

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
